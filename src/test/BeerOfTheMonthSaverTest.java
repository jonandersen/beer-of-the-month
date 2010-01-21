package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.ArticleInfo;
import model.BeerOfTheMonthSaver;
import model.Beverage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;





public class BeerOfTheMonthSaverTest {
	private String filename;
	
	@Before
	public void setUp() throws Exception {		
		filename = "test";
		
	}
	
	@Test
	public void BotMIsSaved(){
		Map<ArticleInfo, String> info = new HashMap<ArticleInfo,String>();
		info.put(ArticleInfo.ID, "1365");
		info.put(ArticleInfo.NAME, "Carlsberg");
		info.put(ArticleInfo.TYPE, "ÖL");
		Beverage beverage = new Beverage(info);
		try {
			BeerOfTheMonthSaver botm = new BeerOfTheMonthSaver(beverage, filename);
			botm.save();
		} catch (FileNotFoundException e) {			
		}		
		assertEquals(beverage.toString(), reader(filename));		
	}
	
	@After
	public void tearDown() throws Exception {
		File file = new File(filename);
		file.delete();
	}
	
	private String reader(String filename){
		String s = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));			
			while(reader.ready()){
				s = s + reader.readLine();
			}
		} catch (FileNotFoundException e) {					
		} catch (IOException e)	 {	}
		return s;
	}

}
