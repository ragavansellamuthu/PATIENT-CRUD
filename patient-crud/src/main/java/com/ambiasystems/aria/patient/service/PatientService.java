package com.ambiasystems.aria.patient.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ambiasystems.aria.patient.model.PatientModel;

public interface PatientService {

	boolean isDuplicateEmail (long patientId, String email);

	PatientModel addPatient (PatientModel model);
	
	PatientModel viewPatient (long candidateId);
	
	PatientModel updatePatient (PatientModel model);
	
	void deletePatient (long candidateId);
	
	Page<PatientModel> paginatePatients (int pageIndex , int pageSize , String attributeName , String sortOrder , String searchText);

	List<PatientModel> listAllPatients();

}
