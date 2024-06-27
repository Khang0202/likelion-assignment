package vn.edu.likelion.moveall0toend;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 0,1,5,6,0,3,5,9,0,8,7,9,0 };
        int[] res = moveAll0ToEnd(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+", ");
        }
    }

    public static int[] moveAll0ToEnd(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == 0) {
                for (int j = i+1; j < arr.length; j++) {
                    arr[j-1] = arr[j];
                }
            }
        }
        return arr;
    }
}
