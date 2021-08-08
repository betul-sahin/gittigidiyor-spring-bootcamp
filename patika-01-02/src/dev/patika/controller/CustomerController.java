package dev.patika.controller;

import dev.patika.models.Customer;
import dev.patika.models.Vehicle;
import dev.patika.service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService customerService = new CustomerService();

    public Customer findCustomer(int custId){
        return customerService.findById(custId);
    }

    public List<Customer> findAllCustomers(){
        return customerService.findAll();
    }

    public void saveCustomer(Customer customer){
        customerService.saveToDatabase(customer);
    }


    public void deleteCustomer(long ssid){
        customerService.deleteCustomerFromDatabase(ssid);
    }

    public List<Vehicle> findVehiclesOfCustomer(long ssid){
        return null;
    }

}
