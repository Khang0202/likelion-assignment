package vn.edu.likelion.project.day28062024.bai2;

import vn.edu.likelion.helpers.DoubleFormat;

public class Product {
    static final String storeName = "ABC Store";
    int productId;
    String productName;
    double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void show() {
        System.out.println(
                "Product ID: " + productId +
                        "\nProduct Name: " + productName +
                        "\nPrice: " + DoubleFormat.format(price) +
                        "\nStore Name: " + storeName
        );
    }
}
