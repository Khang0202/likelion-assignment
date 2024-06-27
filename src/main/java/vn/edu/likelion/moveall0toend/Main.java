package vn.edu.likelion.moveall0toend;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 0,1,5,6,0,3,5,9,0,8,7,9,0 };
        System.out.println("Input:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        moveAll0ToEnd(arr);
        System.out.println();
        System.out.println("Output:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }

    public static void moveAll0ToEnd(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == 0) {
                for (int j = i+1; j < arr.length; j++) {
                    arr[j-1] = arr[j];
                }
                arr[arr.length-1] = 0;
            }
        }
    }
}
