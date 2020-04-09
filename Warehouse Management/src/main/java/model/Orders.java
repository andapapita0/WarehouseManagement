package model;

import java.sql.Date;

/**
 * this class is identical with the previous two, it contains the attributes of an order, as 
 * they are reflected in the orders table: order_id, customer_id, date_order_placed and total_price. 
 * @author anda
 *
 */
public class Orders {
	private int order_id;
	private int customer_id;
	private Date date_order_placed;
	private float total_price;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Date getDate_order_placed() {
		return date_order_placed;
	}
	public void setDate_order_placed(Date date_order_placed) {
		this.date_order_placed = date_order_placed;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		return "Date order placed: " + date_order_placed + "\n" + "Total price: " + total_price;
	}
	
	
}
