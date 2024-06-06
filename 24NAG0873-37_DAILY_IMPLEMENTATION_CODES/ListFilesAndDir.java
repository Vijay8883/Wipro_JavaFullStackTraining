package com.javaio;
//To list all the files and directory of a given directory
import java.io.File;
public class ListFilesAndDir {
public static void main(String[] args) {
	
	File f=new File("C:\\Users\\Administrator\\eclipse-workspace\\JavaAdvancedCoreConcepts\\JaysharmaDir");
	int count=0;
	String[] s=f.list();
	for(String s1:s)
	{
		count++;
		System.out.println(s1);		
	}
System.out.println("Count of Files "+count);
}
}
