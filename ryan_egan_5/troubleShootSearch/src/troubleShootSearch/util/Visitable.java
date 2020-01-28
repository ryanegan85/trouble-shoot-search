package troubleShootSearch.util;

/**
 * Interface for Visitable objects, allows them to accept the 
 * visit from the Visitor class.
 */
public interface Visitable {
	public void accept(ProductSearchVisitor visitor);
}
