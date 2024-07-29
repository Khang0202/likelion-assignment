package vn.edu.likelion.project.day29072024.ManageStorage.model;

import lombok.*;
import vn.edu.likelion.ManageStorage.ConnectDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {
    private int id;
    @NonNull
    private String name;
    @NonNull
    private int count;
    @NonNull
    private int storageId;
    private List<Attribute> attributes = new ArrayList<>();

    public Product(int id, String name, int count, int storageId) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.storageId = storageId;
    }

    public void show() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Product Count: " + count);
        getAttribute();
        if (attributes.size() > 0) {
            for (Attribute attribute : attributes) {
                attribute.show();
            }
        }
        System.out.println("------------------------------");
    }

    public List<Attribute> getAttribute() {
        StringBuilder query = new StringBuilder("select a.* from tbl_attribute a ");
        query.append("INNER JOIN tbl_product p on a.product_id = p.id ");
        query.append("WHERE p.id = ?");
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement(query.toString())){
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            List<Attribute> attributes = new ArrayList<Attribute>();
            while (rs.next()) {
                attributes.add(new Attribute(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
            rs.close();
            ps.close();
            ConnectDB.closeConnection();
            this.attributes = attributes;
            return attributes;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
