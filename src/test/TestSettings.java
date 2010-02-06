package test;


import static org.junit.Assert.*;
import gui.Settings;

import org.junit.Before;
import org.junit.Test;

public class TestSettings {
	private Settings set;

	@Before
	public void setUp() throws Exception {
		set = new Settings();
	}
	
	@Test
	public void testSetAndGet(){
		assertEquals(false, set.rollBeer());
		set.setBeer(true);
		assertEquals(true, set.rollBeer());
	}
	@Test
	public void testCopy(){		
		set.setBeer(true);
		set.setBeverage(true);
		
		Settings set2 = new Settings();
		set2.copySet(set);
		
		assertEquals(set.rollBeer(), set2.rollBeer());
		assertEquals(set.rollWine(), set2.rollWine());
		assertEquals(set.rollBeverage(), set2.rollBeverage());
		
		set2.copySet(set);
		
		assertEquals(set.rollBeer(), set2.rollBeer());
		assertEquals(set.rollWine(), set2.rollWine());
		assertEquals(set.rollBeverage(), set2.rollBeverage());
	}
	
}
