//: by.iba.ekkel.io/MakeDirectories.java
// Using of File class for directories creating and operating them
// {Params: MakeDirectoriesTest}
package by.iba.ekkel.io;

import java.io.*;

public class MakeDirectories {
	
	private static void usage() {
		System.err.println(
					"Using: MakeDirectories path1 ...\n" +
					"Create all the paths\n" +
					"Using: MakeDirectories -d path1 ...\n" +
					"Remove all the paths\n" +
					"Using: MakeDirectories -r path1 path2...\n" +
					"Rename path1 to path2\n");
		System.exit(1);
	}
	
	private static void fileData(File f) {
		System.out.println(
				"Full name: " + f.getAbsolutePath() +
				"\n available for reading: "  + f.canRead() +
				"\n available for writing: "  + f.canWrite() +
				"\n file name -- getName(): " + f.getName() +
				"\n parent directory --getParent(): " + f.getParent() +
				"\n path -- getPath() " + f.getPath() +
				"\n size: " + f.length() + 
				"\n lastmodified: " + f.lastModified());
		if(f.isFile()) {
			System.out.println("This is file");
		} else if (f.isDirectory()) {
			System.out.println("This is directory");
		}
	}
	
	public static void main(String[] args) {
	
		for(String s : args) {
			System.out.println(s);
		}
		
		if(args.length < 1) {
			usage();
		} 
		if(args[0].equals("-r")) {
			if(args.length != 3) {
				usage();
			}
			File 
				old = new File(args[1]),
				rname = new File(args[2]);
			old.renameTo(rname);
			fileData(old);
			fileData(rname);
			return; //Exit from the main method
		}
		int count = 0;
		boolean del = false;
		if(args[0].equals("-d")) {
			count++;
			del = true;
		}
		count--;
		while(++count < args.length) {
			File f = new File(args[count]);
			if(f.exists()) {
				System.out.println(f + " exists");
				if(del) {
					System.out.println("removing: " + f);
					f.delete();
				}
			} else { //don't exist
				if(!del) {
					f.mkdirs();
					System.out.println("Is created " + f);
				}
			}
			fileData(f);
		}
	
	}

} /* Output
args = MakeDirectoriesTest
------------------------------------------------------------------
Is created MakeDirectoriesTest
Full name: D:\java_training\ekkel\TestProject\MakeDirectoriesTest
 available for reading: true
 available for writing: true
 file name -- getName(): MakeDirectoriesTest
 parent directory --getParent(): null
 path -- getPath() MakeDirectoriesTest
 size: 0
 lastmodified: 1506418108119
This is directory
------------------------------------------------------------------
args = -r MakeDirectoriesTest MakeDirectoriesTestUpd
Full name: D:\java_training\ekkel\TestProject\MakeDirectoriesTest
 available for reading: false
 available for writing: false
 file name -- getName(): MakeDirectoriesTest
 parent directory --getParent(): null
 path -- getPath() MakeDirectoriesTest
 size: 0
 lastmodified: 0
Full name: D:\java_training\ekkel\TestProject\MakeDirectoriesTestUpd
 available for reading: true
 available for writing: true
 file name -- getName(): MakeDirectoriesTestUpd
 parent directory --getParent(): null
 path -- getPath() MakeDirectoriesTestUpd
 size: 0
 lastmodified: 1506418108119
This is directory
------------------------------------------------------------------
args = -d MakeDirectoriesTestUpd
MakeDirectoriesTestUpd exists
removing: MakeDirectoriesTestUpd
Full name: D:\java_training\ekkel\TestProject\MakeDirectoriesTestUpd
 available for reading: false
 available for writing: false
 file name -- getName(): MakeDirectoriesTestUpd
 parent directory --getParent(): null
 path -- getPath() MakeDirectoriesTestUpd
 size: 0
 lastmodified: 0
*///:~

