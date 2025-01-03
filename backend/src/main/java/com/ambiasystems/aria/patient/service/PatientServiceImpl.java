package com.ambiasystems.aria.patient.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ambiasystems.aria.patient.entity.PatientEntity;
import com.ambiasystems.aria.patient.model.PatientModel;
import com.ambiasystems.aria.patient.repository.PatientRepository;
import com.ambiasystems.aria.patient.util.CommonUtils;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

	private final PatientRepository patientRepository ;
	
	private final ModelMapper modelMapper;
	
	private PatientModel convert(PatientEntity entity) {
		PatientModel model = modelMapper.map(entity, PatientModel.class);
		model.setPassword(null);
		return model;
	}

	private PatientEntity convert(PatientModel model) {
		return modelMapper.map(model, PatientEntity.class);
	}

	private PatientEntity getPatient(long patientId) {
		PatientEntity entity = patientRepository.findByPatientIdAndIsDeletedFalse(patientId);
		if (entity == null) {
			throw new EntityNotFoundException("Patient not found for ID : " + patientId);
		}
		return entity;
	}

	@Override
	public boolean isDuplicateEmail(long patientId, String email) {
		if(patientId == 0) {
			 return patientRepository.existsByEmailAndIsDeletedFalse(email);
		} else {
			 return  patientRepository.existsByEmailAndPatientIdNotAndIsDeletedFalse(email, patientId); 
		}
	}

	@Override
	public PatientModel addPatient(PatientModel model) {
		return convert(patientRepository.save(convert(model)));
	}

	@Override
	public PatientModel viewPatient(long candidateId) {
		return convert(getPatient(candidateId));
	}

	@Override
	public PatientModel updatePatient(PatientModel model) {
			PatientEntity existingEntity = getPatient(model.getPatientId());
			PatientEntity updatedEntity = convert(model);
			BeanUtils.copyProperties(updatedEntity, existingEntity, "password", "createdAt");
			return convert(patientRepository.save(existingEntity));
	}

	@Override
	public void deletePatient(long patientId) {
		PatientEntity entity = getPatient(patientId);
		entity.setDeleted(true);
		patientRepository.save(entity);
	}

	@Override
	public Page<PatientModel> paginatePatients(int pageIndex, int pageSize, String attributeName, String sortOrder,
			String patientName) {
		Pageable pageable = PageRequest.of(pageIndex, pageSize, CommonUtils.sort("patientId",attributeName, sortOrder));
		Page<PatientEntity> entityPage = null;
		if (StringUtils.hasText(patientName)) {
			entityPage = patientRepository.findAllByPatientNameContainingIgnoreCaseAndIsDeletedFalse(patientName, pageable);
		} else {
			entityPage = patientRepository.findAllByIsDeletedFalse(pageable);
		}
		List<PatientModel> models = entityPage.getContent().stream().map(this::convert).collect(Collectors.toList());
		if(models.isEmpty()) {
			throw new EntityNotFoundException("No Patients Found");
		}
		return new PageImpl<>(models, pageable, entityPage.getTotalElements());
	}

	@Override
	public List<PatientModel> listAllPatients() {
		List<PatientEntity> entities = patientRepository.findAllByIsDeletedFalse(CommonUtils.sort("patientId","patientName", "asc"));
		if(entities.isEmpty()) {
			throw new EntityNotFoundException("No Patients Found");
		} 
			return entities.stream().map(this::convert).collect(Collectors.toList());	
	}

}
