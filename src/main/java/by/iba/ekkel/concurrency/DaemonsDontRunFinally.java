//: by.iba.ekkel.concurrency/DaemonsDontRunFinally.java
// Daemon-thread don't execute the finally section
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import static by.iba.ekkel.mindview.util.Print.*;

class ADaemon implements Runnable {
	
	public void run() {
		try {
			print("Start ADaemon");
			TimeUnit.MILLISECONDS.sleep(1);
		} catch(InterruptedException e) {
			print("Exit through InterruptedException");
		} finally {
			print("Should it run always?");
		}
	}

}

public class DaemonsDontRunFinally {
	
	public static void main(String[] args) throws Exception {
	
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	
	}

} /* Output
Action...
Start ADaemon
*///:~
