package test;


import static org.junit.Assert.*;

import java.util.HashMap;

import model.ArticleInfo;
import model.Beverage;

import org.junit.Before;
import org.junit.Test;

public class TestBeverage {
	private Beverage b1, b2, b3;
	private HashMap m1, m2, m3;
	@Before
	public void setUp() throws Exception {
		m1 = new HashMap<Enum, String>();
		m2 = new HashMap<Enum, String>();
		m3 = new HashMap<Enum, String>();
	}
	
	@Test
	public void testBevereageEquals(){
		m1.put(ArticleInfo.ID, "123");
		m2.put(ArticleInfo.ID, "123");	
		m3.put(ArticleInfo.ID, "43211");	
		b1 = new Beverage(m1);
		b2 = new Beverage(m2);
		b3 = new Beverage(m3);
		assertEquals("Det blev fel" ,b1.equals(b2), true);
		assertEquals("De var lika trots allt, tusan", b1.equals(b3), false);
		}
	}



