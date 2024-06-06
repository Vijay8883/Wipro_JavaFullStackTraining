package com.iobasics;
import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;
 
public class BufferedFileWritingExample {

    public static void main(String[] args) {

        BufferedWriter writer = null;

        try {

            writer = new BufferedWriter(new FileWriter("Jay2.txt"));

            writer.write("Hello, World!");

            writer.newLine();

            writer.write("This is a new line.");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (writer != null) {

                    writer.close();

                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}

