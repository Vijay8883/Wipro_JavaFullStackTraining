package DAY24Assignments;
import java.util.*;

public class LambdaExpressionsExample {
public static void main(String[] args) {
List<Person> people = new ArrayList<>();
people.add(new Person("Shiva", 30));
people.add(new Person("Ram", 25));
people.add(new Person("Krishna", 35));

Collections.sort(people, Comparator.comparingInt(Person::getAge));

System.out.println(people);
}
}

class Person {
private String name;
private int age;

public Person(String name, int age) {
this.name = name;
this.age = age;
}

public int getAge() {
return age;
}

@Override
public String toString() {
return "Person{name='" + name + "', age=" + age + '}';
}
}