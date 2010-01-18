
import java.io.*;
import java.net.*;

import exception.BotMException;

public class FileDownloader {
	
	public static void DownloadFile(String url, File file) throws BotMException {		
		if(file.exists()){
			throw new BotMException("The file already exists");
		}
		try {
			BufferedInputStream bis = new BufferedInputStream(new URL(url).openStream());
			FileOutputStream fos = new FileOutputStream(file.getName());
			BufferedOutputStream  bos = new BufferedOutputStream(fos, 1024);
			byte[] buf = new byte[4 * 1024];
			int bytesRead;
			while ((bytesRead = bis.read(buf)) != -1) {
				bos.write(buf, 0, bytesRead);
			}
			bos.close();
			bis.close();
		} catch (MalformedURLException e) {			
			throw new BotMException("The url is wrong");
		} catch (IOException e) {			
			throw new BotMException("I/O problem");
		}
	}
}


