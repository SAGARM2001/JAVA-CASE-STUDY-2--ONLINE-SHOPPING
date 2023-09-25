package in.mindcraft.pojo; // Use your actual package name

public class CartProduct {
    private String productName;
    private int quantity;
    private double productPrice;
    private int productId;


    public CartProduct(int productId,String productName,double productPrice,int quantity) {
		this.productName = productName;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.productId = productId;
	}

	public CartProduct() {
    }

    public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public CartProduct(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
