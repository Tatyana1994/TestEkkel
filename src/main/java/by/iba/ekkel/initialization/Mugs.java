//: initialization/Mugs.java
// инициализация нестатических данных экземпляра
// Инициализация экземпляра в java
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
		System.out.println("mug1 & mug2 инициализированы");		
	}
	
	Mugs() {
		System.out.println("Mugs()");
	}
	
	Mugs(int i) {
		System.out.println("Mugs(int i)");
	}
	
	public static void main(String[] args) {
		System.out.println("В методе main()");
		new Mugs();
		System.out.println("new Mugs() завершено");
		new Mugs(1);
		System.out.println("new Mugs(1) завершено");
	}
	
}/* Output
В методе main()
Mug(1)
Mug(2)
mug1 & mug2 инициализированы
Mugs()
new Mugs() завершено
Mug(1)
Mug(2)
mug1 & mug2 инициализированы
Mugs(int i)
new Mugs(1) завершено
*///:~
