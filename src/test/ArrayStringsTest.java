package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cracking.dataStructures.ArraysStrings;

public class ArrayStringsTest {
	@Test
	public void duplicatesTest() {			    
		StringBuilder s1 = new StringBuilder("arrasar");
		String s2 = new String("ars");
	    assertEquals("Is ars the outcome of removing duplicates from arrasar?", s2,  ArraysStrings.removeDuplicates(s1)); 
	    assertEquals("Is ars the outcome of removing duplicates from arrasar?", "ars",  ArraysStrings.removeDuplicates(s1));
	}
}