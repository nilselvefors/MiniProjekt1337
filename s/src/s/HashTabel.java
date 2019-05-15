package s;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTabel {
	private static String [] hash;
	private static int hashSize ;
	
	public HashTabel (int size) {
		hash = new String[size];
		hashSize = hash.length;
	}
	
	public void addHash(String string) {
		
	}
	
	public static HashTabel readKeyWords() {
		HashTabel tesTabel = new HashTabel(301);
		try{
	        Scanner scan =new Scanner(new File("javanyckelord.txt"));
	        while (scan.hasNext()) {
	        	String string = scan.next();
	        	int hashValue = makeHashValue(string);
	        	if(tesTabel.hash[ hashValue] == null) {
	        		tesTabel.hash[(hashValue)] = string;
//		        	System.out.println(string + " " + hashValue);
	        	}
	        	else {
	        		int insted = hashValue ;
					while (tesTabel.hash[insted] !=null) {
						insted++;
					}
					tesTabel.hash[insted] = string;
//		        	System.out.println(string + " " + insted + " been here");
				}
	        	
			}
	     }
	     catch( Exception exp) {System.out.println(exp.toString());}
		return tesTabel;
	}
	
	public int findPlace(String s) {
		int find = (int)makeHashValue(s);
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
	
	public boolean find(String s) {
		int find = (int)makeHashValue(s);
		if (hash[find] == null) {
			return false;
		}
		if (hash[find].compareTo(s) == 0 ) {
			return true;
		}
		else if (hash[find] != null ) {
			while (hash[find] != null) {
				if (hash[find].compareTo(s) == 0) {
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
	
	public static int findHash(String s) {
		int find = makeHashValue(s);
		int search = find;
		if (hash[find].contentEquals(s)) {
			return find;
		}
		else {
			while(!hash[search].contentEquals(s)) {
				search++;
			}
			return search;
		}
		
		
	}
		
	
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		HashTabel tesTabel = new HashTabel(22);
//		splitJavaCode();
//		readKeyWords();
//		readCode();
		
	}
}
