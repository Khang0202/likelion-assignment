package vn.edu.likelion.company;

import vn.edu.likelion.company.models.LapTrinhVien;
import vn.edu.likelion.company.models.NhanVien;
import vn.edu.likelion.company.models.QuanLy;

public class Main {
    public static void main(String[] args) {
        NhanVien ltv = new LapTrinhVien("abc", 5000, 20, 25);
        NhanVien ql = new QuanLy("quanly", 8000, 0,25);
        ltv.displayInfo();
        System.out.println("----------------------------------------");
        ql.displayInfo();
    }
}
