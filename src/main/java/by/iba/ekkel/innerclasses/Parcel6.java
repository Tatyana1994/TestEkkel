//: by.iba.ekkel.innerclasses/Parcel6.java
// �������� ������ � ������� ��������
package by.iba.ekkel.innerclasses;

public class Parcel6 {
	
	private void internalTracking(boolean b) {
		if(b) {
			class TrackingSlip {
				private String id;
				public TrackingSlip(String s) {
					id = s;
				}
				String getSlip() {
					return id;
				}
			}
			TrackingSlip ts = new TrackingSlip("��������");
			String s = ts.getSlip();
		}
		// ����� ������������ ����� ������!
		// ��� ������� ���������
		//! TrackingSlip ts = new TrackingSlip("x");
	}
	public void track() {
		internalTracking(true);
	}
	public static void main(String[] args) {
	
		Parcel6 p = new Parcel6();
		p.track();
	
	}

} /* Output
*///:~
