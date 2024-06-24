package vn.edu.likelion.assignment.service;

import vn.edu.likelion.assignment.model.Customer;
import vn.edu.likelion.assignment.model.Event;

public interface CustomerService {
    void input();
    void inputConsole();
    void getCustomers();
    Customer getCustomer(String id);
    Customer addCustomer(Customer customer);
    boolean deleteCustomer(String id);
}
