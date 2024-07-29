package vn.edu.likelion.project.day29072024.ManageStorage.service;

import vn.edu.likelion.project.day29072024.ManageStorage.ConnectDB;
import vn.edu.likelion.project.day29072024.ManageStorage.LocalDB;
import vn.edu.likelion.project.day29072024.ManageStorage.model.Product;
import vn.edu.likelion.project.day29072024.ManageStorage.model.Storage;
import vn.edu.likelion.project.day29072024.ManageStorage.utils.Input;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageService {
    public static void showSelfInfo() {
        LocalDB.localUser.getStorage().show();
    }

    public static void addStorage() {
        System.out.println("Input Storage Name:");
        insertStorage(new Storage(Input.inputString()));
    }

    private static void insertStorage(Storage storage) {
        String query = "INSERT INTO tbl_storage(name) VALUES (?)";
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query)){
            ps.setString(1, storage.getName());
            if (ps.executeUpdate() > 0) {
                System.out.println("Inserted Successfully");
            }
            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStorageNameByStorageId(int storageId, String name) {
        StringBuilder query = new StringBuilder("UPDATE tbl_storage SET name = ? WHERE id = ?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())){
            ps.setString(1, name);
            ps.setInt(2, storageId);
            if (ps.executeUpdate() > 0) {
                System.out.println("Updated Successfully");
            }
            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Product> getProductsByStorageId(int storageId) {
        StringBuilder query = new StringBuilder("select * from tbl_product WHERE storage_id = ?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())){
            ps.setInt(1, storageId);
            ResultSet rs = ps.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                products.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(4),
                        rs.getInt(3)));
            }
            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void getAll() {
        StringBuilder query = new StringBuilder("SELECT * FROM tbl_storage");
        query.append(" ORDER BY id");
        List<Storage> storages = new ArrayList<>();
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                storages.add(new Storage(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            for (Storage storage : storages) {
                storage.setProducts(getProductsByStorageId(storage.getId()));
            }
            LocalDB.localStorage = storages;
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void showAllStorage() {
        getAll();
        for (Storage storage : LocalDB.localStorage){
            storage.show();
        }
    }

    public static void deleteStorage() {
        System.out.println("Deleting Storage...");
        showAllStorage();
        System.out.println("Input Storage Id To Delete: ");
        int storageId = Input.inputInt();
        if (getProductsByStorageId(storageId).size() > 0) {
            System.out.println("You need move all products before deleting Storage");
            showAllStorage();
            System.out.println("Input Storage Id to move: ");
            int changeId = Input.inputInt();
            List<Product> products = getProductsByStorageId(storageId);
            for (Product product : products) {
                product.setStorageId(changeId);
                ProductService.updateProduct(product);
            }
        }
        StringBuilder query = new StringBuilder("DELETE FROM tbl_storage WHERE id = ?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())){
            ps.setInt(1, storageId);
            if (ps.executeUpdate() > 0) {
                System.out.println("Deleted Successfully");
            }
            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static List<Storage> getFreeStorage(){
        List<Storage> storages = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT tbl_storage.* FROM tbl_storage");
        query.append(" LEFT JOIN tbl_user on tbl_user.id = tbl_storage.id");
        query.append(" WHERE tbl_user.storage_id is null");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                storages.add(new Storage(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            return storages;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
