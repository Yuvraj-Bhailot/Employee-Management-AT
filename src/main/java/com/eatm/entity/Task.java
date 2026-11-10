package com.eatm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskId_gen")
	@SequenceGenerator(name = "taskId_gen", initialValue = 51, allocationSize = 1)
	private int taskId;
	private String taskName;
	private int duration;
	private String status;
	
}
