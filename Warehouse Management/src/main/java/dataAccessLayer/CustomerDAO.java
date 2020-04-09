package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Customer;
/**
 * this class extends the AbstractDAO class and can implement all of its methods.
 * @author anda
 *
 */
public class CustomerDAO extends AbstractDAO<Customer> {
	/**
	 * method that always uses the inherited delete method to delete by the customer_id field
	 */
	public void del(int id) {
		super.delete("customer_id",id);
	}
	/**
	 * inserts the following list of parameters (a new reccord) in the customers table
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param f
	 * @param g
	 * @param h
	 */
	public void insert(int a, String b, String c, String d, int f, int g, String h) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String query = " insert into order_management.customer (customer_id, first_name, last_name, email, phone, card_nr, address) values(?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, a);
			st.setString(2, b);
			st.setString(3, c);
			st.setString(4, d);
			st.setInt(5, f);
			st.setInt(6, g);
			st.setString(7, h);
			st.execute();
			con.close();
		} catch(SQLException e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
}

