package vn.edu.likelion.project.day19072024.service;

import vn.edu.likelion.project.day19072024.ConnectDB;
import vn.edu.likelion.project.day19072024.model.Student;
import vn.edu.likelion.project.day19072024.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IService<Student> {
    @Override
    public List<Student> getAll() {
        String query = "SELECT * FROM Student";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student resultEach = new Student();
                resultEach.setId(rs.getString(1));
                resultEach.setName(rs.getString(2));
                students.add(resultEach);
            }

            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student get(int id) {
        String query = "SELECT * FROM Student WHERE id = ?";
        Student result = new Student();
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.setId(rs.getString(1));
                result.setName(rs.getString(2));

            }
            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Student student) {
        String query = "INSERT INTO Student (NAME) VALUES (?)";
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ps.setString(1, student.getName());
            if (ps.executeUpdate() > 0) {
                ps.close();
                ConnectDB.closeConnection();
                return true;
            }
            ps.close();
            ConnectDB.closeConnection();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectDB.closeConnection();
        }
    }

    @Override
    public boolean update(Student student) {
        String query = "UPDATE Student SET NAME=? WHERE ID = ?";
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getId());

            if (ps.executeUpdate() > 0) {
                return true;
            }
            ps.close();
            ConnectDB.closeConnection();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}