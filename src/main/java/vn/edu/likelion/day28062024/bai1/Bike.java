package vn.edu.likelion.day28062024.bai1;

public class Bike extends Vehicle {
    boolean hasGear;

    public boolean isHasGear() {
        return hasGear;
    }

    public void setHasGear(boolean hasGear) {
        this.hasGear = hasGear;
    }

    @Override
    void move() {
        System.out.printf("Bike %s is moving\n",getId());

    }
}
