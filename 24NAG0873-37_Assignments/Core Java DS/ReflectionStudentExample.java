package DAY24Assignments;
//File: ReflectionStudentDemo.java
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionStudentExample {

 public static void main(String[] args) {
     try {
         // Get the class object for Student
         Class<?> clazz = Class.forName("DAY24Assignments.Student");

         // Inspect the methods of the class
         Method[] methods = clazz.getDeclaredMethods();
         System.out.println("Methods:");
         for (Method method : methods) {
             System.out.println(" " + method.getName());
         }

         // Inspect the fields of the class
         Field[] fields = clazz.getDeclaredFields();
         System.out.println("Fields:");
         for (Field field : fields) {
             System.out.println(" " + field.getName());
         }

         // Inspect the constructors of the class
         Constructor<?>[] constructors = clazz.getDeclaredConstructors();
         System.out.println("Constructors:");
         for (Constructor<?> constructor : constructors) {
             System.out.println(" " + constructor.getName());
         }

         // Modify the access level of a private field and set its value
         Field nameField = clazz.getDeclaredField("name");
         nameField.setAccessible(true);  // Make the private field accessible
         Object studentInstance = clazz.getDeclaredConstructor().newInstance();  // Create an instance of Student
         nameField.set(studentInstance, "Alice");  // Set the value of the private field

         // Verify the field's new value
         String nameValue = (String) nameField.get(studentInstance);
         System.out.println("Modified private field value: " + nameValue);

         // Optionally, call a private method using reflection
         Method displayGradeMethod = clazz.getDeclaredMethod("displayGrade");
         displayGradeMethod.setAccessible(true);  // Make the private method accessible
         displayGradeMethod.invoke(studentInstance);  // Call the private method

     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}