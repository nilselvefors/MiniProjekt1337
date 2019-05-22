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
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class HashTabelTest {
	
	HashTabel tabel1 = new HashTabel(10);
	HashTabel tabel2 = new HashTabel(10);
	HashTabel tabel3 = new HashTabel(10);
	@Test
	public void addTest() {
		
		tabel1.addHash("Fungerar"); tabel1.addHash("detta");
		tabel1.addHash("eller"); tabel1.addHash("gör");
		tabel1.addHash("vi"); tabel1.addHash("fel");
		

		assertEquals(tabel1.getHowMannyAddedWordInTheHash(), 6);
		for (int i = 0; i < 100; i++) {
			tabel1.addHash(i+"");
		}
		assertEquals("Add 100 obj test with size()", 106, tabel1.sizeWords());
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
	

	@Test
	public void containsTest()
	{
		tabel2.addHash("finns denna string i tabellen");
		assertEquals("Test contains() with existing object", true, tabel2.find("finns denna string i tabellen"));
		assertEquals("Test contains() with non existing object", false, tabel2.find("finnsdennastringitabellen"));
	}
	@Test
	public void sizeTest()
	{
		assertEquals("Check that new list has size 0", 0, tabel3.sizeWords());
	}
	@Test
	public void indexOfTest()
	{
		String string = "HittaDennaOmDuKan";
		tabel3.addHash(string);
		assertEquals("Test that indexOf() object returns first index", HashTabel.makeHashValue(string), tabel3.findPlace(string));
		
	}
	
	@Test
	public void addTestTwo()
	{
		for(int i = 0; i< 1000; i++)
		{
			tabel3.addHash(i+"");
		}
		assertEquals("Add 1000 obj test with size()", 1000, tabel3.sizeWords());
		
		assertEquals("Check that null object is not added, returns false", false, tabel3.addHash(null));
		assertEquals("Check that size hasn't change when adding null", 1000, tabel3.sizeWords());
		
		
	}


	

}
