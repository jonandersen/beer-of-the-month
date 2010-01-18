package parser.test;


import static org.junit.Assert.*;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beverage.ArticleInfo;
import beverage.Beverage;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import database.Database;

import parser.FileParser;

/**
 * @author dt08ja5
 *
 */
public class FileParserTest extends FileParser {
	public FileParserTest() {
		super(null, null);
		// TODO Auto-generated constructor stub
	}

	public Beverage bev;
	@Before
	public void setUp() throws Exception {
		bev = parseLine("101	namn	namn2	pris	volym	saljstart	slutlev	varugrupp	ursprung	land	producent	argang	prov	alkohol");
	}
	@Test
	public void ParseLineTestName(){
		assertEquals(bev.getName(), "namn namn2");
	}
	@Test
	public void ParseLineTestID(){
		assertEquals(bev.getId(), "101");
	}
	
	@Test
	public void ParseLineTestPrice(){
		assertEquals(bev.getPrice(), "pris");
	}
	
	@Test
	public void ParseLineTestAlcohol(){
		assertEquals(bev.getAlcohol(), "alkohol");
	}

	@Test
	public void ParseLineTestOrigin(){
		assertEquals(bev.getOrigin(), "ursprung");
	}

	@Test
	public void ParseLineTestVintage(){
		assertEquals(bev.getVintage(), "argang");
	}

	@Test
	public void ParseLineTestType(){
		assertEquals(bev.getType(), "varugrupp");
	}

	@Test
	public void ParseLineTestVolume(){
		assertEquals(bev.getVolume(), "volym");
	}
	
//	public void parseStringTest(){
//		StringReader strr = new StringReader("Skapad Tid:	2010-01-18 09:42
//nr	namn	namn2	prisinklmoms	volymiml	saljstart	slutlev	varugrupp	ursprung	ursprunglandnamn	producent	argang	provadargang	alkoholhalt	
//													
//101	Renat		199	700	19931001		SPRIT	Sverige	Sverige	V&S			37,5%
//102	Renat		106	350	19931001		SPRIT	Sverige	Sverige	V&S			37,5%
//");
//	}
}