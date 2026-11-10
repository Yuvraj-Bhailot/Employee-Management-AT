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

<form action="assignTask" method="post">
<fieldset>
<legend> <h2>Assign Task To Developer</h2> </legend>

ENTER TASK ID: <input type="number" name="taskId"> <br> <br>
ENTER DEVELOPER ID: <input type="number" name="employeeId"> <br> <br>

<input type="submit" value="ASSIGN TASK"> <br><br>  

</fieldset>

</form>

</body>
</html>