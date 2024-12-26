package com.ambiasystems.aria.patient.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="patient")
@EntityListeners(AuditingEntityListener.class)
public class PatientEntity implements Serializable{

	private static final long serialVersionUID = -4410019507343869269L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private long patientId ; 
	
	@Column(name="patient_name",nullable=false,length=25)
	private String patientName ; 
	
	@Column(name="email",nullable=false,length=50)
	private String email ; 
	
	@Column(name="password",nullable=false)
	private String password ; 
	
	@Column(name="age",nullable=false)
	private int age ; 
	
	@Column(name="mobile_number",nullable=false,length=10)
	private long mobileNumber ; 
	
	@Column(name="is_deleted",nullable=false)
	private boolean isDeleted;
	
    @CreatedDate
	@Column(name="created_at")
	private Date createdAt;
	
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at",nullable=true)
	private Date updatedAt;
	
	@PreUpdate
	public void preUpdate() {
		this.updatedAt = new Date();
	}
	 
}
