package com.javareflectionapi;
//Create a Sample Class to Inspect
public class Person {
 private String name;
 private int age;

 public Person() {
 }

 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public String getName() {
     return name;
 }

 private void setName(String name) {
     this.name = name;
 }

 public int getAge() {
     return age;
 }

 private void setAge(int age) {
     this.age = age;
 }

 @Override
 public String toString() {
     return "Person{name='" + name + "', age=" + age + '}';
 }
}
