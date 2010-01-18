
import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FileDownloaderTest {
	private File file;
	
	
	@Before
	public void setUp() throws Exception {
		String filename = "wikipedia";		
		file = new File(filename);
		
	}
	
	@Test ( expected = BotMException.class)
	public void wrongURLShouldThrowException() throws BotMException{
		FileDownloader.DownloadFile("heho", file.getName());
	}
	
	@Test ( expected = BotMException.class)
	public void fileAlreadyExistsShouldThrowExpcetion() throws BotMException{
		FileDownloader.DownloadFile("http://www.wikipedia.org/", file.getName());
		FileDownloader.DownloadFile("http://www.wikipedia.org/", file.getName());		
	}
	
	@Test
	public void downloadFile()	{		
		try {
			FileDownloader.DownloadFile("http://www.wikipedia.org/", file.getName());			
		} catch (BotMException e) {				
		}		
		junit.framework.Assert.assertEquals(true, file.exists());		
	}
	
	@After
	public void tearDown() throws Exception {
		file.delete();
	}

}
