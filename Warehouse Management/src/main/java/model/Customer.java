package model;
/**
 * : this class represents the format of a customer which can be introduced in the customers table. 
 * Each object of type Customer will have as attributes the customer_id, first_name, last_name, 
 * email, phone, card_nr, address, the attributes the seller should know in order for an order 
 * to be processed. 
 * @author anda
 *
 */
public class Customer {
	private int customer_id;
	private String first_name;
	private String last_name;
	private String email;
	private int phone;
	private int card_nr;
	private String address;

	public Customer(int customer_id, String first_name, String last_name, String email, int phone, int card_nr,
			String address) {
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.card_nr = card_nr;
		this.address = address;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getCard_nr() {
		return card_nr;
	}
	public void setCard_nr(int card_nr) {
		this.card_nr = card_nr;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer details :" + "\n" + "    first name: " + first_name + ", last name: " + last_name
				+ ", address: " + address + ", email: " + email + ", phone: +0" + phone;
	}
	
	
}
