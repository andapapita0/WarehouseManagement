package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Customer;
import model.Orders;
import model.Product;
/**
 * just like all the other dao classes, this one also extends the AbstractDAO class, but it has
 *  more independent methods which use queries that are have a higher level of complexity
 * @author anda
 *
 */
public class OrderDAO extends AbstractDAO<Orders> {
	/**
	 * this method inserts new values in the table orders, it basically creates a new order. The 
	 * user needs to specify just the order and customer id (parameters) as the date field will 
	 * be automatically completed with the current date and the total price field will be 
	 * initialized with 0.
	 * @param order_id
	 * @param customer_id
	 */
	public void createOrder(int order_id, int customer_id ) {
		Connection con = null;
		PreparedStatement st = null;
		String query = " insert into orders values(?, ?, ?, ?) ";
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date dt = new java.sql.Date(utilDate.getTime());
	    try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(query);
			st.setInt(1, order_id);
			st.setInt(2, customer_id);
			st.setDate(3, dt);
			st.setInt(4, 0);
			st.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(con);
		}
	}
	/**
	 * this method implements a query that sets the safe-update preference to 0, which needs 
	 * to be done every time an update is needed.
	 */
	public void set() {
		Connection con = null;
		PreparedStatement st = null;
		String s1 = " SET SQL_SAFE_UPDATES = 0; ";
		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(s1);
			st.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(con);
		}
	}
	/**
	 * Exception  this method uses a procedure, rather than a query, by which it adds a new 
	 * product to an order. This is achieved by adding values to the orders_products table, 
	 * setting the new total price in the order table and decrementing the quantity of a product 
	 * in the products table, by the amount of products the user wishes to order
	 * @param order_id
	 * @param product_id
	 * @param q
	 * @throws Exception
	 */
	public void addProductToOrder(int order_id, int product_id, int q) throws Exception {
		Connection con = null;
		PreparedStatement st2 = null;
		String s2 = " call order_management.addprod(?, ?, ?) ";
		ProductDAO o = new ProductDAO();
		//System.out.println("\n" + " cantitateeeee: " + o.findById(product_id, "idproducts").toString());
		if(o.findById(product_id, "idproducts").getQuantity() == 0) {
			JOptionPane.showMessageDialog(null, "Product not on stock!");
			throw new Exception("Product not on stock!");
		}
		if(q > o.findById(product_id, "idproducts").getQuantity()) {  
			JOptionPane.showMessageDialog(null, "There are only " + o.findById(product_id, "idproducts").getQuantity() + " products on stock");
			throw new Exception("Product not on stock!");
		}
		try {
			con = ConnectionFactory.getConnection();
			st2 = con.prepareStatement(s2);
			st2.setInt(1, order_id);
			st2.setInt(2, product_id);
			st2.setInt(3, q);
			System.out.println(st2.toString());
			st2.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(con);
		}
		return;
	}
	/**
	 * this method creates a list with all the product that are in an order
	 * @param id
	 * @return
	 */
	public List<Product> getOrderProducts(int id) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = " SELECT product_type, product.price, orders_products.quantity FROM "
					+ "order_management.orders_products join product on idproducts = product_id "
					+ "where order_id =?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet results = statement.executeQuery();
			List<Product> productList = new ArrayList<Product>();
			while (results.next()) {
				Product p = new Product();
				p.setProduct_type(results.getString(1));
			    p.setPrice(results.getInt(2));
				p.setQuantity(results.getInt(3));
				productList.add(p);
			}
			for(Product p : productList) {
				System.out.println(p.toString());
			}
			return productList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}
	/**
	 * this method creates a list which contains the necessary information about the customer 
	 * of an order
	 * @param id
	 * @return
	 */
	public List<Customer> getOrderCustomer(int id) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "SELECT customer.first_name, customer.last_name, customer.address, customer.email, customer.phone, total_price FROM order_management.orders join customer on customer.customer_id=orders.customer_id where order_id =?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			List<Customer> list = new ArrayList<Customer>();
			while (rs.next()) {
				Customer c = new Customer();
				c.setFirst_name(rs.getString(1));
				c.setLast_name(rs.getString(2));
				c.setAddress(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setPhone(rs.getInt(5));
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}
	/**
	 * this method creates a list which contains the necessary information about an order
	 * @param id
	 * @return
	 */
	public List<Orders> getOrder(int id) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "SELECT date_order_placed, total_price FROM order_management.orders where order_id =?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			List<Orders> olist = new ArrayList<Orders>();
			while (rs.next()) {
				Orders o = new Orders();
				o.setDate_order_placed(rs.getDate(1));
				o.setTotal_price(rs.getFloat(2));
				olist.add(o);
			}
			return olist;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.close(con);
		}
		return null;
	}
}
