package com.akhm.repository.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="STUDENT_TL")
public class StudentEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="STUDENT_ID")
		private Integer studentId;
		//nullable=false means its maditory.
		@Column(name="FIRST_NAME",nullable = false,length = 50)
		private String firstName;
		@Column(name="LAST_NAME")
		private String lastName;
		@Column(name="EMAIL_ID")
		private String emailId;
		@Column(name="DATE_OF_BIRTH")
		private Date dateOfBirth;
		@Column(name="PASSWORD")
		private String password;
		
}
