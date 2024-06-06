package com.javareflectionapi;
//Use Reflection to Inspect Methods, Fields, and Constructors


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectionExample {

 public static void main(String[] args) throws Exception {
     // Get the Class object associated with the Person class
     Class<Person> personClass = Person.class; //Getting Class Object

     // Inspect fields
     System.out.println("Fields:");
     Field[] fields = personClass.getDeclaredFields();
     for (Field field : fields) {
         System.out.println(field);
     }

     // Inspect constructors
     System.out.println("\nConstructors:");
     Constructor<?>[] constructors = personClass.getDeclaredConstructors();
     for (Constructor<?> constructor : constructors) {
         System.out.println(constructor);
     }

     // Inspect methods
     System.out.println("\nMethods:");
     Method[] methods = personClass.getDeclaredMethods();
     for (Method method : methods) {
         System.out.println(method);
     }

     // Create an instance of Person
     Person person = personClass.getDeclaredConstructor().newInstance();

     // Modify the access level of a private field and set its value
     Field nameField = personClass.getDeclaredField("name");
     nameField.setAccessible(true);
     nameField.set(person, "John Doe");

     Field ageField = personClass.getDeclaredField("age");
     ageField.setAccessible(true);
     ageField.set(person, 30);

     // Print the modified object
     System.out.println("\nModified Person: " + person);

     // Modify the access level of a private method and invoke it
     Method setNameMethod = personClass.getDeclaredMethod("setName", String.class);
     setNameMethod.setAccessible(true);
     setNameMethod.invoke(person, "Jane Doe");

     Method setAgeMethod = personClass.getDeclaredMethod("setAge", int.class);
     setAgeMethod.setAccessible(true);
     setAgeMethod.invoke(person, 25);

     // Print the modified object again
     System.out.println("Modified Person Again: " + person);
 }
}
