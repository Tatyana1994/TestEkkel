//: by.iba.ekkel.io/MemoryInput.java
package by.iba.ekkel.io;

import java.io.*;

public class MemoryInput {
	
	public static void main(String[] args) throws IOException {
	
		StringReader in = new StringReader(
				BufferedInputFile.read("src/main/java/by/iba/ekkel/io/MemoryInput.java"));
		int c;
		while((c = in.read()) != -1) {
			System.out.print((char)c);
		}
	
	}

} /* Output
//: by.iba.ekkel.io/MemoryInput.java
package by.iba.ekkel.io;

import java.io.*;

public class MemoryInput {
	
	public static void main(String[] args) throws IOException {
	
		StringReader in = new StringReader(
				BufferedInputFile.read("src/main/java/by/iba/ekkel/io/MemoryInput.java"));
		int c;
		while((c = in.read()) != -1) {
			System.out.print((char)c);
		}
	
	}

}
*///:~
