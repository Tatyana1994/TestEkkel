//: by.iba.ekkel.exceptions/StormyInning.java
// Переопределенные методы могут возбуждать только
// исключения, описанные в версии базового класса
// или исключения, унаследованные от исключений
// базового класса
package by.iba.ekkel.exceptions;

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike  extends BaseballException {}

abstract class Inning {
	
	public Inning() throws BaseballException {
		
	}
	public void event() throws BaseballException {
		//Реальное исключение не возбуждается
	}
	public abstract void atBat() throws Strike, Foul;
	public void walk() {
		
	}// Не возбуждает контролируемых исключений
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
	public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
	
	//Можно добавлять новые исключения для конструкторов
	//но нужно учитывать и исключения базового конструктора
	public StormyInning() 
		throws RainedOut, BaseballException {
		
	}
	public StormyInning(String s) 
		throws Foul, BaseballException {
		
	}
	//Обычные методы должны соответствовать базовым
	//! void walk() throws PopFoul {} //Ошибка компиляции
	//Интерфейс НЕ может добавлять исключения
	//существующим методам базового класса
	//! public void event() throws RainedOut {}
	//Если метод не был определен в базовом
	//классе, исключение допускается
	public void rainHard() throws RainedOut {}
	//Метод может не возбуждать исключений вообще
	//даже если базовая версия это делает
	public void event() {}
	//Переопределенные методы могут возбуждать 
	//унаследованные исключения
	public void atBat() throws PopFoul {}
	
	public static void main(String[] args) {
	
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch(PopFoul e) {
			System.out.println("Pop foul");
		} catch(RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Обобщенное исключение");
		} 
		//Strike не возбуждается в производной версии
		try {
			//Что произойдет при восходящем преобразовании?
			Inning i = new StormyInning();
			i.atBat();
			//Необходимо перехыватывать исключения
			//из базовой версии метода
		} catch(Strike e) {
			System.out.println("Strike");
		} catch (Foul e) {
			System.out.println("Foul");
		} catch(RainedOut e) {
			System.out.println("Rained Out");
		} catch(BaseballException e) {
			System.out.println("Обобщенное исключение");
		}
	
	}

} /* Output
*///:~
