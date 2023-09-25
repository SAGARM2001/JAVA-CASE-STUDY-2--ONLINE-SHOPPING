package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.mindcraft.pojo.Cart;
import in.mindcraft.pojo.CartProduct;
import in.mindcraft.utils.DBUtils; // Import your DBUtils class for database connection

public class CartDao {
	private PreparedStatement pst1;
	private Connection connection;

	public CartDao() {

	}

	// Method to add a cart item to the cart table
	public void addToCart(Cart cartItem) throws SQLException {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        connection = DBUtils.openConnection();
	        
	        // Disable autocommit mode to start a transaction
	        connection.setAutoCommit(false);
	        
	        String insertQuery = "INSERT INTO cart (customer_id, product_id, product_name, product_price, quantity) VALUES (?, ?, ?, ?, ?)";
	        preparedStatement = connection.prepareStatement(insertQuery);
	        preparedStatement.setInt(1, cartItem.getCustomerId());
	        preparedStatement.setInt(2, cartItem.getProductId());
	        preparedStatement.setString(3, cartItem.getProductName());
	        preparedStatement.setDouble(4, cartItem.getProductPrice());
	        preparedStatement.setInt(5, cartItem.getQuantity());
	        preparedStatement.executeUpdate();
	        
	        // Commit the transaction
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace(); // You can log the exception or handle it as needed
	        if (connection != null) {
	            // Rollback in case of an error
	            connection.rollback();
	        }
	        throw e; // Rethrow the exception to propagate it to the calling code
	    } finally {
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	        
	        // Re-enable autocommit mode after the transaction
	        if (connection != null) {
	            connection.setAutoCommit(true);
	        }
	        
	        DBUtils.closeConnection();
	    }
	}



	
	
//Method to retrieve cart products by customer ID
    public List<CartProduct> getCartProductsByCustomerId(int customerId) throws SQLException {
        List<CartProduct> cartProducts = new ArrayList<>();
        connection = DBUtils.openConnection();
        String selectQuery = "SELECT * FROM cart WHERE customer_id = ?";
        pst1 = connection.prepareStatement(selectQuery);
        pst1.setInt(1, customerId);

        ResultSet rs = pst1.executeQuery();
        while (rs.next()) {
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            double productPrice = rs.getDouble("product_price");
            int quantity = rs.getInt("quantity");

            CartProduct cartProduct = new CartProduct(productId, productName, productPrice, quantity);
            cartProducts.add(cartProduct);
        }

        rs.close();
        pst1.close();
        DBUtils.closeConnection();

        return cartProducts;
    }


 // Clear the cart for a specific customer
    public void clearCart(int customerId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtils.openConnection();
            connection.setAutoCommit(false); // Disable autocommit

            String sql = "DELETE FROM cart WHERE customer_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            preparedStatement.executeUpdate();

            // Commit the transaction immediately after successful delete
            connection.commit();
        } catch (SQLException e) {
	        e.printStackTrace(); // You can log the exception or handle it as needed
	        if (connection != null) {
	            // Rollback in case of an error
	            connection.rollback();
	        }
	        throw e; // Rethrow the exception to propagate it to the calling code
	    } finally {
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	        
	        // Re-enable autocommit mode after the transaction
	        if (connection != null) {
	            connection.setAutoCommit(true);
	        }
	        
	        DBUtils.closeConnection();
	    }

    }








}
