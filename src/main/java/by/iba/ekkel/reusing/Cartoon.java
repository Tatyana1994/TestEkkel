//: reusing/Cartoon.java
// ������ ������������� ��� ���������� ������������
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Art {
	Art() {
		print("����������� Art");
	}
}

class Drawing extends Art {
	public Drawing() {
		print("����������� Drawing");
	}
}


public class Cartoon extends Drawing {
	
	public Cartoon() {
		print("����������� Cartoon");
	}
	
	public static void main(String[] args) {
		Cartoon x = new Cartoon();
	}

} /* Output
����������� Art
����������� Drawing
����������� Cartoon
*///:~
