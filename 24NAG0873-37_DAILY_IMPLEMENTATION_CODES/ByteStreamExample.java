package com.javaio;
//Byte Stream Example

//Reading from a File using FileInputStream:

import java.io.FileInputStream;

import java.io.IOException;

public class ByteStreamExample { // To read

  public static void main(String[] args) {

      try (FileInputStream inputStream = new FileInputStream("Jay.txt")) {

          int data;

          while ((data = inputStream.read()) != -1) {

              System.out.print((char) data);

          }

      } catch (IOException e) {

          e.printStackTrace();

      }

  }

}