package vn.edu.likelion.project.day19072024.service;

import vn.edu.likelion.project.day19072024.ConnectDB;
import vn.edu.likelion.project.day19072024.model.Role;
import vn.edu.likelion.project.day19072024.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleService implements IService<Role> {
    @Override
    public List<Role> getAll() {
        String query = "SELECT * FROM Role";
        List<Role> roles = new ArrayList<>();
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role resultEach = new Role();
                resultEach.setId(rs.getString(1));
                resultEach.setName(rs.getString(2));
                roles.add(resultEach);
            }

            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            return roles;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Role get(int id) {
        String query = "SELECT * FROM Role WHERE id = ?";
        Role result = new Role();
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
    public boolean save(Role role) {
        String query = "INSERT INTO Role (NAME) VALUES (?)";
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ps.setString(1, role.getName());
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
    public boolean update(Role role) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
