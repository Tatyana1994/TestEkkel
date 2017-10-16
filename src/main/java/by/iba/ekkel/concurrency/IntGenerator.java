//: by.iba.ekkel.concurrency/IntGenerator.java
package by.iba.ekkel.concurrency;

public abstract class IntGenerator {
	
	private volatile boolean canceled = false;
	public abstract int next();
	//To cancel
	public void cancel() {
		canceled = true;
	}
	public boolean isCanceled() {
		return canceled;
	}

}
