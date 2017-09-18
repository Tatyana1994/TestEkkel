//: by.iba.ekkel.generics/CompilerIntelligence.java
package by.iba.ekkel.generics;

import java.util.*;

public class CompilerIntelligence {

	public static void main(String[] args) {
	
		List<? extends Fruit> flist = 
				Arrays.asList(new Apple());
		Apple a = (Apple) flist.get(0); //��� ��������������
		flist.contains(new Apple()); //�������� 'Object'
		flist.indexOf(new Apple()); //�������� 'Object'
	
	}
	
} /* Output
*///:~
