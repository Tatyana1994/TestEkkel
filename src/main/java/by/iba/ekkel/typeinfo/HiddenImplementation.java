//: by.iba.ekkel.typeinfo/HiddenImplementation.java
// Пакетный доступ тоже можно обойти
package by.iba.ekkel.typeinfo;

import by.iba.ekkel.typeinfo.interfacea.*;
import by.iba.ekkel.typeinfo.packageaccess.*;
import java.lang.reflect.*;

public class HiddenImplementation {
	
	public static void main(String[] args) throws Exception {
	
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Ошибка компиляции. символическое имя 'C' не найдено
		/*
		 if(a instanceof C) {
		 	C c = (C)a;
		 	C.g();
		 }*/
		// Однако рефлексия позволяет вызвать g()
		callHiddenImplementation(a, "g");
		// ... И даже еще менее доступные методы!
		callHiddenImplementation(a, "u");
		callHiddenImplementation(a, "v");
		callHiddenImplementation(a, "w");
	}
	
	static void callHiddenImplementation(Object a, String methodName)	
		throws Exception {
			Method g = a.getClass().getDeclaredMethod(methodName);
			g.setAccessible(true);
			g.invoke(a);
	}

} /* Output
public C.f()
by.iba.ekkel.typeinfo.packageaccess.C
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
