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
		
		System.out.println("-----------this is the fucking anser------------");
//		metoder.theTwoComparedFilesResultat(doc1ChoiseString, doc2ChoiseString);
		System.out.print(hash1.eval(hash2));
		metoder.printTheAnswer();
		System.out.println("-----------this is the fucking anser------------" +
		"");
		
		
		HashTabel tesTabel = new HashTabel(6);
		tesTabel.addHash("string1");
		tesTabel.addHash("string2");
		tesTabel.addHash("strin3");
		tesTabel.addHash("string4");
		tesTabel.printHashTable();
		System.out.println(tesTabel.getHowMannyAddedWordInTheHash());
		System.out.println("-------------------------------------------");
		tesTabel.addHash("string5");
		tesTabel.addHash("string6");
		tesTabel.addHash("string7");
		
		System.out.println(tesTabel.getHowMannyAddedWordInTheHash());
		
		tesTabel.printHashTable();
	}
}
