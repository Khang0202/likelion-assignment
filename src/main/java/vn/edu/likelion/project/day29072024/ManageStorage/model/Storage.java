package vn.edu.likelion.project.day29072024.ManageStorage.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Storage {
    private int id;
    @NonNull
    private String name;
    private List<Product> products = new ArrayList<>();

    public Storage(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void show() {
        System.out.println("Storage ID: " + id);
        System.out.println("Storage Name: " + name);
        System.out.println("Total Products: " + products.stream().mapToInt(Product::getCount).sum());
        System.out.println("---------------------------------");
        if (products.size() > 0) {
            for (Product product : products) {
                product.setAttributes(product.getAttributes());
                product.show();
            }
        }

    }
}
