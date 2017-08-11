//: by.iba.ekkel.generics/LostInformation.java
package by.iba.ekkel.generics;

import java.util.*;

class Frob {
	
}

class Fnorkle {
	
}

class Quark<Q> {
	
}

class Participle<POSTITION, MOMENTUM> {
	
}

public class LostInformation {
	
	public static void main(String[] args) {
	
		List<Frob> list = new ArrayList<Frob>();
		Map<Frob, Fnorkle> map = new HashMap<Frob, Fnorkle>();
		Quark<Fnorkle> quark = new Quark<Fnorkle>();
		Participle<Long, Double> p = new Participle<Long, Double>();
		System.out.println(Arrays.toString(
				list.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(
				map.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(
				quark.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(
				p.getClass().getTypeParameters()));
 	
	}

} /* Output
[E]
[K, V]
[Q]
[POSTITION, MOMENTUM]
*///:~

