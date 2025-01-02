package com.ambiasystems.aria.patient.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ambiasystems.aria.patient.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

	boolean existsByEmailAndIsDeletedFalse(String email);

	boolean existsByEmailAndPatientIdNotAndIsDeletedFalse(String email, long patientId);
	
	PatientEntity findByPatientIdAndIsDeletedFalse(long patientId);
	
	List<PatientEntity> findAllByIsDeletedFalse(Sort sort);
	
	Page<PatientEntity> findAllByIsDeletedFalse(Pageable pagebale);
	
	Page<PatientEntity> findAllByPatientNameContainingIgnoreCaseAndIsDeletedFalse(String patientName,Pageable pagebale);

	PatientEntity findAllByEmailAndIsDeletedFalse(String email);
	
}
