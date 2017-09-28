//: by.iba.ekkel.io/Worm.java
// Test of object serialization
package by.iba.ekkel.io;

import java.io.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

class Data implements Serializable {
	private int n;
	public Data(int n) {
		this.n = n;
	}
	public String toString() {
		return Integer.toString(n);
	}
}

public class Worm implements Serializable {
	
	private static Random rand = new Random(47);
	private Data[] d = {
			new Data(rand.nextInt(10)),
			new Data(rand.nextInt(10)),
			new Data(rand.nextInt(10))
	};
	private Worm next;
	private char c;

	// Value i == the number of segments
	public Worm(int i, char x) {
		print("Worm Constructor: " + i);
		c = x;
		if(--i > 0) {
			next = new Worm(i, (char)(x + 1));
		}
	}
	
	public Worm() {
		print("Default Constructor");
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder(":");
		result.append(c);
		result.append("(");
		for(Data dat : d) {
			result.append(dat);
		}
		result.append(")");
		if(next != null) {
			result.append(next);
		}
		return result.toString();
	}
	
	public static void main(String[] args) 
			throws ClassNotFoundException, IOException {
		
				Worm w = new Worm(6, 'a');
				print("w = " + w);
				ObjectOutputStream out = 
						new ObjectOutputStream(
								new FileOutputStream("worm.out"));
				out.writeObject("Worm storage\n");
				out.writeObject(w);
				out.writeObject("Additional line");
				out.close(); //Also Buffer output flush
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream("worm.out"));
				String s = (String)in.readObject();
				Worm w2 = (Worm)in.readObject();
				print(s + "w2 = " + w2);
				ByteArrayOutputStream bout = 
						new ByteArrayOutputStream();
				ObjectOutputStream out2 = new ObjectOutputStream(bout);
				out2.writeObject("Memory of the Worm object\n");
				out2.writeObject(w);
				out2.flush();
				ObjectInputStream in2 = new ObjectInputStream(
						new ByteArrayInputStream(bout.toByteArray()));
				s = (String)in2.readObject();
				Worm w3 = (Worm)in2.readObject();
				print(s + "w3 = " + w3);
	}
	
} /* Output
Worm Constructor: 6
Worm Constructor: 5
Worm Constructor: 4
Worm Constructor: 3
Worm Constructor: 2
Worm Constructor: 1
w = :a(853):b(119):c(802):d(788):e(199):f(881)
Worm storage
w2 = :a(853):b(119):c(802):d(788):e(199):f(881)
Memory of the Worm object
w3 = :a(853):b(119):c(802):d(788):e(199):f(881)
*///:~
