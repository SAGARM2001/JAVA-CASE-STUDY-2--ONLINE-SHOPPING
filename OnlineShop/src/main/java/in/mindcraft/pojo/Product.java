package in.mindcraft.pojo;



public class Product {
	private int pid;
	private String pname;
	private double price;
	private int quantity;
	private double discount;
	private int cartQuantity;

	public Product(int pid, String pname, double price, int quantity, double discount, int cartQuantity) {
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
		this.cartQuantity = cartQuantity;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public Product() {

	}
	
	public Product(int pid, String pname, double price) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
    }

	public Product(int pid, String pname, double price, int quantity, double discount) {
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}



}
