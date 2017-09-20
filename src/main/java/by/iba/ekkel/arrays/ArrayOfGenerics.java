//: by.iba.ekkel.arrays/ArrayOfGenerics.java
//Opportunity to create arrays with generics
package by.iba.ekkel.arrays;

import java.util.*;

public class ArrayOfGenerics {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	
		List<String>[] ls;
		List[] la = new List[10];
		ls = (List<String>[])la; //Warning about illegal convention
		ls[0] = new ArrayList<String>();
		//Error while compile state
		//Type mismatch: cannot convert from ArrayList<Integer> to List<String>
		//!ls[1] = new ArrayList<Integer>();
		
		//Problem: List<String> is subtype of Object
		Object[] objects = ls; //That's why assignment is legal
		// Compiles with no errors and warnings
		objects[1] = new ArrayList<Integer>();
		
		//But if your needs are primitive enough
		//you can create array of generics
		//but with warnings of "unchecked" conventions
		List<BerylliumSphere>[] spheres = 
				(List<BerylliumSphere>[])new List[10];
		for(int i = 0; i < spheres.length; i++) {
			spheres[i] = new ArrayList<BerylliumSphere>();
		}
	
	}
	
} /* Output
*///:~
