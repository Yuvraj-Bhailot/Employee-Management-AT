<%@page import="com.eatm.dto.TaskDto"%>
<%@page import="com.eatm.dto.AddressDto"%>
<%@page import="com.eatm.dto.EmployeeDto"%>
<%@page import="com.eatm.util.EntityMapper"%>
<%@page import="com.eatm.entity.Task"%>
<%@page import="com.eatm.entity.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Developer</title>
<link rel="stylesheet" href="design.css">
</head>
<body>

<table border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>PASSWORD</th>
<th>SALARY</th>
<th>GENDER</th>
<th>ROLE</th>
<th>Address</th>
<th>TASK</th>
</tr>

<% 
List<Employee> employeeList = (List<Employee>)session.getAttribute("developerList"); 
EntityMapper entityMapper = (EntityMapper)session.getAttribute("entityMapper");

for(Employee employees: employeeList){
	
	EmployeeDto employee = entityMapper.convertEntityToEmployeeDto(employees);
	AddressDto employeeAddress = entityMapper.convertEntityToAddressDto(employees.getAddress());
	
	
	int id = employee.getEmployeeId();
	String name = employee.getEmployeeName();
	String email = employee.getEmail();
	String password = employee.getPassword();
	double salary = employee.getSalary();
	String gender = employee.getGender();
	String role = employee.getRole();
	String address = employeeAddress.getHouseNumber()+", "+employeeAddress.getArea()+", "
			+employeeAddress.getCity()+", "+employeeAddress.getState()+", "
			+employeeAddress.getCountry()+", "+employeeAddress.getPincode();
	
	List<Task> taskList = employees.getTasks();
	List<String> tasks = new ArrayList<String>();
	
	for(Task employeeTask: taskList){
		TaskDto task = entityMapper.convertEntityToTaskDto(employeeTask);
		tasks.add("["+task.getTaskId()+", "+task.getTaskName()+", "+task.getDuration()+", "
		            +task.getStatus()+"]");
	}
	
	%>
	<tr>
	<td> <%= id %> </td>
	<td> <%= name %> </td>
	<td> <%= email %> </td>
	<td> <%= password %> </td>
	<td> <%= salary %> </td>
	<td> <%= gender %> </td>
	<td> <%= role %> </td>
	<td> <%= address %> </td>
	<td> <%= tasks %> </td>
	</tr>
	<%
	}
%>

</table>

</body>
</html>