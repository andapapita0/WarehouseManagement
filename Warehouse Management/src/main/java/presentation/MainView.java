package presentation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dataAccessLayer.CustomerDAO;
import dataAccessLayer.OrderDAO;
import dataAccessLayer.ProductDAO;
import model.Customer;
import model.Orders;
import model.Product;
/**
 * this class creates the interface the user works with regarding to introducing the necessary 
 * and desired values in the database tables, and also showing the tables’ records
 * @author anda
 *
 */
@SuppressWarnings("serial")
public class MainView extends JFrame {
	
	private JTable customers = new JTable();
	private JButton b1 = new JButton("View all");
	private JButton b2 = new JButton("Insert customer");
	private JButton b3 = new JButton("Delete customer");
	private JButton b4 = new JButton("Update customer");
	private JTextField t1 = new JTextField("insert customer_id");
	private JTextField t2 = new JTextField("insert first_name");
	private JTextField t3 = new JTextField("insert last_name");
	private JTextField t4 = new JTextField("insert email address");
	private JTextField t5 = new JTextField("insert phone number");
	private JTextField t6 = new JTextField("insert card_nr");
	private JTextField t7 = new JTextField("insert address");
	private JTextField t8 = new JTextField("customer_id");
	//update customer
	private JTextField t9 = new JTextField("field to be updated");
	private JTextField t10 = new JTextField("update by this field");
	private JTextField t11 = new JTextField("new value");
	private JTextField t12 = new JTextField("select which customer");
	//FOR PRODUCTS
	public JTable products = new JTable();
	private JButton bp1 = new JButton("View all");
	private JButton bp2 = new JButton("Insert product");
	private JButton bp3 = new JButton("Delete product");
	private JButton bp4 = new JButton("Update product");
	private JTextField tp1 = new JTextField("product_id");
	private JTextField tp2 = new JTextField("product_name");
	private JTextField tp3 = new JTextField("price");
	private JTextField tp4 = new JTextField("quantity");
	private JTextField tp5 = new JTextField("field to be updated");
	private JTextField tp6 = new JTextField("update by this field");
	private JTextField tp7 = new JTextField("new value");
	private JTextField tp8 = new JTextField("select which product");
	private JTextField tp9 = new JTextField("product_id");
	
	//orders
	private JTable orders = new JTable();
	private JButton bo1 = new JButton("View all");
	private JButton bo2 = new JButton("Add product to an existing order");
	private JButton bo3 = new JButton("Create new order");
	private JButton bo4 = new JButton("Generate bill");
	
	private JTextField to1 = new JTextField("select order id");
	private JTextField to2 = new JTextField("select product id");
	private JTextField to3 = new JTextField("select quantity");
	private JTextField to4 = new JTextField("new order id");
	private JTextField to5 = new JTextField("client id");
	private JTextField to6 = new JTextField("order id");
	/**
	 * the constructor arranges everything in place for the GUI
	 */
	public MainView(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setTitle("Order Management");
		
		//customers
		JPanel main = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 5, 5, 5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 0;
		JPanel ops1 = new JPanel();
		ops1.setBorder(BorderFactory.createTitledBorder("Customers table"));
		BoxLayout lt1 = new BoxLayout(ops1, BoxLayout.Y_AXIS);
		ops1.setLayout(lt1);
		
		customers.setPreferredScrollableViewportSize(new Dimension(450, 63));
		customers.setFillsViewportHeight(true);
		JScrollPane ne = new JScrollPane(customers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ne.setBounds(100,150,500,300);
		ne.setVisible(true);
		ops1.add(ne);
		main.add(ops1, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.fill = GridBagConstraints.VERTICAL;
		c.ipady = 0;     
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth=1;
		main.add(b1,c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 2;
		main.add(b2, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 1;
		c.gridy = 2;
		main.add(t1, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 2;
		c.gridy = 2;
		main.add(t2, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 3;
		c.gridy = 2;
		main.add(t3, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 3;
		main.add(t4, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 1;
		c.gridy = 3;
		main.add(t5, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 2;
		c.gridy = 3;
		main.add(t6, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 3;
		c.gridy = 3;
		main.add(t7, c);
		
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 4;
		main.add(b3, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 1;
		c.gridy = 4;
		main.add(t8, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 5;
		main.add(b4, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 1;
		c.gridy = 5;
		main.add(t9, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 2;
		c.gridy = 5;
		main.add(t10, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 3;
		c.gridy = 5;
		main.add(t11, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 4;
		c.gridy = 5;
		main.add(t12, c);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(50,100,500,200);  
		tabbedPane.addTab("Customers", main);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		
		JPanel panp = new JPanel(new GridBagLayout());//panel for products
		c.insets = new Insets(10, 5, 5, 5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 0;
		JPanel ops2 = new JPanel();
		ops2.setBorder(BorderFactory.createTitledBorder("Products table"));
		BoxLayout lt2 = new BoxLayout(ops2, BoxLayout.Y_AXIS);
		ops2.setLayout(lt2);
		
		products.setPreferredScrollableViewportSize(new Dimension(450, 63));
		products.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(products, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(100,150,500,300);
		sp.setVisible(true);
		ops2.add(sp);
		panp.add(ops2, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.fill = GridBagConstraints.VERTICAL;
		c.ipady = 0;     
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth=1;
		panp.add(bp1,c);
		//insert product
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 2;
		panp.add(bp2, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 1;
		c.gridy = 2;
		panp.add(tp1, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 2;
		c.gridy = 2;
		panp.add(tp2, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 3;
		c.gridy = 2;
		panp.add(tp3, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 4;
		c.gridy = 2;
		panp.add(tp4, c);
		//delete
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 3;
		panp.add(bp3, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 1;
		c.gridy = 3;
		panp.add(tp9, c);
		//update
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 4;
		panp.add(bp4, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 1;
		c.gridy = 4;
		panp.add(tp5, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 2;
		c.gridy = 4;
		panp.add(tp6, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 3;
		c.gridy = 4;
		panp.add(tp7, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 4;
		c.gridy = 4;
		panp.add(tp8, c);
		tabbedPane.addTab("Products", panp);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		//orders
		JPanel pano = new JPanel(new GridBagLayout());//panel for products
		c.insets = new Insets(10, 5, 5, 5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 0;
		JPanel ops3 = new JPanel();
		ops3.setBorder(BorderFactory.createTitledBorder("Orders table"));
		BoxLayout lt3 = new BoxLayout(ops3, BoxLayout.Y_AXIS);
		ops3.setLayout(lt3);
		
		orders.setPreferredScrollableViewportSize(new Dimension(450, 63));
		orders.setFillsViewportHeight(true);
		JScrollPane sp1 = new JScrollPane(orders, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp1.setBounds(100,150,500,300);
		sp1.setVisible(true);
		ops3.add(sp1);
		pano.add(ops3, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.fill = GridBagConstraints.VERTICAL;
		c.ipady = 0;     
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth=1;
		pano.add(bo1,c);
		c.gridx = 0;
		c.gridy = 2;
		pano.add(bo2, c);
		c.gridx = 1;
		c.gridy = 2;
		pano.add(to1, c);
		c.gridx = 2;
		c.gridy = 2;
		pano.add(to2, c);
		c.gridx = 3;
		c.gridy = 2;
		pano.add(to3, c);
		c.gridx = 0;
		c.gridy = 3;
		pano.add(bo3, c);
		c.gridx = 1;
		c.gridy = 3;
		pano.add(to4, c);
		c.gridx = 2;
		c.gridy = 3;
		pano.add(to5, c);
		c.gridx = 0;
		c.gridy = 4;
		pano.add(bo4, c);
		c.gridx = 1;
		c.gridy = 4;
		pano.add(to6, c);
		
		tabbedPane.addTab("Orders", pano);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		
		this.add(tabbedPane);
	}
	
	public void addViewListener(ActionListener view) {
		this.b1.addActionListener(view);
	}
	
	public void addInsertListener(ActionListener view) {
		this.b2.addActionListener(view);
	}
	
	public void addDeleteListener(ActionListener view) {
		this.b3.addActionListener(view);
	}
	
	public void addUpdateListener(ActionListener view) {
		this.b4.addActionListener(view);
	}
	
	public void addViewProdListener(ActionListener view) {
		this.bp1.addActionListener(view);
	}
	
	public void addInsertProdListener(ActionListener view) {
		this.bp2.addActionListener(view);
	}
	
	public void addDeleteProdListener(ActionListener view) {
		this.bp3.addActionListener(view);
	}
	
	public void addUpdateProdListener(ActionListener view) {
		this.bp4.addActionListener(view);
	}
	
	public void addViewOrdersListener(ActionListener view) {
		this.bo1.addActionListener(view);
	}
	
	public void addInsertOrdersListener(ActionListener view) {
		this.bo2.addActionListener(view);
	}
	
	public void addCreateOrdersListener(ActionListener view) {
		this.bo3.addActionListener(view);
	}
	
	public void addBillOrdersListener(ActionListener view) {
		this.bo4.addActionListener(view);
	}
	
	public void createCustomerTable(List<Customer> clist, CustomerDAO cdao) {
		String[] cols = {"customer_id", "first_name","last_name","email","phone","card_nr","address"};

		DefaultTableModel tm = new DefaultTableModel();
		tm.setColumnIdentifiers(cols);
		
		for(Customer c : clist) {
			Object[] temp = new Object[cols.length];
			temp[0] = c.getCustomer_id();
			temp[1] = c.getFirst_name();
			temp[2] = c.getLast_name();
			temp[3] = c.getEmail();
			temp[4] = c.getPhone();
			temp[5] = c.getCard_nr();
			temp[6] = c.getAddress();
			tm.addRow(temp);
		}
		this.customers.setModel(tm);
	}
	public void createProductTable(List<Product> list, ProductDAO pdao) {
		DefaultTableModel tm = new DefaultTableModel();
		//String[] cols = pdao.getFields();
		String[] cols = {"id", "product_name", "price", "quantity"};
		tm.setColumnIdentifiers(cols);
		
		for(Product p : list) {
			Object[] temp = new Object[cols.length];
			temp[0] = p.getIdproducts();
			temp[1] = p.getProduct_type();
			temp[2] = p.getPrice();
			temp[3] = p.getQuantity();
			tm.addRow(temp);
		}
		products.setModel(tm);
	}
	
	public void createOrderTable(List<Orders> list, OrderDAO odao) {
		DefaultTableModel tm = new DefaultTableModel();
		String[] cols = {"order_id", "customer_id", "date_order_placed", "total_price"};
		tm.setColumnIdentifiers(cols);
		
		for(Orders p : list) {
			Object[] temp = new Object[cols.length];
			temp[0] = p.getOrder_id();
			temp[1] = p.getCustomer_id();
			//temp[2] = p.getPrice();
			temp[2] = p.getDate_order_placed();
			temp[3] = p.getTotal_price();
			tm.addRow(temp);
		}
		orders.setModel(tm);
	}
	
	public int getUserInput1() {
		String s = t1.getText();
		return Integer.parseInt(s);
	}
	
	public String getUserInput2() {
		return t2.getText();
	}
	
	public String getUserInput3() {
		return t3.getText();
	}
	public String getUserInput4() {
		return t4.getText();
	}
	
	public int getUserInput5() {
		return Integer.parseInt(t5.getText());
	}
	
	public int getUserInput6() {
		return Integer.parseInt(t6.getText());
	}
	public String getUserInput7() {
		return t7.getText();
	}
	public int getUserInput8() {
		return Integer.parseInt(t8.getText());
	}
	public String getUserInput9() {
		return t9.getText();
	}
	public String getUserInput10() {
		return t10.getText();
	}
	public String getUserInput11() {
		return t11.getText();
	}
	public String getUserInput12() {
		return t12.getText();
	}
	public int getUserInput13() {
		return Integer.parseInt(tp1.getText());
	}
	public String getUserInput14() {
		return tp2.getText();
	}
	public int getUserInput15() {
		return Integer.parseInt(tp3.getText());
	}
	public int getUserInput16() {
		return Integer.parseInt(tp4.getText());
	}
	public int getUserInput17() {
		return Integer.parseInt(tp9.getText());
	}
	public String getUserInput18() {
		return tp5.getText();
	}
	public String getUserInput19() {
		return tp6.getText();
	}
	public String getUserInput20() {
		return tp7.getText();
	}
	public String getUserInput21() {
		return tp8.getText();
	}
	public int getUserInput22() {
		return Integer.parseInt(to1.getText());
	}
	public int getUserInput23() {
		return Integer.parseInt(to2.getText());
	}
	public int getUserInput24() {
		return Integer.parseInt(to3.getText());
	}
	public int getUserInput25() {
		return Integer.parseInt(to4.getText());
	}
	public int getUserInput26() {
		return Integer.parseInt(to5.getText());
	}
	public int getUserInput27() {
		return Integer.parseInt(to6.getText());
	}
}
