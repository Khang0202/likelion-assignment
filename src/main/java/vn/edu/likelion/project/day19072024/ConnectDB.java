package vn.edu.likelion.project.day19072024;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static String url = "jdbc:oracle:thin:@//localhost:1521/schooldb";
    public static  String user = "schooldb_admin";
    public static  String password = "0";
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            con = DriverManager
                    .getConnection(url, user, password);
            if (con.isClosed()) {
                con.close();
            }
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
