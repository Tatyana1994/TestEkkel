//: by.iba.ekkel.io/BufferToText.java
// Get text from ByteBuffers and backwards 
package by.iba.ekkel.io;

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

import javax.imageio.stream.FileImageOutputStream;

import java.io.*;

public class BufferToText {
	
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception {
	
		FileChannel fc = 
				new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		// Is not working
		System.out.println(buff.asCharBuffer());
		
		//Decode using default encoding
		buff.rewind();
		String encoding = System.getProperty("file.encoding");
		System.out.println("Decoded to " + encoding + ": " +
					Charset.forName(encoding).decode(buff));
		// Encoding in printing form
		fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap(
				"Some text".getBytes("UTF-16BE")));
		fc.close();
		
		// Repeated attempt of reading
		fc = new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		
		// Using CharBuffer for writing
		fc = new FileOutputStream("data2.txt").getChannel();
		buff = ByteBuffer.allocate(24); //More that it's needed
		buff.asCharBuffer().put("Some text");
		fc.write(buff);
		fc.close();
		
		// Read and write
		fc = new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
	
	}

} /* Output
????
Decoded to Cp1251: Some text
Some text
Some text
*///:~
