package model;
/**
 * this class represents the format of a product which can be introduced in the products table. 
 * Each object of type Product will have as attributes the idproducts, product_type, price, 
 * quantity, the attributes the user should know in order for an order to be processed.
 * @author anda
 *
 */
public class Product {
	int idproducts;
	String product_type;
	int quantity;
	int price;
	
	public Product(int idproducts, String product_type, int quantity, int price) {
		this.idproducts = idproducts;
		this.product_type = product_type;
		this.quantity = quantity;
		this.price = price;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getIdproducts() {
		return idproducts;
	}
	public void setIdproducts(int idproducts) {
		this.idproducts = idproducts;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "           " + product_type + ", quantity: " + quantity + ", price: " + price + "\n";
	}
	
	
}
