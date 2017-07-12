//: mindview/util/Print.java
// Методы печати, которые могут использоваться без спецификаторов, благодаря
// конструкции JAVA SE5 static import
package by.iba.ekkel.mindview.util;

import java.io.*;

public class Print {
	
	//Печать с переводом строки
	public static void print(Object obj) {
		System.out.println(obj);
	}
	
	//Перевод строки
	public static void print() {
		System.out.println();
	}
	
	//Печать без перевода строки
	public static void printb(Object obj) {
		System.out.print(obj);
	}
	
	 
	//Новая конструкция Java SE5 printf() (из языка С)
	public static PrintStream printf(String format, Object... args) {
		return System.out.printf(format, args);
	}
	
}
