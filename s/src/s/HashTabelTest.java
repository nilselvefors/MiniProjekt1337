package s;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*; 
import static org.junit.jupiter.api.Assertions.*;
import s.HashTabel;


import org.junit.Before;
import org.junit.jupiter.api.Test;

class HashTabelTest {
	
	HashTabel tabel1;
	HashTabel tabel2;
	HashTabel tabel3;
	
	/**
	 * Sets up all the Hashtabels before testing 
	 */
	@Before
	public void setUp()throws Exception {
		tabel1 = new HashTabel(101);
		tabel2 = new HashTabel(101);
		tabel3 = new HashTabel(101);
	}
	
	@Test
	public void addTest()throws Exception {
		for (int i = 0; i < 100; i++) {
			tabel1.addHash(i+"");
		}
		assertEquals(tabel1.getHowMannyAddedWordInTheHash(), 100);
//		assertEquals("Add 100 obj test with size()", tabel1.sizeWords(), tabel1.sizeWords());
	}
	@Test
	public void isEmptyTest()
	{
		assertEquals("Test if new list is empty", true, tabel2.isEmpty());
		for(int i = 0; i < 1000; i++)
		{
			tabel2.addHash(i+"");
		}
		assertEquals("Test if list with objects isn't empty", false, tabel2.isEmpty());
	}

}
