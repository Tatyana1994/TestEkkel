//: by.iba.ekkel.generics/Holder2.java
package by.iba.ekkel.generics;

public class Holder2 {
	
	private Object a;
	public Holder2(Object a) {
		this.a = a;
	}
	public void set(Object a) {
		this.a = a;		
	}
	public Object get() {
		return a;
	}
	
	public static void main(String[] args) {
	
		Holder2 h2 = new Holder2(new Automobile());
		Automobile a = new Automobile();
		h2.set("He Automobile");
		String s = (String)h2.get();
		h2.set(1); //������������� ������������� � Integer
		Integer x = (Integer)h2.get();
	
	}

} /* Output
*///:~
