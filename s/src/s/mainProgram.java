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
		HashTabel doc1hasHashTabel = document.compareToKeyWords(keyword);
		return doc1hasHashTabel;
	}

	public static void main(String[] args) throws FileNotFoundException {
//		metoder.choseTwoDocs();
//		String doc1ChoiseString = scan.nextLine();
//		System.out.println("-------------");
//		String doc2ChoiseString = scan.nextLine();
//		ReadDocument doc1 = new ReadDocument(doc1ChoiseString);
//		ReadDocument doc2 = new ReadDocument(doc2ChoiseString);
		ReadDocument doc1 = new ReadDocument("javakod.txt");
		ReadDocument doc2 = new ReadDocument("javakod.txt");
		HashTabel hash1 = ak(doc1);
		HashTabel hash2 = ak(doc2);
		hash1.printQue();
		IteratorHash ithas = new IteratorHash(hash1);
		int counter = 0;
		while (ithas.hasNext()) {
			System.out.println(ithas.next());
			counter++;
		}
		System.out.println(counter);
		System.out.println(hash1.size());
		System.out.println("--------------------");
		ithas.printObject();
		
		System.out.println("-----------this is the fucking anser------------");
//		metoder.theTwoComparedFilesResultat(doc1ChoiseString, doc2ChoiseString);
		System.out.print(hash1.eval(hash2));
		metoder.printTheAnswer();
		System.out.println("-----------this is the fucking anser------------" +
		"");
	}
}
