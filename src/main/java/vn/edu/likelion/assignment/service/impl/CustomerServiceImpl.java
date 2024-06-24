package vn.edu.likelion.assignment.service.impl;

import vn.edu.likelion.assignment.helpers.Input;
import vn.edu.likelion.assignment.model.Customer;
import vn.edu.likelion.assignment.model.Event;
import vn.edu.likelion.assignment.model.Storage;
import vn.edu.likelion.assignment.service.CustomerService;

import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void input() {
        System.out.print("Nhập số lượng khách hàng: ");
        int numInput = Input.inputInt();
        if (numInput>0) {
            for (int i = 1; i <= numInput; i++){
                System.out.println("----------------------"+i+"----------------------");
                inputConsole();
            }
        } else {
            throw new RuntimeException("Can not add less than 1 customer");
        }

    }

    @Override
    public void inputConsole() {
        Customer customer = new Customer();
        System.out.println("Nhập tên khách hàng");
        customer.setCustomerName(Input.inputString());
        System.out.println("Nhập tuổi khách hàng");
        customer.setAge(Input.inputInt());
        addCustomer(customer);
    }

    @Override
    public void getCustomers() {
        for (Customer c: Storage.customerArrayList){
            c.show();
            System.out.println("------------------------------------");
        }
    }

    @Override
    public Customer getCustomer(String id) {
        for (Customer c: Storage.customerArrayList){
            if(c.getId().equalsIgnoreCase(id)){
                return c;
            }
        }
        throw new RuntimeException("Customer with id " + id + " does not exist");
    }

    @Override
    public Customer addCustomer(Customer customer) {
        if (checkCustomerExists(customer.getId())){
            throw new RuntimeException("Customer with id " + customer.getId() + " already exists");
        } else if (Storage.customerArrayList.add(customer)) {
            Storage.customerArrayList.get(Storage.customerArrayList.size()-1);
            return Storage.customerArrayList.get(Storage.customerArrayList.size()-1);
        } else {
            throw new RuntimeException("Customer with id " + customer.getId() + " can not be added");
        }
    }

    @Override
    public boolean deleteCustomer(String id) {
        for (Customer customer : Storage.customerArrayList){
            if (customer.getId().equals(id)){
                if (customer.isRegis()){
                    for (Event e : Storage.eventArrayList){
                        if (e.getCustomers().contains(customer)){
                            e.getCustomers().remove(customer);
                            return Storage.customerArrayList.remove(customer);
                        }else {
                            throw new RuntimeException("Customer with id " + customer.getId() + " doesn't regis any event");
                        }
                    }
                }else {
                    return Storage.customerArrayList.remove(customer);
                }
            }
        }
        throw new RuntimeException("Customer with id " + id + " can not be delete");
    }

    private boolean checkCustomerExists(String customerId) {
        for (Customer c : Storage.customerArrayList) {
            if (c.getId().equals(customerId)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
