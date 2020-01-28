package troubleShootSearch.driver;

import java.util.ArrayList;
import java.util.HashMap;
import troubleShootSearch.util.*;

class Driver {
	
	public static void main(String[] args) {
		if(args.length != 4) {
			System.out.println("Error with args, see README for proper usage.");
			System.exit(0);
		}

		//Assigning names of hard coded input files and those read
		//from the command line, and debug level.
		final String INPUT1 = "technicalSentences1.txt";
		final String INPUT2 = "technicalSentences2.txt";
		final String INPUT3 = "technicalSentences3.txt";
		final String INPUT4 = "technicalSentences4.txt";
		String userInput = args[0];
		String output = args[1];
		String synonymFile = args[2];
		int debugLevel = -1;
		try {
			debugLevel = Integer.parseInt(args[3]);
		} catch(NumberFormatException e) {
			System.out.println("ERROR: debugValue must be an integer between 0 and 4. Exiting");
			System.exit(0);
		}
		if(debugLevel < 0 || debugLevel > 4) {
			System.out.println("ERROR: debugValue must be an integer between 0 and 4. Exiting");
			System.exit(0);
		}
		
		MyLogger.setDebugValue(debugLevel);
		
		//Creating File Processors for each input file, along with
		//a Results class.
		FileProcessor fp1 = new FileProcessor(INPUT1);
		FileProcessor fp2 = new FileProcessor(INPUT2);
		FileProcessor fp3 = new FileProcessor(INPUT3);
		FileProcessor fp4 = new FileProcessor(INPUT4);
		FileProcessor userFp = new FileProcessor(userInput);
		FileProcessor synonymFp = new FileProcessor(synonymFile);
		Results res = new Results(output);
		
		//Turning data from files into ArrayLists/a HashMap.
		ArrayList<String> techSentencesA = fp1.intoArrayList();
		ArrayList<String> techSentencesB = fp2.intoArrayList();
		ArrayList<String> techSentencesC = fp3.intoArrayList();
		ArrayList<String> techSentencesD = fp4.intoArrayList();
		ArrayList<String> userWords = userFp.intoArrayList();
		HashMap<String, String> synonyms = synonymFp.intoHashMap();
		
		//Creating an Object for each search class and a Visitor for
		//each product.
		ExactMatch em = new ExactMatch();
		NaiveMatch nm = new NaiveMatch();
		SemanticMatch sm = new SemanticMatch();
		ProductSearchVisitor prod1 = new ProductSearchVisitor(techSentencesA, userWords, synonyms, res);
		ProductSearchVisitor prod2 = new ProductSearchVisitor(techSentencesB, userWords, synonyms, res);
		ProductSearchVisitor prod3 = new ProductSearchVisitor(techSentencesC, userWords, synonyms, res);
		ProductSearchVisitor prod4 = new ProductSearchVisitor(techSentencesD, userWords, synonyms, res);
		
		//Running each search algorithm on each product
		//and writing results to output file.
		em.accept(prod1);
		nm.accept(prod1);
		sm.accept(prod1);
		
		em.accept(prod2);
		nm.accept(prod2);
		sm.accept(prod2);
		
		em.accept(prod3);
		nm.accept(prod3);
		sm.accept(prod3);
		
		em.accept(prod4);
		nm.accept(prod4);
		sm.accept(prod4);
		
		res.writeToFile();
		
	}
}