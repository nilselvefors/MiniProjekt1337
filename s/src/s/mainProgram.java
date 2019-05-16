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
		ReadDocument doc2 = new ReadDocument("javakod.txt");
		HashTabel hash1 = ak(doc1);
		HashTabel hash2 = ak(doc2);
		
		
		System.out.println("-----------this is the fucking anser------------");
		System.out.println(hash1.eval(hash2));
		System.out.println("-----------this is the fucking anser------------" +
		"");
		
		
		
		
		doc1.PrintOutStringAndArrays();
		System.out.println("end stuff here");
		hash1.printHashTable();
		System.out.println(hash1.find("Nils"));
	}
}
