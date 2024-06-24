package vn.edu.likelion.assignment.model;

import vn.edu.likelion.assignment.helpers.IdHelper;
import vn.edu.likelion.assignment.helpers.Input;

import java.time.LocalDate;

public class Customer {
    String id;
    private String customerName;
    private int age;
    private boolean isRegis = false;

    public Customer() {
        this.id = IdHelper.uuid();
    }

    public Customer(String customerName, int age) {
        this.id = IdHelper.uuid();
        this.customerName = customerName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isRegis() {
        return isRegis;
    }

    public void setRegis(boolean regis) {
        isRegis = regis;
    }

    public boolean regisEvent(Event event) {
        if (this.age >= 18) {
            if (Storage.eventArrayList.contains(event)) {
                if (this.isRegis) {
                    for (Event e : Storage.eventArrayList) {
                        if (e.getCustomers().contains(this) && e.getDateStart().isAfter(LocalDate.now().plusDays(1))) {
                            e.getCustomers().remove(this);
                            this.isRegis = false;
                            break;
                        } else {
                            return false;
                        }
                    }
                }
                if (event.getCustomers().size() < event.getSlot()) {
                    if (event.getCustomers().add(this)) {
                        this.isRegis = true;
                        return true;
                    } else {
                        this.isRegis = false;
                        return false;
                    }
                }else {
                    throw new RuntimeException("Event with id " + id + " already max");
                }

            } else {
                throw new RuntimeException("Event with id " + id + " does not exist");
            }
        } else {
            throw new RuntimeException("Age of customer with id " + id + " does not valid");
        }
    }

    public void show() {
        System.out.println(
                "ID khách: " + this.getId() + " " +
                "Tên khách mời: " + this.getCustomerName() + " " +
                        "Tuổi: " + this.getAge());
    }

    public Customer updateCustomerName() {
        System.out.println("Nhập tên khách mời mới");
        this.setCustomerName(Input.inputString());
        return this;
    }

    public Customer updateCustomerAge() {
        System.out.println("Nhập tuổi mới của khách");
        this.setAge(Input.inputInt());
        return this;
    }

}
