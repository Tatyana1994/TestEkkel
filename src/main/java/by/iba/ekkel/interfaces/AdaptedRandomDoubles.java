//: by.iba.ekkel.interfaces/AdaptedRandomDoubles.java
package by.iba.ekkel.interfaces;

import java.util.*;
import java.nio.*;

public class AdaptedRandomDoubles extends RandomDoubles
implements Readable {
	
  private int count;
 
  public AdaptedRandomDoubles(int count) {
	  this.count = count;
  }
  
  public int read(CharBuffer cb) {
    
	if(count-- == 0) {
		return -1;
	}
    String result = Double.toString(next()) + " ";
    cb.append(result);
    return result.length();
    
  }
  
  public static void main(String[] args) {
	  
	  AdaptedRandomDoubles adptRand = new AdaptedRandomDoubles(7);	  
	  
	  Scanner s = new Scanner(adptRand);
	  while(s.hasNext())
		  System.out.print(s.next() + " ");
  	   }
  
}  /* Output
0.7271157860730044 0.5309454508634242 0.16020656493302599 0.18847866977771732 0.5166020801268457 0.2678662084200585 0.2613610344283964 
*///:~