package in.mindcraft.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.mindcraft.dao.CustomerDao;
import in.mindcraft.dao.ProductDao;
import in.mindcraft.pojo.Customer;
import in.mindcraft.pojo.Product;

@Controller
public class AdminController {
	private static final String ADMIN_USERNAME = "sagar";
	private static final String ADMIN_PASSWORD = "1234";

//	ADMIN LOGIN SATHI KELA AHE HE
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String adminLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");

		if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
			return "admindash.jsp";
		} else {
			return "adminLogin.jsp";
		}
	}

	
//	ADD PRODUCT SATHI ADMIN SIDE NE
	private ProductDao productdao = new ProductDao();

	@RequestMapping("/addproduct")
	public String addProduct(HttpServletRequest request, HttpServletResponse response, Model model) {
		int pid = Integer.parseInt(request.getParameter("productId"));
		String pname = request.getParameter("productName");
		double price = Double.parseDouble(request.getParameter("productPrice"));
		int quantity = Integer.parseInt(request.getParameter("productQuantity"));
		double discount = Double.parseDouble(request.getParameter("productDiscount"));

		Product product = new Product(pid, pname, price, quantity, discount);
		try {
			productdao.addProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "addProduct.jsp";
	}
	
	

//	PRODUCTS DISPLAY KRNYA SATHI
	@RequestMapping("/display")
	public String showProducts(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Product> list = productdao.getProducts();
			request.setAttribute("products", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "displayProduct.jsp";
	}
	
	

//	ADMIN SIDE CUSTOMER ADD KRNYA SATHI
	private CustomerDao customerdao = new CustomerDao();

	@RequestMapping("/addcustomer")
	public String addCustomer(HttpServletRequest request, HttpServletResponse response, Model model) {
		int cid = Integer.parseInt(request.getParameter("customerId"));
		String cpass = request.getParameter("customerPass");
		Customer customer = new Customer(cid, cpass);

		try {
			customerdao.addCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "addCustomer.jsp";
	}
	
	

//	ADMIN SIDE NE CUSTOMER DELETE KRNYA SATHI
	@RequestMapping("/deletecustomer")
	public String deleteCustomer(@RequestParam("custId") int customerId, Model model) {
		try {
			customerdao.deleteCustomer(customerId);
			model.addAttribute("successMessage", "Customer deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "deleteCustomer.jsp";
	}
}
