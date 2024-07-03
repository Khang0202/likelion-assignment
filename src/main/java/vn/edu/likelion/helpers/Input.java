package vn.edu.likelion.helpers;

import java.util.Scanner;

public class Input {
    public static int inputInt() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.hasNextInt() ? sc.nextInt() : 0;
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.hasNext() ? sc.nextLine() : "";
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public static double inputDouble() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.hasNextDouble() ? sc.nextDouble() : 0;
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
}
