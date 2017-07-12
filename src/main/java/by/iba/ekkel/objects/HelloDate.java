//: objects/HelloDate.java
package by.iba.ekkel.objects;

import java.io.IOException;
import java.util.*;

/** Первая программа-пример книги.
 * Выводит строку и текущее число
 * @author Svirydchuk_T
 * @author svi_tr@mail.ru
 * @version 1.0
 */

public class HelloDate {
	/** Точка входа в класс и приложение
	 * 
	 * @param args Массив строковых аргументов
	 * @throws IOException Перехватывает исключение ввода/вывода
	 */
		
	public static void main(String[] args) throws IOException {
		System.out.println("Привет. Сегодня");
		System.out.println(new Date());
	}

} /* Output. (55% match)
Привет. Сегодня
Tue Jun 20 17:36:53 AST 2017
*/// ~ 