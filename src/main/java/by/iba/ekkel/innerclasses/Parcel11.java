//: by.iba.ekkel.innerclasses/Parcel11.java
// Вложенные (статические внутренние) классы
package by.iba.ekkel.innerclasses;

public class Parcel11 {
	
	public static class PContents implements Contents {
		private int i = 11;
		public int value() {
			return i;
		}
		
		protected static class PDestination 
			implements Destination {
				private String label;
				private PDestination(String whereTo) {
					label = whereTo;
				}
				public String readLabel() {
					return label;
				}
				// Вложенные классы могут содержать другие статические
				// элементы
				public static void f() {
					
				}
				
				static int x = 10;
				static class AnotherLevel {
					public static void f() {
						
					}
					static int x = 10;
			}
		}
		
		public static Destination destination(String s) {
			return new PDestination(s);
		}
		
		public static Contents cont() {
			return new PContents();
		}
		
		public static void main(String[] args) {
		
			Contents c = cont();
			Destination d = destination("Тасмания");
			
		}
		
	}

} /* Output
*///:~
