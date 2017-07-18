//: by.iba.ekkel.innerclasses/Parcel10.java
// ������������ "������������� ����������" ���
// ��������������� ����������� ����������� ������
package by.iba.ekkel.innerclasses;

public class Parcel10 {
	
	public Destination 
		destination(final String dest, final float price) {
			return new Destination() {
				private int cost;
				//������������� ���������� ��� ������� �������
				{
					cost = Math.round(price);
					if(cost > 100) {
						System.out.println("���������� �������!");
					}
				}
				
				private String label = dest;
				
				public String readLabel() {
					return label;
				}

			};
	}
	public static void main(String[] args) {
	
		Parcel10 p = new Parcel10();
		Destination d = p.destination("��������", 101.395F);
		System.out.println(d.readLabel());
	}

}/* Output
���������� �������!
*///:~
