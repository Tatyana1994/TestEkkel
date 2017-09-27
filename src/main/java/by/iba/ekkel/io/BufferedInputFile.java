//: by.iba.ekkel.io/BufferedInputFile.java
package by.iba.ekkel.io;

import java.io.*;

public class BufferedInputFile {
	
	//Exceptions are being send to console
	public static String 
		read(String filename) throws IOException {
			//Reas input stream by string
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String s;
			StringBuilder sb = new StringBuilder();
			while((s = in.readLine()) != null) {
				sb.append(s + "\n");
			}
			in.close();
			return sb.toString();
		}
	
	public static void main(String[] args) throws IOException {
	
		System.out.println(read("src/main/java/by/iba/ekkel/io/BufferedInputFile.java"));
	
	}

} /* Output
//: by.iba.ekkel.io/BufferedInputFile.java
package by.iba.ekkel.io;

import java.io.*;

public class BufferedInputFile {
	
	//Exceptions are being send to console
	public static String 
		read(String filename) throws IOException {
			//Reas input stream by string
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String s;
			StringBuilder sb = new StringBuilder();
			while((s = in.readLine()) != null) {
				sb.append(s + "\n");
			}
			in.close();
			return sb.toString();
		}
	
	public static void main(String[] args) throws IOException {
	
		System.out.println(read("src/main/java/by/iba/ekkel/io/BufferedInputFile.java"));
	
	}

}
*///:~
