import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;


public class PageMaker extends FileWriter {

	public PageMaker(String fileName) throws IOException {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	public PageMaker(File file) throws IOException {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public PageMaker(FileDescriptor fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	public PageMaker(String fileName, boolean append) throws IOException {
		super(fileName, append);
		// TODO Auto-generated constructor stub
	}

	public PageMaker(File file, boolean append) throws IOException {
		super(file, append);
		// TODO Auto-generated constructor stub
	}

}
