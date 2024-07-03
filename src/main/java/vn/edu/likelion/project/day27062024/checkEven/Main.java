package vn.edu.likelion.project.day27062024.checkEven;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int a = 256789113;
        int b = 2468268;
        show(a);
        System.out.println("---------------------------------------");
        show(b);
    }

    public static void show(int n) {
        System.out.println("Input an interger: " + n);
        System.out.println("Check whether every digit of the said integer is even or not!");
        System.out.println(checkArray(n));
    }

    public static boolean checkEven(int n) {
        return n % 2 == 0;
    }

    public static boolean checkArray(int n) {
        LinkedList<Integer> list = toList(n);
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (checkEven(list.get(i))) {
                flag = true;
            } else {
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    public static LinkedList<Integer> toList(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        do {
            list.add(n % 10);
            n = n / 10;
        } while (n > 10);
        list.add(n);
        return list;
    }
}
