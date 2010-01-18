package parser.test;


import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beverage.ArticleInfo;
import beverage.Beverage;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import parser.FileParser;

/**
 * @author dt08ja5
 *
 */
public class FileParserTest extends FileParser {
	@Test
	public void ParseLineTest() throws Exception{
		Beverage bev = parseLine("101	namn	namn2	pris	volym	saljstart	slutlev	varugrupp	ursprung	land	producent	argang	prov	alkohol");
		assertEquals(bev.getId(), "101");
		assertEquals(bev.getName(), "namn");
		assertEquals(bev.getPrice(), "pris");
		assertEquals(bev.getAlcohol(), "alkohol");
		assertEquals(bev.getOrigin(), "ursprung");
		assertEquals(bev.getAlcohol(), "alkohol");
	}

}
