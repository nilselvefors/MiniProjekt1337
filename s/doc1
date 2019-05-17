package s;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class IteratorHash {
	private WordObject next;
	private boolean hasNext;
	private int goThrewTheArrayList;
	private ArrayList<Integer> listWhitTheLocationsOfTheHashTabel;
	private HashTabel hashTabel;
	
	public IteratorHash(HashTabel list) {
		hashTabel = list;
		listWhitTheLocationsOfTheHashTabel = list.returnArrayList();
		goThrewTheArrayList = 0;
		Collections.sort(listWhitTheLocationsOfTheHashTabel);
	}
	
	public WordObject next() {
		WordObject returThisObject = hashTabel.getObject(listWhitTheLocationsOfTheHashTabel.get(goThrewTheArrayList));
		goThrewTheArrayList++;
		return returThisObject;
	}
	public void printObject() {
		hashTabel.printHashTable();
	}
	
	public boolean hasNext() {
		if (goThrewTheArrayList < listWhitTheLocationsOfTheHashTabel.size()) {
			return true;
		}
		return false;
	}

}
