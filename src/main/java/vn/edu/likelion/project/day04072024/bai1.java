package vn.edu.likelion.project.day04072024;

public class bai1 {

    @FunctionalInterface
    public interface CheckPalindrome{
        boolean checkPalindrome(String str);
    }

    public static void main(String[] args) {
        CheckPalindrome obj = bai1::checkPalindrome;

        obj.checkPalindrome("Madam");
        obj.checkPalindrome("radar");
        obj.checkPalindrome("defied");
    }

    public static boolean checkPalindrome(String str) {
        System.out.print(str + " is a palindrome? ");
        int n = str.length();
        int start = 0;
        int end = n - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println(isPalindrome);
        return isPalindrome;
    }
}
