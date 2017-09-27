//: by.iba.ekkel.io/TestEOF.java
// Check whether the end of the file is reached at the same time as byte was read
package by.iba.ekkel.io;

import java.io.*;

public class TestEOF {
	
	public static void main(String[] args) throws IOException {
	
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream("src/main/java/by/iba/ekkel/io/TestEOF.java")));
		while(in.available() != 0) {
			System.out.print((char)in.readByte());
		}
	}

} /* Output
//: by.iba.ekkel.io/TestEOF.java
// Check whether the end of the file is reached at the same time as byte was read
package by.iba.ekkel.io;

import java.io.*;

public class TestEOF {
	
	public static void main(String[] args) throws IOException {
	
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream("src/main/java/by/iba/ekkel/io/TestEOF.java")));
		while(in.available() != 0) {
			System.out.print((char)in.readByte());
		}
	}
}
*///:~
