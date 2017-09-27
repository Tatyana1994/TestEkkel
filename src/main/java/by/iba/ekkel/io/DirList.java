//: by.iba.ekkel.io/DirList.java
// The list of directories that use regular expressions
// {ParamsL "D.*\java" } 
package by.iba.ekkel.io;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class DirFilter implements FilenameFilter {
	
	private Pattern pattern;
	
	public DirFilter(String regexp) {
		pattern = Pattern.compile(regexp);
	}
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}

public class DirList {
	
	public static void main(String[] args) {
	
		File path = new File("src/main/java/by/iba/ekkel/io");
		String list[];
		if(args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list) {
			System.out.println(dirItem);
		}
	
	}
	
} /* Output
DirList.java
DirList2.java
*///:~


