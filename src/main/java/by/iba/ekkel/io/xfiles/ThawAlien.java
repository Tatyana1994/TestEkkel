//: by.iba.ekkel.io.xfiles/ThawAlien.java
// Try to recover the serialized file
// without saving the class of the object in the file
package by.iba.ekkel.io.xfiles;

import java.io.*;

public class ThawAlien {
	
	public static void main(String[] args) throws Exception {
	
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(new File(".", "X.file")));
		Object mystery = in.readObject();
		System.out.println(mystery.getClass());
	
	}

} /* Output
class by.iba.ekkel.io.Alien
*///:~
