//: by.iba.ekkel.generics/NonCovariantGenerics.java
//{CompileError} (Won't compile)
package by.iba.ekkel.generics;

import java.util.*;

public class NonCovariantGenerics {

	//ќшибка компил€ции: несовместимые типы
	//!List<Fruit> flist = new ArrayList<Apple>();
	
} /* Output
Type mismatch: cannot convert from ArrayList<Apple> to List<Fruit>
*///:~
