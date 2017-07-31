//: by.iba.ekkel.typeinfo.factory/Factory.java
package by.iba.ekkel.typeinfo.factory;

public interface Factory<T> {
	
	T create();

}

//Обобщенный параметр T позволяет create() возвращать разные типы для
//разных реализаций Factory.
