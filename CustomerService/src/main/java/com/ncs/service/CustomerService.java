package com.ncs.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.model.Customer;
import com.ncs.repository.CustomerRepository;
//defining the business logic
@Service
public class CustomerService 
{
@Autowired
CustomerRepository customerRepository;
//getting all customer record by using the method findaAll() of JpaRepository
@Transactional(readOnly = true)
public List<Customer> getAllCustomer() 
{
List<Customer> customer = new ArrayList<Customer>();
customerRepository.findAll().forEach(customer1 -> customer.add(customer1));
return customer;
}
//getting a specific record by using the method findById() of JpaRepository
@Transactional(readOnly = true)
public Customer getCustomerById(int id) 
{
return customerRepository.findById(id).get();
}
//saving a specific record by using the method save() of JpaRepository
@Transactional(propagation = Propagation.REQUIRED)
public Customer saveOrUpdate(Customer customer) 
{
return customerRepository.save(customer);
}
//deleting a specific record by using the method deleteById() of JpaRepository
public void delete(int id) 
{
customerRepository.deleteById(id);
}
//updating a record
@Transactional(propagation = Propagation.REQUIRED)
public void update(Customer customer, int customerId) 
{
customerRepository.save(customer);
}
}