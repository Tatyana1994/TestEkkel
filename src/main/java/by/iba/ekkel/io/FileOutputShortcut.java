//: by.iba.ekkel.io/FileOutputShortcut.java
package by.iba.ekkel.io;

import java.io.*;

public class FileOutputShortcut {
	
	static String file = "FileOutputShortcut.out";
	public static void main(String[] args) throws IOException {
	
		BufferedReader in = new BufferedReader(
				new StringReader(
						BufferedInputFile.read("src/main/java/by/iba/ekkel/io/FileOutputShortcut.java")));
		// Shortcut record
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while((s = in.readLine()) != null) {
			out.println(lineCount++ + ": " + s);
		}
		out.close();
		//Output of file content
		System.out.println(BufferedInputFile.read(file));
	}

} /* Output
1: //: by.iba.ekkel.io/FileOutputShortcut.java
2: package by.iba.ekkel.io;
3: 
4: import java.io.*;
5: 
6: public class FileOutputShortcut {
7: 	
8: 	static String file = "FileOutputShortcut.out";
9: 	public static void main(String[] args) throws IOException {
10: 	
11: 		BufferedReader in = new BufferedReader(
12: 				new StringReader(
13: 						BufferedInputFile.read("src/main/java/by/iba/ekkel/io/FileOutputShortcut.java")));
14: 		// Shortcut record
15: 		PrintWriter out = new PrintWriter(file);
16: 		int lineCount = 1;
17: 		String s;
18: 		while((s = in.readLine()) != null) {
19: 			out.println(lineCount++ + ": " + s);
20: 		}
21: 		out.close();
22: 		//Output of file content
23: 		System.out.println(BufferedInputFile.read(file));
24: 	}
25: 
26: } /* Output
27: ///:~
*///:~
