//: by.iba.ekkel.exceptions/CleanUp.java
// ��������������� ������������ ��������
package by.iba.ekkel.exceptions;

public class CleanUp {
	
	public static void main(String[] args) {
	
		try {
			InputFile in = new InputFile("CleanUp java");
			try {
				String s;
				int i = 1;
				while((s = in.getLine()) != null){
					//���������� ���������
				}
			} catch(Exception e) {
				System.out.println("����������� Exception � main");
				e.printStackTrace(System.out);
			} finally {
				in.dispose();
			}
		} catch(Exception e) {
			System.out.println("���� ��� ��������������� InputFile");
		}
	
	}

} /* Output
���������� ������� CleanUp java
���� ��� ��������������� InputFile
*///:~
