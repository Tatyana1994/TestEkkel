//: operators/PassObject.java
//Передача объектов методам может работать
//не так, как вы привыкли
package by.iba.ekkel.operators;

class Letter {
	char c;
}

public class PassObject {
	
	static void f(Letter y) {
		y.c = 'z';
	}
	
	public static void main(String[] args) {
		
		Letter x = new Letter();
		
		x.c = 'a';
		
		System.out.println("1: x.c: " + x.c);
		
		f(x);
	
		System.out.println("2: x.c: " + x.c);
		
	}

} /* Output
1: x.c: a
2: x.c: z
*///:~
