package s;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class mainProgram {
	public static void ak(ReadDocument document) {
		document.makeSpaceInString();
		document.splitSpaces();
	}

	public static void main(String[] args) throws FileNotFoundException {

		HashTabel keyword = HashTabel.readKeyWords();
		keyword.printHashTable();
		System.out.println();
		System.out.println(keyword.find("final"));
		ReadDocument doc1 = new ReadDocument("javakod.txt");
		ak(doc1);
		doc1.PrintOutStringAndArrays();
		doc1.compareToKeyWords(keyword);
		doc1.PrintOutStringAndArrays();

//		HashTabel javaNyckelordHasTabell = new HashTabel(41);
//		javaNyckelordHasTabell.readKeyWords();
//
//		String doc1OriginalString = metoder.readDoc("javakod.txt");
////		System.out.println(doc1OriginalString);
//
//		String doc1SpaceString = metoder.makeSpaceInString(doc1OriginalString);
////		System.out.println(doc1SpaceString);
//
//		String[]  doc1CleanTextArray = metoder.splitJavaCode(doc1OriginalString);
//
//		String[]  doc1SpaceStringArray = metoder.splitSpaces(doc1SpaceString);
//		for (int i = 0; i < doc1CleanTextArray.length; i++) {
//			System.out.println(doc1CleanTextArray[i]);
////		}
//		System.out.println();
//		for (int i = 0; i < doc1SpaceStringArray.length; i++) {
//			System.out.print(doc1SpaceStringArray[i] + " ");
//		}




		//System.out.println(doc1OriginalString);


//		for(int i = 0; i < doc1CleanTextArray.length;i ++) {
//			System.out.println(doc1CleanTextArray[i]);
//		}

	}
}
