package vn.edu.likelion.project.day28062024.bai1;

public abstract class Vehicle {
    static int vehicleCount = 0;
    final String id;
    String name;

    Vehicle() {
        id = java.util.UUID.randomUUID().toString();
        vehicleCount++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void move();

}
