//: by.iba.ekkel.generics/TupleTest2.java
package by.iba.ekkel.generics;

import by.iba.ekkel.mindview.util.*;
import static by.iba.ekkel.mindview.util.Tuple.*;

public class TupleTest2 {
	
	static TwoTuple<String,Integer> f() {
		return tuple("hi", 47);
	}
	
	static TwoTuple<String,Integer> f2() {
		return tuple("hi", 47);
	}
	
	static ThreeTuple<Amphibian,String,Integer> g() {
		return tuple(new Amphibian(), "hi", 47);
	}
	
	static FourTuple<Vehicle,Amphibian,String,Integer> h() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47);
	}
	
	static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}
	
	public static void main(String[] args) {
	
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	
	}

} /* Output
(hi, 47)
(hi, 47)
(by.iba.ekkel.generics.Amphibian@15db9742, hi, 47)
(by.iba.ekkel.generics.Vehicle@6d06d69c, by.iba.ekkel.generics.Amphibian@7852e922, hi, 47)
(by.iba.ekkel.generics.Vehicle@4e25154f, by.iba.ekkel.generics.Amphibian@70dea4e, hi, 47, 11.1)
*///:~
