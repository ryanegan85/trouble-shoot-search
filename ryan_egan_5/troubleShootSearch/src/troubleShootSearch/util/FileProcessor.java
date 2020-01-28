package troubleShootSearch.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * Class that handles opening input files along with changing
 * the data in those files into a usable form.
 */
public class FileProcessor {
	
	File file;
	
	/**
	 * Constructor, attempts to open the given file and exits
	 * program if it does not exist.
	 */
	public FileProcessor(String inputString) {	
		file = new File(inputString);
		
		if(!file.exists()) {
			System.out.println("Input file does not exist. Exiting program.");
			System.exit(0);
		}
		MyLogger.writeMessage("File successfully opened: " + inputString, DebugLevel.FILE_PROCESSOR);
		MyLogger.writeMessage("Successfully constructed FileProcessor object", DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Reads the line at the given index.
	 * @return The line read from the file.
	 */
	public String readline(int line) {
		int count = 1;
		String temp = "a";
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				if(count == line) {
					temp = scanner.nextLine();
					scanner.close();
					return temp;
				} else {
					scanner.nextLine();
					count++;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return temp;
	}
	
	/**
	 * Reads the number of lines in the file.
	 * @return Number of lines in file.
	 */
	public int numLines() {
		int num = 0;
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				num++;
				scanner.nextLine();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	/**
	 * Adds each line in the file into an ArrayList of Strings.
	 * @return The constructed ArrayList.
	 */
	public ArrayList<String> intoArrayList() {
		ArrayList<String> arrayList = new ArrayList<>();
		
		int lines = this.numLines();
		String temp;
		
		for(int i=1; i<=lines; i++) {
			temp = this.readline(i);
			arrayList.add(temp);
		}
		
		return arrayList;
	}
	
	/**
	 * Adds each line in the file into an HashMap with a
	 * <String, String> key/value pair.
	 * @return The constructed HashMap.
	 */
	public HashMap<String, String> intoHashMap() {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		int lines = this.numLines();
		String tempLine;
		String tempKey;
		String tempValue;
		String[] tempStringArray = new String[2];
		
		try {
			for(int i=1; i<=lines; i++) {
				tempLine = this.readline(i);
				tempStringArray = tempLine.split("\\|");
				tempKey = tempStringArray[0];
				tempValue = tempStringArray[1];
				hashMap.put(tempKey, tempValue);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error turning user input into HashMap. Exiting");
			System.exit(0);
		}
		
		
		return hashMap;
		
	}
}
