package vn.edu.likelion.getFirstNum;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int a = 1234;
        int b = -5678;

        show(a);
        show(b);

    }

    public static void show(int n) {
        System.out.println("Input an integer(positive/negative): " + n);
        System.out.println("Extract the first digit from the said integer: " + getFirstNum(n));
    }

    public static int getFirstNum(int n){
        if (n <= 0) {
            n *= -1;
        }
        return firstNum(n);
    }

    public static int firstNum(int n) {
        do{
            n=n/10;
        }while (n>10);
        return n;
    }

}
