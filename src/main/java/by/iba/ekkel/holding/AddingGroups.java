//: by.iba.ekkel.holding/AddingGroups.java
// ���������� ����� ��������� � ������� Collection
package by.iba.ekkel.holding;

import java.util.*;

public class AddingGroups {
	
	public static void main(String[] args) {
	
		Collection<Integer> collection = 
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Integer[] moreInts = {6, 7, 8, 9, 10};
		collection.addAll(Arrays.asList(moreInts));
		//�������� ������� �������, �� ����� ��������
		//���������� ��������������� Collection
		Collections.addAll(collection, 11, 12, 13, 14, 15);
		Collections.addAll(collection, moreInts);
		for(Integer i : collection) {
			System.out.print(i + " ");
		}
		System.out.println("");
		//������� ������ �� ������ �������
		List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
		list.set(1, 99); // ����� - ��������� ��������
		//!list.add(21); // ������ ������� ���������� - �����������
						 // ������ �� ������ ���������� � ��������
		for(Integer i : list) {
			System.out.print(i + " ");
		}
	
	}

} /* Output
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 6 7 8 9 10 
16 99 18 19 20 
*///:~
