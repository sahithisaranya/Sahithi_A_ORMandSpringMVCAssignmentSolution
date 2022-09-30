package com.greatlearning.customer_rln_mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customer_rln_mgmt.model.Customer;
import com.greatlearning.customer_rln_mgmt.service.CustomerService;

@Controller
public class CustomerController {
	
	private CustomerService customerService;
		
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCustomerService(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	
	
	@RequestMapping("/")
	public String testStr(Model model) {
		List<Customer> customers=this.customerService.readCustomers();
		model.addAttribute("Customers",customers);
		return "customers";
	}

	//show all customers
	@RequestMapping(value="/customers")
	public String listCustomers(Model model) {
		List<Customer> customers=this.customerService.readCustomers();
		model.addAttribute("Customers",customers);
		return "customers";
	}
	
	@RequestMapping("/add")
	public String addCustomer(Model model){
		Customer newCustomer=new Customer();
		model.addAttribute("Customer",newCustomer);
		return "save-customer";
	}
	
	
	//delete a customer
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customer_id")int id){
	 	this.customerService.deleteCustomer(id);
	 	return "redirect:/customers";
	}
	
	//update a customer
	@RequestMapping("/update")
	public String updateCustomer(@RequestParam("customer_id")int id, Model model){
		Customer customer=this.customerService.readCustomerById(id);
		model.addAttribute("Customer",customer);
		return "save-customer";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("customer_id")int id, 
			@RequestParam("first_name")String _fname,
			@RequestParam("last_name")String _lname,
			@RequestParam("email")String _email) {
		
		Customer newCustomer;
		if(id!=0) {
			newCustomer=this.customerService.readCustomerById(id);
			newCustomer.setFirst_name(_fname);
			newCustomer.setLast_name(_lname);
			newCustomer.setEmail(_email);
			
		}
		else
			newCustomer=new Customer(_fname,_lname,_email);
		
		this.customerService.addCustomer(newCustomer);
		return "redirect:/customers";
	}
}
