//: reusing/FinalArguments.java
//Использование final с аргументами метода
package by.iba.ekkel.reusing;

class Gizmo {
	public void spin() {
		
	}
}

public class FinalArguments {

	void with(final Gizmo g) {
		//! g = new Gizmo(); //запрещено g -- объявлено final
	}
	
	void without(Gizmo g) {
		g = new Gizmo(); //разрешено -- g не является final
		g.spin();
	}
	
	//void f(final int i) { i++; } //Нельзя изменить
	//неизменные примитивы доступны только для чтения
	int g(final int i) {
		return i + 1;
	}
	
	public static void main(String[] args) {
		FinalArguments bf = new FinalArguments();
		bf.without(null);
		bf.with(null);
	}
	
} /* Output
*///:~

