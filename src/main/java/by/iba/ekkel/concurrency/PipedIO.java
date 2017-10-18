//: by.iba.ekkel.concurrency/PipedIO.java
// Using channels to input/output between threads
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.io.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

class Sender implements Runnable {
	private Random rand = new Random(47);
	private PipedWriter out = new PipedWriter();
	public PipedWriter getPipedWriter() {
		return out;
	}
	public void run() {
		try {
			while(true) {
				for(char c = 'A'; c <= 'z'; c++) {
					out.write(c);
					TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				}
			}
		} catch(IOException e) {
			print(e + " Sender write exception");
		} catch (InterruptedException e) {
			print(e + " Sender sleep interrupted");
		}
	}
}

class Receiver implements Runnable {
	private PipedReader in;
	public Receiver(Sender sender) throws IOException {
		in = new PipedReader(sender.getPipedWriter());
	}
	public void run() {
		try {
			while(true) {
				// Blocked till the next symbol appears
				printb("Read: " + (char)in.read() + "; ");
			}
		} catch(IOException e) {
			print(e + " Receiver read exception");
		}
	}
}

public class PipedIO {
	
	public static void main(String[] args) throws Exception {
	
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		TimeUnit.SECONDS.sleep(4);
		exec.shutdownNow();
	
	}

} /* OutputRead: A; Read: B; Read: C; Read: D; 
Read: E; Read: F; Read: G; Read: H; Read: I; Read: J; 
Read: K; Read: L; Read: M; Read: N; Read: O; Read: P; 
Read: Q; 
java.lang.InterruptedException: sleep interrupted Sender 
sleep interrupted
java.io.InterruptedIOException Receiver read exception
*///:~
