package s;
import java.lang.Object;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;
public class metoder {
	
	public static HashTabel readKeyWords(String fileName) throws FileNotFoundException {
		HashTabel keyWords = new HashTabel(301);
		Scanner scan = new Scanner(new File(fileName));
		while (scan.hasNext()) {
			keyWords.addHash(scan.next());
		}
		return keyWords;
		
	}

	
	public static String removejavaKeyword(String javaString) {
		
		
		return "";
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String test = "   for(  int   i   =  0  ;  )";
//		String newString = makeSpaceInString(test);
//		System.out.println(newString);
		} 
	}


