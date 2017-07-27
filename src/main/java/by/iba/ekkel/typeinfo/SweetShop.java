//: by.iba.ekkel.typeinfo/SweetShop.java
// �������� �������� �������� �������
package by.iba.ekkel.typeinfo;

import static by.iba.ekkel.mindview.util.Print.*;

class Candy {
	static {
		print("�������� ������ Candy");
	}
}

class Gum {
	static {
		print("�������� ������ Gum");
	}
}

class Cookie {
	static {
		print("�������� ������ Cookie");
	}
}


public class SweetShop {
	
	public static void main(String[] args) {
	
		print("� ������ main()");
		new Candy();
		print("����� �������� ������� Candy");
		try {
			Class.forName("by.iba.ekkel.typeinfo.Candy");
			print("������ ������");
		} catch(ClassNotFoundException e) {
			print("����� Gum �� ������");
		}
		print("����� ������ ������ Class.forName(\"Gum\")");
		new Cookie();
		print("����� �������� ������� Cookie");
	 
	}

} /* Output
� ������ main()
�������� ������ Candy
����� �������� ������� Candy
������ ������
����� ������ ������ Class.forName("Gum")
�������� ������ Cookie
����� �������� ������� Cookie
*///:~

