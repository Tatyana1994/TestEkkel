//: by.iba.ekkel.io/IntBufferDemo.java
// Operate with int numbers in ByteBuffer
// by using IntBuffer 
package by.iba.ekkel.io;

import java.nio.*;

public class IntBufferDemo {
	
	public static final int BSIZE = 1024;
	public static void main(String[] args) {
	
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();
		// Save int array
		ib.put(new int[] { 11, 42, 47, 99, 143, 811, 1016 });
		
		// Read and write on absolute positions
		System.out.println(ib.get(3));
		ib.put(3, 1811);
		
		// Assign new limit before buffer shift
		ib.flip();
		while(ib.hasRemaining()) {
			int i = ib.get();
			System.out.println(i);
		}
		
	}

} /* Output
99
11
42
47
1811
143
811
1016
*///:~
