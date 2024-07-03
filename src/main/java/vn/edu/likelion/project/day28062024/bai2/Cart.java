package vn.edu.likelion.project.day28062024.bai2;

import vn.edu.likelion.helpers.DoubleFormat;

import java.util.ArrayList;

public class Cart {
    ArrayList<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    boolean addToCart(Product p) {
        return this.products.add(p);
    }

    void totalPrice() {
        double total = 0;
        for (Product p : this.products) {
            total += p.getPrice();
        }
        System.out.println("Total price: " + DoubleFormat.format(total));
    }

    void showProduct() {
        for (Product p : this.products) {
            p.show();
        }
    }
}
