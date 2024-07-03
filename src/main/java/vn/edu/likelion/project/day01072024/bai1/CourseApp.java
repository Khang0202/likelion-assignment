package vn.edu.likelion.project.day01072024.bai1;

public class CourseApp {
    public static void main(String[] args) {
        Course course1 = new Course(1, "học ké", "mắm", 120000);
        Course course2 = new CourseOnline(1, "học online", "mắm 2", 15000, "zoom", 60);

        course1.getStudentList().add(new Student(1, "name1"));
        course1.getStudentList().add(new Student(2, "name2"));
        course1.getStudentList().add(new Student(3, "name3"));
        course1.getStudentList().add(new Student(4, "name4"));
        course1.getStudentList().add(new Student(5, "name5"));

        course2.getStudentList().add(new Student(6, "name6"));
        course2.getStudentList().add(new Student(7, "name7"));
        course2.getStudentList().add(new Student(8, "name8"));
        course2.getStudentList().add(new Student(9, "name9"));
        course2.getStudentList().add(new Student(10, "name10"));
        course2.getStudentList().add(new Student(11, "name11"));

        course1.displayDetailCourse();
        course1.displayStudent();

        System.out.println(">-----------Course Online------------<");
        course2.displayDetailCourse();
        course2.displayStudent();
    }
}
