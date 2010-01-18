
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beverage.ArticleInfo;
import beverage.Beverage;


public class DatabaseTest {
	private Database db;
	@Before
	public void setUp() throws Exception {
		db = new Database();
	}

	@Test
	public void emptyDatabaseShouldBeEmpty(){
		assertEquals(0,db.size());
	}
	
	@Test
	public void DatabaseShouldNotBeEmpty(){
		Map<Enum, String> info = new HashMap<Enum,String>();
		info.put(ArticleInfo.ID, "johan suger");
		info.put(ArticleInfo.NAME, "nilsoscar");
		
		Map<Enum, String> info56 = new HashMap<Enum,String>();
		info56.put(ArticleInfo.ID, "johan suger2");
		
		db.add(new Beverage(info));
		db.add(new Beverage(info56));
		assertEquals(2,db.size());
	}
	
	@Test
	public void DatabaseGetShouldReturn(){
		Map<Enum, String> info = new HashMap<Enum,String>();
		info.put(ArticleInfo.ID, "johan suger");
		info.put(ArticleInfo.NAME, "nilsoscar");
		Beverage b = new Beverage(info);
		db.add(b);
		assertEquals(db.get("johan suger"), b);
	}
	
	@Test
	public void DatabaseMakeListShouldBeEmpty(){
		List dbList = db.makeList();
		assertEquals(dbList.isEmpty(),true);
	}
	
	public void DatabaseMakeListShouldNotBeEmpty(){
		Map<Enum, String> info = new HashMap<Enum,String>();
		info.put(ArticleInfo.ID, "johan suger");
		info.put(ArticleInfo.NAME, "nilsoscar");
		db.add(new Beverage(info));
		
		List dbList = db.makeList();
		assertEquals(dbList.isEmpty(),false);
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

}
