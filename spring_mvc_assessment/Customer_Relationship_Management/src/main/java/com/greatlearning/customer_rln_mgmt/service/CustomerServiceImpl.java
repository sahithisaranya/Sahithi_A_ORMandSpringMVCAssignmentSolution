package com.greatlearning.customer_rln_mgmt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.greatlearning.customer_rln_mgmt.dao.CustomerDAO;
import com.greatlearning.customer_rln_mgmt.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO customerDAO;
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO=customerDAO;
	}
	
	@Override
	@Transactional
	public void addCustomer(Customer c) {
		this.customerDAO.addCustomer(c);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer c) {
		this.customerDAO.updateCustomer(c);
	}

	@Override
	@Transactional
	public List<Customer> readCustomers() {
		return this.customerDAO.readCustomers();
	}

	@Override
	@Transactional
	public Customer readCustomerById(int id) {
		return this.customerDAO.readCustomerById(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		this.customerDAO.deleteCustomer(id);
	}

}
