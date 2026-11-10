package com.eatm.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendanceId_gen")
	@SequenceGenerator(name = "attendanceId_gen", initialValue = 101, allocationSize = 1)
	private int attendanceId;
	@CreationTimestamp
	private LocalDateTime loginTime;
	private LocalDateTime logoutTime;
		
}
