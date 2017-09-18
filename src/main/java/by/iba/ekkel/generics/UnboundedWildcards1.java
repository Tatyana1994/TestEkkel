//: by.iba.ekkel.generics/UnboundedWildcards1.java
package by.iba.ekkel.generics;

import java.util.*;

public class UnboundedWildcards1 {
	
	static List list1;
	static List<?> list2;
	static List<? extends Object> list3;
	static void assign1(List list) {
		list1 = list;
		list2 = list;
		list3 = list; //предупреждение: непроверенное преобразование
		//Обнаружен List, требуется List<? extends Object>
		
	}
	static void assign2(List<?> list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}
	static void assign3(List<? extends Object> list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}
	
	public static void main(String[] args) {
	
		assign1(new ArrayList<>());
		assign2(new ArrayList<>());
		assign3(new ArrayList<>()); //Предупреждение
		//непроверенное преобразование. Обнаружен ArrayList
		//Требуется: List<? extends Object>
		assign1(new ArrayList<String>());
		assign2(new ArrayList<String>());
		assign3(new ArrayList<String>());
		//Преимлемы обе формы
		List<?> wildlist = new ArrayList();
		wildlist = new ArrayList<String>();
		assign1(wildlist);
		assign2(wildlist);
		assign3(wildlist);
	}

} /* Output
*///:~
