package vn.edu.likelion.assignment.model;

import vn.edu.likelion.assignment.helpers.DateFormat;
import vn.edu.likelion.assignment.helpers.DateTimeFormat;
import vn.edu.likelion.assignment.helpers.IdHelper;
import vn.edu.likelion.assignment.helpers.Input;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Event {
    private String id;
    private String name;
    private LocalDate dateStart;
    private int slot;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Event(String name, LocalDate dateStart, int slot) {
        this.id = IdHelper.uuid();
        this.name = name;
        if (dateStart.isAfter(LocalDate.now().plusDays(2))) {
            System.out.println(dateStart);
            this.dateStart = dateStart;
        }else {
            throw new RuntimeException("Date start must be after 2 day from now");
        }

        if (slot > 3){
            throw new RuntimeException("Slot must be less than 3");
        }else {
            this.slot = slot;
        }
    }

    public Event() {
        this.id = IdHelper.uuid();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        if (dateStart.isAfter(LocalDate.now().plusDays(2))) {
            this.dateStart = dateStart;
        }else {
            throw new RuntimeException("Date start must be after 2 day from now");
        }
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        if (slot > 3){
            throw new RuntimeException("Slot must be less than 3");
        }else {
            this.slot = slot;
        }
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void show() {
        System.out.println("Tên sự kiện: " + this.getName() + " " +
                "Id sự kiện: " + this.getId() + " \n" +
                "Ngày bắt đầu: " + this.getDateStart() + " \n" +
                "Số lượng khách mời tối đa: " + this.getSlot() + " \n" +
                "Số khách mời đã đăng ký: " + this.getCustomers().size());
        if (this.getCustomers().size() > 0) {
            System.out.println("------------------------------------");
            System.out.println("Danh sách khách mời:");
            for (int i = 1; i < this.getCustomers().size() + 1; i++) {
                Customer c = this.getCustomers().get(i-1);
                System.out.println("Khách mời: " + i + " " +
                        "Tên khách mời: " + c.getCustomerName() + " " +
                        "Tuổi: " + c.getAge());
            }
        }
    }
    public Event updateEventName() {
        System.out.println("Nhập tên sự kiện mới");
        this.setName(Input.inputString());
        return this;
    }

    public Event updateDateStart() {
        System.out.println("Nhập ngày tổ chức mới");
        System.out.println("format: " + DateFormat.PATTERN);
        this.setDateStart(DateFormat.parseStringToLocalDate(Input.inputString()));
        return this;
    }

    public Event updateSlot() {
        System.out.println("Nhập số lượng khách mời tối đa mới");
        this.setSlot(Input.inputInt());
        return this;
    }
}
