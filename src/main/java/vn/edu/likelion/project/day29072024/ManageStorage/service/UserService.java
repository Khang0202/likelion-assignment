package vn.edu.likelion.project.day29072024.ManageStorage.service;

import vn.edu.likelion.project.day29072024.ManageStorage.ConnectDB;
import vn.edu.likelion.project.day29072024.ManageStorage.LocalDB;
import vn.edu.likelion.project.day29072024.ManageStorage.model.Permission;
import vn.edu.likelion.project.day29072024.ManageStorage.model.Role;
import vn.edu.likelion.project.day29072024.ManageStorage.model.Storage;
import vn.edu.likelion.project.day29072024.ManageStorage.model.User;
import vn.edu.likelion.project.day29072024.ManageStorage.utils.Input;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class UserService {
    public static User login(String username, String password) {
        System.out.println("Logging, Please wait.");
        User user = new User();
        StringBuilder query = new StringBuilder("select u.id, u.username, u.password, u.storage_id, s.name,r.id, r.name from tbl_user u ");
        query.append("INNER JOIN tbl_role r on u.role_id = r.id ");
        query.append("LEFT JOIN tbl_storage s on u.storage_id = s.id ");
//        query.append("INNER JOIN tbl_role_permission on tbl_user.role_id = tbl_role_permission.role_id ");
//        query.append("INNER JOIN tbl_permission on tbl_permission.id = tbl_role_permission.permission_id ");
        query.append(" where username=? and password=?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())){
            ps.setString(1, username);
            ps.setString(2, Base64.getEncoder().encodeToString(password.getBytes()));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                if (rs.getString(4) != null) {//storage_id
                    user.setStorage(new Storage(rs.getInt(4), rs.getString(5)));
                }
                user.setRole(new Role(rs.getInt(6), rs.getString(7)));
                rs.close();
                ps.close();
                ConnectDB.closeConnection();
                LocalDB.localUser = user;
                getUserPermissions();
                LocalDB.localUser.getStorage().setProducts(StorageService.getProductsByStorageId(LocalDB.localUser.getStorage().getId()));
                return user;
            }else {
                rs.close();
                ps.close();
                ConnectDB.closeConnection();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static List<Permission> getUserPermissions() {
        StringBuilder query = new StringBuilder("select p.* from tbl_role r ");
        query.append("INNER JOIN tbl_role_permission rp on r.id = rp.role_id ");
        query.append("INNER JOIN tbl_permission p on p.id = rp.permission_id ");
        query.append("WHERE r.id  = ?");
        List<Permission> permissions = new ArrayList<Permission>();
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())){
            if (LocalDB.localUser != null) {
                ps.setInt(1, LocalDB.localUser.getRole().getId());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    permissions.add(new Permission(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
                rs.close();
                ps.close();
                ConnectDB.closeConnection();
            }else {
                ps.close();
                ConnectDB.closeConnection();
            }
            LocalDB.localUser.setPermissions(permissions);
            return permissions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void insertUser(User user) {
        StringBuilder query = new StringBuilder("INSERT INTO tbl_user(username, password, role_id, storage_id) VALUES (?, ?, ?, ?)");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())) {
            ps.setString(1, user.getUsername());
            ps.setString(2, Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
            ps.setInt(3, user.getRole().getId());
            ps.setInt(4, user.getStorage().getId());

            if (ps.executeUpdate() > 0) {
                System.out.println("Inserted successfully");
            }

            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Role> getAllRole() {
        StringBuilder query = new StringBuilder("Select * from tbl_role");
        List<Role> roles = new ArrayList<>();
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                roles.add(new Role(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            return roles;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void insertUser(){
        System.out.println("Inserting user...");
        List<Storage> storages = StorageService.getFreeStorage();
        if (storages.size() > 0){
            for (Storage storage : storages){
                storage.show();
            }
            System.out.println("Input username: ");
            String username = Input.inputString();
            System.out.println("Input password: ");
            String password = Input.inputString();
            for (Role r : getAllRole()){
                r.show();
            }
            System.out.println("Input role id: ");
            int roleId = Input.inputInt();
            System.out.println("Input id of Storage");
            int storageId = Input.inputInt();
            insertUser(new User(username, password, new Storage(storageId, null), new Role(roleId)));
        }else
            System.out.println("None free storage to add user");
    }

    private static void updateUser(User user) {
        StringBuilder query = new StringBuilder("UPDATE tbl_user SET");
        int countAppend = 0;
        if (user.getUsername() != null) {
            query.append(" username =?,");
            countAppend++;
        }
        if (user.getPassword() != null) {
            query.append(" password=?,");
            countAppend++;
        }
        if (user.getRole() != null) {
            query.append(" role_id=?,");
            countAppend++;
        }
        if (user.getStorage() != null) {
            query.append(" storage_id=?,");
            countAppend++;
        }
        query.append(" WHERE id=?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())) {
            for (int i = 1; i <= countAppend; i++){
                switch (i){
                    case 1:
                        ps.setString(i, user.getUsername());
                        break;
                    case 2:
                        ps.setString(i, user.getPassword());
                        break;
                    case 3:
                        ps.setInt(i, user.getRole().getId());
                        break;
                    case 4:
                        ps.setInt(i, user.getStorage().getId());
                        break;
                    default:
                        System.out.println("Invalid insert statement");
                        break;
                }
            }
            ps.setInt(++countAppend, user.getId());

            if (ps.executeUpdate() > 0) {
                System.out.println("Update successfully");
            }
            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(){
        System.out.println("Updating user...");
        System.out.println("Input username: ");
        String username = Input.inputString();
        System.out.println("Input password: ");
        String password = Input.inputString();
        getAllRole();
        System.out.println("Input role id: ");
        int roleId = Input.inputInt();
        StorageService.getFreeStorage();
        System.out.println("Input id of Storage: ");
        int storageId = Input.inputInt();
        updateUser(new User(username, password, new Storage(storageId, null), new Role(roleId)));

    }

    public static void getAll(){
        StringBuilder query = new StringBuilder("Select * from tbl_user");
        List<User> users = new ArrayList<>();

        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                users.add(new User(rs.getInt(1), rs.getString(2),rs.getString(3), new Storage(rs.getInt(5),""), new Role(rs.getInt(4),"")));
            }
            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            for (User user : users){
                user.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteUser(int id){
        StringBuilder query = new StringBuilder("DELETE FROM tbl_user WHERE id=?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())) {
            if (  ps.executeUpdate() > 0) {
                System.out.println("Delete successfully");
            }
            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
