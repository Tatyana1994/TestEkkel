//: by.iba.ekkel.exceptions/AlwaysFinally.java
// Finally выполн€етс€ всегда
package by.iba.ekkel.exceptions;

import static by.iba.ekkel.mindview.util.Print.*;

class FourException extends Exception {
	
}

public class AlwaysFinally {
	
	public static void main(String[] args) {
	
		print("¬ходим в первый блок try");
		try {
			print("¬ходим во второй блок try");
			try {
				throw new FourException();
			} finally {
				print("finally во втором блоке try");
			}
		} catch(FourException e) {
			System.out.println("ѕерехвачено FourException в первом блоке try");
		} finally {
			System.out.println("finally в первом блоке try");
		}
	
	}

} /* Output
¬ходим в первый блок try
¬ходим во второй блок try
finally во втором блоке try
ѕерехвачено FourException в первом блоке try
finally в первом блоке try
*///:~


