package com.javaio;
//To creatE a File
import java.io.File;
import java.io.IOException;

public class FileCreationExample {

	public static void main(String[] args) throws IOException  {
	File f=new File("Nirvan.txt");
	System.out.println(f.exists());//false since file not exists
	f.createNewFile();//To create a file
	System.out.println(f.exists());//True
	}

}
