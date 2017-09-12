//: by.iba.ekkel.generics/ListOfGenerics.java
package by.iba.ekkel.generics;

import java.util.*;

public class ListOfGenerics<T> {
	
	private List<T> array = new ArrayList<T>();
	public void add(T item) {
		array.add(item);
	}
	public T get(int index) {
		return array.get(index);
	}

}
