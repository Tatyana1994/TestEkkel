//: by.iba.ekkel.holding/ApplesAndOrangesWithoutGenerics.java
// Простой пример работы с контейнером
// (компилятор выдает предупреждения)
// {ThrowsException}
package by.iba.ekkel.holding;

import java.util.*;

class Apple {
	private static long counter;
	private final long id = counter++;
	public long id() {
		return id;
	}
}

class Orange {
	
}

public class ApplesAndOrangesWithoutGenerics {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	
		ArrayList apples = new ArrayList();
		for(int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		//Не препятствует добавлению объекта Orange
		apples.add(new Orange());
		for(int i = 0; i < apples.size(); i++) {
			((Apple)apples.get(i)).id();
			// Объект Orange обнаруживается только во время выполнения
		}
	
	}

} /* Output
Exception in thread "main" java.lang.ClassCastException: by.iba.ekkel.holding.Orange cannot be cast to by.iba.ekkel.holding.Apple
	at by.iba.ekkel.holding.ApplesAndOrangesWithoutGenerics.main(ApplesAndOrangesWithoutGenerics.java:33)
*///:~

