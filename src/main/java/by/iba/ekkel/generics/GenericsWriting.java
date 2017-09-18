//: by.iba.ekkel.generics/GenericsWriting.java
package by.iba.ekkel.generics;

import java.util.*;

public class GenericsWriting {
	
	static <T> void writeExact(List<T> list, T item) {
		list.add(item);
	}
	static List<Apple> apples = new ArrayList<Apple>();
	static List<Fruit> fruit = new ArrayList<Fruit>();
	static void f1() {
		writeExact(apples, new Apple());
		writeExact(fruit, new Apple()); //������
		//������������� ����: ��������� Fruit, ��������� Apple
	}
	static <T> void 
		writeWithWildcard(List<? super T> list, T item) {
		list.add(item);
	}
	static void f2() {
		writeWithWildcard(apples, new Apple());
		writeWithWildcard(fruit, new Apple()); 
	}
	
	public static void main(String[] args) {
		
		f1();
		f2();
		
	}

}
