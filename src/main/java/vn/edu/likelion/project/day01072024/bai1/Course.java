package vn.edu.likelion.project.day01072024.bai1;

import java.util.ArrayList;
import java.util.List;

public class Course implements Display {
    private int courseId;
    private String courseName;
    private String mentorName;
    private int credit;
    private List<Student> studentList;

    public Course() {
    }

    public Course(int courseId, String courseName, String mentorName, int credit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.mentorName = mentorName;
        this.credit = credit;
        this.studentList = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public void displayDetailCourse() {
        Display.super.displayDetailCourse();
        System.out.println("Course Id: " + this.courseId);
        System.out.println("Course Name: " + this.courseName);
        System.out.println("Mentor Name: " + this.mentorName);
        System.out.println("Credit: " + this.credit);
    }

    @Override
    public void displayStudent() {
        for (Student s : this.studentList) {
            System.out.println("---------------------------");
            s.displayStudent();
        }
    }
}
