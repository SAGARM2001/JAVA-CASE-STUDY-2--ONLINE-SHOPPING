<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
            color: #ff6f61;
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 16px;
        }

        input[type="number"] {
            width: 100%;
        }

        input[type="submit"] {
            background-color: #ff6f61;
            color: #fff;
            border: none;
            cursor: pointer;
            padding: 10px;
            border-radius: 3px;
            transition: background-color 0.2s ease-in-out;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #e54844;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add Product</h1>
        <form action="addproduct">
            <div class="form-group">
                <label for="productId">Product ID:</label> 
                <input type="text" class="form-control" name="productId" placeholder="Enter Product ID"> 
            </div>
            <div class="form-group">
                <label for="productName">Product Name:</label> 
                <input type="text" class="form-control" name="productName" placeholder="Enter Product Name"> 
            </div>
            <div class="form-group">
                <label for="productPrice">Product Price:</label> 
                <input type="number" class="form-control" name="productPrice" placeholder="Enter Product Price"> 
            </div>
            <div class="form-group">
                <label for="productQuantity">Product Quantity:</label> 
                <input type="number" class="form-control" name="productQuantity" placeholder="Enter Product Quantity">
            </div>
            <div class="form-group">
                <label for="productDiscount">Product Discount:</label> 
                <input type="number" class="form-control" name="productDiscount" placeholder="Enter Product Discount"> 
            </div>
            <input type="submit" class="btn btn-primary" value="Add Product">
        </form>
    </div>
</body>
</html>
