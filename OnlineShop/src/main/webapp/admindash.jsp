<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f8f8;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.dashboard-container {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	width: 400px;
	text-align: center;
}

.dashboard-heading {
	text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
	font-size: 36px;
	margin-bottom: 20px;
}

.dashboard-buttons {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 20px;
}

.dashboard-buttons form {
	margin: 10px 0;
}

input[type="submit"] {
	padding: 10px 20px;
	font-size: 16px;
	background-color: #ff6f61;
	color: #fff;
	border: none;
	border-radius: 5px;
	margin: 10px;
	cursor: pointer;
	transition: transform 0.2s ease-in-out;
}

input[type="submit"]:hover {
	background-color: #e54844;
	transform: scale(1.05);
}
</style>
</head>
<body>
	<div class="dashboard-container">
		<h1 class="dashboard-heading">
			Welcome, <span style="color: #ff6f61;">Admin!</span>
		</h1>
		<div class="dashboard-buttons">
			<form action="addProduct.jsp">
				<input type="submit" value="Add Product in List" />
			</form>

			<form action="display">
				<input type="submit" value="Display Product from List" />
			</form>

			<form action="addCustomer.jsp">
				<input type="submit" value="Add Customer Account" />
			</form>

			<form action="deleteCustomer.jsp">
				<input type="submit" value="Delete Customer Account" />
			</form>
		</div>
	</div>
</body>
</html>
