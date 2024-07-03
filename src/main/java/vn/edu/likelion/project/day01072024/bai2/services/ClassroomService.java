package vn.edu.likelion.project.day01072024.bai2.services;

import vn.edu.likelion.generic.IGenericService;
import vn.edu.likelion.helpers.Input;
import vn.edu.likelion.project.day01072024.bai2.DB;
import vn.edu.likelion.project.day01072024.bai2.models.Classroom;
import vn.edu.likelion.project.day01072024.bai2.models.Student;

import java.util.List;

public class ClassroomService implements IGenericService<Classroom> {
    @Override
    public void inputConsole() {
        Classroom classroom = new Classroom();
        System.out.print("Input classroom name: ");
        classroom.setName(Input.inputString());
        insert(classroom);
    }

    @Override
    public void inputConsoleMany() {
        System.out.print("Input number of classrooms: ");
        for (int i = 0; i< Input.inputInt(); i++){
            System.out.println("Classroom #" + ++i);
            inputConsole();
        }
    }

    @Override
    public List<Classroom> findAll() {
        if (!DB.classrooms.isEmpty()){
            for (Classroom classroom : DB.classrooms){
                classroom.show();
            }
            return DB.classrooms;
        }else {
            System.out.println("List of classrooms is empty");
            return null;
        }
    }

    @Override
    public Classroom findOne(String id) {
        for (Classroom c : DB.classrooms) {
            if (id.equals(c.getId())) {
                c.show();
                return c;
            }
        }
        throw new RuntimeException("Classroom with id " + id + " does not exits.");
    }

    @Override
    public Classroom insert(Classroom classroom) {
        if (DB.classrooms.add(classroom)){
            return classroom;
        }else {
            throw new RuntimeException("Insert classroom failed.");
        }
    }

    @Override
    public boolean delete(String id) {
        for (Classroom c : DB.classrooms) {
            if (c.getId().equals(id)) {
                return DB.students.remove(c);
            }
        }
        throw new RuntimeException("Classroom with id " + id + " does not exits.");
    }
}
