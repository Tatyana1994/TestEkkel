//: polymorphism/ReferenceCounting.java
// Уничтожение совместно используемых встроенных объектов
package by.iba.ekkel.polymorphism;

import static by.iba.ekkel.mindview.util.Print.*;

class Shared {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;
	
	public Shared() {
		print("Создаем " + this);
	}
	
	public void addRef() {
		refcount++;
	}
	
	protected void dispose() {
		if(--refcount == 0) { 
			print("Disposing " + this);
		}
	}
	public String toString() {
		return "Shared " + id;
	}
}

class Composing {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++;
	public Composing(Shared shared) {
		print("Создаем " + this);
		this.shared = shared;
		this.shared.addRef();
	}
	protected void dispose() {
		print("disposing " + this);
		shared.dispose();
	}
	public String toString() {
		return "Composing " + id;
	}
}

public class ReferenceCounting {

	public static void main(String[] args) {
		Shared shared = new Shared();
		Composing[] composing = { new Composing(shared),
				new Composing(shared), new Composing(shared),
				new Composing(shared), new Composing(shared)
		};
		for(Composing c : composing) {
			c.dispose();
		}
	}
	
} /* Output
Создаем Shared 0
Создаем Composing 0
Создаем Composing 1
Создаем Composing 2
Создаем Composing 3
Создаем Composing 4
disposing Composing 0
disposing Composing 1
disposing Composing 2
disposing Composing 3
disposing Composing 4
Disposing Shared 0
*///:~

