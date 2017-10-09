//: by.iba.ekkel.io/FileLocking.java
package by.iba.ekkel.io;

import java.nio.channels.*;
import java.util.concurrent.*;
import java.io.*;

public class FileLocking {
	
	public static void main(String[] args) throws Exception {
	
		FileOutputStream fos = new FileOutputStream("file.txt");
		FileLock fl = fos.getChannel().tryLock();
		if(fl != null) {
			System.out.println("File is blocked");
			TimeUnit.MILLISECONDS.sleep(100);
			fl.release();
			System.out.println("Block is discarded");
		}
		fos.close();
	
	}

} /* Output
File is blocked
Block is discarded
*///:~
