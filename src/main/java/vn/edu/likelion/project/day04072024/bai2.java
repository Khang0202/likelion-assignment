package vn.edu.likelion.project.day04072024;

import java.util.Arrays;

public class bai2 {
    @FunctionalInterface
    public interface SecondLargest{
        int secondLargest(int[] array);
    }
    @FunctionalInterface
    public interface Smallest{
        int smallest(int[] array);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};

        SecondLargest secondLargest = (arr) -> Arrays.stream(arr).filter(n -> n != Arrays.stream(arr).max().getAsInt()).max().getAsInt();

        Smallest smallest = (arr) -> Arrays.stream(arr).min().getAsInt();

        System.out.println("Array elements: " + Arrays.toString(array));
        System.out.println("Second largest element: " + secondLargest.secondLargest(array));
        System.out.println("Smallest element: " + smallest.smallest(array));
    }
}
