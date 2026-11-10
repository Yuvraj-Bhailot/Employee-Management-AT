<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Details</title>
<link rel="stylesheet" href="design.css">
</head>
<body>

<form method="post">
<fieldset>
<legend> <h2>Update Developer Details</h2> </legend>

ENTER EMPLOYEE ID: <input type="number" name="id"> <br> <br>

<%
String option = request.getParameter("option");

if(option.equals("updateName")){
%>	
ENTER NEW NAME: <input type="text" name="employeeName"> <br> <br>

<input type="submit" value="Update" formaction="updateDeveloperName"> <br><br>
<% 
} else if(option.equals("updateEmail")){
%>	
ENTER NEW EMAIL: <input type="text" name="email"> <br> <br>

<input type="submit" value="Update" formaction="updateDeveloperEmail"> <br><br>
<% 
} else if(option.equals("updateAddress")){
%>		
Enter House Number: <input type="number" name="houseNumber"> <br> <br>
Enter Area: <input type="text" name="area"> <br> <br>
Enter City: <input type="text" name="city"> <br> <br>
Enter State: <input type="text" name="state"> <br> <br>
Enter Country: <input type="text" name="country"> <br> <br>
Enter Pin Code: <input type="number" name="pincode"> <br> <br>

<input type="submit" value="Update" formaction="updateDeveloperAddress"> <br><br>
<%
}

%>  

</fieldset>
</form>

</body>
</html>