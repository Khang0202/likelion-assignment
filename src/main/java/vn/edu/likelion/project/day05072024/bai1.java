package vn.edu.likelion.project.day05072024;

import java.math.MathContext;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class bai1 {
    public static void main(String[] args) {
        System.out.println("array");
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Sum of even numbers: " + Arrays.stream(array).filter(s -> s % 2 == 0).sum());
        System.out.println("Sum of odd numbers: " + Arrays.stream(array).filter(s -> s % 2 != 0).sum());
        System.out.println("\ncolections");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Sum of even numbers: " + list.stream().filter(s -> s % 2 == 0).mapToInt(s -> s).sum());
        System.out.println("Sum of odd numbers: " + list.stream().filter(s -> s % 2 != 0).mapToInt(s -> s).sum());
    }
}
