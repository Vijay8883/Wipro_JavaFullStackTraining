package DAY23Assignments;
//Generic Pair class
public class Pair<T, U> {
 private T first;
 private U second;

 // Constructor
 public Pair(T first, U second) {
     this.first = first;
     this.second = second;
 }

 // Getters
 public T getFirst() {
     return first;
 }

 public U getSecond() {
     return second;
 }

 // Setters
 public void setFirst(T first) {
     this.first = first;
 }

 public void setSecond(U second) {
     this.second = second;
 }

 // Method to return a reversed version of the pair
 public Pair<U, T> reverse() {
     return new Pair<>(second, first);
 }

 // toString method for easy display
 @Override
 public String toString() {
     return "Pair{" + "first=" + first + ", second=" + second + '}';
 }

 // Main method for testing
 public static void main(String[] args) {
     Pair<String, Integer> pair = new Pair<>("Hello", 123);
     System.out.println("Original Pair: " + pair);
     
     Pair<Integer, String> reversedPair = pair.reverse();
     System.out.println("Reversed Pair: " + reversedPair);
 }
}
