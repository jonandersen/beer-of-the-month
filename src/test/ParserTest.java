package test;

import static org.junit.Assert.*;
import model.Parser;

import org.junit.Before;
import org.junit.Test;

public class ParserTest {

	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void removeHTMLTagsTest(){
		Parser p = new Parser();
		String htmlTags = "<html><title>Title</title></html>";	
		htmlTags = p.removeHTMLTags(htmlTags);
		assertEquals("Title", htmlTags);
	}
	
	@Test
	public void removeHTMLTagsBodyDontAffectStringSentInTest(){
	    String htmlTags= "<html>"+
        "<head>"+
        "<title>Title</title>"+
        "</head>"+
        "<body>"+
        "Body"+
        "</body>"+
        "</html>";
	    Parser p = new Parser();
	    String htmlNoTags = p.removeHTMLTags(htmlTags);
	    assertEquals("<html>"+"<head>"+"<title>Title</title>"+"</head>"+"<body>"+
        "Body"+"</body>"+"</html>", htmlTags);
	    assertEquals("TitleBody", htmlNoTags);
	}
}
