package s;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import org.omg.IOP.TaggedComponentHelper;

public class HashTabel {
	private WordObject [] hash;
	private int hashSize ;
	private static int hashSizeStatic;
	private ArrayList<Integer> it = new ArrayList<Integer>();
	private int addCount;
	private int addCountAndIfObjectStringIsSame;
	
	public HashTabel (int size) {
		hash = new WordObject[size];
		hashSize = size;
		addCount = 0;
		addCountAndIfObjectStringIsSame = 0;
		hashSizeStatic = size;
	}
	public int getHowMannyAddedWordInTheHash() {
		return addCount;
	}
	public void printQue() {
		Collections.sort(it);
		for (int i = 0; i < it.size(); i++) {
			System.out.println(it.get(i));
		}
		
	}
	public ArrayList<Integer> returnArrayList(){
		return it;
	}
	
	public void printHashTable() {
		if (addCount == 0) {
			System.out.println("HashTabel is Empty");
		}
		else {
			System.out.print("Hash table: ");
			for(int i = 0; i < hash.length; i++) {
				if(hash[i] != null) {
					System.out.print(hash[i].getObjectString() + ", ");
				}
				
			}
			System.out.println();
		}
		
		
	}
	public boolean isEmpty() {
		if(addCount == 0) {
			return true;
		}
		return false;
	}
	
	public double eval(HashTabel hashTable2) {
		String wordDoc1, wordDoc2;
		int wordCounterDoc1;
		int wordCounterDoc2 = 0;
		int wordSameCounter = 0;
		
		WordObject object = null;
		
		for(int i = 0; i < hash.length; i++) {
			if (hash[i] != null ) {
				wordDoc1 = hash[i].getObjectString(); 				// saves word in Doc1
				wordCounterDoc1 = hash[i].getObjectWordCounter();  // saves count in Doc1
				System.out.println(wordDoc1);
				
				if(hashTable2.find(wordDoc1)) {
					object = hashTable2.findWordObject(wordDoc1);
					wordDoc2 = object.getObjectString();             // saves word in Doc2
					wordCounterDoc2 = object.getObjectWordCounter();// saves count in Doc2
					System.out.println(wordDoc2);
				}
				if ( wordCounterDoc2 > wordCounterDoc1) {
					wordSameCounter += wordCounterDoc2 - wordCounterDoc1;
				}
				else if (wordCounterDoc2 <  wordCounterDoc1) {
					wordSameCounter += wordCounterDoc1 - wordCounterDoc2;
				}
				else {
					wordSameCounter += wordCounterDoc1;
				}	
			}
		}
		//answer = wordSameCounter / addCountAndIfObjectStringIsSame ;
		double answer  = 4 / 8;
		System.out.println((double) 4 / 8);
		System.out.println("word same counter" + wordSameCounter + " " + " addCountAndIfObjectStringIsSame "+ addCountAndIfObjectStringIsSame );
		System.out.println(answer + "this is ");
		return (answer * 100);
		
		
	}
	
	
	public boolean addHash(String string) {
		if (addCount >= (hashSize/3)) {
			increaseHash();
			
		}
		WordObject newObject = new WordObject(string);
		int hashValue = makeHashValue(string);
    	if(hash[ hashValue] == null) {
    		hash[(hashValue)] = newObject;
    		it.add(hashValue);
    		addCount++;
    		addCountAndIfObjectStringIsSame++;
    		return true;
//        	System.out.print(string + " " + hashValue);
    	}
    	else {
    		int insted = hashValue ;
			while (hash[insted] !=null ) {
				if(hash[insted].compareStringTo(newObject) == 0) {
					hash[insted].add();
					addCountAndIfObjectStringIsSame++;
					return true;
				}
				insted++;
				insted %= hashSize;
			}
			hash[insted] = newObject;
			it.add(insted);
			addCount++;
			addCountAndIfObjectStringIsSame++;
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
		int newHashSize = getNextPrime(hashSize + (hashSize*2));
		moveHash(newHashSize);
	}
	public void moveHash(int newHashSize) {
		WordObject [] cleanArray = removeEmptySpacesInHash(hash);
		hash = new WordObject [newHashSize];
		hashSize = newHashSize;
		hashAddArray(cleanArray);
		
	}
	public void hashAddArray(WordObject[] cleanArray) {

		for (int n = 0; n < cleanArray.length; n++) {

			WordObject newElementVal = cleanArray[n];
			int arrayIndex = makeHashValue(newElementVal.getObjectString());

			while (hash[arrayIndex] != null) {
				++arrayIndex;
				arrayIndex %= hashSize;

				
			}
			hash[arrayIndex] = newElementVal;
		}
	}
	public WordObject[] removeEmptySpacesInHash (WordObject [] arrarToClean) {
		ArrayList<WordObject> list = new ArrayList<WordObject>();
		for(WordObject theObject : arrarToClean) {
			if (theObject != null) {
				list.add(theObject);
			}
		}
		return list.toArray(new WordObject [list.size()]);
	}
	
	public static int makeHashValue(String s) {
		int a = s.length();
		double hasValue = 1;
		for (int i = 0; i < a; i++) {
			hasValue = hasValue * s.charAt(i)*Math.pow(2, a);
		}
		return (int) (hasValue % hashSizeStatic);
	}
		
		public boolean find(String string) {
			int find = (int)makeHashValue(string);
			if (hash[find] == null) {
				return false;
			}
			if (hash[find].getObjectString().compareTo(string) == 0 ) {
				return true;
			}
			else if (hash[find] != null ) {
				while (hash[find] != null) {
					if (hash[find].getObjectString().compareTo(string) == 0) {
						return true;
					}
					find++;
					
				}
			}
			return false;
		}
		public WordObject findWordObject(String string) {
			int find = (int)makeHashValue(string);
			if (hash[find] == null) {
				return null;
			}
			if (hash[find].getObjectString().compareTo(string) == 0 ) {
				return hash[find];
			}
			else if (hash[find] != null ) {
				while (hash[find] != null) {
					if (hash[find].getObjectString().compareTo(string) == 0) {
						return hash[find];
					}
					find++;
				}
			}
			return null;
		}

	public int findPlace(String s) {
		int find = (int)makeHashValue(s);
		if (hash[find] == null) {
			return -1;
		}
		if (hash[find].getObjectString().compareTo(s) == 0 ) {
			return find;
		}
		else if (hash[find] != null ) {
			while (hash[find] != null) {
				if (hash[find].getObjectString().compareTo(s) == 0) {
					return find;
				}
				find++;
				
			}
		}
		return find;
		
	}
	public int size() {
		return addCount;
	}
	public WordObject getObject (int get) {
		if(hash[get] == null ) {
			return null;
		}
		else {
			return hash[get];
		}
	}
}
