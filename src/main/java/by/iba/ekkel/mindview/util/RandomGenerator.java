//: by.iba.ekkel.mindview.util/RandomGenerator.java
// Generators that produce random values.
package by.iba.ekkel.mindview.util;
import java.util.*;

public class RandomGenerator {

	private static Random r = new Random(47);
	
	public static class
		Boolean implements Generator<java.lang.Boolean> {
			public java.lang.Boolean next() {
				return r.nextBoolean();
			}
	}
		
	public static class
		Byte implements Generator<java.lang.Byte> {
			public java.lang.Byte next() {
				return (byte)r.nextInt();
			}
	}
	
	public static class
		Character implements Generator<java.lang.Character> {
			public java.lang.Character next() {
				return CountingGenerator.chars[
				         r.nextInt(CountingGenerator.chars.length)
					];
			}
	}
	
	public static class
		String extends CountingGenerator.String {
			// Plug in the random Character generator:
			{ 
				cg = new Character(); 
			} // Instance initializer
			public String() {
			}
			public String(int length) { 
				super(length); 
			}
	}
	
	public static class
		Short implements Generator<java.lang.Short> {
			public java.lang.Short next() {
				return (short)r.nextInt();
			}
	}
	
	public static class
		Integer implements Generator<java.lang.Integer> {
			private int mod = 10000;
			public Integer() {
			}
			public Integer(int modulo) { 
				mod = modulo; 
			}
			public java.lang.Integer next() {
				return r.nextInt(mod);
			}
	}
	
	public static class
		Long implements Generator<java.lang.Long> {
			private int mod = 10000;
			public Long() {
			}
			public Long(int modulo) { 
				mod = modulo; 
			}
			public java.lang.Long next() {
				return new java.lang.Long(r.nextInt(mod));
			}
	}
	
	public static class
		Float implements Generator<java.lang.Float> {
			public java.lang.Float next() {
				// Trim all but the first two decimal places:
				int trimmed = Math.round(r.nextFloat() * 100);
					return ((float)trimmed) / 100;
			}
	}
	
	public static class
		Double implements Generator<java.lang.Double> {
			public java.lang.Double next() {
				long trimmed = Math.round(r.nextDouble() * 100);
				return ((double)trimmed) / 100;
			}
	}
	
} /* Output
Boolean: true false true false false true false false true true 
Byte: 33 -64 -114 123 -110 -36 92 26 -96 84 
Character: e G Z M m J M R o E 
Double: 0.62 0.99 0.48 0.01 0.4 0.27 0.16 0.87 0.7 0.66 
Float: 0.87 0.51 0.59 0.76 0.64 0.9 0.19 0.12 0.32 0.97 
Integer: 9257 9634 5402 8317 5984 7242 5080 3698 4961 2899 
Long: 7052 6665 2654 3909 5202 2209 5458 4158 5903 2273 
Short: 23229 -21780 18500 6624 -17917 -19206 28107 -25856 -56 8704 
String: RFJQAHx xHvHqXu mcXZJoo goYWMNv qeuTpnX sgqiaxx EAJJmzM sslJrLv pfFvHVE EqjncLd 
*///:~
