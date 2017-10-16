//: by.iba.ekkel.concurrency/DaemonFromFactory.java
// Using ThreadFactory to create daemons
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import by.iba.ekkel.mindview.util.*;

import static by.iba.ekkel.mindview.util.Print.*;

public class DaemonFromFactory implements Runnable {
	
	public void run() {
		try {
			while(true) {
				TimeUnit.MILLISECONDS.sleep(100);
				print(Thread.currentThread() + " " + this);
			}
		} catch(InterruptedException e) {
			print("Interrupted");
		}
	}
	
	public static void main(String[] args) throws Exception {
	
		ExecutorService exec = Executors.newCachedThreadPool(
				new DaemonThreadFactory());
		for(int i = 0; i < 10; i++) {
			exec.execute(new DaemonFromFactory());
		}
		print("All the daemons are started");
		TimeUnit.MILLISECONDS.sleep(500); //Delay
	
	}

}
