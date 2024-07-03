package vn.edu.likelion.project.day26062024.company;

import vn.edu.likelion.project.day26062024.company.models.LapTrinhVien;
import vn.edu.likelion.project.day26062024.company.models.NhanVien;
import vn.edu.likelion.project.day26062024.company.models.QuanLy;

public class Main {
    public static void main(String[] args) {
        NhanVien ltv = new LapTrinhVien("abc", 5000, 20, 25);
        NhanVien ql = new QuanLy("quanly", 8000, 0, 25);
        ltv.displayInfo();
        System.out.println("----------------------------------------");
        ql.displayInfo();
    }
}
