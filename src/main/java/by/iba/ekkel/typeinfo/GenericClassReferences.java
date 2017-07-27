//: by.iba.ekkel.typeinfo/GenericCkassReferences.java
package by.iba.ekkel.typeinfo;

public class GenericClassReferences {
	
	public static void main(String[] args) {
	
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		genericIntClass = Integer.class; //То же самое
		intClass = double.class;
		// genericIntClass = double.class; //Недопустимо
	
	}

}
