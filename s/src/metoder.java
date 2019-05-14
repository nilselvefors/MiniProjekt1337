import java.text.*;
public class metoder {
	
	/**
	 * Creates space between every java character
	 * @return New string with spaces
	 */
	public static String makeSpaceInString(String originalString){
		
		originalString = originalString.replaceAll("[\\{ \\} \\( \\) \\; \\= \\== \\< \\> \\+ \\- \\, \\[ \\] ]"," $0 ");
		
		System.out.println(originalString);
		
		return originalString;
	}
	
	/**
	 * Counts words and symbols in a given string
	 * @Return int containing amount of symbols and words 
	 **/
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

