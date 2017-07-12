//: reusing/BlankFinal.java
//"Пустые" неизменные поля
package by.iba.ekkel.reusing;

class Poppet {
	private int i;
	Poppet(int ii) {
		i = ii;
	}
}

public class BlankFinal {
	
	private final int i = 0; //Инициализированная константа
	private final int j; // Пустая константа
	private final Poppet p; // Пустая константа-ссылка
	
	//Пустые константы НЕОБХОДИМО инициализировать
	//в конструкторе
	public BlankFinal() {
		j = 1; // Инициализация пустой константы
		p = new Poppet(1); // Инициализация пустой неизменной ссылки
	}
	
	public BlankFinal(int x) {
		j = x; // Инициализация пустой константы
		p = new Poppet(x); // Инициализация пустой неизменной ссылки
	}
	
	public static void main(String[] args) {
		new BlankFinal();
		new BlankFinal(47);
	}

} /* Output
*///:~

