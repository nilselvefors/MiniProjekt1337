package s;

public class WordObject {
	private String wordString;
	private int wordOccurrence;
	
	public WordObject(String string) {
		wordString = string;
		wordOccurrence = 1;
	}
	
	public void add() {
		wordOccurrence++;
	}
	
	public int compareTo(WordObject object) {
		return wordString.compareTo(object.getObjectString());
	}
	
	public String getObjectString() {
		return wordString;
	}

}
