//: by.iba.ekkel.generics/TupleList.java
// Построение сложных параметризованных типов путем объединения
package by.iba.ekkel.generics;

import java.util.*;
import by.iba.ekkel.mindview.util.*;

public class TupleList<A,B,C,D> 
	extends ArrayList<FourTuple<A, B, C, D>>{
	
	public static void main(String[] args) {
	
		TupleList<Vehicle, Amphibian, String, Integer> tl = 
				new TupleList<Vehicle, Amphibian, String, Integer>();
		tl.add(TupleTest.h());
		tl.add(TupleTest.h());
		for(FourTuple<Vehicle, Amphibian, String, Integer> i : tl) {
			System.out.println(i);
		}
	
	}

} /* Output
(by.iba.ekkel.generics.Vehicle@15db9742, by.iba.ekkel.generics.Amphibian@6d06d69c, hi, 47)
(by.iba.ekkel.generics.Vehicle@7852e922, by.iba.ekkel.generics.Amphibian@4e25154f, hi, 47)
*///:~
