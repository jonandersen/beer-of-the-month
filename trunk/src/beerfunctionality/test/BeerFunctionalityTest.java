package beerfunctionality.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import database.Database;

import beerfunctionality.BeerFunctionality;
import beverage.ArticleInfo;
import beverage.Beverage;


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
		m2.put(ArticleInfo.ID, "2");
		m2.put(ArticleInfo.ALCOHOL, "100");
		m2.put(ArticleInfo.VOLUME, "1000");
		m2.put(ArticleInfo.PRICE, "100");
		m3.put(ArticleInfo.ID, "3");
		m3.put(ArticleInfo.ALCOHOL, "1");
		m3.put(ArticleInfo.VOLUME, "1000");
		m3.put(ArticleInfo.PRICE, "120");
		db.add(new Beverage(m1));
		bev = new Beverage(m2);
		db.add(bev);
		db.add(new Beverage(m3));
		bf = new BeerFunctionality(db);
	}
	
	@Test
	public void BangForTheBuckFunctionallityTest(){
		assertEquals("Det blev fel", bf.bangForTheBuck(), bev);
	}

}
