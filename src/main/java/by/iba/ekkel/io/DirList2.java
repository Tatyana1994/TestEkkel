//: by.iba.ekkel.io/DirList.java
// The list of directories that use regular expressions
// {Parameters: "D.*\.java"}
package by.iba.ekkel.io;

import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList2 {
	public static void main(String[] args) {
		
		File path = new File("src/main/java/by/iba/ekkel/io");
		String[] list;
		if(args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(args[0]));
		}	
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list) {
			System.out.println(dirItem);
		}
		
		for(String s : args) {
			System.out.println(s);
		}
	}
}
	
class DirFilter2 implements FilenameFilter {
	
	private Pattern pattern;
	
	public DirFilter2(String regex) {
		pattern = Pattern.compile(regex);
	}
	
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}	
	
}
/* Output:
DirList.java
D.*\.java
*///:~
