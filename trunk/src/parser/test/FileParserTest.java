package parser.test;


import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beverage.ArticleInfo;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import parser.FileParser;

/**
 * @author dt08ja5
 *
 */
public class FileParserTest {

	private File file;
	private FileParser parser;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		file = new File("/home/johan/testfile");
		parser = new FileParser(file);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
//	@Test
//	public void ParseLineTest(){
//		HashMap<ArticleInfo, String> map = parser.parseLine("101	one	two	three		four");
//		Collection<String> list = map.values();
//		String[] cList = {"101", "one", "two", "three", "", "four"};
//		for(int i = 0; i < cList.length; ++i)
//			assertEquals(map.get(i), cList[i]);
//	}

}
