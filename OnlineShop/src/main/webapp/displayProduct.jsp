<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

h1 {
    text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
    text-align: center;
    margin: 20px 0;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    border: 1px solid #ccc;
}

th, td {
    padding: 10px;
    text-align: center;
    border: 1px solid #ccc;
}

th {
    background-color: #f2f2f2;
}
</style>
</head>
<body>
    <div class="container">
        <h1>Product List</h1>
        <table class="table table-bordered">
            <thead class="thead-light">
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Product Price</th>
                    <th>Product Quantity</th>
                    <th>Product Discount</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<in.mindcraft.pojo.Product> products = (List<in.mindcraft.pojo.Product>) request.getAttribute("products");
                for (int i = 0; i < products.size(); i++) {
                    in.mindcraft.pojo.Product product = products.get(i);
                %>
                <tr>
                    <td><%=product.getPid()%></td>
                    <td><%=product.getPname()%></td>
                    <td><%=product.getPrice()%></td>
                    <td><%=product.getQuantity()%></td>
                    <td><%=product.getDiscount()%></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </div>

</body>
</html>
