package vn.edu.likelion.project.day26062024.company.models;

public class QuanLy extends NhanVien {

    public QuanLy(String name, double salary, int overtimeHours, int hourlyRate) {
        super(name, salary, overtimeHours, hourlyRate);
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Manager name: " + super.getName());
        super.displayInfo();
    }
}
