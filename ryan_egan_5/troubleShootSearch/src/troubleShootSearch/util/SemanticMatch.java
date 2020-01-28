package troubleShootSearch.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * Visitable Class for the Semantic Match search algorithm.
 */
public class SemanticMatch implements Visitable {
	
	/**
	 * Default constructor.
	 */
	public SemanticMatch() {
		MyLogger.writeMessage("Successfully constructed SemanticMatch object", DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Accept method from interface, allows Class to be visited by
	 * the visitor class.
	 */
	@Override
	public void accept(ProductSearchVisitor visitor) {
		visitor.visit(this);	
	}

	/**
	 * Runs the semantic match search on the input ArrayList given the
	 * user's input and synonyms.
	 * @return An ArrayList of Strings from input that have an exact
	 * substring from userInput, or an exact substring of a String from
	 * userInput after changing the last word to its synonym.
	 */
	public ArrayList<String> match(ArrayList<String> input, ArrayList<String> userInput, HashMap<String, String> synonyms) {
		ExactMatch em = new ExactMatch();
		ArrayList<String> sentencesWithSynonyms = new ArrayList<>();
		for(int i=0; i<userInput.size(); i++) {
			sentencesWithSynonyms.add(userInput.get(i));
		}
		ArrayList<String> matchedSentences = new ArrayList<>();
		String temp;
		String newLastWord;
		String firstWords;
		String newSentence;
		int index;
		
		for(int i=0; i<userInput.size(); i++) {
			temp = userInput.get(i);
			String lastWord = temp.substring(temp.lastIndexOf(" ")+1);
		    index = temp.indexOf(' ');
			
			for(Map.Entry<String, String> entry : synonyms.entrySet()) {
				//System.out.println("looping " + check + " times");
			    String key = entry.getKey();
			    String value = entry.getValue();
			    
				if(index > -1) {
					//firstWord = tempUserSentence.substring(0, index);
					//System.out.println("checking if " + lastWord + " = " + key);
					if(lastWord.equals(key)) {
				    	firstWords = temp.substring(0, temp.lastIndexOf(" "));
				    	newLastWord = value;
				    	newSentence = firstWords + " " + newLastWord;
				    	//System.out.println("Match found! Adding " + newSentence);
				    	sentencesWithSynonyms.add(newSentence);
				    }
					//System.out.println("checking if " + lastWord + " = " + value);
				    if(lastWord.equals(value)) {
				    	firstWords = temp.substring(0, temp.lastIndexOf(" "));
				    	newLastWord = key;
				    	newSentence = firstWords + " " + newLastWord;
				    	//System.out.println("Match found! Adding " + newSentence);
				    	sentencesWithSynonyms.add(newSentence);
				    }
				} else {
					//System.out.println("checking if " + lastWord + " = " + key);
					if(lastWord.equals(key)) {
						//System.out.println("Match found! Adding " + value);
				    	sentencesWithSynonyms.add(value);
				    }
					//System.out.println("checking if " + lastWord + " = " + value);
				    if(lastWord.equals(value)) {
				    	//System.out.println("Match found! Adding " + key);
				    	sentencesWithSynonyms.add(key);
				    }
				}
			}	
		}
		
		matchedSentences = em.match(input, sentencesWithSynonyms);
		
		return matchedSentences;
		
	}
	
}