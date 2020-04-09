package businessLayer;
/**
 * this is the interface implemented by all the other classes in the businessLayer package. It 
 * simply contains an unimplemented method validate(T t).
 * @author anda
 *
 * @param <T> generic
 */
public interface Validator<T> {
	public void validate(T t);
}
