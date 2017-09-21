//: by.iba.ekkel.mindview.util/CountingGenerator.java
// Simple generator implementations.
package by.iba.ekkel.mindview.util;

public class CountingGenerator {
	
		public static class
			Boolean implements Generator<java.lang.Boolean> {
					private boolean value = false;
					public java.lang.Boolean next() {
						value = !value; // Just flips back and forth
						return value;
					}
		}
		
		public static class
			Byte implements Generator<java.lang.Byte> {
				private byte value = 0;
				public java.lang.Byte next() { 
					return value++; 
				}
		}
		
		static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		
		public static class
			Character implements Generator<java.lang.Character> {
				int index = -1;
					public java.lang.Character next() {
						index = (index + 1) % chars.length;
						return chars[index];
					}
		}
		
		public static class
			String implements Generator<java.lang.String> {
				private int length = 7;
				Generator<java.lang.Character> cg = new Character();
				public String() {
					}
				public String(int length) { 
					this.length = length; 
				}
				public java.lang.String next() {
					char[] buf = new char[length];
					for(int i = 0; i < length; i++) {
						buf[i] = cg.next();
					}		
					return new java.lang.String(buf);
				}
		}
		
		public static class
			Short implements Generator<java.lang.Short> {
				private short value = 0;
				public java.lang.Short next() { 
					return value++; 
				}
		}
		
		public static class
			Integer implements Generator<java.lang.Integer> {
				private int value = 0;
				public java.lang.Integer next() { 
					return value++; 
			}
		}
		
		public static class
			Long implements Generator<java.lang.Long> {
				private long value = 0;
				public java.lang.Long next() { 
					return value++; 
				}
		}
		
		public static class
			Float implements Generator<java.lang.Float> {
				private float value = 0;
				public java.lang.Float next() {
					float result = value;
					value += 1.0;
					return result;
				}
		}
		
		public static class
			Double implements Generator<java.lang.Double> {
				private double value = 0.0;
				public java.lang.Double next() {
					double result = value;
					value += 1.0;
					return result;
				}
		}
		
		public static void main(java.lang.String[] args) {
		
			CountingGenerator.Character gc = new Character();
			java.lang.String[] strs = new java.lang.String[27];
			for(int i = 0; i < strs.length; i++) {
				strs[i] = gc.next().toString();
				System.out.print(i + ": " + strs[i] + "; ");
			}
		
		}
			
} /* Output
0: a; 1: b; 2: c; 3: d; 4: e; 5: f; 6: g; 7: h; 8: i; 9: j; 10: k; 11: l; 12: m; 13: n; 14: o; 15: p; 16: q; 17: r; 18: s; 19: t; 20: u; 21: v; 22: w; 23: x; 24: y; 25: z; 26: A; 
*///:~
