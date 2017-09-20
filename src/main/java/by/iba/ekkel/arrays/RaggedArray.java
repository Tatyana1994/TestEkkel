//: by.iba.ekkel.arrays/RaggedArray.java
package by.iba.ekkel.arrays;

import java.util.*;

public class RaggedArray {
	
	public static void main(String[] args) {
	
		long id = 0;
		
		Random rand = new Random(47);
		//Three-dimensional array with vector of variable size
		int[][][] a = new int[rand.nextInt(7)][][];
		for(int i = 0; i < a.length; i++) {
			a[i] = new int[rand.nextInt(5)][];
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] = new int[rand.nextInt(5)];
			}
		}
		System.out.println(Arrays.deepToString(a));
		
		//Algorithm to get the decimal number of random row in threeD array
		int[][][] threeD = new int[rand.nextInt(5)][rand.nextInt(47)][rand.nextInt(47)];
		for(int i = 0; i < threeD.length; i++) {
			//System.out.print("i = " + i + "->");
			for(int j = 0; j < threeD[i].length; j++) {
				//System.out.print("j = " + j + "->");
				for(int k = 0; k < threeD[i][j].length; k++) {
					//System.out.print(" k = " + k + "->");
					threeD[i][j][k] = rand.nextInt(2);
					System.out.print(threeD[i][j][k]);
					id +=  threeD[i][j][k] * Math.pow(2, (threeD[i][j].length-1) - k);
				}
				System.out.print("  ID: = " + id);
				System.out.println();
				id = 0;
			}
			System.out.println();
		}
	
	}

} /* Output
[[], [[0], [0], [0, 0, 0, 0]], [[], [0, 0], [0, 0]], [[0, 0, 0], [0], [0, 0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0], []], [[0], [], [0]]]
000
100
110

100
100
010

001
101
011
*///:~
