package s;

import java.io.FileNotFoundException;

public class mainProgram {
	
	public static void main(String[] args) throws FileNotFoundException {
		HashTabel javaNyckelordHasTabell = new HashTabel();
		javaNyckelordHasTabell.readKeyWords();
		
		
		String doc1OriginalString = metoder.readDoc("javakod.txt");
		System.out.println(doc1OriginalString);
		
		String doc1SpaceString = metoder.makeSpaceInString(doc1OriginalString);
		System.out.println(doc1SpaceString);
		
		String[]  doc1CleanTextArray = metoder.splitJavaCode(doc1OriginalString);
		
		
		
		
		
		
		//System.out.println(doc1OriginalString);
		
		
//		for(int i = 0; i < doc1CleanTextArray.length;i ++) {
//			System.out.println(doc1CleanTextArray[i]);
//		}
		
	}
}
