package com.javaio;
//To read the content from the file
import java.io.FileReader;
import java.io.IOException;
public class FileReadingExample {

	public static void main(String[] args) {
		FileReader reader=null;
		try {
			reader=new FileReader("Example.txt");
			int character;
			while((character=reader.read())!=-1) {
				//if you do not have any data to read,it will eturn -1
				System.out.print((char)character);//type casting the unicode value with char
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(reader!=null)
				{
					reader.close();
				}
			}catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}

}
