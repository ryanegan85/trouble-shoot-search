package troubleShootSearch.util;

/**
 * Visitor interface for ProductSearchVisitor, contains declarations
 * for each visit method.
 */
public interface ProductSearchVisitorInterface {
	public void visit(ExactMatch em);
	public void visit(NaiveMatch nm);
	public void visit(SemanticMatch sm);
}
