package vn.edu.likelion.project.day01072024.bai2.services;

import vn.edu.likelion.helpers.DateFormat;
import vn.edu.likelion.helpers.Input;
import vn.edu.likelion.project.day01072024.bai2.DB;
import vn.edu.likelion.project.day01072024.bai2.models.Student;
import vn.edu.likelion.generic.IGenericService;

import java.util.List;

public class StudentService implements IGenericService<Student> {
    @Override
    public void inputConsole() {
        Student student = new Student();
        System.out.print("Input student name: ");
        student.updateName(Input.inputString());
        System.out.println("Input with format: " + DateFormat.PATTERN);
        System.out.print("Input student date of birth: ");
        student.updateDateOfBirth(DateFormat.parseStringToLocalDate(Input.inputString()));
        System.out.print("Input student citizen identification: ");
        student.updateCitizenIdentification(Input.inputString());
        insert(student);
    }

    @Override
    public void inputConsoleMany() {
        System.out.print("Input number of students: ");
        for (int i = 0; i< Input.inputInt(); i++){
            System.out.println("Student #" + ++i);
            inputConsole();
        }
    }

    @Override
    public List<Student> findAll() {
        if (!DB.students.isEmpty()){
            for (Student student : DB.students){
                student.show();
            }
            return DB.students;
        }else {
            System.out.println("List of students is empty");
            return null;
        }
    }

    @Override
    public Student findOne(String id) {
        for (Student s : DB.students) {
            if (id.equals(s.getId())) {
                s.show();
                return s;
            }
        }
        throw new RuntimeException("Student with id " + id + " does not exits.");
    }

    @Override
    public Student insert(Student student) {
        if (DB.students.add(student)){
            return student;
        }else {
            throw new RuntimeException("Insert student failed.");
        }
    }

    @Override
    public boolean delete(String id) {
        for (Student s : DB.students) {
            if (s.getId().equals(id)) {
                return DB.students.remove(s);
            }
        }
        throw new RuntimeException("Student with id " + id + " does not exits.");
    }
}
