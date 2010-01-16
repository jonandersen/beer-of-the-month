
import java.io.*;
import java.net.*;

public class FileDownloader {
	private BufferedInputStream bis;
	private FileOutputStream fos;
	private BufferedOutputStream bos;

	public FileDownloader(String url, String filename)
			throws MalformedURLException, IOException {
		bis = new BufferedInputStream(new URL(url).openStream());
		fos = new FileOutputStream(filename);
		bos = new BufferedOutputStream(fos, 1024);


	}
	
	public void WriteToFile() throws IOException{
		byte[] buf = new byte[4 * 1024]; // 4K buffer
		int bytesRead;
		while ((bytesRead = bis.read(buf)) != -1) {
			bos.write(buf, 0, bytesRead);
		}
		bos.close();
		bis.close();
	}
}
