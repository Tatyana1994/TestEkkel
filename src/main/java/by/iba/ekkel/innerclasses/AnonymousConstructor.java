//: by.iba.ekkel.innerclasses/AnonymousConstructor.java
// �������� ������������ ��� ����������� ����������� ������
package by.iba.ekkel.innerclasses;

import static by.iba.ekkel.mindview.util.Print.*;

abstract class Base {
	public Base(int i) {
		print("����������� Base, i = " + i);
	}
	public abstract void f();
}

	public class AnonymousConstructor {
		
		public static Base getBase(int i) {
			return new Base(i) {
				{
					print("������������� ����������");
				}
				public void f() {
					print("���������� f()");
				}
			};
		}
	
	public static void main(String[] args) {
	
		Base base = getBase(47);
		base.f();
	
	}

} /* Output
����������� Base, i = 47
������������� ����������
���������� f()
*///:~
