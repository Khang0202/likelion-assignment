package vn.edu.likelion.project.day03072024;

public class Bai2 {
    @FunctionalInterface
    public interface DangNhiPhan {
        void chuyenDangNhiPhan(int so);
    }

    public static void main(String[] args) {
        DangNhiPhan dangNhiPhan = (n) -> {
            System.out.println("Number: " + n);
            long soNhiPhan = 0;
            int p = 0;
            //tính cho đến khi n = 0
            while (n != 0) {
                //số nhị phân = chính nó cộng cho số dư của n/2 nhân 10^p tính từ lúc bắt đầu
                //ví dụ 8 / 2 dư 0, số nhị phân bằng 0 + 8%2 * 10^0 = 0, n/2
                //4/2 dư 0, số nhị phân bằng 0 + 8%2 * 10^1 = 00, n/2
                //2/2 dư 0, số nhị phân bằng 00 + 4%2 * 10^2 = 000, n/2
                //1/2 dư 1, số nhị phân bằng 000 + 1%2*10^3 = 1000, n/2 => 0,5 => kiểu int = 0
                soNhiPhan += (long) ((n % 2) * Math.pow(10, p++));
                n /= 2;
            }
            System.out.println("Binary representation: " + soNhiPhan);
        };

        dangNhiPhan.chuyenDangNhiPhan(747);

    }
}
