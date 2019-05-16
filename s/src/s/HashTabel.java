package s;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.IOP.TaggedComponentHelper;

public class HashTabel {
	private WordObject [] hash;
	private static int hashSize ;
	private int addCount;
	
	public HashTabel (int size) {
		hashSize = size;
		hash = new WordObject[size];
		addCount = 0;
	}
	
	public void printHashTable() {
		System.out.print("Hash table: ");
		for(int i = 0; i < hash.length; i++) {
			if(hash[i] != null) {
				System.out.print(hash[i].getObjectString() + ", ");
			}
			
		}
		System.out.println();
		
	}
	
	public void eval(HashTabel hashTable2) {
		String word;
		int wordOccurrence;
		for(int i = 0; i < hash.length; i++) {
			word = hash[i].getObjectString();
			wordOccurrence = hash[i].getObjectWordCounter();
			
			if(hashTable2.find(word)) {
				
			}
			
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public boolean addHash(String string) {
		if (addCount > hashSize/2) {
			//make hash bigger jump to a prime in the furture
			increaseHash();
			
		}
		WordObject newObject = new WordObject(string);
		int hashValue = makeHashValue(string);
    	if(hash[ hashValue] == null) {
    		hash[(hashValue)] = newObject;
    		addCount++;
    		newObject.add();
    		return true;
//        	System.out.print(string + " " + hashValue);
    	}
    	else {
    		int insted = hashValue ;
			while (hash[insted] !=null ) {
				if(hash[insted].compareTo(newObject) == 0) {
					hash[insted].add();
					return true;
				}
				insted++;
				insted %= hashSize;
			}
			hash[insted] = newObject;
			addCount++;
			return true;
//        	System.out.print(string + " " + insted + " been here");
        	
		}
		
	}

	public boolean isPrime(int number) {
		if(number % 2 == 0) {
			return false;
		}
		for (int i = 3; i *i <= number ; i+=2) {
			if(number % i == 0 ) {
				return false;
			}
		}
		return true;
	}
	
	public int getNextPrime(int numberToCheck) {
		for (int i = numberToCheck ; true ; i++){
			if (isPrime(i)) {
				return i;
			}
		}
	}
	
	public void increaseHash() {
		int newHashSize = getNextPrime(hashSize+50);
		moveHash(newHashSize);
	}
	public void moveHash(int newHashSize) {
		WordObject [] cleanArray = removeEmptySpacesInHash(hash);
		hash = new WordObject [newHashSize];
		hashSize = newHashSize;
		hashAddArray(cleanArray, hash);
		
	}
	public void hashAddArray(WordObject[] cleanArray, WordObject[] hash2) {

		for (int n = 0; n < cleanArray.length; n++) {

			WordObject newElementVal = cleanArray[n];
			int arrayIndex = makeHashValue(newElementVal.getObjectString());

			while (hash2[arrayIndex] != null) {
				++arrayIndex;
				arrayIndex %= hashSize;

				
			}
			hash2[arrayIndex] = newElementVal;
		}
	}
	public WordObject[] removeEmptySpacesInHash (WordObject [] arrarToClean) {
		ArrayList<WordObject> list = new ArrayList<WordObject>();
		for(WordObject theString : arrarToClean) {
			if (!theString.equals(null) && !theString.equals("")) {
				list.add(theString);
			}
		}
		return list.toArray(new WordObject [list.size()]);
	}
	
//	public static HashTabel readKeyWords() {
//		HashTabel tesTabel = new HashTabel(301);
//		try{
//	        Scanner scan =new Scanner(new File("javanyckelord.txt"));
//	        while (scan.hasNext()) {
//	        	String string = scan.next();
//	        	int hashValue = makeHashValue(string);
//	        	if(tesTabel.hash[ hashValue] == null) {
//	        		tesTabel.hash[(hashValue)] = string;
////		        	System.out.println(string + " " + hashValue);
//	        	}
//	        	else {
//	        		int insted = hashValue ;
//					while (tesTabel.hash[insted] !=null) {
//						insted++;
//					}
//					tesTabel.hash[insted] = string;
////		        	System.out.println(string + " " + insted + " been here");
//				}
//	        	
//			}
//	     }
//	     catch( Exception exp) {System.out.println(exp.toString());}
//		return tesTabel;
//	}
	
	public boolean find(String docNameArrayEverthing) {
		int find = (int)makeHashValue(docNameArrayEverthing);
		if (hash[find] == null) {
			return false;
		}
		if (hash[find].getObjectString().compareTo(docNameArrayEverthing) == 0 ) {
			return true;
		}
		else if (hash[find] != null ) {
			while (hash[find] != null) {
				if (hash[find].getObjectString().compareTo(docNameArrayEverthing) == 0) {
					return true;
				}
				find++;
				
			}
		}
		else if (hash[find] == null) {
			return false;
		}
		return false;
	}
	
	public static int makeHashValue(String s) {
		int a = s.length();
		double hasValue = 1;
		for (int i = 0; i < a; i++) {
			hasValue = hasValue * s.charAt(i)*Math.pow(2, a);
		}
		return (int) (hasValue % hashSize);
	}
	
	public int findPlace(WordObject s) {
		int find = (int)makeHashValue(s.getObjectString());
		if (hash[find] == null) {
			return -1;
		}
		if (hash[find].compareTo(s) == 0 ) {
			return find;
		}
		else if (hash[find] != null ) {
			while (hash[find] != null) {
				if (hash[find].compareTo(s) == 0) {
					return find;
				}
				find++;
				
			}
		}
		return find;
		
	}

//	public static int findHash(String s) {
//		int find = makeHashValue(s);
//		int search = find;
//		if (hash[find].contentEquals(s)) {
//			return find;
//		}
//		else {
//			while(!hash[search].contentEquals(s)) {
//				search++;
//			}
//			return search;
//		}
//		
//		
//	}
		
	
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		HashTabel tesTabel = new HashTabel(22);
//		splitJavaCode();
//		readKeyWords();
//		readCode();
		
	}
}
