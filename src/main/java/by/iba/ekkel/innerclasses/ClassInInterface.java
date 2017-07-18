//: by.iba.ekkel.innerclasses/ClassInterface.java
// {main: ClassInInterface$Test}
package by.iba.ekkel.innerclasses;

public interface ClassInInterface {
	  void howdy();
	  class Test implements ClassInInterface {
	    public void howdy() {
	      System.out.println("Howdy!");
	    }
	    public static void main(String[] args) {
	      new Test().howdy();
	}
  }
} /* Output
Howdy!
*///:~
