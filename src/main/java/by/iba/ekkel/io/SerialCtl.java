//: by.iba.ekkel.io/SerialCtl.java
// Manage the serialization process by
// defining individual methods writeObject() and readObject()
package by.iba.ekkel.io;

import java.io.*;

public class SerialCtl  implements Serializable {
	
	private String a;
	private transient String b;
	public SerialCtl(String aa, String bb) {
		a = "Is not declared as transient: " + aa;
		b = "Is declared as transient: " + bb;
	}
	public String toString() {
		return a + "\n" + b;
	}
	private void writeObject(ObjectOutputStream stream) 
		throws IOException {
			stream.defaultWriteObject();
			stream.writeObject(b);
	}
	private void readObject(ObjectInputStream stream) 
			throws IOException, ClassNotFoundException {
				stream.defaultReadObject();
				b = (String)stream.readObject();
	}
	
	public static void main(String[] args) 
		throws IOException, ClassNotFoundException {
		
		SerialCtl sc = new SerialCtl("Test1", "Test2");
		System.out.println("Before record: \n" + sc);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(buf);
		o.writeObject(sc);
		//Now get it back
		ObjectInputStream in = new ObjectInputStream(
				new ByteArrayInputStream(buf.toByteArray()));
		SerialCtl sc2 = (SerialCtl)in.readObject();
		System.out.println("After recovering:\n" + sc2);
		
	}
	
} /* Output
Before record: 
Is not declared as transient: Test1
Is declared as transient: Test2
After recovering:
Is not declared as transient: Test1
Is declared as transient: Test2
*///:~
