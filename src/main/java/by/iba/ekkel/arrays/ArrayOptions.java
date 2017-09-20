//: by.iba.ekkel.arrays/ArrayOptions.java
// Initialization and reusable assignment of arrays
package by.iba.ekkel.arrays;

import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

public class ArrayOptions {
	
	public static void main(String[] args) {
	
		// Arrays of objects
		BerylliumSphere[] a; //Local assignment of the variable
		BerylliumSphere[] b = new BerylliumSphere[5];
		
		//References in arrays are initialized by null values
		print("b " + Arrays.toString(b));
		BerylliumSphere[] c = new BerylliumSphere[4];
		for (int i = 0; i < c.length; i++) {
			if(c[i] == null) { //Check reference for existance
				c[i] = new BerylliumSphere();
			}
		}
		//Aggregate initialization
		BerylliumSphere[] d = { new BerylliumSphere(),
				new BerylliumSphere(), new BerylliumSphere()
			};
		//Dynamic aggregate initialization
		a = new BerylliumSphere[] {
				new BerylliumSphere(), new BerylliumSphere()
			};
		print("a.length = " + a.length);
		print("b.length = " + b.length);
		print("c.length = " + c.length);
		print("d.length = " + d.length);
		a = d;
		print("a.length = " + a.length);
		
		//Array of primitives
		int[] e; //Reference is null
		int[] f = new int[5];
		// Primitives in array should be automatically initialized by null
		print("f: " +  Arrays.toString(f));
		int[] g = new int[4];
		for(int i = 0; i < g.length; i++) {
			g[i] = i * i;
		}
		int[] h = { 11, 47, 93 };
		//{Compile error} The local variable e may not have been initialized
		//!print("e.length = " + e.length);
		print("f.length = " + f.length);
		print("g.length = " + g.length);
		print("h.length = " + h.length);
		e = h;
		print("e.length = " + e.length);
		e = new int[] {1, 2};
		print("e.length = " + e.length);
	}

} /* Output
b [null, null, null, null, null]
a.length = 2
b.length = 5
c.length = 4
d.length = 3
a.length = 3
f: [0, 0, 0, 0, 0]
f.length = 5
g.length = 4
h.length = 3
e.length = 3
e.length = 2
*///:~
