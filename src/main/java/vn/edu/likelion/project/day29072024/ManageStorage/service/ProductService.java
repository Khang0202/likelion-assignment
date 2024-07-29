package vn.edu.likelion.project.day29072024.ManageStorage.service;

import vn.edu.likelion.project.day29072024.ManageStorage.ConnectDB;
import vn.edu.likelion.project.day29072024.ManageStorage.LocalDB;
import vn.edu.likelion.project.day29072024.ManageStorage.model.Attribute;
import vn.edu.likelion.project.day29072024.ManageStorage.model.Product;
import vn.edu.likelion.project.day29072024.ManageStorage.utils.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static void getAll() {
        StringBuilder query = new StringBuilder("SELECT * FROM tbl_product");
        query.append(" ORDER BY id");
        List<Product> products = new ArrayList<>();
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(4),rs.getInt(3)));
            }
            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            LocalDB.localProducts = products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showAllProduct() {
        getAll();
        for (Product product : LocalDB.localProducts) {
            product.show();
        }
    }
    private static Product insertProduct(Product product) {
        StringBuilder query = new StringBuilder("INSERT INTO tbl_product(name, count, STORAGE_ID) VALUES (?,?,?);");
        query.append("SELECT MAX(id) FROM tbl_product;");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())){
            ps.setString(1, product.getName());
            ps.setInt(2, product.getCount());
            ps.setInt(3, product.getStorageId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product.setId(rs.getInt(1));
            }
            ps.close();
            ConnectDB.closeConnection();
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void insertMultiAttribute(List<Attribute> attributes) {
        StringBuilder query = new StringBuilder("INSERT INTO tbl_attribute(name, PRODUCT_ID) VALUES (?,?);");
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query.toString());){
            for (Attribute attribute : attributes) {
                ps.setString(1, attribute.getName());
                ps.setInt(2, attribute.getProductId());
                ps.addBatch();
            }
            int[] rs = ps.executeBatch();
            conn.commit();

            if (rs.length > 0) {
                System.out.println("Inserted Successfully. Total rows affected: " + rs.length);
            }

            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateProduct(Product product) {
        StringBuilder query = new StringBuilder("UPDATE tbl_product SET name = ?, count = ?, STORAGE_ID = ? WHERE id = ?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())){
            ps.setString(1, product.getName());
            ps.setInt(2, product.getCount());
            ps.setInt(3, product.getStorageId());
            ps.setInt(4, product.getId());
            if (ps.executeUpdate() > 0) {
                System.out.println("Updated Successfully.");
            }
            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateAttribute(Attribute attribute) {
        StringBuilder query = new StringBuilder("UPDATE tbl_attribute SET name = ? WHERE id = ?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())) {
            ps.setString(1, attribute.getName());
            ps.setInt(2, attribute.getId());
            if (ps.executeUpdate() > 0) {
                System.out.println("Updated Successfully.");
            }
            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update(int id) {
        System.out.println("Updating product...");
        System.out.println("Input product name: ");
        String name = Input.inputString();
        System.out.println("Input product count: ");
        int count = Input.inputInt();
        System.out.println("Input product storage id: ");
        int storageId = Input.inputInt();
        updateProduct(new Product(id, name, count, storageId));
    }
    public static void addProduct() {
        System.out.println("Inserting product...");
        System.out.println("Input product name: ");
        String name = Input.inputString();
        System.out.println("Input product count: ");
        int count = Input.inputInt();
        System.out.println("Input product storage id: ");
        int storageId = Input.inputInt();
        Product product = insertProduct(new Product(name, count, storageId));
        addAttribute(product.getId());
    }
    public static void deleteProduct() {
        System.out.println("Deleting product...");
        showAllProduct();
        System.out.println("Input id product to delete: ");
        int id = Input.inputInt();
        StringBuilder query = new StringBuilder("DELETE FROM tbl_product WHERE id = ?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())){
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("Deleted Successfully.");
            }
            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Product get(int id) {
        StringBuilder query = new StringBuilder("Select * from tbl_product where id = ?");
        Product product = null;
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(3));
            }
            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            return product;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void addAttribute(int productId){
        System.out.println("Input the number of attribute: ");
        int num = Input.inputInt();
        List<Attribute> attributes = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.println("Input attribute string: ");
            attributes.add(new Attribute(Input.inputString(), productId));
        }
        insertMultiAttribute(attributes);
    }
    public static void deleteAttribute(int id) {
        StringBuilder query = new StringBuilder("delete from tbl_attribute where id = ?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())){
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("Deleted Successfully.");
            }
            ps.close();
            ConnectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
