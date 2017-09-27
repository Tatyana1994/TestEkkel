//: by.iba.ekkel.io/ChannelCopy.java
// File copying by using channels and buffers
// {Params: ChannelCopy.java test.txt}
package by.iba.ekkel.io;

import java.nio.channels.*;
import java.io.*;

public class ChannelCopy {
	
	public static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception {
	
		if(args.length != 2) {
			System.out.println("params: Source Receiver");
			System.exit(1);
		}
		FileChannel 
			in = new FileInputStream(args[0]).getChannel(),
			out = new FileOutputStream(args[1]).getChannel();
		in.transferTo(0, in.size(), out);
		// or
		//out.transferFrom(in, 0, in.size);
	
	}

} /* Output
*///:~
