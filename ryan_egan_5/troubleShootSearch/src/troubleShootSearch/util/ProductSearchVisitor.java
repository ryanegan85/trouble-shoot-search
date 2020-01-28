package troubleShootSearch.util;

import java.util.ArrayList;
import java.util.HashMap;

import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * Visitor class, contains information about each product and methods
 * to visit each search algorithm Class.
 */
public class ProductSearchVisitor implements ProductSearchVisitorInterface {
	ArrayList<String> productSentences;
	ArrayList<String> userSentences;
	HashMap<String, String> synonyms;
	ArrayList<String> matchedSentences;
	Results res;
	
	/**
	 * Constructor that sets the passed objects to their
	 * corresponding objects in the Class.
	 */
	public ProductSearchVisitor(ArrayList<String> newProductSentences, ArrayList<String> newUserSentences, HashMap<String, String> newSynonyms, Results newResults) {
		productSentences = newProductSentences;
		userSentences = newUserSentences;
		synonyms = newSynonyms;
		matchedSentences = new ArrayList<>();
		res = newResults;
		MyLogger.writeMessage("Successfully constructed ProductSearchVisitor object", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * Visit method for ExactMatch, results are written to the passed
	 * Results class.
	 */
	@Override
	public void visit(ExactMatch em) {
		res.addResults(em.match(productSentences, userSentences));
		MyLogger.writeMessage("Successful ExactMatch visit", DebugLevel.VISIT);
	}

	/**
	 * Visit method for NaiveMatch, results are written to the passed
	 * Results class.
	 */
	@Override
	public void visit(NaiveMatch nm) {
		res.addResults(nm.match(productSentences, userSentences));
		MyLogger.writeMessage("Successful NaiveMatch visit", DebugLevel.VISIT);
	}

	/**
	 * Visit method for SemanticMatch, results are written to the passed
	 * Results class.
	 */
	@Override
	public void visit(SemanticMatch sm) {
		res.addResults(sm.match(productSentences, userSentences, synonyms));
		MyLogger.writeMessage("Successful SemanticMatch visit", DebugLevel.VISIT);
	}
	
	/**
	 * Getter for matchedSentences.
	 */
	public ArrayList<String> getMatchedSentences() {
		return matchedSentences;
	}
	
	/**
	 * Setter for productSentences.
	 */
	public void setProductSentences(ArrayList<String> ps) {
		productSentences = ps;
	}
	
	/**
	 * Getter for productSentences.
	 */
	public ArrayList<String> getProductSentences() {
		return productSentences;
	}
	
	/**
	 * Setter for userSentences.
	 */
	public void setUserSentences(ArrayList<String> us) {
		userSentences = us;
	}
	
	/**
	 * Getter for userSentences.
	 */
	public ArrayList<String> getUserSentences() {
		return userSentences;
	}
	
	/**
	 * Setter for synonyms.
	 */
	public void setSynonyms(HashMap<String, String> sMap) {
		synonyms = sMap;
	}
	
	/**
	 * Getter for synonyms.
	 */
	public HashMap<String, String> getSynonyms() {
		return synonyms;
	}
	
}