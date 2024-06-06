package DAY24Assignments;
// File: Student.java
public class Student {
   private String id = "S12345";
   private String name = "John Doe";
   private int grade = 85;

   public Student() {
   }

   public Student(String id, String name, int grade) {
       this.id = id;
       this.name = name;
       this.grade = grade;
   }

   public void displayInfo() {
       System.out.println("Student ID: " + id + ", Name: " + name + ", Grade: " + grade);
   }

   private void displayGrade() {
       System.out.println("Grade: " + grade);
   }
}