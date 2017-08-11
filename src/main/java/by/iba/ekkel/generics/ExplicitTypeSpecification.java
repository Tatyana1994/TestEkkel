//: by.iba.ekkel.generics/ExplicitTypeSpecification.java
package by.iba.ekkel.generics;

import by.iba.ekkel.typeinfo.pets.*;
import java.util.*;
import by.iba.ekkel.mindview.util.*;

public class ExplicitTypeSpecification {
	
	static void f(Map<Person,List<Pet>> petPeople) {
		
	}
	
	public static void main(String[] args) {
	
		f(New.<Person,List<Pet>>map());
	
	}

}
