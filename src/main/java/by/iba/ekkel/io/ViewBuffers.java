//: by.iba.ekkel.io/ViewBuffers.java
package by.iba.ekkel.io;

import java.nio.*;
import java.nio.charset.Charset;

import static by.iba.ekkel.mindview.util.Print.*;

public class ViewBuffers {
	
	public static void main(String[] args) {
	
		ByteBuffer bb = ByteBuffer.wrap(
				new byte[] { 0, 0, 0, 0, 0, 0, 0, 'a' });
		bb.rewind();
		printb("Buffer Byte: ");
		while(bb.hasRemaining()) {
			printb(bb.position() + " -> " + bb.get() + "; ");
		}
		print();
		CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
		printb("Buffer Char: ");
		while(cb.hasRemaining()) {
			printb(cb.position() + " -> " + cb.get() + "; ");
		}
		print();
		FloatBuffer fb = ((ByteBuffer)bb.rewind()).asFloatBuffer();
		printb("Buffer Float: ");
		while(fb.hasRemaining()) {
			printb(fb.position() + " -> " + fb.get() + "; ");
		}
		print();
		IntBuffer ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
		printb("Buffer Int: ");
		while(ib.hasRemaining()) {
			printb(ib.position() + " -> " + ib.get() + "; ");
		}
		print();
		LongBuffer lb = ((ByteBuffer)bb.rewind()).asLongBuffer();
		printb("Buffer Long: ");
		while(lb.hasRemaining()) {
			printb(lb.position() + " -> " + lb.get() + "; ");
		}
		print();
		ShortBuffer sb = ((ByteBuffer)bb.rewind()).asShortBuffer();
		printb("Buffer Short: ");
		while(sb.hasRemaining()) {
			printb(sb.position() + " -> " + sb.get() + "; ");
		}
		print();
		DoubleBuffer db = ((ByteBuffer)bb.rewind()).asDoubleBuffer();
		printb("Buffer Double: ");
		while(db.hasRemaining()) {
			printb(db.position() + " -> " + db.get() + "; ");
		}
		print();
			
	}

} /* Output
Buffer Byte: 0 -> 0; 1 -> 0; 2 -> 0; 3 -> 0; 4 -> 0; 5 -> 0; 6 -> 0; 7 -> 97; 
Buffer Char: 0 -> ; 1 -> ; 2 -> ; 3 -> a; 
Buffer Float: 0 -> 0.0; 1 -> 1.36E-43; 
Buffer Int: 0 -> 0; 1 -> 97; 
Buffer Long: 0 -> 97; 
Buffer Short: 0 -> 0; 1 -> 0; 2 -> 0; 3 -> 97; 
Buffer Double: 0 -> 4.8E-322; 
*///:~
