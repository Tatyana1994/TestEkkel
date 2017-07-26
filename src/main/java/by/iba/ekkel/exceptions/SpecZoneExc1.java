//: by.iba.ekkel.exceptions/SpecZoneExc1.java
// Измените следующий cat метод так, чтобы это скомпилировало:
package by.iba.ekkel.exceptions;

import java.io.*;

public class SpecZoneExc1 {
	
	public static void cat(File file) throws IOException {
	    RandomAccessFile input = null;
	    String line = null;

	    try {
	        input = new RandomAccessFile(file, "r");
	        while ((line = input.readLine()) != null) {
	            System.out.println(line);
	        }
	        return;
	    } catch(FileNotFoundException e) {
	    	e.printStackTrace();
	    } catch(IOException e) {
	    	e.printStackTrace();
	    } finally {
	        if (input != null) {
	            input.close();
	        }
	    }
	}

}
