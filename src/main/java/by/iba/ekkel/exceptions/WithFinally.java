//: by.iba.ekkel.exceptions/WithFinally.java
// Finally гарантирует выполнение завершающего кода
package by.iba.ekkel.exceptions;

public class WithFinally {
	
	static Switch sw = new Switch();
	public static void main(String[] args) {
	
		try {
			sw.on();
			//  од, способный возбуждать исключени€
			OnOffSwitch.f();
		} catch(OnOffException1 e) {
			System.out.println("OnOffException1");
		} catch (OnOffException2 e) {
			System.out.println("OnOffException2");
		} finally {
			sw.off();
		}
	
	}

} /* Output
on
off
*///:~
