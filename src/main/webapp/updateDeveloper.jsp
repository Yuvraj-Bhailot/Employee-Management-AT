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

	<form action="developerOption.jsp">
		<fieldset>
			<legend>
				<h2>Update Developer Details</h2>
			</legend>
			SELECT AN OPTION YOU WANT TO UPDATE: <br> <select name="option">
				<option value="updateName">Name</option>
				<option value="updateEmail">Email</option>
				<option value="updateAddress">Address</option>
			</select> <br> <br> <input type="submit" value="PROCEED"
				class="button">
		</fieldset>
	</form>

</body>
</html>