//: initialization/Mugs.java
// ������������� ������������� ������ ����������
// ������������� ���������� � java
package by.iba.ekkel.initialization;

class Mug {
	
	Mug(int marker) {
		System.out.println("Mug(" + marker + ")");
	}
	
	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
	
}

public class Mugs {
	
	Mug mug1;
	Mug mug2;
	{		
		mug1 = new Mug(1);
		mug2 = new Mug(2);
		System.out.println("mug1 & mug2 ����������������");		
	}
	
	Mugs() {
		System.out.println("Mugs()");
	}
	
	Mugs(int i) {
		System.out.println("Mugs(int i)");
	}
	
	public static void main(String[] args) {
		System.out.println("� ������ main()");
		new Mugs();
		System.out.println("new Mugs() ���������");
		new Mugs(1);
		System.out.println("new Mugs(1) ���������");
	}
	
}/* Output
� ������ main()
Mug(1)
Mug(2)
mug1 & mug2 ����������������
Mugs()
new Mugs() ���������
Mug(1)
Mug(2)
mug1 & mug2 ����������������
Mugs(int i)
new Mugs(1) ���������
*///:~
