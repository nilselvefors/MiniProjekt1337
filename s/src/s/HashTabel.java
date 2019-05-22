package s;

import java.io.File;


import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

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
	/**
	 * 
	 * @return How many WordObjects and the counter of WordObject in HashTabel 
	 */
	public int getHowMannyAddedWordInTheHash() {
		return addCountAndIfObjectStringIsSame;
	}
	/**
	 * Print all the location of WordObject in the HasTabel
	 */
	public void printQue() {
		Collections.sort(it);
		for (int i = 0; i < it.size(); i++) {
			System.out.println(it.get(i));
		}
		
	}
	/**
	 * 
	 * @return The ArrayList of the HashTabel
	 */
	public ArrayList<Integer> returnArrayList(){
		return it;
	}
	/**
	 * Prints all the WordObjects String, if HAshTabel is empty it prints "HashTabel is Empty"
	 */
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
	/**
	 * 
	 * @return True if HashTabel is empty otherwise False
	 */
	public boolean isEmpty() {
		if(addCount == 0) {
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param hashTable2
	 * Evaluating two HashTabel against each other 
	 * @return The percent of plagiarism 
	 */
	public double eval(HashTabel hashTable2) {
		String wordDoc1, wordDoc2 = null;
		int wordCounterDoc1;
		int wordCounterDoc2 = 0;
		int wordSameCounter = 0;
		
		WordObject object = null;
			for (int i = 0; i < it.size(); i++) {
				wordDoc1 = hash[it.get(i)].getObjectString(); 				// saves word in Doc1
				wordCounterDoc1 = hash[it.get(i)].getObjectWordCounter();  // saves count in Doc1
				
				if(hashTable2.find(wordDoc1)) {
					object = hashTable2.findWordObject(wordDoc1);
					wordDoc2 = object.getObjectString();             // saves word in Doc2
					wordCounterDoc2 = object.getObjectWordCounter();// saves count in Doc2
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
			double dividedByThis = 0;
			if(addCountAndIfObjectStringIsSame > hashTable2.getHowMannyAddedWordInTheHash()) {
				dividedByThis = addCountAndIfObjectStringIsSame;
			}
			else {
				dividedByThis = hashTable2.getHowMannyAddedWordInTheHash();
			}
			
		
			double answer  = (double)wordSameCounter / dividedByThis ;
			System.out.println();
			System.out.println(answer);
			DecimalFormat showResultDecimalFormat = new DecimalFormat("##.##");
			String formString = showResultDecimalFormat.format(answer*100);
			System.out.println();
			System.out.println(formString);
			System.out.println();
		return (answer * 100);
		
		
	}
	
	/**
	 * @param string
	 * Makes hash value for the string, makes a WordObject of the string and then places it in the Array, but if the 
	 * place is already taken it checks the place to the right if it's available until it found a place and placing 
	 * the string in the location
	 * @returns true if added 
	 */
	public boolean addHash(String string) {
		if (addCount >= (hashSize/3)) {
			increaseHash();
			
		}
		if(string == null) {
			return false;
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
	/**
	 * @param number
	 * @return True if number is Prim number
	 */
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
	/**
	 *
	 * @param numberToCheck
	 * Takes a int value and then return the closest prime number that is higher.
	 * @returns a primt number
	 */
	public int getNextPrime(int numberToCheck) {
		for (int i = numberToCheck ; true ; i++){
			if (isPrime(i)) {
				return i;
			}
		}
	}
	/**
	 * Increases HashTabel and moves the existing one to the new
	 */
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
	/**
	 * 
	 * @param cleanArray
	 * Adds a array of WordObject in the HashTabel
	 */
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
	/**
	 * Takes all the WordObject in the HashTabel and make an WordObject array of it 
	 */
	public WordObject[] removeEmptySpacesInHash (WordObject [] arrarToClean) {
		ArrayList<WordObject> list = new ArrayList<WordObject>();
		for(WordObject theObject : arrarToClean) {
			if (theObject != null) {
				list.add(theObject);
			}
		}
		return list.toArray(new WordObject [list.size()]);
	}
	/**
	 * 
	 * @param s
	 * Makes a hashvalue for the string 
	 * @return a hashvalue
	 */
	public static int makeHashValue(String s) {
		int a = s.length();
		double hasValue = 1;
		for (int i = 0; i < a; i++) {
			hasValue = hasValue * s.charAt(i)*Math.pow(2, a);
		}
		return (int) (hasValue % hashSizeStatic);
		
	}
		/**
		 * 
		 * @param string
		 * @return True if String is located in HashTabel otherwise returns False 
		 */
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
		/**
		 * 
		 * @param string
		 * @return The WordObject whit the String string
		 */
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
		/**
		 * 
		 * @param String 
		 * @return The Location of the string s in the HasTabel 
		 */
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
		/**
		 * 
		 * @return The size of how manny WordObject added
		 */
		public int sizeWords() {
			return addCount;
		}
		public int sizeOfHashTabel() {
			return hashSize;
		}
		/**
		 * 
		 * @param get
		 * 
		 * @return The WordObject at place get 
		 */
		public WordObject getObject (int get) {
			if(hash[get] == null ) {
				return null;
			}
			else {
				return hash[get];
			}
	}
}
