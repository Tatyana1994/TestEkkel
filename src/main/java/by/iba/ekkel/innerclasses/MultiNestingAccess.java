//: by.iba.ekkel.innerclasses/MultiNestingAccess.java
// Вложенные классы могут обращаться ко всем членам всех
// классов, в которых они находятся
package by.iba.ekkel.innerclasses;

class MNA {
	private void f() {}
	class A {
		private void g() {}
		public class B{
			void h() {
				g();
				f();
			}
		}
	}
}

public class MultiNestingAccess {
	
	public static void main(String[] args) {
	
		MNA mna = new MNA();
		MNA.A mnaa = mna.new A();
		MNA.A.B mnaab = mnaa.new B();
		
	}

} /* Output
*///:~
