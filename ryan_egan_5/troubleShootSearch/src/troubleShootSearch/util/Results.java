package troubleShootSearch.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * Class that stores passed results and writes them to a
 * given output file.
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	ArrayList<String> data;
	File outputFile;
	
	/**
	 * Constructor, sets output file to passed file name, and
	 * creates one with that name if it does not exist.
	 */
	public Results(String filename) {
		data = new ArrayList<String>();
		
		outputFile = new File(filename);
		
		try {
			if(outputFile.createNewFile()) {
				System.out.println("Output file not found, creating one.");
			} else {
				System.out.println("Output file found.");
			}
		} catch (IOException e) {
			System.out.println("Error with files.");
			System.exit(0);
		}
		MyLogger.writeMessage("Successfully constructed Results object", DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Adds items from the passed ArrayList to data and checks
	 * to make sure no duplicates are added.
	 */
	public void addResults(ArrayList<String> values) {
		for(int i=0; i<values.size(); i++) {
			if(!data.contains(values.get(i))) {
				MyLogger.writeMessage("Adding new result: " + values.get(i), DebugLevel.SEARCH_RESULTS);
				data.add(values.get(i));
			}
		}
		
		//data.addAll(values);
	}
	
	/**
	 * Writes items in data to console.
	 */
	public void printResults() {
		for(int i=0; i<data.size(); i++) {
			writeToStdout(data.get(i));
		}
	}
	
	/**
	 * Sorts items in data.
	 */
	public void sortData() {
		Collections.sort(data);
	}
	
	/**
	 * Writes the items in the data ArrayList to the specified
	 * output file.
	 */
	public void writeToFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
			for(int i=0; i<data.size(); i++) {
				bw.write(data.get(i));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			writeToStdout("Error writing to file.");
		}
		
	}

	/**
	 * Prints passed string to the console.
	 */
	public void writeToStdout(String s) {
		System.out.println(s);	
	}
	
	/**
	 * Getter for data.
	 * @return The data ArrayList.
	 */
	public ArrayList<String> getData() {
		return data;
	}
	
	/**
	 * Setter for data.
	 */
	public void setData(ArrayList<String> newData) {
		data = newData;
	}
}
