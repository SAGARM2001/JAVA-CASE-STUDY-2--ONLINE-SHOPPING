<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Cart Products</title>
<!-- Include Bootstrap CSS and custom styles if needed -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
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

.page-heading {
	text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.2);
	font-size: 36px;
	margin-left: 500px
}
</style>
</head>
<body>
	<div class="container mt-5">
		<h2 class="page-heading">
			Cart <span style="color: #ff6f61;">Products</span>
		</h2>

		<form action="${pageContext.request.contextPath}/pay" method="post">
			<div class="form-group">
				<label for="customerId">Customer ID:</label> <input type="text"
					class="form-control" id="customerId" name="customerId"
					placeholder="Enter Customer ID">
			</div>

			<div class="table-container">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Product ID</th>
							<th>Product Name</th>
							<th>Price</th>
							<th>Quantity</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cartProducts}" var="cartProduct">
							<tr>
								<td>${cartProduct.productId}</td>
								<td>${cartProduct.productName}</td>
								<td>${cartProduct.productPrice}</td>
								<td>${cartProduct.quantity}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="text-right">
				<p>
					Total Price: $<%=request.getAttribute("totalPrice")%></p>
				<button type="submit" class="btn btn-custom">Pay</button>
			</div>
		</form>

	</div>

</body>
</html>
