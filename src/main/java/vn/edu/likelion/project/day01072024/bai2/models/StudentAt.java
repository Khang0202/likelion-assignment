package vn.edu.likelion.project.day01072024.bai2.models;

import java.time.LocalDate;

public class StudentAt {
    //only in class
    private static int numOfStudentRegistered = 0;
    private static final String staticName = "TABLE";
    //can get
    private final Student student;
    private final String studentId;
    private String tableId;

    public StudentAt(Classroom classroom, Student student) {
        this.student = student;
        this.tableId = generateTableId(classroom);
        this.studentId = generateStudentId(classroom);
    }

    //số lượng học viên đã đăng ký
    public static int getNumOfStudentRegistered() {
        return numOfStudentRegistered;
    }

    //lấy ra học sinh đã đăng ký
    public Student getStudent() {
        return student;
    }

    //lấy thông id học sinh khi đã đăng ký
    public String getStudentId() {
        return studentId;
    }

    //lấy ra bàn học của học sinh trong lớp
    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    private String generateTableId(Classroom classroom) {
        return classroom.getId() + "-" + staticName + "-" + String.format("%02d", Classroom.getNumOfTable());
    }

    private String generateStudentId(Classroom classroom) {
        return "K"
                //gán năm học vào id
                + String.format("%03d", LocalDate.now().getYear() % 100)
                + "-"
                //gán id của lớp vào id
                + classroom.getId().substring(classroom.getId().lastIndexOf("-") + 1)
                + "-"
                + String.format("%04d", ++numOfStudentRegistered);

    }

    public void show() {
        student.show();
        System.out.println("ID Student in class: " + studentId);
        System.out.println("Table ID: " + tableId);
    }
}
