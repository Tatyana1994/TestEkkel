//: by.iba.ekkel.generics/LimitsOfInference.java
package by.iba.ekkel.generics;

import java.util.*;
import by.iba.ekkel.typeinfo.pets.*;

public class LimitsOfInference {
	
	static void 
		f(Map<Person, List<? extends Pet>> petPeople) {
		
	}
	
	public static void main(String[] args) {
	
		//f(New.map()); //Не компилируется
	
	}

}
