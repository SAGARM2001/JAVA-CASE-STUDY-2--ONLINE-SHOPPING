<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.login-container {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	width: 340px;
	text-align: center;
}

.login-heading {
	text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
	color: #ff6f61;
	font-size: 28px;
	margin-bottom: 20px;
}

label {
	display: block;
	margin-bottom: 5px;
}

input {
	width: 200px;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

input[type="submit"] {
	background-color: #ff6f61;
	color: #fff;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #e54844;
}

.error-message {
	color: #d9534f;
	font-size: 14px;
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2 class="login-heading">Admin Login</h2>
		<form action="${pageContext.request.contextPath}/admin" method="post">
			<label for="username">Username:</label> <input type="text"
				id="username" name="uname"><br> <label for="password">Password:</label>
			<input type="password" id="password" name="pass"><br> <input
				type="submit" value="Login">
		</form>
	</div>
</body>
	
</body>
</html>
