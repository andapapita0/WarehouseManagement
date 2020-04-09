package businessLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.Product;
/**
 * this class also implements the previously mentioned interface. It contains three validator 
 * classes that verify the product name, quantity and price.
 * @author anda
 *
 */
public class ProductBLL {
	
	private List<Validator<Product>> validators;
	
	public ProductBLL() {
		validators = new ArrayList<Validator<Product>>();
		validators.add(new NameValidator());
		validators.add(new QuantityValidator());
		validators.add(new PriceValidator());
	}
	
	public List<Validator<Product>> getValidators() {
		return validators;
	}
	public void setValidators(List<Validator<Product>> validators) {
		this.validators = validators;
	}

	public class NameValidator implements Validator<Product>{
		private static final String PRODUCT_PATTERN = "^[A-Za-z0-9 ]+$";
		public void validate(Product t) {
			Pattern pattern = Pattern.compile(PRODUCT_PATTERN);
			if(!pattern.matcher(t.getProduct_type()).matches()) {
				JOptionPane.showMessageDialog(null, "Name of the product is not valid!");
				throw new IllegalArgumentException("Name of the product is not valid!");
			}
		}
	}
	public class QuantityValidator implements Validator<Product>{
		public void validate(Product t) {
			if(t.getQuantity() < 0) {
				JOptionPane.showMessageDialog(null, "Quantity cannot be negative!");
				throw new IllegalArgumentException("Quantity cannot be negative!");
			}
		}
	}
	public class PriceValidator implements Validator<Product>{
		public void validate(Product t) {
			if(t.getPrice() <= 0) {
				JOptionPane.showMessageDialog(null, "Price cannot be negative!");
				throw new IllegalArgumentException("Price cannot be negative!");
			}
		}
	}
}
