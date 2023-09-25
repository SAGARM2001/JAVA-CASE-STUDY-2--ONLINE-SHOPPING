package in.mindcraft.pojo;

public class Wallet {
	private int id;
	private int customerId;
	private double amount;

	public Wallet() {
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Wallet(int id, int customerId, double amount) {
		this.id = id;
		this.customerId = customerId;
		this.amount = amount;
	}
}
