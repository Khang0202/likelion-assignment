package vn.edu.likelion.project.day03072024;

public class Test {

    @FunctionalInterface
    public interface MRInterface {
        int timXY(int x, int y);
    }

    public static int tinhTong(int x, int y) {
        return x + y;
    }

    public static int toDo(int x, int y, MRInterface s) {
        return s.timXY(x, y);
    }

    public static void main(String[] args) {
        MRInterface a = (x, y) -> tinhTong(x, y);

        System.out.println(toDo(10, 10, a));
    }
}
