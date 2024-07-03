package vn.edu.likelion.day03072024;

public class Bai1 {

    @FunctionalInterface
    public interface SoNguyenTo {
        boolean isSoNguyenTo(int so);
    }

    @FunctionalInterface
    public interface UocLonNhat {
        void uocNguyenToLonNhat(int so);
    }

    public static void main(String[] args) {
        SoNguyenTo soNguyenTo = (n)-> {
            //chia hết trong khoảng từ 2 cho tới căn n thì n không phải là số nguyên số
            for (int i=2;i<=Math.sqrt(n);i++){
                if (n%i==0) return false;
            }
            //0, 1 không là số nguyên tố
            return n>1;
        };

        UocLonNhat uocLonNhat = (n) -> {
            System.out.println("Number: " + n);
            for (int i = n; i>=2;i--) {
                if (n%i==0 && soNguyenTo.isSoNguyenTo(i)){
                    System.out.println("Largest prime factor: " + i);
                    break;
                }
            }
        };

        uocLonNhat.uocNguyenToLonNhat(176);
        uocLonNhat.uocNguyenToLonNhat(36);


    }
}
