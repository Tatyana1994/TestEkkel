//: by.iba.ekkel.io/GetData.java
// Get various data from ByteBuffer
package by.iba.ekkel.io;

import java.nio.*;
import static by.iba.ekkel.mindview.util.Print.*;

public class GetData {
	
	public static final int BSIZE = 1024;
	public static void main(String[] args) {
	
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		// When allocated it's populated with 0
		int i = 0;
		while(i++ < bb.limit()) {
			if(bb.get() != 0) {
				print("nonzero");
			}
		}
		print("i = " + i);
		bb.rewind();
		// Save and read character array
		bb.asCharBuffer().put("Howdy!");
		char c;
		while((c = bb.getChar()) != 0) {
			printb(c + " ");
		}
		print();
		//rewind() -- перемотать -- Rewinds this buffer. The position is set to zero and the mark is discarded. 
		//Invoke this method before a sequence of channel-write or get operations, assuming that the limit has already been set appropriately. 
		bb.rewind();
		// Save and read the number of short type
		bb.asShortBuffer().put((short)471142);
		print(bb.getShort());
		bb.rewind();
		// Save and read the number of int type
		bb.asIntBuffer().put(99471142);
		print(bb.getInt());
		bb.rewind();
		// Save and read the number of long type
		bb.asLongBuffer().put(99471142);
		print(bb.getLong());
		bb.rewind();
		// Save and read the number of float type
		bb.asFloatBuffer().put(99471142);
		print(bb.getFloat());
		bb.rewind();
		// Save and read the number of double type
		bb.asDoubleBuffer().put(99471142);
		print(bb.getDouble());
		bb.rewind();
		
	
	}

} /* Output
i = 1025
H o w d y ! 
12390
99471142
99471142
9.9471144E7
9.9471142E7
*///:~
