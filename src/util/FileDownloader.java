package util;


import java.io.*;
import java.net.*;

import exception.BotMException;

public class FileDownloader implements Runnable{
	private boolean done;
	private int progress;
	private String urlpath;
	private File file;
	
	public FileDownloader(String urlpath, File file){
		done = false;
		progress = 0;
		this.urlpath = urlpath;
		this.file = file;
	}
	public void DownloadFile() throws BotMException {
		try {
			URL url = new URL(urlpath);
			URLConnection conn = url.openConnection();
			double total = conn.getContentLength();				
			BufferedInputStream bis = new BufferedInputStream(new URL(urlpath).openStream());			
			FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
			BufferedOutputStream  bos = new BufferedOutputStream(fos, 1024);			
			byte[] buf = new byte[4 * 1024];
			int bytesRead;
			double current = 0;
			while ((bytesRead = bis.read(buf)) != -1) {
				bos.write(buf, 0, bytesRead);
				current += bytesRead;				
				progress = (int)((current / total * 100));				
			}
			done = true;
			bos.close();
			bis.close();
		} catch (MalformedURLException e) {			
			throw new BotMException("The url is wrong");
		} catch (IOException e) {			
			throw new BotMException("I/O problem");
		} 
	}
	
	public boolean done(){
		return done;
	}
	public int progress(){		
		return progress;
	}
	
	public void run() {
		try {
			DownloadFile();
		} catch (BotMException e) {
			System.err.println("An error occured: " + e.getMessage());
			System.exit(-1);
		}		
	}
}


