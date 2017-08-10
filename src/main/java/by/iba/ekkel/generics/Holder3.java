//: by.iba.ekkel.generics/Holder3.java
package by.iba.ekkel.generics;

public class Holder3<T> {
	
	private T a;
	public Holder3(T a) {
		this.a = a;
	}
	public T get() {
		return a;
	}
	public void set(T a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
	
		Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
		Automobile a = h3.get(); // Преобразование не потребуется
		//h3.set("He Automobile"); //Ошибка
		//h3.set(1); //Ошибка
	
	}

} /* Output
*///:~
