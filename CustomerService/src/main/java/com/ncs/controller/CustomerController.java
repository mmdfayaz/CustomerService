package com.ncs.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ncs.model.Customer;
import com.ncs.service.CustomerService;
//mark class as Controller
@RestController
public class CustomerController 
{
//autowire the CustomerService class
@Autowired
CustomerService customerService;
//creating a get mapping that retrieves all the customer detail from the database 
@GetMapping("/customer")
private List<Customer> getAllCustomer() 
{
return customerService.getAllCustomer();
}
//creating a get mapping that retrieves the detail of a specific customer
@GetMapping("/customer/{customerid}")
private Customer getCustomer(@PathVariable("customerid") int customerid) 
{
return customerService.getCustomerById(customerid);
}
//creating a delete mapping that deletes a specified customer
@DeleteMapping("/customer/{customerid}")
private void deleteCustomer(@PathVariable("customerid") int customerid) 
{
customerService.delete(customerid);
}
//creating post mapping that post the customer detail in the database
@PostMapping("/customer")
private Customer saveCustomer(@RequestBody Customer customer) 
{
return customerService.saveOrUpdate(customer);
 
}
//creating put mapping that updates the Customer detail 
@PutMapping("/customer")
private Customer update(@RequestBody Customer customer) 
{
customerService.saveOrUpdate(customer);
return customer;
}
}
