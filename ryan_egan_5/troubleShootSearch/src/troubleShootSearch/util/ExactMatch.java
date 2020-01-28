package troubleShootSearch.util;

import java.util.ArrayList;

import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * Visitable Class for the Exact Match search algorithm.
 * 
 */
public class ExactMatch implements Visitable {

	/**
	 * Default constructor.
	 */
	public ExactMatch() {
		MyLogger.writeMessage("Successfully constructed ExactMatch object", DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Runs the exact match search on the input ArrayList given the
	 * user's input.
	 * @return An ArrayList of Strings from input that have an exact
	 * substring from userInput.
	 */
	public ArrayList<String> match(ArrayList<String> input, ArrayList<String> userInput) {
		String tempSentence;
		String tempUserSentence;
		ArrayList<String> matchedSentences = new ArrayList<>();
		
		for(int i=0; i<input.size(); i++) {
			tempSentence = input.get(i);
			for(int j=0; j<userInput.size(); j++) {
				tempUserSentence = userInput.get(j);
				if(tempSentence.contains(tempUserSentence)) {
					matchedSentences.add(tempSentence);
				}
			}
		}
		
		return matchedSentences;
	}

	/**
	 * Accept method from interface, allows Class to be visited by
	 * the visitor class.
	 */
	@Override
	public void accept(ProductSearchVisitor visitor) {
		visitor.visit(this);	
	}
	
}