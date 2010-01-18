package parser.test;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parser.FileParser;

/**
 * @author dt08ja5
 *
 */
public class FileParserTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		File file = new File("/home/johan/testfile");
		FileParser parser = new FileParser(file);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void ParseTest(){
		
	}

}
