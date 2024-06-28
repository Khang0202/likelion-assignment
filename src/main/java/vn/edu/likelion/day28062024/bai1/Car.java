package vn.edu.likelion.day28062024.bai1;

public class Car extends Vehicle{
    int numberOfDoors;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    void move() {
        System.out.printf("Car %s is moving\n", getId());
    }
}
