package in.mindcraft.pojo;

public class Customer {
	private int cid;
	private String cpass;

	public Customer() {

	}

	public Customer(int cid, String cpass) {
		this.cid = cid;
		this.cpass = cpass;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
}
