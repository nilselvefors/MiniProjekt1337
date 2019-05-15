package s;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class mainProgram {
	public static HashTabel ak(ReadDocument document) throws FileNotFoundException {
		document.makeSpaceInString();
		document.splitSpaces();
		document.splitJavaCode();
		HashTabel keyword = metoder.readKeyWords("javanyckelord.txt");
		HashTabel doc1hasHashTabel = document.compareToKeyWords(keyword);
		return doc1hasHashTabel;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("here is keyword in main");
		System.out.println();
		ReadDocument doc1 = new ReadDocument("javakod.txt");
		HashTabel aHashTabel = ak(doc1);
		System.out.println("-----------stuff here------------");
		doc1.PrintOutStringAndArrays();
		System.out.println("end stuff here");
		aHashTabel.printHashTable();
		HashTabel hash1 = new HashTabel(50);
		HashTabel hash2 = new HashTabel(50);
		System.out.println("" + 
		"");
		hash1.addHash("string");
		hash1.addHash("bok");
		hash2.addHash("this is wrong");
		hash1.printHashTable();
		hash2.printHashTable();
		
	}
}
