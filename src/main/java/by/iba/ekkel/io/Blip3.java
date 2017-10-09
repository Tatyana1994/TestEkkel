//: by.iba.ekkel.io/Blip3.java
// Externalizable Object recovering
package by.iba.ekkel.io;

import java.io.*;

import jdk.nashorn.internal.ir.LiteralNode.PrimitiveLiteralNode;

import static by.iba.ekkel.mindview.util.Print.*;

public class Blip3 implements Externalizable {
	
	private int i;
	private String s; //without initializing
	
	public Blip3() {
		print("Blip3 Constructor");
		//s,i doesn't initializing
	}
	
	public Blip3(String x, int a) {
		print("Blip3(String x, int a)");
		s = x;
		i = a;
		// s and i are initializing 
		// outside the default constructor
	}
	
	public void writeExternal(ObjectOutput out) 
			throws IOException {
			print("Blip3.writeExternal");
			// You should act in this way
			out.writeObject(s);
			out.writeInt(i);
	}
	
	public void readExternal(ObjectInput in) 
			throws IOException, ClassNotFoundException {
			print("Blip3.readExternal");
			// You should act in this way
			s = (String)in.readObject();
			i = in.readInt();
	}
	
	public String toString() {
		
		return "Blip3: [string]: " + s + "; [int]: " + i;
		
	}
	
	public static void main(String[] args) 
		throws IOException, ClassNotFoundException {
	
		print("Object creating:");
		Blip3 b3 = new Blip3("String ", 47);
		print(b3);
		ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("Blip3.out"));
		print("Object saving...");
		o.writeObject(b3);
		o.close();
		
		//Now get it back:
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("Blip3.out"));
		print("b3 recovering: ");
		b3 = (Blip3)in.readObject();
		print(b3);
		
	}

} /* Output
Object creating:
Blip3(String x, int a)
Blip3: [string]: String ; [int]: 47
Object saving...
Blip3.writeExternal
b3 recovering: 
Blip3 Constructor
Blip3.readExternal
Blip3: [string]: String ; [int]: 47

*///:~
