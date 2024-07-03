package vn.edu.likelion.project.day01072024.bai1;

public class Student {
    private int studentId;
    private String name;

    public Student() {
    }

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Student Name: " + this.name);
    }
}
