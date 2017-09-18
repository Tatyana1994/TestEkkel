//: by.iba.ekkel.generics/CovariantArrays.java
package by.iba.ekkel.generics;

class Fruit {
	
}

class Apple extends Fruit {
	
}

class Jonathan extends Apple {
	
}

class Orange extends Fruit {
	
}

public class CovariantArrays {
	
	public static void main(String[] args) {
	
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple(); //OK
		fruit[1] = new Jonathan(); //OK
		//��� ������� ���������� - Apple[], � �� Fruit[] ��� Orange[]
		try {
			//���������� ��������� ��������� ������� Fruit
			fruit[0] = new Fruit(); //ArrayStoreExcepion
		} catch(Exception e) {
			System.out.println(e);
		}
		try {
			//���������� ��������� ��������� ������� Orange
			fruit[0] = new Orange();
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}/* Output
java.lang.ArrayStoreException: by.iba.ekkel.generics.Fruit
java.lang.ArrayStoreException: by.iba.ekkel.generics.Orange
*///:~
