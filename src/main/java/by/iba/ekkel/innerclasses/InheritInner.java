//: by.iba.ekkel.innerclasses/InheritInner.java
// Наследование от внутреннего класса
package by.iba.ekkel.innerclasses;

class WithInner {
	class Inner {}
}

public class InheritInner extends WithInner.Inner {
	
	//! InheritInner() {} //не компилируется
	InheritInner(WithInner wi) {
		wi.super();
	}
	
	public static void main(String[] args) {
	
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
		
	}

}
