//: by.iba.ekkel.io/BasicFileOutput.java
package by.iba.ekkel.io;

import java.io.*;

public class BasicFileOutput {
	
	static String file = "BasicFileOutput.out";
	public static void main(String[] args) throws IOException {
	
		BufferedReader in = new BufferedReader(
				new StringReader(BufferedInputFile.read("src/main/java/by/iba/ekkel/io/BasicFileOutput.java")));
		PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter(file)));
		int lineCount = 1;
		String s;
		while((s = in.readLine()) != null) {
			out.println(lineCount++ + "  " + s);
		}
		out.close();
		// Content of the file
		System.out.println(BufferedInputFile.read(file));
	
	}

} /* Output
1  //: by.iba.ekkel.io/BasicFileOutput.java
2  package by.iba.ekkel.io;
3  
4  import java.io.*;
5  
6  public class BasicFileOutput {
7  	
8  	static String file = "BasicFileOutput.out";
9  	public static void main(String[] args) throws IOException {
10  	
11  		BufferedReader in = new BufferedReader(
12  				new StringReader(BufferedInputFile.read("src/main/java/by/iba/ekkel/io/BasicFileOutput.java")));
13  		PrintWriter out = new PrintWriter(
14  				new BufferedWriter(new FileWriter(file)));
15  		int lineCount = 1;
16  		String s;
17  		while((s = in.readLine()) != null) {
18  			out.println(lineCount++ + "  " + s);
19  		}
20  		out.close();
21  		// Content of the file
22  		System.out.println(BufferedInputFile.read(file));
23  	
24  	}
25  
26  } /* Output
27  ///:~
*///:~
