package vn.edu.likelion.project.day10072024;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        int x = 23;
        System.out.println("Vị trí của giá trị "
                + x + " = " + binarySearch1(arr, x));
    }

    private static int binarySearch1(int[] arr, int x) {
        // xác định cái phạm vi tìm kiếm từ index - 0 đến arr.length - 1
        int left = 0;
        int right = arr.length - 1;

        // sử dụng vòng lặp để lặp từ left qua right tới khi ko còn gì để lặp
        while (left <= right) {
            // lấy phần tử ở giữa mảng
            int mid = (left + right) / 2;

            // so sánh giá trị cần tìm vs phần tử ở giữa
            if (arr[mid] == x) {
                return mid;
            }

            // nếu phần tử cần tìm nhỏ hơn phần ở giữa, thì tìm bên trái
            if (arr[mid] > x) {
                right = mid - 1;
            } else {
                // nếu phần tử cần tìm lớn hơn mid, thì tìm bên phải
                left = mid + 1;
            }
        }
        // ko tìm thấy phần tử nào khớp thì trả về -1
        return -1;
    }
}
