//: by.iba.ekkel.exceptions/Switch.java
package by.iba.ekkel.exceptions;

import static by.iba.ekkel.mindview.util.Print.*;

public class Switch {
	
	private boolean state = false;
	public boolean read() {
		return state;
	}
	public void on() {
		state = true;
		print(this);
	}
	public void off() {
		state = false;
		print(this);
	}
	public String toString() {
		return state ? "on" : "off";
	}


}/* Output
*///:~
