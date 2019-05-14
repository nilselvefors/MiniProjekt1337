package s;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTabel {
	private static String [] hash;
	private static int hashSize ;
	private int sizeOfFileTkn;
	private String [] syntax = { "{, } , ( , ) , = , == , < , > , + , - , "};
	
	public HashTabel () {
		hash = new String[307];
		hashSize = hash.length;
		sizeOfFileTkn = 0;
	}
	
	public static HashTabel readKeyWords() {
		HashTabel tesTabel = new HashTabel();
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
		double a = makeHashValue(s);
		return (int) a;
		
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
		HashTabel tesTabel = new HashTabel();
//		splitJavaCode();
//		readKeyWords();
//		readCode();
		
	}
}
