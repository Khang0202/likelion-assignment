package vn.edu.likelion.project.day10072024;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        System.out.println("Giai thừa của " + number + " là: "
            + factorial(number));
    }

    private static int factorial(int n) {
        // nếu n = 0 hoặc n = 1 thì trả về 1
        if (n == 0 || n == 1) return 1;
        // đệ quy factorial cho n - 1 và nhân với n
        return n * factorial(n-1);
    }
}
