package com.eatm.service;

import com.eatm.dto.AddressDto;
import com.eatm.dto.EmployeeDto;
import com.eatm.dto.TaskDto;

public interface EmployeeServiceInterface {

	public String registerManager(EmployeeDto employeeDto, AddressDto addressDto);
	public String loginEmployee(String email, String password);
	public String addDeveloper(EmployeeDto employeeDto, AddressDto addressDto);
	public String createTask(TaskDto taskDto);
	public String assignTask(int taskId, int employeeId);
	public String deleteDeveloper(int employeeId);
	public String viewAllDeveloper();
	public String deleteTask(int taskId);
	public String logoutEmployee();
	public String verifyEmail(String email);
	public String forgotPassword(String password);
	public String updateDeveloperName(int id, String employeeName);
	public String updateDeveloperEmail(int id, String email);
	public String updateDeveloperAddress(int id, AddressDto addressDto);
	public String changeTaskStatus(int taskId);
	public String viewAllTask();
	
}
