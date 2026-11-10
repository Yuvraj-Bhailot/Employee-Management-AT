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

<form action="addDeveloper" method="post">
<fieldset>
<legend> <h2>Add Developer Form</h2> </legend>

ENTER DEVELOPER NAME: <input type="text" name="employeeName"> <br> <br>
ENTER DEVELOPER EMAIL: <input type="email" name="email"> <br> <br>
ENTER DEVELOPER PASSWORD: <input type="password" name="password"> <br> <br>
ENTER DEVELOPER SALARY: <input type="number" name="salary" step="0.01"> <br> <br>
ENTER DEVELOPER GENDER: <input type="text" name="gender"> <br> <br>

<h2>Developer Address Details:</h2>

Enter House Number: <input type="number" name="houseNumber"> <br> <br>
Enter Area: <input type="text" name="area"> <br> <br>
Enter City: <input type="text" name="city"> <br> <br>
Enter State: <input type="text" name="state"> <br> <br>
Enter Country: <input type="text" name="country"> <br> <br>
Enter Pin Code: <input type="number" name="pincode"> <br> <br>

<input type="submit" value="ADD DEVELOPER"> 

</fieldset>
</form>

</body>
</html>