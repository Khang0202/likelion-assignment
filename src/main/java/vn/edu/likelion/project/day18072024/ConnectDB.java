package vn.edu.likelion.project.day18072024;

import vn.edu.likelion.project.day19072024.model.Users;

import java.sql.*;

public class ConnectDB {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//localhost:1521/schooldb";
        String user = "schooldb_admin";
        String password = "0";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Users users = new Users("test4", "pass", "test", "1");

            String query = "INSERT INTO users (USERNAME, PASSWORD, ROLE_ID) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, users.getUsername());
                ps.setString(2, users.getPassword());
                ps.setString(4, users.getRoleId());

//                int rowsAffected = ps.executeUpdate();
                System.out.println("Rows affected: " + ps.executeUpdate());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
