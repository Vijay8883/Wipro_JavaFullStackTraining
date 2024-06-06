package com.javaio;
//To list the files present in a directory
import java.io.File;


public class ListTheFilesInDir {

	public static void main(String[] args) {
	int count=0;
	File f=new File("C:\\Users\\Administrator\\eclipse-workspace\\JavaAdvancedCoreConcepts\\JaysharmaDir");
	String[] s=f.list();
	for(String s1:s) {
		File f1=new File(f,s1);
		if(f1.isFile()) {
count++;
System.out.println(s1);
		}
	}
	System.out.println("Count of Files: "+count);
	}
}
