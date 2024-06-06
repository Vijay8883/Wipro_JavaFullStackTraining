package DAY25Assignments;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {

	public static void main(String[] args) {
String inputFilePath="C:\\Users\\Administrator\\eclipse-workspace\\JavaAdvancedCoreConcepts\\Example.txt";
String outputFilePath="C:\\Users\\Administrator\\eclipse-workspace\\JavaAdvancedCoreConcepts\\Nirvan.txt";
//Using try with resources to ensure that resources are closed after the program is finished
try(FileReader fileReader=new FileReader(inputFilePath);
		Scanner scanner =new Scanner(fileReader);
		FileWriter fileWriter=new FileWriter(outputFilePath))
{
	Map<String,Integer> wordCounts=new HashMap<>();
	//Reading each word in the file
	while(scanner.hasNext()) {
		String word=scanner.next().toLowerCase();//convert to lowercase to count all variations of a word the same
		wordCounts.put(word, wordCounts.getOrDefault(word, 0)+1);
	}
	//Writing the word counts to the output file
	for(Map.Entry<String,Integer> entry:wordCounts.entrySet()) {
		fileWriter.write(entry.getKey()+":"+entry.getValue()+"\n");
	}
	System.out.println("Word frequency count has been written to "+outputFilePath);
}catch(IOException e) {
	e.printStackTrace();
}

	}

}
