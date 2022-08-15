import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myArray = getIntegers(5);
        printArray(myArray);

    }

    // method to print the passed array
    public static void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++)
            System.out.println("Element " + i + " contents " + myArray[i]);
    }

    // method to get integer values for an array(from the user)
    public static int[] getIntegers(int capacity) {
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values : \r");
        for (int i = 0; i < array.length; i++)
            array[i] = scanner.nextInt();
        return array;
    }

    // method to sort an array full of integers in descending order,
    // returns the sorted array instead of altering the original one
    public static int[] sortArray(int[] myArray) {
        // as arrays are pass by reference, so we need
        // to make a copy of the original array
        int[] sortedArray = Arrays.copyOf(myArray, myArray.length);
        // System.arraycopy(myArray, 0, sortedArray, 0, myArray.length);
        boolean flag = true;
        while (flag) {
            flag = false;
            int temp;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    // swapping next element with the current element if current
                    // element is less than the next element (descending order)
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
