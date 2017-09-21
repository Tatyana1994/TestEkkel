//: by.iba.ekkel.arrays/ArraySearching.java
// Using Arrays.binarySearch()
package by.iba.ekkel.arrays;

import java.util.*;
import by.iba.ekkel.mindview.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

public class ArraySearching {
	
	public static void main(String[] args) {
	
		Generator<Integer> gen = 
				new RandomGenerator.Integer(1000);
		int[] a = ConvertTo.primitive(Generated.array(
				new Integer[25], gen));
		Arrays.sort(a);
		print("Sorted array: " + Arrays.toString(a));
		while(true) {
			int r = gen.next();
			int location = Arrays.binarySearch(a, r);
			if(location >= 0) {
				print("Value: " + r + " is on position " + 
						location + 
						", a[" + location + "] = " + a[location]);
				break;
			}
			
		}
	
	}

} /* Output
Sorted array: [128, 140, 200, 207, 258, 258, 278, 288, 322, 429, 511, 520, 522, 551, 555, 589, 693, 704, 809, 861, 861, 868, 916, 961, 998]
Value: 322 is on position 8, a[8] = 322
*///:~
