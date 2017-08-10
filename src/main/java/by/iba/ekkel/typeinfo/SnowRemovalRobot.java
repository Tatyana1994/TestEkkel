//: by.iba.ekkel.typeinfo/SnowRemovalRobot.java
package by.iba.ekkel.typeinfo;

import java.util.*;

public class SnowRemovalRobot implements Robot {
	
	private String name;
	public SnowRemovalRobot(String name) {
		this.name = name;
	}
	public String name() {
		return name;
	}
	public String model() {
		return "SnowBot Series 11";
	}
	public List<Operation> operations() { 
		return Arrays.asList(
				new Operation() {
					
					public String description() {
						return name + "  ����� ������� ����";
					}
					
					public void command() {
						System.out.println(name + " ������� ����");
						
					}
				},
				new Operation() {
					
					public String description() {
						return name + "  ����� ������� �����";
					}
					
					public void command() {
						System.out.println(name + " ������ �����");
						
					}
				});
	}
	
	public static void main(String[] args) {
	
		Robot.Test.test(new SnowRemovalRobot("Slusher"));
	
	}

} /* Output
��������: Slusher
������: SnowBot Series 11
Slusher  ����� ������� ����
Slusher ������� ����
Slusher  ����� ������� �����
Slusher ������ �����
*///:~

