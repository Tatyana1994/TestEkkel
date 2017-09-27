//: by.iba.ekkel.io/getChannel.java
// Get the channel of the streams
package by.iba.ekkel.io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetChannel {
	
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception {
	
		// File record
		FileChannel fc = 
				new FileOutputStream("data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		// Add to the end of the file
		fc = 
				new RandomAccessFile("data.txt", "rw").getChannel();
		fc.position(fc.size()); //Go to the end
		fc.write(ByteBuffer.wrap(" Some more".getBytes()));
		fc.close();
		// Read the file
		fc = new FileInputStream("data.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		while(buff.hasRemaining()) {
			System.out.print((char)buff.get());
		}
		
	}

} /* Output
Some text Some more
*///:~

