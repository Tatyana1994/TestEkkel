//: by.iba.ekkel.io/LargeMappedFiles.java
// Creating of a large file that is reflected to memory
// {RunByHand}
package by.iba.ekkel.io;

import java.nio.*;
import java.nio.channels.*;
import java.util.Random;
import java.io.*;
import static by.iba.ekkel.mindview.util.Print.*;

public class LargeMappedFiles {
	
	static int length = 0x8FFFFFF; //128 MB
	public static void main(String[] args) throws Exception {
	
		// MappedByteBuffer is of direct access buffer type
		MappedByteBuffer out = 
				new RandomAccessFile("test.dat", "rw").getChannel()
					.map(FileChannel.MapMode.READ_WRITE, 0, length);
		for(int i = 0; i < length; i++) {
			out.put((byte)'x');
		}
		print("Writing is completed");
		for(int i = length/2; i < length/2 + 6; i++) {
			printb((char)out.get(i));
		}
	
	}

}
