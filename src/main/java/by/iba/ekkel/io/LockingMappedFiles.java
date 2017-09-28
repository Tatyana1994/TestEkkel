//: by.iba.ekkel.io/LockingMappedFiles.java
// Partial block of the reflected file
// {RunByHand}
package by.iba.ekkel.io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class LockingMappedFiles {
	
	static final int LENGTH = 0x8FFFFFF; //128 MB
	static FileChannel fc;
	
	public static void main(String[] args) throws Exception {
	
		fc = 
				new RandomAccessFile("test.dat", "rw").getChannel();
		MappedByteBuffer out = 
				fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
		for(int i = 0; i < LENGTH; i++) {
			out.put((byte)'x');	
		}	
		new LockAndModify(out, 0, 0 + LENGTH/3);
		new LockAndModify(out, LENGTH/2, LENGTH/3 + LENGTH/4);
		
	}
	
	private static class LockAndModify extends Thread {
		private ByteBuffer buff;
		private int start, end;
		LockAndModify(ByteBuffer mbb, int start, int end) {
			this.start = start;
			this.end = end;
			mbb.limit(end);
			mbb.position(start);
			buff = mbb.slice();
			start();
		}
		public void run() {
			try {
				// Monopolistic block without covering
				FileLock fl = fc.lock(start, end, false);
				System.out.println("Blocked: " + start + " to " + end);
				//Modification
				while(buff.position() < buff.limit() - 1) {
					buff.put((byte)(buff.get() + 1));
				}
				fl.release();
				System.out.println("Block is discarded: " + start + " to " + end);
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
} /* Output
*///:~
