//: interfaces/classprocessor/Apply.java
package by.iba.ekkel.interfaces.classprocessor;

import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

class Processor {
	public String name() {
		return getClass().getSimpleName();
	}
	
	Object process(Object input) {
		return input;
	}
}

class Upcase extends Processor {
	String process(Object input) {
		//������������ ������������ ���
		return ((String)input).toUpperCase();
	}
}

class Downcase extends Processor {
	String process(Object input) {
		return ((String)input).toLowerCase();
	}
}

class Splitter extends Processor {
	String process(Object input) {
		//�������� split() ������������ ��� ��������� ������
		return Arrays.toString(((String)input).split(" "));
	}
}

public class Apply {
	
	public static void process(Processor p, Object s) {
		print("���������� Processor " + p.name());
		print(p.process(s));
	}
	
	public static String s = "Disagreement with beliefs id by definition incorrect";
	
	public static void main(String[] args) {
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
	}

} /* Output
���������� Processor Upcase
DISAGREEMENT WITH BELIEFS ID BY DEFINITION INCORRECT
���������� Processor Downcase
disagreement with beliefs id by definition incorrect
���������� Processor Splitter
[Disagreement, with, beliefs, id, by, definition, incorrect]
*///:~
