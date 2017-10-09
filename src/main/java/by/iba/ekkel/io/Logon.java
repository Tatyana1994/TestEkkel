//: by.iba.ekkel.io/Logon.java
// Key word 'transient'
package by.iba.ekkel.io;

import java.util.concurrent.*;
import java.io.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

public class Logon implements Serializable {
	private Date date = new Date();
	private String username;
	private transient String password;
	public Logon(String name, String pwd) {
		username = name;
		password = pwd;
	}
	public String toString() {
		return "info about the session \n user: " + username +
				"\n date: " + date +
				"\n password: " + password;
	}
	
	public static void main(String[] args) throws Exception {
	
		Logon a = new Logon("User", "Password");
		print("Session a = " + a);
		ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("Logon.out"));
		o.writeObject(a);
		o.close();
		TimeUnit.SECONDS.sleep(1); //
		// Recovering
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("Logon.out"));
		print("Object recovering: Time: " + new Date());
		a = (Logon)in.readObject();
		print("Session a = " + a);
	
	}
} /* Output
*///:~