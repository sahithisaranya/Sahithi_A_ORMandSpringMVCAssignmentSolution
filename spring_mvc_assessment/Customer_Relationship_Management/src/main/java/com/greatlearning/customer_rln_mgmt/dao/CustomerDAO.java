package com.greatlearning.customer_rln_mgmt.dao;

import java.util.List;

import com.greatlearning.customer_rln_mgmt.model.Customer;

public interface CustomerDAO {
	public void addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public List<Customer> readCustomers();
	public Customer readCustomerById(int id);
	public void deleteCustomer(int id);
}
