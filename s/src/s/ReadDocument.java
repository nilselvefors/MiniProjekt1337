package s;

import java.lang.Object;
import java.nio.channels.SeekableByteChannel;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class ReadDocument {
	private static int counter;	
	private String docName;
	private String docNameSpace;
	private  String[] docNameArrayEverthing;
	private  String[] docNameArrayOnlyCode;
	private  HashTabel hashTabel ;
	
	public ReadDocument(String fileName) throws FileNotFoundException {
		docName = readDoc(fileName);
		counter = 0;
		hashTabel = new HashTabel(301);
	}
	
	public void PrintOutStringAndArrays() {
		System.out.println();
		System.out.print("docNameArrayEverthing: ");
		for(int i = 0; i  < docNameArrayEverthing.length; i++) {
			System.out.print(docNameArrayEverthing[i] + " ");
		}
		System.out.println();
		System.out.println("docNameSpace: " + docNameSpace);
		System.out.println("docName: " + docName);
		System.out.println("counter: " + counter);
		System.out.println("docNameArrayOnlyCode");
		for (int i = 0; i < docNameArrayOnlyCode.length; i++) {
			System.out.print(docNameArrayOnlyCode[i]+ " ");
		}
	}
	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public String readDoc(String fileName) throws FileNotFoundException {
		StringBuilder string = new StringBuilder();
		Scanner scan = new Scanner(new File(fileName));
		while (scan.hasNext()) {
			string.append(scan.nextLine().trim());
		}
		return string.toString();
		
	}
	
	public void splitSpaces() {
		docNameArrayEverthing = docNameSpace.trim().split("[\t \" \' \\s+]+");
	}
	
	public HashTabel compareToKeyWords(HashTabel keyWordsHashTabel) {
		for (int i = 0; i < docNameArrayEverthing.length; i++) {
			if (keyWordsHashTabel.find(docNameArrayEverthing[i]) || isNumeric(docNameArrayEverthing[i])){
				counter++;
			}
			else {
				hashTabel.addHash(docNameArrayEverthing[i]);
				counter++;
			}
		}
		return hashTabel;
	}
	
	public boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	public void splitJavaCode() {
		docNameArrayOnlyCode= docNameSpace.trim().split("[\\{ \\} \\( \\) \\; \\= \\== \\< \\> \\+ \\- \\, \\[ \\] \\s+ ]+");
	}
	
	public static int countWordsAndSymbols(String string) {
		int counter = 0;
		
		CharacterIterator iterator = new StringCharacterIterator(string);
		while(iterator.current() != CharacterIterator.DONE) {
			counter++;
			iterator.next();
		}
		return counter;
		
		
	}
	public void makeSpaceInString(){
		docNameSpace =  docName.replaceAll("[\\{ \\} \\( \\) \\; \\= \\== \\< \\> \\+ \\- \\, \\[ \\] ]"," $0 ");

	}

}
