//: by.iba.ekkel.typeinfo/GenericCkassReferences.java
package by.iba.ekkel.typeinfo;

public class GenericCkassReferences {
	
	public static void main(String[] args) {
	
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		genericIntClass = Integer.class; //�� �� �����
		intClass = double.class;
		// genericIntClass = double.class; //�����������
	
	}

}
