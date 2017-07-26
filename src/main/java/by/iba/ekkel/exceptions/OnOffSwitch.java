//: by.iba.ekkel.exceptions/OnOffSwitch.java
// Для чего нужно finally?
package by.iba.ekkel.exceptions;

public class OnOffSwitch {
	
	private static Switch sw = new Switch();
	static void f() throws OnOffException1, OnOffException2 {
	}
	public static void main(String[] args) {
	
		try {
			sw.on();
			// Код, способный возбуждать исключения
			f();
			sw.off();
		} catch(OnOffException1 e){
			System.out.println("OnOffException1");
			sw.off();
		} catch (OnOffException2 e) {
			System.out.println("OnOffException2");
			sw.off();
		}
	
	}

} /* Output
on
off
*///:~
