<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Wallet Balance</title>
<!-- Include Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<style>
.container {
	max-width: 600px;
}
.btn-custom {
	padding: 10px 20px;
	font-size: 16px;
	background-color: #ff6f61;
	color: #fff;
	border: none;
	width: 200px;
	border-radius: 5px;
	margin: 10px;
	cursor: pointer;
	transition: transform 0.2s ease-in-out;
}

.btn-custom:hover {
	background-color: #e54844;
	transform: scale(1.05);
}
</style>
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">Wallet Balance</h2>
		<div class="text-center">
			<p class="lead">
				Your wallet balance is:
				<%=request.getAttribute("balance")%></p>
		</div>

		<div class="text-center mt-3">
			<a href="custIdDisplay.jsp" class="btn btn-custom">Back</a>
		</div>
	</div>
</body>
</html>
