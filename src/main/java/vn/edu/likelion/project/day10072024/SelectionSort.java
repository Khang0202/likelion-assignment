package vn.edu.likelion.project.day10072024;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {8,5,6,9,1,3};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] selectionSort(int[] arr) {
        int i = 0;
        do {
            int loc = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[loc]) {
                    loc = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[loc];
            arr[loc] = temp;
            i++;

        }while (i < arr.length);
        return arr;
    }
}
