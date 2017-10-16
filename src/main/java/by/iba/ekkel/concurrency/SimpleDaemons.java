//: by.iba.ekkel.concurrency/SimpleDaemons.java
// Daemons don't interrupt programm completing
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import static by.iba.ekkel.mindview.util.Print.*;

public class SimpleDaemons implements Runnable {
	
	public void run() {
		try {
			while(true) {
				TimeUnit.MILLISECONDS.sleep(100);
				print(Thread.currentThread() + " " + this);
			}
		} catch(InterruptedException e) {
			print("sleep() interrupted!");
		}
	}
	
	public static void main(String[] args) throws Exception {
	
		for(int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true); //Should be called before start()
			daemon.start();
		}
		print("All daemons are started");
		TimeUnit.MILLISECONDS.sleep(175);
	
	}
	
} /* Output
All daemons are started
Thread[Thread-3,5,main] by.iba.ekkel.concurrency.SimpleDaemons@53bc4411
Thread[Thread-0,5,main] by.iba.ekkel.concurrency.SimpleDaemons@64b20945
Thread[Thread-4,5,main] by.iba.ekkel.concurrency.SimpleDaemons@147ff76c
Thread[Thread-1,5,main] by.iba.ekkel.concurrency.SimpleDaemons@163b0ba8
Thread[Thread-8,5,main] by.iba.ekkel.concurrency.SimpleDaemons@5ad93fda
Thread[Thread-9,5,main] by.iba.ekkel.concurrency.SimpleDaemons@27c4b4bd
Thread[Thread-5,5,main] by.iba.ekkel.concurrency.SimpleDaemons@3ccec577
Thread[Thread-6,5,main] by.iba.ekkel.concurrency.SimpleDaemons@12a128ac
Thread[Thread-2,5,main] by.iba.ekkel.concurrency.SimpleDaemons@1bedb3dd
Thread[Thread-7,5,main] by.iba.ekkel.concurrency.SimpleDaemons@40ff1043
*///:~

