//: polymorphism/ReferenceCounting.java
// ����������� ��������� ������������ ���������� ��������
package by.iba.ekkel.polymorphism;

import static by.iba.ekkel.mindview.util.Print.*;

class Shared {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;
	
	public Shared() {
		print("������� " + this);
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
		print("������� " + this);
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
������� Shared 0
������� Composing 0
������� Composing 1
������� Composing 2
������� Composing 3
������� Composing 4
disposing Composing 0
disposing Composing 1
disposing Composing 2
disposing Composing 3
disposing Composing 4
Disposing Shared 0
*///:~

