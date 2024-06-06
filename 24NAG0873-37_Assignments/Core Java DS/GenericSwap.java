package DAY23Assignments;

import java.util.Arrays;

public class GenericSwap {

    // Generic method to swap two elements in an array
    public static <T> void swap(T[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid index or null array");
        }
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // Example with Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Original Integer array: " + Arrays.toString(intArray));
        swap(intArray, 1, 3);
        System.out.println("Swapped Integer array: " + Arrays.toString(intArray));

        // Example with String array
        String[] strArray = {"apple", "banana", "cherry", "date"};
        System.out.println("Original String array: " + Arrays.toString(strArray));
        swap(strArray, 0, 2);
        System.out.println("Swapped String array: " + Arrays.toString(strArray));

        // Example with Double array
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        System.out.println("Original Double array: " + Arrays.toString(doubleArray));
        swap(doubleArray, 2, 3);
        System.out.println("Swapped Double array: " + Arrays.toString(doubleArray));
    }
}