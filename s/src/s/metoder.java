package s;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
public class metoder {
	
	public static String makeSpaceInString(String originalString){
		
		originalString = originalString.replaceAll("[\\{ \\} \\( \\) \\; \\= \\== \\< \\> \\+ \\- \\, \\[ \\] ]"," $0 ");
		
		System.out.println(originalString);
		
		return originalString;
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
	
	public static void main(String[] args) {
		String test = "for(int i=0;)";
		String newString = makeSpaceInString(test);
		//System.out.println(newString);
		} 
	}


