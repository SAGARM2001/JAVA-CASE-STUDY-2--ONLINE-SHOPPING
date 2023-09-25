<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Login</title>
<!-- Include Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.login-container {
	background-color: #fff;
	padding: 20px;
	margin-top: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
	text-align: center;
}

.login-heading {
	color: #ff6f61;
	font-size: 28px;
	text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
}

.error-message {
	color: #d9534f;
	font-size: 14px;
	margin-top: 10px;
}

.btn-custom {
	padding: 10px 20px;
	font-size: 16px;
	background-color: #ff6f61;
	color: #fff;
	border: none;
	width: 100px;
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
		<div class="row justify-content-center">
			<div class="col-md-4">
				<div class="login-container">
					<h2 class="login-heading">Customer Login</h2>
					<form action="customerLoginAction" method="post">
						<div class="mb-3">
							<label for="username" class="form-label">Username:</label> <input
								type="text" class="form-control" id="username" name="username">
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">Password:</label> <input
								type="password" class="form-control" id="password"
								name="password">
						</div>
						<button type="submit" class="btn btn-custom">Login</button>
					</form>
					<p class="error-message">${errorMessage}</p>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
