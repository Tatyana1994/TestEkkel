//: by.iba.ekkel.io/ZipCompress.java
// Using ZIP format to compress 
// any number of files that are defined in the command line
// { Params: ZipCompress.java }
package by.iba.ekkel.io;

import java.util.zip.*;
import java.io.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

public class ZipCompress {
	
	public static void main(String[] args) 
		throws IOException 
			{
		
				FileOutputStream f = new FileOutputStream("test.zip");
				CheckedOutputStream csum = 
						new CheckedOutputStream(f, new Adler32());
				ZipOutputStream zos = new ZipOutputStream(csum);
				BufferedOutputStream out = 
						new BufferedOutputStream(zos);
				zos.setComment("Check ZIP-compression Java");
				// However, the pair method to get the comment doesn't exist
				for(String arg : args) {
					print("File writing: " + arg);
					BufferedReader in = 
							new BufferedReader(new FileReader(arg));
					zos.putNextEntry(new ZipEntry(arg));
					int c;
					while((c = in.read()) != -1) {
						out.write(c);
					}
					in.close();
					out.flush();
				}
				out.close();
				// Checksum becomes relevant only after archive file close
				print("Checksum: " + csum.getChecksum().getValue());
				// Retrieve the files then
				print("File reading...");
				FileInputStream fi = new FileInputStream("test.zip");
				CheckedInputStream csumi = 
						new CheckedInputStream(fi, new Adler32());
				ZipInputStream in2 = new ZipInputStream(csumi);
				BufferedInputStream bis = new BufferedInputStream(in2);
				ZipEntry ze;
				while((ze = in2.getNextEntry()) != null) {
					print("Reading file: " + ze);
					int x;
					while((x = bis.read()) != -1) {
						System.out.write(x);
					}
				}
				if(args.length == 1) {
					print("Checksum " + csumi.getChecksum().getValue());
				}
				bis.close();
				// Alternative way to open and read
				// the files of ZIP format
				ZipFile zf = new ZipFile("test.zip");
				Enumeration e = zf.entries();
				while(e.hasMoreElements()) {
					ZipEntry ze2 = (ZipEntry)e.nextElement();
					print("File: " + ze2);
					// ...then the data is retrieved the same way as before
					/* if(args.length == 1)*/
				}
		
			}

}/* Output
File writing
File reading
//: by.iba.ekkel.io/ZipCompress.java
// Using ZIP format to compress 
// any number of files that are defined in the command line
// { Params: ZipCompress.java }
package by.iba.ekkel.io;

import java.util.zip.*;
import java.io.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

public class ZipCompress {
	
	public static void main(String[] args) 
		throws IOException 
			{
		
				FileOutputStream f = new FileOutputStream("test.zip");
				CheckedOutputStream csum = 
						new CheckedOutputStream(f, new Adler32());
				ZipOutputStream zos = new ZipOutputStream(csum);
				BufferedOutputStream out = 
						new BufferedOutputStream(zos);
				zos.setComment("Check ZIP-compression Java");
				// However, the pair method to get the comment doesn't exist
				for(String arg : args) {
					print("File writing: " + arg);
					BufferedReader in = 
							new BufferedReader(new FileReader(arg));
					zos.putNextEntry(new ZipEntry(arg));
					int c;
					while((c = in.read()) != -1) {
						out.write(c);
					}
					in.close();
					out.flush();
				}
				out.close();
				// Checksum becomes relevant only after archive file close
				print("Checksum: " + csum.getChecksum().getValue());
				// Retrieve the files then
				print("File reading...");
				FileInputStream fi = new FileInputStream("test.zip");
				CheckedInputStream csumi = 
						new CheckedInputStream(fi, new Adler32());
				ZipInputStream in2 = new ZipInputStream(csumi);
				BufferedInputStream bis = new BufferedInputStream(in2);
				ZipEntry ze;
				while((ze = in2.getNextEntry()) != null) {
					print("Reading file: " + ze);
					int x;
					while((x = bis.read()) != -1) {
						System.out.write(x);
					}
				}
				if(args.length == 1) {
					print("Checksum " + csumi.getChecksum().getValue());
				}
				bis.close();
				// Alternative way to open and read
				// the files of ZIP format
				ZipFile zf = new ZipFile("test.zip");
				Enumeration e = zf.entries();
				while(e.hasMoreElements()) {
					ZipEntry ze2 = (ZipEntry)e.nextElement();
					print("File: " + ze2);
					// ...then the data is retrieved the same way as before
					/* if(args.length == 1)*//*
				}
		
			}

}
*///:~