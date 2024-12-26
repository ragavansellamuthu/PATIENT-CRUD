package com.ambiasystems.aria.patient.model;

import java.io.Serializable;
import java.util.Date;

import com.ambiasystems.aria.patient.annotaion.Age;
import com.ambiasystems.aria.patient.annotaion.MobileNumber;
import com.ambiasystems.aria.patient.annotaion.UniqueEmail;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientModel implements Serializable{

	private static final long serialVersionUID = 5469674939953691540L;

	private long patientId ; 
	
	@NotBlank(message = "Patient name is required",groups= {ValidCreation.class,ValidUpdation.class})
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Patient name must contain only letters and spaces",groups= {ValidCreation.class,ValidUpdation.class})
	@Size(max = 25, message = "Patient name must be less than or equal to 25 characters",groups= {ValidCreation.class,ValidUpdation.class})
	private String patientName ; 
	
	@NotBlank(message = "Email is required",groups= {ValidCreation.class,ValidUpdation.class})
	@Email(message ="Invalid Email Address",groups= {ValidCreation.class,ValidUpdation.class})
	@Size(max = 50 , message = "Email must be less than or equal to 50 characters",groups= {ValidCreation.class,ValidUpdation.class})
	@UniqueEmail(groups = ValidCreation.class)
	private String email ; 
	
	@NotBlank(message = "Password is required",groups=ValidCreation.class)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
    message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special symbol",
    groups = ValidCreation.class)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password ; 
	
	@Age(groups= {ValidCreation.class,ValidUpdation.class})
	private int age ; 
	
	@MobileNumber(groups= {ValidCreation.class,ValidUpdation.class})
	private long mobileNumber ; 
	
	@JsonProperty(access = Access.READ_ONLY)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createdAt ; 
	
	@JsonProperty(access = Access.READ_ONLY)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date updatedAt ; 
	
	// Validation groups : 
	
	public interface ValidCreation{}
	
	public interface ValidUpdation{}
	
}
