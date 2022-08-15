import java.util.Arrays;
public class ReverseArray {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5, 6};
        reverse(myArray);
    }
    // write code here
    private static void reverse(int[] array) {
        System.out.println("Original Array = " + Arrays.toString(array));
        int temp, swapIndex;
        int arrayLength = array.length / 2;
        for (int i = 0; i < arrayLength; i++) {
            swapIndex = array.length - 1 - i;
            temp = array[swapIndex];
            array[swapIndex] = array[i];
            array[i] = temp;
        }
        System.out.println("Reversed Array = " + Arrays.toString(array));
    }
}