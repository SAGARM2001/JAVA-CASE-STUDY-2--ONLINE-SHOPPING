package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.mindcraft.pojo.Customer;
import in.mindcraft.utils.DBUtils;

public class CustomerDao {
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;

	// Customer add krnya sathi
	public void addCustomer(Customer customer) throws SQLException {
	    cn = DBUtils.openConnection();
	    cn.setAutoCommit(false); // Disable autocommit
	    try {
	        String insertQuery = "INSERT INTO customer (customer_id, customer_pass) VALUES (?, ?)";
	        pst1 = cn.prepareStatement(insertQuery);
	        pst1.setInt(1, customer.getCid());
	        pst1.setString(2, customer.getCpass());
	        pst1.execute();
	        cn.commit(); // Commit the transaction
	    } catch (SQLException e) {
	        cn.rollback(); // Rollback in case of an error
	        throw e;
	    } finally {
	        cn.setAutoCommit(true); // Re-enable autocommit
	        DBUtils.closeConnection();
	    }
	}


	
//	Customer database madhe ahe ki nahi te check krnya sathi
	public boolean doesCustomerExist(int customerId) throws SQLException {
		cn = DBUtils.openConnection();
		String checkQuery = "SELECT * FROM customer WHERE customer_id = ?";
		pst2 = cn.prepareStatement(checkQuery);
		pst2.setInt(1, customerId);
		ResultSet rs = pst2.executeQuery();
		boolean customerExists = rs.next();
		rs.close();
		DBUtils.closeConnection();
		return customerExists;
	}

	
//	Customer account delete krnya sathi
	public void deleteCustomer(int customerId) throws SQLException {
		cn = DBUtils.openConnection();
		String deleteQuery = "DELETE FROM customer WHERE customer_id = ?";
		pst3 = cn.prepareStatement(deleteQuery);
		pst3.setInt(1, customerId);
		pst3.execute();
		cn.commit();
		DBUtils.closeConnection();
	}

	
//	Customer account get krnya sathi
	public Customer getCustomer(int customerId) throws SQLException {
		cn = DBUtils.openConnection();
		String selectQuery = "SELECT * FROM customer WHERE customer_id = ?";
		pst4 = cn.prepareStatement(selectQuery);
		pst4.setInt(1, customerId);
		ResultSet rs = pst4.executeQuery();

		Customer customer = null;
		if (rs.next()) {
			String cpass = rs.getString("customer_pass");
			customer = new Customer(customerId, cpass);
		}
		rs.close();
		DBUtils.closeConnection();

		return customer;
	}


}
