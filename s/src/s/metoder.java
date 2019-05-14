package s;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;
public class metoder {
	
	public static String makeSpaceInString(String originalString){
		
		originalString = originalString.replaceAll("[\\{ \\} \\( \\) \\; \\= \\== \\< \\> \\+ \\- \\, \\[ \\] ]"," $0 ");
		
		
		
		return originalString;
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
	public static String readDoc(String fileName) throws FileNotFoundException {
		StringBuilder string = new StringBuilder();
		Scanner scan = new Scanner(new File(fileName));
		while (scan.hasNext()) {
			string.append(scan.next().trim());
			
		}
		return string.toString();
		
	}
	
	public static String removejavaKeyword(String javaString) {
		
		
		
		
		
		return "";
	}
	
	
	public static String [] splitJavaCode(String string) {
		String [] split = string.trim().split("[\\{ \\} \\( \\) \\; \\= \\== \\< \\> \\+ \\- \\, \\[ \\] \\s+ ]+");
//		for (String string2 : split) {
//			System.out.println(string2);
//		}
		return split;
	}
	
	public static void main(String[] args) {
		String test = "for(int i=0;)";
		String newString = makeSpaceInString(test);
		//System.out.println(newString);
		} 
	}


