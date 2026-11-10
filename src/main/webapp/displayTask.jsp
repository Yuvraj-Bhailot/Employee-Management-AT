<%@page import="com.eatm.dto.TaskDto"%>
<%@page import="com.eatm.util.EntityMapper"%>
<%@page import="com.eatm.entity.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="design.css">
</head>
<body>

<table border="1">
<tr>
<th>TASK ID</th>
<th>TASK NAME</th>
<th>DURATION</th>
<th>STATUS</th>
</tr>

<% 
List<Task> taskList = (List<Task>)request.getAttribute("taskList");
EntityMapper entityMapper = (EntityMapper)request.getAttribute("entityMapper");
for(Task task: taskList){
	TaskDto taskDto = entityMapper.convertEntityToTaskDto(task); 
	int id = taskDto.getTaskId();
	String name = taskDto.getTaskName();
	int duration = taskDto.getDuration();
	String status = taskDto.getStatus();

	
	%>
	<tr>
	<td> <%= id %> </td>
	<td> <%= name %> </td>
	<td> <%= duration %> </td>
	<td> <%= status %> </td>
	</tr>
	<%
	}
%>

</table>

</body>
</html>