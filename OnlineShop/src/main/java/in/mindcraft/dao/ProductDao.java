package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.mindcraft.pojo.Product;
import in.mindcraft.utils.DBUtils;

public class ProductDao {
	private Connection cn;
	private PreparedStatement pst1;

	
//	Admin side ne product krnya sathi
	public void addProduct(Product product) throws SQLException {
	    cn = DBUtils.openConnection();
	    String insertQuery = "INSERT INTO products (pid, pname, pprice,pquantity,pdiscount) VALUES (?, ?, ?, ?, ?)";
	    pst1 = cn.prepareStatement(insertQuery);
	    pst1.setInt(1, product.getPid());
	    pst1.setString(2, product.getPname());
	    pst1.setDouble(3, product.getPrice());
	    pst1.setInt(4, product.getQuantity());
	    pst1.setDouble(5, product.getDiscount());
	    pst1.execute();
	    cn.commit(); // Add this commit statement
	    DBUtils.closeConnection();
	}

//	Product chi list get krnya sathi database madhun
	public List<Product> getProducts() throws SQLException {
		List<Product> list = new ArrayList<Product>();
		cn = DBUtils.openConnection();
		String selectQuery = "SELECT * FROM products";
		pst1 = cn.prepareStatement(selectQuery);

		ResultSet rs = pst1.executeQuery();
		while (rs.next()) {
			int pid = rs.getInt("pid");
			String name = rs.getString("pname");
			double price = rs.getDouble("pprice");
			int qty = rs.getInt("pquantity");
			Double disc = rs.getDouble("pdiscount");

			Product product = new Product(pid, name, price, qty, disc);
			list.add(product);
		}

		rs.close();
		pst1.close();
		DBUtils.closeConnection();

		return list;
	}
	
	
//	je products available ahet te ithun get krya sathi
	public List<Product> getAvailableProducts() throws SQLException {
	    List<Product> list = new ArrayList<Product>();
	    cn = DBUtils.openConnection();
	    String selectQuery = "SELECT pid, pname, pprice FROM products"; // columns je pahije tech ghetle
	    pst1 = cn.prepareStatement(selectQuery);

	    ResultSet rs = pst1.executeQuery();
	    System.out.println("Query reach");
	    while (rs.next()) {
	    	System.out.println("ini");
	        int pid = rs.getInt("pid");
	        String name = rs.getString("pname");
	        double price = rs.getDouble("pprice");

	        Product product = new Product(pid, name, price);
	        list.add(product);
	        System.out.println("product added");
	    }

	    rs.close();
	    pst1.close();
	    DBUtils.closeConnection();

	    return list;
	}
	
	
//	Product id varun product get krnyasathi
	public Product getProductById(int productId) throws SQLException {
        cn = DBUtils.openConnection();
        String selectQuery = "SELECT * FROM products WHERE pid = ?";
        pst1 = cn.prepareStatement(selectQuery);
        pst1.setInt(1, productId);

        ResultSet rs = pst1.executeQuery();
        Product product = null;

        if (rs.next()) {
            int pid = rs.getInt("pid");
            String pname = rs.getString("pname");
            double price = rs.getDouble("pprice");
            
            // Created a Product object with the retrieved data
            product = new Product(pid, pname, price);
        }
        rs.close();
        DBUtils.closeConnection();

        return product;
    }
}
