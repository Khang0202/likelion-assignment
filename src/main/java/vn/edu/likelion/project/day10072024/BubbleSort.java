package vn.edu.likelion.project.day10072024;

import java.util.Arrays;

public class BubbleSort {

    public static  void main(String[] args) {
        int[] arr = {7, 2, 9, 6, 4};
        System.out.println("Mảng gốc: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Mảng say khi sắp xếp bubble sort: "
                + Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        // Duyệt toàn bộ phần tử trong mảng
        // Ko cần duyệt phần tử cuối cùng nên i < arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            // Ko cần duyệt phần tử đã đc đưa về cuối mảng
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // Trường hợp phần tử phía trước lớn hơn phần tử liền kề
                // Thì hoán đổi vị trí cho nhau
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
