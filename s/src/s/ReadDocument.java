package s;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class ReadDocument {
	private int counter;
	private String docName;
	
	
	public ReadDocument(String fileName) throws FileNotFoundException {
		docName = readDoc(fileName);
		counter = 0;
	}
	
	public static String readDoc(String fileName) throws FileNotFoundException {
		StringBuilder string = new StringBuilder();
		Scanner scan = new Scanner(new File(fileName));
		while (scan.hasNext()) {
			string.append(scan.next().trim());
		}
		return string.toString();
		
	}
	
	public static String [] splitSpaces(String string) {
		String [] split = string.trim().split(" ");

		return split;
	}
	
	public static void compareToKeyWords(String [] stringArray, HashTabel keyWordsHashTabel) {
		HashTabel  hashTabel = new HashTabel(53);
		int counter = 0 ;
		for (int i = 0; i < stringArray.length; i++) {
			if (keyWordsHashTabel.find(stringArray[i]) || isNumeric(stringArray[i])){
				counter++;
			}
			else {
				hashTabel.addHash(stringArray[i]);
				
			}
		}
		
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	public static String [] splitJavaCode(String string) {
		String [] split = string.trim().split("[\\{ \\} \\( \\) \\; \\= \\== \\< \\> \\+ \\- \\, \\[ \\] \\s+ ]+");

		return split;
	}
	public static int countWordsAndSymbols(String string) {
		int counter = 0;
		
		CharacterIterator iterator = new StringCharacterIterator(string);
		while(iterator.current() != CharacterIterator.DONE) {
			counter++;
			iterator.next();
		}
		return counter;
		
		
	}
public static String makeSpaceInString(String originalString){
		
		originalString = originalString.replaceAll("[\\{ \\} \\( \\) \\; \\= \\== \\< \\> \\+ \\- \\, \\[ \\] ]"," $0 ");

		return originalString;
	}

}
