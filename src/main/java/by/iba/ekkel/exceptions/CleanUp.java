//: by.iba.ekkel.exceptions/CleanUp.java
// Гарантированное освобождение ресурсов
package by.iba.ekkel.exceptions;

public class CleanUp {
	
	public static void main(String[] args) {
	
		try {
			InputFile in = new InputFile("CleanUp java");
			try {
				String s;
				int i = 1;
				while((s = in.getLine()) != null){
					//Построчная обработка
				}
			} catch(Exception e) {
				System.out.println("Перехвачено Exception в main");
				e.printStackTrace(System.out);
			} finally {
				in.dispose();
			}
		} catch(Exception e) {
			System.out.println("Сбой при конструировании InputFile");
		}
	
	}

} /* Output
Невозможно открыть CleanUp java
Сбой при конструировании InputFile
*///:~
