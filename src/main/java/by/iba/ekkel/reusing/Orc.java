//: reusing/Orc.java
// �������� ����� protected
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Villain {
	private String name;
	protected void set(String nm) {
		name = nm;
	}
	public Villain(String name) {
		this.name = name;
	}
	public String toString() {
		return "� ������ Villain � ��� ���: " + name;
	}
}

public class Orc extends Villain {
	
	private int orcNumber;
	
	public Orc(String name, int orcNumber) {
		super(name);
		this.orcNumber = orcNumber;
	}
	
	public void change(String name, int orcNumber) {
		set(name); //��������, ��� ��� ��������� protected
		this.orcNumber = orcNumber;
	}
	
	public String toString() {
		return "Orc " + orcNumber + ": " + super.toString();
	}
	
	public static void main(String[] args) {
		Orc orc = new Orc("���������", 12);
		print(orc);
		orc.change("���", 19);
		print(orc);
	}

} /* Output
Orc 12: � ������ Villain � ��� ���: ���������
Orc 19: � ������ Villain � ��� ���: ���
*///:~
