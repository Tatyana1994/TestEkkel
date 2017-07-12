//: access/IceCream.java
// ������������ ��������� ����� private
package by.iba.ekkel.access;

import static by.iba.ekkel.mindview.util.Print.*;

class Sundae {
	
	private Sundae() {
		
	}
	
	static Sundae makeASundae() {
		print("����������� Sundae()");
		return new Sundae();
	}
	
}

public class IceCream {
	
	public static void main(String[] args) {
		//! Sundae x = new Sundae();
		Sundae x = Sundae.makeASundae();
		
	}

}/* Output

*///:~
