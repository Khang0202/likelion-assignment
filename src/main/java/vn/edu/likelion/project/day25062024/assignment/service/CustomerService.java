package vn.edu.likelion.project.day25062024.assignment.service;

import vn.edu.likelion.project.day25062024.assignment.model.Customer;

public interface CustomerService {
    void input();

    void inputConsole();

    void getCustomers();

    Customer getCustomer(String id);

    Customer addCustomer(Customer customer);

    boolean deleteCustomer(String id);
}
