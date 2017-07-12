//: initialization/Spoon.java
package by.iba.ekkel.initialization;

public class Spoon {
	
	static int i;
	//статический блок инициализации 
	//выполняется только один раз:
	// при первом создании объекта этого класса
	// или при первом обращении к статическим членам этого класса
	static {
		i = 47;
	}	
}
