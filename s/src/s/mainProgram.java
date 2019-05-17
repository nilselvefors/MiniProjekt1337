package s;

import java.io.FileNotFoundException;

import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

public class mainProgram {


private static Scanner scan = new Scanner(System.in);

	public static HashTabel ak(ReadDocument document) throws FileNotFoundException {
		document.makeSpaceInString();
		document.splitSpaces();
		document.splitJavaCode();
		HashTabel keyword = metoder.readKeyWords("javanyckelord.txt");
		HashTabel doc = document.compareToKeyWords(keyword);
		return doc;
	}

	public static void main(String[] args) throws FileNotFoundException {
//		metoder.choseTwoDocs();
//		String doc1ChoiseString = scan.nextLine();
//		System.out.println("-------------");
//		String doc2ChoiseString = scan.nextLine();
//		ReadDocument doc1 = new ReadDocument(doc1ChoiseString);
//		ReadDocument doc2 = new ReadDocument(doc2ChoiseString);
		ReadDocument doc1 = new ReadDocument("doc1");
		ReadDocument doc2 = new ReadDocument("doc2");
		HashTabel hash1 = ak(doc1);
		HashTabel hash2 = ak(doc2);
//		hash1.printHashTable();
//		hash2.printHashTable();
//		System.out.println("--------------------");
//		
//		
//		System.out.println("-----------this is the fucking anser------------");
////		metoder.theTwoComparedFilesResultat(doc1ChoiseString, doc2ChoiseString);
		System.out.print(hash1.eval(hash2));
//		metoder.printTheAnswer();
//		System.out.println("-----------this is the fucking anser------------" +
//		"");
	}
}
