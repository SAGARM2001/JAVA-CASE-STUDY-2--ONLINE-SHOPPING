package in.mindcraft.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.mindcraft.dao.CartDao;
import in.mindcraft.dao.CustomerDao;
import in.mindcraft.dao.ProductDao;
import in.mindcraft.dao.WalletDao;
import in.mindcraft.pojo.Cart;
import in.mindcraft.pojo.CartProduct;
import in.mindcraft.pojo.Customer;
import in.mindcraft.pojo.Product;
import in.mindcraft.pojo.Wallet;

@Controller
public class CustomerController {

//	CUSTOMER LOGIN SATHI KELA AHE
	private CustomerDao customerdao = new CustomerDao();
	@RequestMapping(value = "/customerLoginAction", method = RequestMethod.POST)
	public String customerLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		int customerId = Integer.parseInt(request.getParameter("username"));
		String password = request.getParameter("password");

		try {
			if (customerdao.doesCustomerExist(customerId)) {
				Customer customer = customerdao.getCustomer(customerId);

				if (customer.getCpass().equals(password)) {
					return "customerdash.jsp"; // Successful login jhala ki customerdash cha page yeil
				} else {
					model.addAttribute("errorMessage", "Incorrect password");
				}
			} else {
				model.addAttribute("errorMessage", "Customer not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "An error occurred");
		}
		return "customerLogin.jsp"; // Unsuccessful login jhala ki toch page yeil login cha parat error msg sobat
	}

	
//	ADD PRODUCT PAGE VAR PRODUCT DISPLAY SATHI
	private ProductDao productDao = new ProductDao();
	private int customerId;

	@RequestMapping(value = "/addProductcart", method = RequestMethod.GET)
	public String customerDashboard(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("hii");
		try {
			List<Product> avaProducts = productDao.getAvailableProducts();
//			just to check product yety ki nahi
//			for(Product product : avaProducts) {
//				System.out.println("Product id"+product.getPid());
//				System.out.println("Product name"+product.getPname());
//				System.out.println("Product price"+product.getPrice());
//				System.out.println();
//			}
			request.setAttribute("availableProducts", avaProducts);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "addProductCart.jsp";
	}

	
	
//	 Product cart madhe add krnya sathi
	private CartDao cartDao = new CartDao();

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(HttpServletRequest request, Model model) {
		int customerId = Integer.parseInt(request.getParameter("customerId"));

		try {
			if (customerdao.doesCustomerExist(customerId)) {
				List<Product> availableProducts = productDao.getAvailableProducts();

				for (Product product : availableProducts) {
					int productId = product.getPid();
					int quantity = Integer.parseInt(request.getParameter("quantity-" + productId));

					if (quantity > 0) {
						Cart cartItem = new Cart();
						cartItem.setCustomerId(customerId);
						cartItem.setProductId(productId);
						cartItem.setProductPrice(product.getPrice());
						cartItem.setProductName(product.getPname());
						cartItem.setQuantity(quantity);

						cartDao.addToCart(cartItem);
					}
				}

				request.setAttribute("availableProducts", availableProducts);
				model.addAttribute("successMessage", "Products added to cart successfully!");
			} else {
				model.addAttribute("errorMessage", "Customer not found");
			}
		} catch (NumberFormatException e) {
			model.addAttribute("errorMessage", "Invalid quantity");
		} catch (SQLException e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "An error occurred");
		}
		return "addProductCart.jsp";
	}

	
	
// Display the cart products based on customer ID
	@RequestMapping(value = "/custidcart", method = RequestMethod.GET)
	public String showCustIdCart() {
		return "custIdCart.jsp";
	}

	
	
//	Display Cart products of particular customer id
	private CustomerDao customerDao = new CustomerDao();
	private CartDao cartDaos = new CartDao();

	@RequestMapping(value = "/cartprod", method = RequestMethod.POST)
	public String showCartProducts(HttpServletRequest request, Model model) {
	    int customerId = Integer.parseInt(request.getParameter("customerId"));
	    try {
	        if (customerDao.doesCustomerExist(customerId)) {
	            List<CartProduct> cartProducts = cartDaos.getCartProductsByCustomerId(customerId);
	            
	            // Calculate the total price
	            double totalPrice = calculateTotalPrice(cartProducts);
	            
	            model.addAttribute("cartProducts", cartProducts);
	            model.addAttribute("totalPrice", totalPrice);
	            
	            return "displayCartProducts.jsp";
	        } else {
	            model.addAttribute("errorMessage", "Customer not found");
	            return "custIdCart.jsp";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        model.addAttribute("errorMessage", "An error occurred");
	        return "customerLogin.jsp";
	    }
	}

	
	
//	Adding amount to wallet
	private WalletDao walletDao = new WalletDao();

	@RequestMapping(value = "/addFundsToWallet", method = RequestMethod.POST)
	public String addFundsToWallet(HttpServletRequest request, Model model) {
	    int customerId = Integer.parseInt(request.getParameter("customerId"));
	    double amount = Double.parseDouble(request.getParameter("amount"));

	    try {
	        if (customerdao.doesCustomerExist(customerId)) {

	            Wallet wallet = new Wallet();
	            wallet.setCustomerId(customerId);
	            wallet.setAmount(amount);
	            walletDao.addToWallet(wallet);

	            model.addAttribute("successMessage", "Funds added to the wallet successfully!");
	        } else {
	            model.addAttribute("errorMessage", "Customer not found");
	        }
	    } catch (NumberFormatException e) {
	        model.addAttribute("errorMessage", "Invalid input");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        model.addAttribute("errorMessage", "An error occurred");
	    }
	    return "addBalance.jsp";
	}

	
	
	
// Display customer wallet balance
	@RequestMapping(value = "/displaybal", method = RequestMethod.POST)
	public String displayBalance(HttpServletRequest request, Model model) {
	    int customerId = Integer.parseInt(request.getParameter("customerId"));

	    try {
	        if (customerdao.doesCustomerExist(customerId)) {
	            // Fetch the wallet balance for the customer
	            double balance = walletDao.getWalletBalance(customerId);
	            model.addAttribute("balance", balance);
	            return "customerBalance.jsp"; 
	        } else {
	            model.addAttribute("errorMessage", "Customer not found");
	        }
	    } catch (NumberFormatException e) {
	        model.addAttribute("errorMessage", "Invalid input");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        model.addAttribute("errorMessage", "An error occurred");
	    }
	    return "custIdDisplay.jsp"; 
	}

	
	
// Calculate total price of cart products
    private double calculateTotalPrice(List<CartProduct> cartProducts) {
        double totalPrice = 0.0;
        for (CartProduct cartProduct : cartProducts) {
            totalPrice += cartProduct.getProductPrice() * cartProduct.getQuantity();
        }
        return totalPrice;
    }
    
    
    
 // Payment of bill
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String pay(HttpServletRequest request, Model model) {
        String customerIdParam = request.getParameter("customerId");

        // Check if the customerIdParam is null or empty
        if (customerIdParam == null || customerIdParam.isEmpty()) {
            model.addAttribute("errorMessage", "Customer ID is required");
            return "displayCartProducts.jsp";
        }

        int customerId = Integer.parseInt(customerIdParam);

        try {
            if (customerDao.doesCustomerExist(customerId)) {
                List<CartProduct> cartProducts = cartDaos.getCartProductsByCustomerId(customerId);
                double totalPrice = 0.0;
                for (CartProduct cartProduct : cartProducts) {
                    totalPrice += cartProduct.getProductPrice() * cartProduct.getQuantity();
                }


                // current wallet balance get kela
                double currentBalance = walletDao.getWalletBalance(customerId);

                if (currentBalance >= totalPrice) {
                    // minus total price from the wallet balance
                	double newBalance = currentBalance - totalPrice;

                    walletDao.updateWalletBalance(customerId, newBalance);
                    System.out.println("Updated Wallet Balance: " + newBalance);
                    // Cleared the cart after successful payment
                    cartDaos.clearCart(customerId);

                    model.addAttribute("successMessage", "Payment successful!");
                } else {
                    model.addAttribute("errorMessage", "Insufficient funds in the wallet");
                }
            } else {
                model.addAttribute("errorMessage", "Customer not found");
            }
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "Invalid customer ID");
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "An error occurred");
        }
        return "displayCartProducts.jsp";
    }


}
