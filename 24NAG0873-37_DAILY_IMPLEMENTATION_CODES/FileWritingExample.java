package com.javaio;
//To write content into the file
import java.io.FileWriter;
import java.io.IOException;
public class FileWritingExample {

	public static void main(String[] args) throws IOException {
		//FileWriter fw=new FileWriter("Example.txt");//override
FileWriter fw1=new FileWriter("Example.txt",true);//append
	
fw1.write("Hello");
fw1.write('\n');
fw1.write("This is an example for writing into file");
fw1.write('\n');
char[] ch= {'w','e','l','c','o','m','e'};
fw1.write(ch);
	fw1.write('\n');
	fw1.flush();
	fw1.close();
	}
}