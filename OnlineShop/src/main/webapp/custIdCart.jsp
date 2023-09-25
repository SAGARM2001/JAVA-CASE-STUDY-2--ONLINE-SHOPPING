<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer ID Input</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.showbtn {
	background-color: #ff6f61;
	border: none;
	color: white;
	padding: 5px 10px;
	cursor: pointer;
}
.showbtn:hover {
    background-color: #e54844;
    transform: scale(1.1); 
    transition: 0.2s ease-in-out; 
}
.page-heading {
	text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.2);
	font-size: 36px;
	margin-left: 100px
}
</style>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h2 class="page-heading">Enter <span style="color: #ff6f61;">Customer</span> ID</h2>
					</div>
					<div class="card-body">
						<form action="${pageContext.request.contextPath}/cartprod" method="post">
							<div class="form-group">
								<label for="customerId">Customer ID:</label> <input type="text"
									class="form-control" id="customerId" name="customerId"
									placeholder="Enter Customer ID" required>
							</div>
							<div class="text-center">
								<button type="submit" class="showbtn">Show Cart Products</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
