//: by.iba.ekkel.exceptions/LoggingExceptions2.java
// Регистрация перехваченных исключений
package by.iba.ekkel.exceptions;

import java.util.logging.*;
import java.io.*;

public class LoggingExceptions2 {
	
	private static Logger logger = 
			Logger.getLogger("LoggingExceptions2");
	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	
	public static void main(String[] args) {
	
		try {
			throw new NullPointerException();
		} catch(NullPointerException e) {
			logException(e);
		}
	
	}

} /* Output
июл 25, 2017 2:22:52 PM by.iba.ekkel.exceptions.LoggingExceptions2 logException
SEVERE: java.lang.NullPointerException
	at by.iba.ekkel.exceptions.LoggingExceptions2.main(LoggingExceptions2.java:21)
*///:~
