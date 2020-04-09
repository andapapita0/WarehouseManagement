package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Product;
/**
 * this class also extends the AbstractDAO class, and just as CustomerDAO, it has its own insert 
 * method
 * @author anda
 *
 */
public class ProductDAO extends AbstractDAO<Product>{
	/**
	 * inserts a new record into the products table
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 */
	public void insert(int a, String b, int c, int d) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String query = " insert into order_management.product (idproducts, product_type, price, quantity) values(?, ?, ?, ?) ";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, a);
			st.setString(2, b);
			st.setInt(3, c);
			st.setInt(4, d);
			st.execute();
			con.close();
		} catch(SQLException e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
}
