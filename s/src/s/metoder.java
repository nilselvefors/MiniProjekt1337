package s;
import java.lang.Object;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;
import java.util.PrimitiveIterator.OfDouble;
public class metoder {
	
	public static HashTabel readKeyWords(String fileName) throws FileNotFoundException {
		HashTabel keyWords = new HashTabel(301);
		Scanner scan = new Scanner(new File(fileName));
		while (scan.hasNext()) {
			keyWords.addHash(scan.next());
		}
		return keyWords;
		
	}
	public static void theTwoComparedFilesResultat(String doc1, String doc2) {
		System.out.print("The Result of the comparison of " + doc1 +" and " + doc2 + " are ");
	}
	public static void choseTwoDocs() {
		System.out.println("Choose the two files you wanna compare");
	}

	public static void printTheAnswer() {
		System.out.println("% "+ "the plagiarism of the two files");
	}
	
	public static String removejavaKeyword(String javaString) {
		
		
		return "";
	}
}


