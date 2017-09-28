//: by.iba.ekkel.io/GZIPcompress.java
// {Params: GZIPcompress.java}
package by.iba.ekkel.io;

import java.util.zip.*;
import java.io.*;

public class GZIPcompress {
	
	public static void main(String[] args) throws IOException {
	
		if(args.length == 0) {
			System.out.println(
					"Using: \nGZIPcompress file\n" +
					"\tUses method GZIP to compress the file " +
					"to test.gz archive");
			System.exit(1);
		}
		
		BufferedReader in = new BufferedReader(
				new FileReader(args[0]));
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(
						new FileOutputStream("test.gz")));
		System.out.println("File writing");
		int c;
		while((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();
		System.out.println("File reading");
		BufferedReader in2 = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(
						new FileInputStream("test.gz"))));
		String s;
		while((s = in2.readLine()) != null) {
			System.out.println(s);
		}
	
	}

} /* Output
File writing
File reading
//: by.iba.ekkel.io/GZIPcompress.java
// {Params: GZIPcompress.java}
package by.iba.ekkel.io;

import java.util.zip.*;
import java.io.*;

public class GZIPcompress {
	
	public static void main(String[] args) throws IOException {
	
		if(args.length == 0) {
			System.out.println(
					"Using: \nGZIPcompress file\n" +
					"\tUses method GZIP to compress the file " +
					"to test.gz archive");
			System.exit(1);
		}
		
		BufferedReader in = new BufferedReader(
				new FileReader(args[0]));
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(
						new FileOutputStream("test.gz")));
		System.out.println("File writing");
		int c;
		while((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();
		System.out.println("File reading");
		BufferedReader in2 = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(
						new FileInputStream("test.gz"))));
		String s;
		while((s = in2.readLine()) != null) {
			System.out.println(s);
		}
	
	}

} /* Output
*///:~
