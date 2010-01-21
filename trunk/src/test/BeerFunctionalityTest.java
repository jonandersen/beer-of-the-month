package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import model.ArticleInfo;
import model.BeerFunctionality;
import model.Beverage;
import model.Database;

import org.junit.Before;
import org.junit.Test;




public class BeerFunctionalityTest {
	private Database db;
	private BeerFunctionality bf;
	private Beverage bev;
	
	@Before
	public void setUp() throws Exception {
		db = new Database();
		HashMap<ArticleInfo, String> m1 = new HashMap<ArticleInfo, String>();
		HashMap<ArticleInfo, String> m2 = new HashMap<ArticleInfo, String>();
		HashMap<ArticleInfo, String> m3 = new HashMap<ArticleInfo, String>();
		m1.put(ArticleInfo.ID, "1");
		m1.put(ArticleInfo.ALCOHOL, "10");
		m1.put(ArticleInfo.VOLUME, "1000");
		m1.put(ArticleInfo.PRICE, "90");
		m1.put(ArticleInfo.TYPE, "ÖL");
		m2.put(ArticleInfo.ID, "2");
		m2.put(ArticleInfo.ALCOHOL, "100");
		m2.put(ArticleInfo.VOLUME, "1000");
		m2.put(ArticleInfo.PRICE, "100");
		m2.put(ArticleInfo.TYPE, "ÖL");
		m3.put(ArticleInfo.ID, "3");
		m3.put(ArticleInfo.ALCOHOL, "1");
		m3.put(ArticleInfo.VOLUME, "1000");
		m3.put(ArticleInfo.PRICE, "120");
		m3.put(ArticleInfo.TYPE, "ÖL");
		db.add(new Beverage(m1));
		bev = new Beverage(m2);
		db.add(bev);
		db.add(new Beverage(m3));
		bf = new BeerFunctionality(db);
	}
	
	@Test
	public void BeerOfTheMonthFunctionallityTest(){
		assertEquals("Det blev fel", bf.BeerOfTheMonth(), bev);
	}
	
	@Test
	public void BangForTheBuckFunctionallityTest(){
		assertEquals("Det blev fel", bf.bangForTheBuck(), bev);
	}

}
