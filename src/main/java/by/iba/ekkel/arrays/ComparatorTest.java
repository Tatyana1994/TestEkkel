//: by.iba.ekkel.arrays/ComparatorTest.java
// Comparator implementation
package by.iba.ekkel.arrays;

import java.util.*;
import by.iba.ekkel.mindview.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

class CompTypeComparator implements Comparator<CompType> {
	
	public int compare(CompType o1, CompType o2) {
		return(o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
	}
	
}

public class ComparatorTest {

	public static void main(String[] args) {
	
		CompType[] a = Generated.array(new CompType[12], CompType.generator());
		print("before sort");
		print(Arrays.toString(a));
		Arrays.sort(a, new CompTypeComparator());
		print("after sort: ");
		print(Arrays.toString(a));
	
	}
	
} /* Output
before sort
[[i = 58, j = 55], [i = 93, j = 61], [i = 61, j = 29]
, [i = 68, j = 0], [i = 22, j = 7], [i = 88, j = 28]
, [i = 51, j = 89], [i = 9, j = 78], [i = 98, j = 61]
, [i = 20, j = 58], [i = 16, j = 40], [i = 11, j = 22]
]
after sort: 
[[i = 68, j = 0], [i = 22, j = 7], [i = 11, j = 22]
, [i = 88, j = 28], [i = 61, j = 29], [i = 16, j = 40]
, [i = 58, j = 55], [i = 20, j = 58], [i = 93, j = 61]
, [i = 98, j = 61], [i = 9, j = 78], [i = 51, j = 89]
]
*///:~

