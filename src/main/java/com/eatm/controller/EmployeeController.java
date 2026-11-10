package com.eatm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eatm.dto.AddressDto;
import com.eatm.dto.EmployeeDto;
import com.eatm.dto.TaskDto;
import com.eatm.service.EmployeeServiceInterface;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceInterface employeeServiceInterface;

	@RequestMapping("/registerManager")
	public String registerManager(@ModelAttribute EmployeeDto employeeDto, @ModelAttribute AddressDto addressDto) {
		return employeeServiceInterface.registerManager(employeeDto, addressDto);
	}

	@RequestMapping("/loginEmployee")
	public String loginEmployee(@RequestParam("email") String email, @RequestParam("password") String password) {
		return employeeServiceInterface.loginEmployee(email, password);
	}

	@RequestMapping("/addDeveloper")
	public String addDeveloper(@ModelAttribute EmployeeDto employeeDto, @ModelAttribute AddressDto addressDto) {
		return employeeServiceInterface.addDeveloper(employeeDto, addressDto);
	}

	@RequestMapping("/createTask")
	public String createTask(@ModelAttribute TaskDto taskDto) {
		return employeeServiceInterface.createTask(taskDto);
	}

	@RequestMapping("/assignTask")
	public String assignTask(@RequestParam("taskId") int taskId, @RequestParam("employeeId") int employeeId) {
		return employeeServiceInterface.assignTask(taskId, employeeId);
	}

	@RequestMapping("/deleteDeveloper")
	public String deleteDeveloper(@RequestParam("employeeId") int employeeId) {
		return employeeServiceInterface.deleteDeveloper(employeeId);
	}

	@RequestMapping("/viewAllDeveloper")
	public String viewAllDeveloper() {
		return employeeServiceInterface.viewAllDeveloper();
	}

	@RequestMapping("/deleteTask")
	public String deleteTask(@RequestParam("taskId") int taskId) {
		return employeeServiceInterface.deleteTask(taskId);
	}

	@RequestMapping("/logoutEmployee")
	public String logoutEmployee() {
		return employeeServiceInterface.logoutEmployee();
	}

	@RequestMapping("/verifyEmail")
	public String verifyEmail(@RequestParam("email") String email) {
		return employeeServiceInterface.verifyEmail(email);
	}

	@RequestMapping("/forgotPassword")
	public String forgotPassword(@RequestParam("password") String password) {
		return employeeServiceInterface.forgotPassword(password);
	}

	@RequestMapping("/updateDeveloperName")
	public String updateDeveloperName(@RequestParam("id") int id, @RequestParam("employeeName") String employeeName) {
		return employeeServiceInterface.updateDeveloperName(id, employeeName);
	}
	
	@RequestMapping("/updateDeveloperEmail")
	public String updateDeveloperEmail(@RequestParam("id") int id,
			@RequestParam("email") String email) {
		return employeeServiceInterface.updateDeveloperEmail(id, email);
	}
	
	@RequestMapping("/updateDeveloperAddress")
	public String updateDeveloperAddress(@RequestParam("id") int id, @ModelAttribute AddressDto addressDto) {
		return employeeServiceInterface.updateDeveloperAddress(id, addressDto);
	}
	
	@RequestMapping("/changeTaskStatus")
	public String changeTaskStatus(@RequestParam("taskId") int taskId) {
		return employeeServiceInterface.changeTaskStatus(taskId);
	}
	
	@RequestMapping("/viewAllTask")
	public String viewAllTask() {
		return employeeServiceInterface.viewAllTask();
	}

	
}
