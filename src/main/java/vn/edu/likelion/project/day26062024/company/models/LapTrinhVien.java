package vn.edu.likelion.project.day26062024.company.models;

public class LapTrinhVien extends NhanVien {
    public LapTrinhVien(String name, double salary, int overtimeHours, int hourlyRate) {
        super(name, salary, overtimeHours, hourlyRate);
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Developer name: " + super.getName());
        super.displayInfo();
    }
}
