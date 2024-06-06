package DAY25Assignments;
import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person(20, "Joe");

        try {
            // Serialize the object to a file
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in person.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        try {
            // Deserialize the object from the file
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person p2 = (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized Person:");
            System.out.println("Age: " + p2.getAge());
            System.out.println("Name: " + p2.getName());
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }
    }
}
