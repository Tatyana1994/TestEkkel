//: by.iba.ekkel.io/FormattedMemoryInput.java
package by.iba.ekkel.io;

import java.io.*;

public class FormattedMemoryInput {
	
	public static void main(String[] args) throws IOException {
	
		try {
			DataInputStream in = new DataInputStream(
					new ByteArrayInputStream(BufferedInputFile.read("src/main/java/by/iba/ekkel/io/FormattedMemoryInput.java").getBytes()));
			while(true) {
				System.out.print((char)in.readByte());
			}
		} catch(EOFException e) {
			System.err.println("End of stream");
		}
	
	}

} /* Output
//: by.iba.ekkel.io/FormattedMemoryInput.java
package by.iba.ekkel.io;

import java.io.*;

public class FormattedMemoryInput {
	
	public static void main(String[] args) throws IOException {
	
		try {
			DataInputStream in = new DataInputStream(
					new ByteArrayInputStream(BufferedInputFile.read("src/main/java/by/iba/ekkel/io/FormattedMemoryInput.java").getBytes()));
			while(true) {
				System.out.print((char)in.readByte());
			}
		} catch(EOFException e) {
			System.err.println("End of stream");
		}
	
	}

}
End of stream
*///:~
