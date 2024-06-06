package com.javaio;
//To create a directory
import java.io.File;
import java.io.IOException;
public class FileDirectoryCreation {

	public static void main(String[] args) throws IOException {
		File f=new File("JaysharmaDir");
		System.out.println(f.exists());
		f.mkdir();//To create a directory
		System.out.println(f.exists());
		
	}

}
