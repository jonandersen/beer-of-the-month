package test;


import java.io.File;
import java.io.IOException;

import model.FileDownloader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.BotMException;


public class FileDownloaderTest {
	private File file;
	
	
	@Before
	public void setUp() throws Exception {		
		file = new File("wikipedia");
		
	}
	
	@Test ( expected = BotMException.class)
	public void wrongURLShouldThrowException() throws BotMException{
		FileDownloader.DownloadFile("heho", file);
	}
	
//	@Test ( expected = BotMException.class)
//	public void fileAlreadyExistsShouldThrowExpcetion() throws BotMException{
//		FileDownloader.DownloadFile("http://www.wikipedia.org/", file);
//		FileDownloader.DownloadFile("http://www.wikipedia.org/", file);		
//	}
	
	@Test
	public void downloadFile()	{		
		try {
			FileDownloader.DownloadFile("http://www.wikipedia.org/", file);			
		} catch (BotMException e) {				
		}		
		junit.framework.Assert.assertEquals(true, file.exists());		
	}
	
	@After
	public void tearDown() throws Exception {
		file.delete();
	}

}
