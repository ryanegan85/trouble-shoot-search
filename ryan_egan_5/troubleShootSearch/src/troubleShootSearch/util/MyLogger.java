package troubleShootSearch.util;

/**
 * Logger class used for debugging.
 */
public class MyLogger{

	public static enum DebugLevel { CONSTRUCTOR, FILE_PROCESSOR, NONE
                                , SEARCH_RESULTS, VISIT};

    private static DebugLevel debugLevel;


 /**
  * Sets the debugLevel to the int level passed in.
  */
 public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	case 4: debugLevel = DebugLevel.VISIT; break;
	case 3: debugLevel = DebugLevel.CONSTRUCTOR; break;
	case 2: debugLevel = DebugLevel.FILE_PROCESSOR; break;
	case 1: debugLevel = DebugLevel.SEARCH_RESULTS; break;
	default: debugLevel = DebugLevel.NONE; break;
	}
 }
 /**
  * Sets the debugLevel to the passed in DebugLevel value.
  */
 public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
 }

 /**
  * Writes a passed message to the console if levelIn matches
  * the current debugLevel.
  */
 public static void writeMessage (String     message  ,
                                  DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
 }

 /**
  * Returns a String containing info about the current DebugLevel.
  * @return The constructed String.
  */
 public String toString() {
	return "The debug level has been set to the following " + debugLevel;
 }
}