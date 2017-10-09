//: by.iba.ekkel.io/FreezeAlien.java
// Create the file with serialization data
package by.iba.ekkel.io;

import java.io.*;

public class FreezeAlien {
	
	public static void main(String[] args) throws Exception {
	
		ObjectOutput out = new ObjectOutputStream(
				new FileOutputStream("X.file"));
		Alien quellek = new Alien();
		out.writeObject(quellek);
		
	}

} /* Output
*///:~
