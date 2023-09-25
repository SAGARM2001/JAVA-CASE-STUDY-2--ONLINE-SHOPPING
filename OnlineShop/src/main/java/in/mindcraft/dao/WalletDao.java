package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.mindcraft.pojo.Wallet;
import in.mindcraft.utils.DBUtils;

public class WalletDao {

//	add wallet balance
	public void addToWallet(Wallet wallet) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtils.openConnection();
			connection.setAutoCommit(false); // Disable autocommit

			String checkSql = "SELECT * FROM wallet WHERE customer_id = ?";
			preparedStatement = connection.prepareStatement(checkSql);
			preparedStatement.setInt(1, wallet.getCustomerId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// Customer ID already exists, update the amount
				double currentAmount = resultSet.getDouble("amount");
				double newAmount = currentAmount + wallet.getAmount();

				String updateSql = "UPDATE wallet SET amount = ? WHERE customer_id = ?";
				preparedStatement = connection.prepareStatement(updateSql);
				preparedStatement.setDouble(1, newAmount);
				preparedStatement.setInt(2, wallet.getCustomerId());
				preparedStatement.executeUpdate();
			} else {
				// Customer ID doesn't exist, insert a new record
				String insertSql = "INSERT INTO wallet (customer_id, amount) VALUES (?, ?)";
				preparedStatement = connection.prepareStatement(insertSql);
				preparedStatement.setInt(1, wallet.getCustomerId());
				preparedStatement.setDouble(2, wallet.getAmount());
				preparedStatement.executeUpdate();
			}

			connection.commit(); // Commit the transaction
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				connection.rollback(); // Rollback in case of an error
			}
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			connection.setAutoCommit(true); // Re-enable autocommit
			DBUtils.closeConnection();
		}
	}

// Get wallet balance
	public double getWalletBalance(int customerId) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		double balance = 0.0;

		try {
			connection = DBUtils.openConnection();
			String sql = "SELECT amount FROM wallet WHERE customer_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				balance = resultSet.getDouble("amount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
			DBUtils.closeConnection();
		}
		return balance;
	}

	public void updateWalletBalance(int customerId, double newBalance) throws SQLException {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        connection = DBUtils.openConnection();

	        String sql = "UPDATE wallet SET amount = ? WHERE customer_id = ?";
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setDouble(1, newBalance);
	        preparedStatement.setInt(2, customerId);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	        if (connection != null) {
	            DBUtils.closeConnection(); // Close the connection here
	        }
	    }
	}


}
