package vn.edu.likelion.day28062024.bai2;

import java.util.ArrayList;

public class Cart {
    ArrayList<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    boolean addToCart(Product p){
        return this.products.add(p);
    }
    void totalPrice(){
        double total = 0;
        for(Product p : this.products){
            total += p.getPrice();
        }
        System.out.println("Total price: " + total);
    }

    void showProduct(){
        for(Product p : this.products){
            p.show();
        }
    }
}
