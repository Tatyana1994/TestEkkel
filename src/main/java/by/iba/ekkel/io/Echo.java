//: by.iba.ekkel.io/Echo.java
//Read from standard input
// {RunByHand}
package by.iba.ekkel.io;

import java.io.*;

public class Echo {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));
		String s;
		while((s = stdin.readLine()) != null && s.length() != 0) {
			System.out.println(s);
		}
		// empty String or Ctrl+Z
	
	}

} /* Output
Echo
Echo
*///:~

