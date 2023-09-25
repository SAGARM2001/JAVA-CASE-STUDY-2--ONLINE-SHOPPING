<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Funds</title>
<!-- Include Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.btn-custom {
	padding: 10px 20px;
	font-size: 16px;
	background-color: #ff6f61;
	color: #fff;
	border: none;
	width: 480px;
	border-radius: 5px;
	margin: 10px;
	cursor: pointer;
	transition: transform 0.2s ease-in-out;
}

.btn-custom:hover {
	background-color: #e54844;
	transform: scale(1.05);
}
.card-header{
text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
	font-size: 36px;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h2 class="text-center">Add <span style="color: #ff6f61;">Funds</span> to Your <span style="color: #ff6f61;">Wallet!</span></h2>
					</div>
					<div class="card-body">
						<form action="${pageContext.request.contextPath}/addFundsToWallet"
							method="POST">
							<div class="form-group">
								<label for="customerId">Customer ID:</label> <input type="text"
									class="form-control" id="customerId" name="customerId" required>
							</div>
							<div class="form-group">
								<label for="amount">Amount to Add:</label> <input type="number"
									class="form-control" id="amount" name="amount" required>
							</div>
							<button type="submit" class="btn btn-custom">Add Funds</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>