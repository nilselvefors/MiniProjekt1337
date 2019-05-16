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
	}
}
