
import static org.junit.Assert.*;

import java.util.ArrayList;
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
		fillDB();
		assertEquals(2,db.size());
	}
	
	@Test
	public void DatabaseShouldRemoveBeverage(){
		fillDB();
		assertEquals(2,db.size());
		db.remove("1365");
		assertEquals(1,db.size());
	}
	
	@Test
	public void DatabaseGetShouldReturn(){
		fillDB();
		Map<Enum, String> info = new HashMap<Enum,String>();
		info.put(ArticleInfo.ID, "7895");
		info.put(ArticleInfo.NAME, "Mariestad");
		Beverage b = new Beverage(info);
		db.add(b);
		assertEquals(db.get("7895"), b);
	}
	
	@Test
	public void DatabaseMakeListShouldBeEmpty(){		
		List dbList = db.makeList();
		assertEquals(dbList.isEmpty(),true);
	}
	
	public void DatabaseMakeListShouldNotBeEmpty(){		
		List dbList = db.makeList();
		assertEquals(dbList.isEmpty(),false);
		
	}
	
	@Test
	public void BeerListOnlyContainsBeer(){
		Map<Enum, String> info = new HashMap<Enum,String>();
		info.put(ArticleInfo.ID, "1365");
		info.put(ArticleInfo.NAME, "Redulf");
		info.put(ArticleInfo.TYPE, "Wine");
		
		ArrayList<Beverage> beerlist = db.getBeerList();
		Boolean containsnotbeer = false;
		for(Beverage bevrage: beerlist){
			if(!bevrage.getType().equals("Beer")){
				containsnotbeer = true;
				break;
			}
		}
		assertEquals(containsnotbeer, false);
	}
	
	private void fillDB(){
		Map<Enum, String> info = new HashMap<Enum,String>();
		info.put(ArticleInfo.ID, "1365");
		info.put(ArticleInfo.NAME, "Carlsberg");
		info.put(ArticleInfo.TYPE, "Beer");
		
		Map<Enum, String> info2 = new HashMap<Enum,String>();
		info2.put(ArticleInfo.ID, "1456");
		info2.put(ArticleInfo.NAME, "Mariestad");
		info2.put(ArticleInfo.TYPE, "Beer");
		
		db.add(new Beverage(info));	
		db.add(new Beverage(info2));
	}

}
