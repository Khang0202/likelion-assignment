package vn.edu.likelion.project.day05072024;

import java.util.Arrays;
import java.util.List;

public class bai2 {
    public static void main(String[] args) {
        System.out.println("array");
        int[] array = {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10};
        System.out.print("Origin List of numbers: \t");
        Arrays.stream(array).forEach(s -> System.out.print(s + "\t"));
        System.out.println();
        System.out.print("After removing duplicates from the said list: \t");
        Arrays.stream(array).distinct().forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n\ncolections");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10);
        System.out.print("Origin List of numbers: \t" + list + "\n");
        System.out.print("After removing duplicates from the said list: \t");
        list.stream().distinct().forEach(s -> System.out.print(s + "\t"));
    }
}
