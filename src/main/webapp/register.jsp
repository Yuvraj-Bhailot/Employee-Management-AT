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

<form action="registerManager" method="post">
<fieldset>
<legend>Register Form</legend>

<h2>Employee Details:</h2>

Enter Employee Name: <input type="text" name="employeeName"> <br> <br>
Enter Employee Email: <input type="text" name="email"> <br> <br>
Enter Employee Password: <input type="password" name="password" required="required"> <br> <br>
Enter Employee Salary: <input type="number" name="salary" step="0.01"> <br> <br>
Enter Employee Gender: <input type="text" name="gender"> <br> <br>

<h2>Employee Address Details:</h2>

Enter House Number: <input type="number" name="houseNumber"> <br> <br>
Enter Area: <input type="text" name="area"> <br> <br>
Enter City: <input type="text" name="city"> <br> <br>
Enter State: <input type="text" name="state"> <br> <br>
Enter Country: <input type="text" name="country"> <br> <br>
Enter Pin Code: <input type="number" name="pincode"> <br> <br>

<input type="submit" value="REGISTER">

</fieldset>
</form>

</body>
</html>