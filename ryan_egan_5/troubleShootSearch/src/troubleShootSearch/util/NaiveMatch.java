package troubleShootSearch.util;

import java.util.ArrayList;

import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * Visitable Class for the Naive Match search algorithm.
 * 
 */
public class NaiveMatch implements Visitable {
	
	/**
	 * Default constructor.
	 */
	public NaiveMatch() {
		MyLogger.writeMessage("Successfully constructed NaiveMatch object", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * Runs the naive match search on the input ArrayList given the
	 * user's input.
	 * @return An ArrayList of Strings from input that have a
	 * substring matching the first word of a String from userInput.
	 */
	public ArrayList<String> match(ArrayList<String> input, ArrayList<String> userInput) {
		String tempSentence;
		String tempUserSentence;
		ArrayList<String> matchedSentences = new ArrayList<>();
		int index;
		String firstWord;
		
		for(int i=0; i<userInput.size(); i++) {
			tempUserSentence = userInput.get(i);
			
			index = tempUserSentence.indexOf(' ');
			if(index > -1) {
				firstWord = tempUserSentence.substring(0, index);
			} else {
				firstWord = tempUserSentence;
			}
			
			for(int j=0; j<input.size(); j++) {
				tempSentence = input.get(j);
				
				if(tempSentence.contains(firstWord)) {
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