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

<%
String message = (String)request.getAttribute("message");

if(message!=null){
%>

<h2 style="color: red">  <%=message %> </h2>

<%} %>
<form action="loginEmployee" method="post">
<fieldset>
<legend> <h2>Employee Login Form</h2> </legend>

ENTER EMPLOYEE EMAIL: <input type="email" name="email"> <br> <br>
ENTER EMPLOYEE PASSWORD: <input type="password" name="password"> <br> <br>

<input type="submit" value="LOGIN"> <br><br>  

<a href="verifyEmail.jsp">FORGOT PASSWORD?</a> &nbsp;
<a href="register.jsp">NEW USER?</a>

</fieldset>
</form>

</body>
</html>