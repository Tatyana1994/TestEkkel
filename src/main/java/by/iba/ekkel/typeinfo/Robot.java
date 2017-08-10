//: by.iba.ekkel.typeinfo/Robot.java
package by.iba.ekkel.typeinfo;

import java.util.*;
import by.iba.ekkel.mindview.util.*;

public interface Robot {
	String name();
	String model();
	List<Operation> operations();
	class Test {
		public static void test(Robot r) {
			if(r instanceof Null) {
				System.out.println("[Null Robot]");
			}
			System.out.println("Название: " + r.name());
			System.out.println("Модель: " + r.model());
			for(Operation operation : r.operations()) {
				System.out.println(operation.description());
				operation.command();
			}
		}
	}

}
