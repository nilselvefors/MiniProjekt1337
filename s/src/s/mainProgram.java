package s;

import java.io.FileNotFoundException;

import java.util.Iterator;
import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import java.io.*;

public class mainProgram {
	
	private static HashTabel keyWords;
	public static HashTabel keyWords () throws FileNotFoundException {
		return keyWords = metoder.readKeyWords("javanyckelord.txt");
	}


	private static Scanner scan = new Scanner(System.in);

	public static HashTabel ak(ReadDocument document) throws FileNotFoundException {
		document.makeSpaceInString();
		document.splitSpaces();
		document.splitJavaCode();
		HashTabel doc = document.compareToKeyWords(keyWords);
		return doc;
	}

	public static void main(String[] args) throws FileNotFoundException {
		keyWords();
		metoder.choseTwoDocs();
		String doc1ChoiseString = scan.nextLine();
		System.out.println("-------------");
		String doc2ChoiseString = scan.nextLine();
		ReadDocument doc1 = new ReadDocument(doc1ChoiseString);
		ReadDocument doc2 = new ReadDocument(doc2ChoiseString);
//		ReadDocument doc1 = new ReadDocument("doc3");
//		ReadDocument doc2 = new ReadDocument("doc4");
		
		HashTabel hash1 = ak(doc1);
		HashTabel hash2 = ak(doc2);

		hash1.eval(hash2);
	}
}
