//: by.iba.ekkel.typeinfo/ClassInitialization.java
package by.iba.ekkel.typeinfo;

import java.util.*;

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = 
			ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("������������� Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("������������� Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("������������� Initable3");
	}
}

public class ClassInitialization {
	
	public static Random rand = new Random(47);
	public static void main(String[] args) throws Exception {
	
		Class initable = Initable.class;
		System.out.println("����� �������� ������ Initable");
		// �� �������� � �������������
		System.out.println(Initable.staticFinal);
		// �������� � �������������
		System.out.println(Initable.staticFinal2);
		// �������� � �������������
		System.out.println(Initable2.staticNonFinal);
		Class initable3 = Class.forName("by.iba.ekkel.typeinfo.Initable3");
		System.out.println("����� �������� ������ Initable3");
		System.out.println(Initable3.staticNonFinal);
	
	}

} /* Output
����� �������� ������ Initable
47
������������� Initable
258
������������� Initable2
147
������������� Initable3
����� �������� ������ Initable3
74
*///:~
