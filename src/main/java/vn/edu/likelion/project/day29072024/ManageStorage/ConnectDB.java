package vn.edu.likelion.project.day29072024.ManageStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static String url = "jdbc:oracle:thin:@//localhost:1521/mydb";
    public static  String user = "DB_MANAGE_STORAGE";
    public static  String password = "0";
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(url, user, password);
                return con;
            }else {
                con.close();
                getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection() {
        try {
            if (con != null || !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
