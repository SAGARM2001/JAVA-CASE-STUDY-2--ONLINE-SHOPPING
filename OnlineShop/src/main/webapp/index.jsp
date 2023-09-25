<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Shopping</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .custom-heading {
            font-size: 36px;
            color: #333;
            text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin-top: 20px; 
        }

        .center-vertically {
            display: flex;
            flex-direction: column;
            justify-content: center;
            min-height: 80vh;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1 class="custom-heading">Welcome to the <span style="color: #ff6f61;">Online Shop</span>!</h1>
    </div>

    <div class="container center-vertically">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center">
                <!-- Login as Customer Button -->
                <form action="customerLogin.jsp">
                    <button type="submit" class="btn btn-primary btn-lg">Login as Customer</button>
                </form>
                
                <!-- Login as Administrator Button -->
                <form action="adminLogin.jsp">
                    <button type="submit" class="btn btn-danger btn-lg mt-3">Login as Administrator</button>
                </form>
            </div>
        </div>
    </div>


</body>
</html>


