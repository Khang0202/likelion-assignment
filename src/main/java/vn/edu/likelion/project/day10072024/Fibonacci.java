package vn.edu.likelion.project.day10072024;

public class Fibonacci {

    public static void main(String[] args) {
        int number = 10;
        ;
        for (int i = 0; i < number; i++) {
            System.out.println(fibonacci(i));
        }
    }

    private static int fibonacci(int n) {
        // nếu n = 0 thì trả về 0
        // nếu n = 1 thì trả về 1
        if (n == 0 || n == 1) return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
