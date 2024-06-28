package vn.edu.likelion.day28062024.bai2;

import vn.edu.likelion.day28062024.bai1.Car;
import vn.edu.likelion.manageBank.helpers.DoubleFormat;

/**
 * • Bài tập tự luận 2:
 * Đề bài:
 * Viết một chương trình Java để quản lý thông tin về các mặt hàng trong cửa hàng. Hãy thực hiện các yêu cầu sau:
 * 1. Tạo một lớp Product với các thuộc tính int productId, String productName, double price, và static final String storeName = "ABC Store".
 * 2. Tạo một lớp Cart đại diện cho giỏ hàng với các thuộc tính là một mảng các đối tượng Product.
 * 3. Viết phương thức addToCart() để thêm một sản phẩm vào giỏ hàng.
 * 4. Viết phương thức totalPrice() để tính tổng giá trị của các sản phẩm trong giỏ hàng.
 * 5. Trong lớp ShoppingApp, viết phương thức main để:
 * • Khởi tạo vài đối tượng Product.
 * • Tạo một đối tượng Cart và thêm các sản phẩm vào giỏ hàng.
 * • Hiển thị thông tin của từng sản phẩm trong giỏ hàng, bao gồm productId, productName, price, cùng với tên cửa hàng storeName
 * • Tính và hiển thị tổng giá trị của giỏ hàng.
 */

public class ShoppingApp {
    public static void main(String[] args) {
        Cart c= new Cart();
        c.addToCart(new Product(1, "chuoi", 1000));
        c.addToCart(new Product(2, "tao", 2000));
        c.addToCart(new Product(3, "cam", 3000));
        c.addToCart(new Product(4, "dienthoai", 5000000));
        c.addToCart(new Product(5, "xe", 100000000));

        c.showProduct();

        c.totalPrice();
    }
}
