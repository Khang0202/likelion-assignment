package vn.edu.likelion.project.day19072024.service;

import vn.edu.likelion.generic.IGenericService;
import vn.edu.likelion.project.day19072024.model.Attendance;

import java.util.List;

public class AttendanceService implements IGenericService<Attendance> {
    @Override
    public void inputConsole() {

    }

    @Override
    public void inputConsoleMany() {

    }

    @Override
    public List<Attendance> findAll() {
        return List.of();
    }

    @Override
    public Attendance findOne(String id) {
        return null;
    }

    @Override
    public Attendance insert(Attendance attendance) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
