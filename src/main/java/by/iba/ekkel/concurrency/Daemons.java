//: by.iba.ekkel.concurrency/Daemons.java
// Threads that are generated by daemons are daemons too
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import static by.iba.ekkel.mindview.util.Print.*;

class Daemon implements Runnable {
	
	private Thread[] t = new Thread[10];
	public void run() {
		for(int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			printb("DaemonSpawn " + i + " started. \n");
		}
		for(int i = 0; i < t.length; i++) {
			printb("t[" + i + "].isDaemon() = " + 
						t[i].isDaemon() + ". \n");
		}
		while(true) {
			Thread.yield();
		}
	}
}

class DaemonSpawn implements Runnable {
	
	public void run() {
		while(true) {
			Thread.yield();
		}
	}
	
}

public class Daemons {
	
	public static void main(String[] args) throws Exception {
	
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		printb("d.isDaemon() = " + d.isDaemon() + ". \n");
		//Get the daemons threads to complete the start process
		TimeUnit.MILLISECONDS.sleep(1);
		
	}

}/* Output
d.isDaemon() = true. 
DaemonSpawn 0 started. 
DaemonSpawn 1 started. 
DaemonSpawn 2 started. 
DaemonSpawn 3 started. 
DaemonSpawn 4 started. 
DaemonSpawn 5 started. 
DaemonSpawn 6 started. 
DaemonSpawn 7 started. 
DaemonSpawn 8 started. 
DaemonSpawn 9 started. 
t[0].isDaemon() = true. 
t[1].isDaemon() = true. 
t[2].isDaemon() = true. 
t[3].isDaemon() = true. 
t[4].isDaemon() = true. 
t[5].isDaemon() = true. 
t[6].isDaemon() = true. 
t[7].isDaemon() = true. 
t[8].isDaemon() = true. 
t[9].isDaemon() = true. 

*///:~

