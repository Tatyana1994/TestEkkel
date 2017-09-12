//: by.iba.ekkel.generics/Erased.java
// {CompileTimeError} 
package by.iba.ekkel.generics;

public class Erased<T> {
	
	private final int SIZE = 100;
	public static void f(Object arg) {
		//if(arg instanceof T) {
		//	//Ошибка
		//}
		//T var = new T(); //Ошибка
		//T[] array = new T[SIZE]; //Ошибка
		//T[] array = (T)new Object[SIZE]; //Предупреждение
	}

}
