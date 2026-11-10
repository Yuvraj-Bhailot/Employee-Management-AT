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

<form action="createTask" method="post">
<fieldset>
<legend> <h2>Create Task Form</h2> </legend>

ENTER TASK NAME: <input type="text" name="taskName"> <br> <br>
ENTER TASK DURATION(DAYS): <input type="number" name="duration"> <br> <br>

<input type="submit" value="CREATE TASK"> <br><br>  

</fieldset>
</form>

</body>
</html>