package vn.edu.likelion.project.day01072024.bai2.models;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private static final int numOfTable = 0;
    private static int numOfClassrooms = 0;
    private static final String staticName = "CLASS";
    private final String id;
    private String name;

    /**
     * MAX 10
     */
    private final List<StudentAt> students;

    public Classroom() {
        this.id = staticName + String.format("-%03d", ++numOfClassrooms);
        this.students = new ArrayList<>();
    }

    public Classroom(String name) {
        this.id = staticName + String.format("-%03d", ++numOfClassrooms);
        this.name = name;
        this.students = new ArrayList<>();
    }

    public static int getNumOfTable() {
        return numOfTable;
    }

    public static int getNumOfClassrooms() {
        return numOfClassrooms;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<StudentAt> getStudents() {
        return students;
    }

    public static void setNumOfClassrooms(int numOfClassrooms) {
        Classroom.numOfClassrooms = numOfClassrooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Classroom ID: " + id);
        System.out.println("Classname: " + name);
        if (students.size() > 0) {
            System.out.println("--------List student of class--------");
            for (StudentAt st : students) {
                st.show();
            }
        }
    }
}
