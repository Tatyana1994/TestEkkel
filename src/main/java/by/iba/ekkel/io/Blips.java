//: by.iba.ekkel.io/Blips.java
// Simple implementation of Externalizable interface .. with problems
package by.iba.ekkel.io;

import java.io.*;
import static by.iba.ekkel.mindview.util.Print.*;

class Blip1 implements Externalizable {
	
	public Blip1() {
		print("Blip1 Constructor");
	}
	
	public void writeExternal(ObjectOutput out) 
		throws IOException {
		
		print("Blip1.writeExternal");
		
	}
	
	public void readExternal(ObjectInput out) 
			throws IOException, ClassNotFoundException {
			
			print("Blip1.readExternal");
			
	}


}

class Blip2 implements Externalizable {
	
	Blip2() {
		print("Blip2 Constructor");
	}
	
	public void writeExternal(ObjectOutput out) 
		throws IOException {
		
		print("Blip2.writeExternal");
		
	}
	
	public void readExternal(ObjectInput out) 
			throws IOException, ClassNotFoundException {
			
			print("Blip2.readExternal");
			
	}


}

public class Blips {
	
	public static void main(String[] args) 
		throws IOException, ClassNotFoundException {
	
		print("Object creating");
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("Blips.out"));
		print("Object saving");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		
		//Recover saved objects
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("Blips.out"));
		print("b1 recovering:");
		b1 = (Blip1)in.readObject();
		//!Exception:  java.io.InvalidClassException due to Blip2 constructor
		// is not public
		//!print("b2 recovering:");
		//!b2 = (Blip2)in.readObject();
	
	}
	
} /* Output
Object creating
Blip1 Constructor
Blip2 Constructor
Object saving
Blip1.writeExternal
Blip2.writeExternal
b1 recovering:
Blip1 Constructor
Blip1.readExternal
b2 recovering:
Exception in thread "main" java.io.InvalidClassException: by.iba.ekkel.io.Blip2; no valid constructor
	at java.io.ObjectStreamClass$ExceptionInfo.newInvalidClassException(Unknown Source)
	at java.io.ObjectStreamClass.checkDeserialize(Unknown Source)
	at java.io.ObjectInputStream.readOrdinaryObject(Unknown Source)
	at java.io.ObjectInputStream.readObject0(Unknown Source)
	at java.io.ObjectInputStream.readObject(Unknown Source)
	at by.iba.ekkel.io.Blips.main(Blips.java:76)
*///:~

