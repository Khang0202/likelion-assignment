package vn.edu.likelion.company.models;

public abstract class NhanVien {
    private String name;
    private double salary;
    private int overtimeHours;
    private int hourlyRate;
    private int bonus;

    public NhanVien() {
    }

    public NhanVien(String name, double salary, int overtimeHours, int hourlyRate) {
        this.name = name;
        this.salary = salary;
        this.overtimeHours = overtimeHours;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void displayInfo(){
        System.out.println("Base salary: " + this.salary);
        if (this.bonus > 0){
            System.out.println("Bonus: " + this.bonus);
        }
        if (this.overtimeHours < 0){
            System.out.println("Overtime hours: " + this.overtimeHours);
            System.out.println("Hourly rate: " + this.hourlyRate);
        }
        System.out.println("Total salary: " + calculateSalary());

    }
    public double calculateSalary() {
        double salary = this.salary;
        if (this.bonus > 0){
            salary += this.bonus;
        }
        if (this.overtimeHours > 0){
            salary += this.overtimeHours*this.hourlyRate;
        }
        return salary;
    }
}
