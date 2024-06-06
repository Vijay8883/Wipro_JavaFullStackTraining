package com.iobasics;
import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;
 
public class BufferedFileReadingExample {

    public static void main(String[] args) {

        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader("Example2.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (reader != null) {

                    reader.close();

                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}
