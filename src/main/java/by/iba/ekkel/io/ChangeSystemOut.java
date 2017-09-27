//: by.iba.ekkel.io/ChangeSystemOut.java
// Convert System.out to symbol stream PrintWriter
package by.iba.ekkel.io;

import java.io.*;

public class ChangeSystemOut {
	
	public static void main(String[] args) {
	
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("Hello, world!");
	
	}

} /* Output
Hello, world!
*///:~
