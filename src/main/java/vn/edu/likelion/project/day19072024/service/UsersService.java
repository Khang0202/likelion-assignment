package vn.edu.likelion.project.day19072024.service;

import vn.edu.likelion.project.day19072024.ConnectDB;
import vn.edu.likelion.project.day19072024.TempData;
import vn.edu.likelion.project.day19072024.helper.Encode;
import vn.edu.likelion.project.day19072024.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersService implements IService<Users> {
    @Override
    public List<Users> getAll() {
        String query = "SELECT * FROM users";
        List<Users> users = new ArrayList<>();
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users resultEach = new Users();
                resultEach.setId(rs.getString(1));
                resultEach.setUsername(rs.getString(2));
                resultEach.setPassword(rs.getString(3));
                resultEach.setRoleId(rs.getString(4));
                users.add(resultEach);
            }

            rs.close();
            ConnectDB.closeConnection();
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Users get(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        Users result = new Users();
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.setId(rs.getString(1));
                result.setUsername(rs.getString(2));
                result.setPassword(rs.getString(3));
                result.setRoleId(rs.getString(4));
                rs.close();
            }

            ConnectDB.closeConnection();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Users users) {
        String query = "INSERT INTO users (USERNAME, PASSWORD, ROLE_ID) VALUES (?, ?, ?)";
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ps.setString(1, users.getUsername());
            ps.setString(2, Encode.encode(users.getPassword()));
            ps.setString(3, users.getRoleId());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            ConnectDB.closeConnection();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Users users) {
        String query = "UPDATE Users SET USERNAME = ?, PASSWORD = ?, ROLE_ID = ? WHERE ID = ?";
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getPassword());
            ps.setString(3, users.getRoleId());
            ps.setString(4, users.getId());

            if (ps.executeUpdate() > 0) {
                return true;
            }

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

    public Users getByUsername(String username) {
        String query = "SELECT * FROM users WHERE USERNAME = ?";
        Users result = new Users();
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.setId(rs.getString(1));
                result.setUsername(rs.getString(2));
                result.setPassword(rs.getString(3));
                result.setRoleId(rs.getString(4));
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

    public void login(String username, String password) {
        Users users = getByUsername(username);
        if (users != null) {
            if (Encode.decode(users.getPassword()).equals(password)) {
                TempData.loginer = users;
                System.out.println("Login Success");
            } else {
                System.out.println("Wrong password");
            }
        } else {
            System.out.println("Login Failed");
        }
    }

    public void register(String username, String password) {
        if(save(new Users(username, password, "4"))){
            System.out.println("Register Success");
        }else {
            System.out.println("Register Failed");
        }
    }

}
