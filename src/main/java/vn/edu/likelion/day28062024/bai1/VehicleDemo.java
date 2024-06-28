package vn.edu.likelion.day28062024.bai1;

import java.util.ArrayList;

public class VehicleDemo {
    /**
     * • Bài tập tự luận 1:
     * Đề bài:
     * Viết một chương trình Java để quản lý các loại phương tiện giao thông. Hãy thực hiện các yêu cầu sau:
     * 1. Tạo một lớp trừu tượng Vehicle với các thuộc tính String name và final int id, cùng với một phương thức trừu tượng void move()
     * 2. Tạo các lớp con Car và Bike kế thừa từ lớp Vehicle.
     * • Lớp Car có thêm thuộc tính int numberOfDoors.
     * • Lớp Bike có thêm thuộc tính boolean hasGear
     * 3. Cài đặt phương thức move() cho mỗi lớp con để in ra thông điệp tương ứng, ví dụ: "Car is moving" hoặc "Bike is moving".
     * 4. Tạo một lớp VehicleDemo có phương thức main để:
     * • Khởi tạo một mảng các đối tượng Vehicle gồm cả Car và Bike.
     * • Gọi phương thức move() cho từng đối tượng trong mảng để thể hiện tính đa hình.
     * 5. Trong lớp Vehicle, tạo một biến static int vehicleCount để đếm số lượng đối tượng Vehicle được tạo ra. Cập nhật biến này trong constructor của Vehicle.
     */

    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    public static void main(String[] args) {
        vehicles.add(new Bike());
        vehicles.add(new Car());
        vehicles.add(new Car());
        vehicles.add(new Bike());
        vehicles.add(new Car());
        vehicles.add(new Bike());
        vehicles.add(new Car());
        vehicles.add(new Bike());
        vehicles.add(new Car());
        vehicles.add(new Bike());
        for (Vehicle vehicle : vehicles) {

            vehicle.move();
        }
    }
}
