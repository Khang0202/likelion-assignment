package vn.edu.likelion.assignment.helpers;

import java.util.Scanner;

public class Input {
    public static int inputInt(){
        Scanner sc = new Scanner(System.in);
        try {
            return sc.hasNextInt() ? sc.nextInt() : 0;
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    public static String inputString(){
        Scanner sc = new Scanner(System.in);
        try {
            return sc.hasNext() ? sc.nextLine() : "";
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }
}
