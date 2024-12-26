package com.ambiasystems.aria.patient.initializer;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.ambiasystems.aria.patient.entity.PatientEntity;
import com.ambiasystems.aria.patient.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientInitializer  implements CommandLineRunner{

	private final PatientRepository patientRepository ; 
	

	public void run(String... args) throws Exception {
		if(patientRepository.count()==0) {
			
			PatientEntity patient1 = new PatientEntity();		
			patient1.setPatientName("Paulraj");
			patient1.setEmail("paulraj@gmail.com");
			patient1.setPassword("Paulraj@123");
			patient1.setAge(60);
			patient1.setMobileNumber(9999999999L);
		
			PatientEntity patient2 = new PatientEntity();
			patient2.setPatientName("Maruthamuthu");
			patient2.setEmail("maruthamuthu@gmail.com");
			patient2.setPassword("Marutha@234");
			patient2.setAge(60);
			patient2.setMobileNumber(9999999888L);
			
			PatientEntity patient3 = new PatientEntity();
			patient3.setPatientName("Rajalingam");
			patient3.setEmail("rajalingam@gmail.com");
			patient3.setPassword("Raja@123");
			patient3.setAge(60);
			patient3.setMobileNumber(9989999888L);
			
			PatientEntity patient4 = new PatientEntity();
			patient4.setPatientName("Sellamuthu");
			patient4.setEmail("sellamuthu@gmail.com");
			patient4.setPassword("Muthu@137");
			patient4.setAge(57);
			patient4.setMobileNumber(9998887771L);
			
			PatientEntity patient5 = new PatientEntity();
			patient5.setPatientName("Aasai Thambi");
			patient5.setEmail("aasai@gmail.com");
			patient5.setPassword("Aasai@256");
			patient5.setAge(50);
			patient5.setMobileNumber(9879879870L);
			
			PatientEntity patient6 = new PatientEntity();
			patient6.setPatientName("Swaminathan");
			patient6.setEmail("swami@gmail.com");
			patient6.setPassword("Swami@123");
			patient6.setAge(35);
			patient6.setMobileNumber(9955999888L);
			
			PatientEntity patient7 = new PatientEntity();
			patient7.setPatientName("Saravanan");
			patient7.setEmail("saravanan@gmail.com");
			patient7.setPassword("Sarav@123");
			patient7.setAge(30);
			patient7.setMobileNumber(9876987689L);
			
			PatientEntity patient8 = new PatientEntity();
			patient8.setPatientName("Maris");
			patient8.setEmail("maris@gmail.com");
			patient8.setPassword("Maris@123");
			patient8.setAge(30);
			patient8.setMobileNumber(6789678909L);
			
			PatientEntity patient9 = new PatientEntity();
			patient9.setPatientName("Jegadheesan");
			patient9.setEmail("jegadhish@gmail.com");
			patient9.setPassword("Jega@111");
			patient9.setAge(60);
			patient9.setMobileNumber(9999999888L);
			
			PatientEntity patient10 = new PatientEntity();
			patient10.setPatientName("Ragavan");
			patient10.setEmail("ragavan@gmail.com");
			patient10.setPassword("Ragav@123");
			patient10.setAge(24);
			patient10.setMobileNumber(8778088268L);
			
			patientRepository.saveAll(Arrays.asList(patient1, patient2,patient3,patient4,patient5,patient6,patient7,patient8,patient9,patient10));
		}
	}

}
