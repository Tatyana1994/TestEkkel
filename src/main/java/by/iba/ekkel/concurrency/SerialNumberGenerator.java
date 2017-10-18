//: by.iba.ekkel.concurrency/SerialNumberGenerator.java
package by.iba.ekkel.concurrency;

public class SerialNumberGenerator {
	
	private static volatile int serialNumber = 0;
	public static synchronized int nextSerialNumber() {
		return serialNumber++; //Operation is not thread-safe
	}

}
