package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

import model.ArticleInfo;
import model.BeerFunctionality;
import model.Beverage;
import model.Database;
import model.HtmlParser;

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
		m1.put(ArticleInfo.TYPE, "WINE");
		m2.put(ArticleInfo.ID, "2");
		m2.put(ArticleInfo.ALCOHOL, "100");
		m2.put(ArticleInfo.VOLUME, "1000");
		m2.put(ArticleInfo.PRICE, "100");
		m2.put(ArticleInfo.TYPE, "ÖL");
		m3.put(ArticleInfo.ID, "3");
		m3.put(ArticleInfo.ALCOHOL, "1");
		m3.put(ArticleInfo.VOLUME, "1000");
		m3.put(ArticleInfo.PRICE, "120");
		m3.put(ArticleInfo.TYPE, "SPRIT");
		db.add(new Beverage(m1));
		bev = new Beverage(m2);
		db.add(bev);
		db.add(new Beverage(m3));
		bf = new BeerFunctionality(db);
	}
	
	@Test
	public void TestHtmlParserIsInHouseBreznakShouldBeInHouse() throws IOException{
		HtmlParser parse = new HtmlParser();
		URL ur = new URL("http://www.systembolaget.se/SokDrycker/Produkt?VaruNr=1611&Butik=226");
		parse.isInHouse(parse.getHtmlSource(ur));
		assertEquals(parse.isInHouse(parse.getHtmlSource(ur)),true);
	}
	
	
	@Test
	public void BeerOfTheMonthFunctionallityTest(){
		assertEquals(bf.BeerOfTheMonth(), bev);
	}
	
	@Test
	public void BangForTheBuckFunctionallityTest(){
		assertEquals(bf.bangForTheBuck(), bev);
	}

}
