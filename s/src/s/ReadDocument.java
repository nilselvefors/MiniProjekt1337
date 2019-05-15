package s;

import java.lang.Object;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class ReadDocument {
	private static int counter;	
	private static String docName;
	private static String docNameSpace;
	private static String[] docNameArrayEverthing;
	
	
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
	
	public static void splitSpaces() {
		docNameArrayEverthing = docNameSpace.trim().split(" ");
	}
	
	public static void compareToKeyWords(HashTabel keyWordsHashTabel) {
		HashTabel  hashTabel = new HashTabel(301);
		for (int i = 0; i < docNameArrayEverthing.length; i++) {
			if (keyWordsHashTabel.find(docNameArrayEverthing[i]) || isNumeric(docNameArrayEverthing[i])){
				counter++;
			}
			else {
				hashTabel.addHash(docNameArrayEverthing[i]);
				counter++;
				
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
	
	public static String [] splitJavaCode() {
		String [] split = docNameSpace.trim().split("[\\{ \\} \\( \\) \\; \\= \\== \\< \\> \\+ \\- \\, \\[ \\] \\s+ ]+");

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
	public static void makeSpaceInString(){
		docNameSpace=  docName.replaceAll("[\\{ \\} \\( \\) \\; \\= \\== \\< \\> \\+ \\- \\, \\[ \\] ]"," $0 ");

	}

}
