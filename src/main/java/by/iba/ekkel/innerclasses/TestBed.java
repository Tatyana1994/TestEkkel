//: by.iba.ekkel.innerclasses/TestBed.java
// ѕомещение тестового кода во вложенный класс
// {main: TestBed$Tester}
package by.iba.ekkel.innerclasses;

public class TestBed {
	
	public void f() {
		System.out.println("f()");
	}
	
	public static class Tester {
		public static void main(String[] args) {
			TestBed t = new TestBed();
			t.f();
		}
	}
}/* Output
f()
*///:~
