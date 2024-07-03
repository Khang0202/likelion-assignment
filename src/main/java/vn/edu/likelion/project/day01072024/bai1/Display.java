package vn.edu.likelion.project.day01072024.bai1;

public interface Display {
    default void displayDetailCourse() {
        System.out.println("-----------------Course Detail--------------------");
    }

    void displayStudent();


}
