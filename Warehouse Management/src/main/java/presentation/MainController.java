package presentation;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import businessLayer.CustomerBLL;
import businessLayer.ProductBLL;
import businessLayer.Validator;
import dataAccessLayer.CustomerDAO;
import dataAccessLayer.OrderDAO;
import dataAccessLayer.ProductDAO;
import model.Customer;
import model.Orders;
import model.Product;
/**
 * this class acts on dataAccessLayer, model and MainView classes. It controls the data flow 
 * that goes into the database and updates the View whenever data changes and the other way 
 * around
 * @author anda
 *
 */
public class MainController {
	MainView v = new MainView();
	
	public MainController(MainView v){
		this.v = v;
		v.addViewListener(new ViewListener());
		v.addInsertListener(new InsertListener());
		v.addDeleteListener(new DeleteListener());
		v.addUpdateListener(new UpdateListener());
		v.addViewProdListener(new ViewProductsListener());
		v.addInsertProdListener(new InsertProductListener());;
		v.addDeleteProdListener(new DeleteProductListener());
		v.addUpdateProdListener(new UpdateProductListener());
		v.addViewOrdersListener(new ViewOrdersListener());
		v.addInsertOrdersListener(new InsertOrdersListener());
		v.addCreateOrdersListener(new CreateOrdersListener());
		v.addBillOrdersListener(new BillOrdersListener());
	}
	
	class ViewListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			CustomerDAO cdao = new CustomerDAO();
			List<Customer> clist = cdao.createObjects();
			v.createCustomerTable(clist, cdao);
		}
	}
	
	class InsertListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			CustomerDAO cdao = new CustomerDAO();
			CustomerBLL cbll = new CustomerBLL();
			Customer c = new Customer(v.getUserInput1(), v.getUserInput2(), v.getUserInput3(), v.getUserInput4(), v.getUserInput5(), v.getUserInput6(), v.getUserInput7());
			for (Validator<Customer> val : cbll.getValidators()) {
				val.validate(c);
			}
			cdao.insert(v.getUserInput1(), v.getUserInput2(), v.getUserInput3(), v.getUserInput4(), v.getUserInput5(), v.getUserInput6(), v.getUserInput7());
			JOptionPane.showMessageDialog(v, "Customer inserted successfully");
		}
	}
	
	class DeleteListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			CustomerDAO cdao = new CustomerDAO();
			cdao.del(v.getUserInput8());
			JOptionPane.showMessageDialog(v, "Customer deleted successfully");
		}
	}
	
	class UpdateListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			CustomerDAO cdao = new CustomerDAO();
			cdao.update(v.getUserInput9(), v.getUserInput10(), v.getUserInput11(), v.getUserInput12());
			JOptionPane.showMessageDialog(v, "Customer updated successfully");
		}
	}
	
	class ViewProductsListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			ProductDAO pdao = new ProductDAO();
			List<Product> plist = pdao.createObjects();
			v.createProductTable(plist, pdao);
		}
	}
	
	class InsertProductListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			ProductDAO pdao = new ProductDAO();
			ProductBLL pbll = new ProductBLL();
			Product p = new Product(v.getUserInput13(), v.getUserInput14(), v.getUserInput15(), v.getUserInput16());
			for (Validator<Product> val : pbll.getValidators()) {
				val.validate(p);
			}
			pdao.insert(v.getUserInput13(), v.getUserInput14(), v.getUserInput15(), v.getUserInput16());
			JOptionPane.showMessageDialog(v, "Product inserted successfully");
		}
	}
	
	class DeleteProductListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			ProductDAO pdao = new ProductDAO();
			pdao.delete("idproducts", v.getUserInput17());
			JOptionPane.showMessageDialog(v, "Product deleted successfully");
		}
	}
	
	class UpdateProductListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			ProductDAO pdao = new ProductDAO();
			pdao.update(v.getUserInput18(), v.getUserInput19(), v.getUserInput20(), v.getUserInput21());
			JOptionPane.showMessageDialog(v, "Product updated successfully");
		}
	}
	
	class ViewOrdersListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			OrderDAO odao = new OrderDAO();
			List<Orders> olist = odao.createObjects();
			v.createOrderTable(olist, odao);
		}
	}
	
	class InsertOrdersListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			OrderDAO odao = new OrderDAO();
			try {
				odao.addProductToOrder(v.getUserInput22(), v.getUserInput23(), v.getUserInput24());
				JOptionPane.showMessageDialog(v, "Product added successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class CreateOrdersListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			OrderDAO odao = new OrderDAO();
			odao.createOrder(v.getUserInput25(), v.getUserInput26());
			JOptionPane.showMessageDialog(v, "Order created successfully");
		}
	}
	
	class BillOrdersListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			try 
            {
				File file = new File("D:\\bill.txt");
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Order number: " + v.getUserInput27());
                bw.newLine();
                OrderDAO odao = new OrderDAO();
    			List<Orders> olist = odao.getOrder(v.getUserInput27());
    			for(Orders o : olist) {
    				bw.write("Date: " + o.getDate_order_placed());
    				bw.newLine();
    				bw.write("Total price: " + o.getTotal_price());
    				bw.newLine();
    			}
    			List<Customer> clist = odao.getOrderCustomer(v.getUserInput27());
    			for(Customer c : clist) {
    				bw.write("Customer: ");
    				bw.newLine();
    				bw.write("           First name: " + c.getFirst_name());
    				bw.newLine();
    				bw.write("           Last name: " + c.getLast_name());
    				bw.newLine();
    				bw.write("           Address: " + c.getAddress());
    				bw.newLine();
    				bw.write("           Email: " + c.getEmail());
    				bw.newLine();
    				bw.write("           Phone nr.: +0" + c.getPhone());
    				bw.newLine();
    			}
    			bw.write("Ordered products:");
    			bw.newLine();
     			List<Product> plist = odao.getOrderProducts(v.getUserInput27());
     			for(Product p : plist) {
     				bw.write(p.toString());
     				bw.newLine();
     			}
                bw.close();
            } catch(IOException e) {
            	e.printStackTrace();
            }
			finally {
				JOptionPane.showMessageDialog(v, "Bill created successfully");
			}
		}
	}
}


