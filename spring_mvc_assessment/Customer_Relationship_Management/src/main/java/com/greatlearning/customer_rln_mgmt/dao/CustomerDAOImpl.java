package com.greatlearning.customer_rln_mgmt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.greatlearning.customer_rln_mgmt.model.Customer;

@Repository
@EnableTransactionManagement
public class CustomerDAOImpl implements CustomerDAO {

	private static final Logger logger=LoggerFactory.getLogger(CustomerDAOImpl.class);
	private SessionFactory sessionFactory;
//	private Session session;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory=sf;
	}
	
	/*@Autowired
	CustomerDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		try {
			session=this.sessionFactory.getCurrentSession();
		}catch(HibernateException e) {
			session=this.sessionFactory.openSession();
		}
	}
	*/
	
	@Override
	public void addCustomer(Customer c) {
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(c);
		logger.info("Customer saved successfully, here are the details: "+c);
	}

	@Override
	public void updateCustomer(Customer c) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Customer updated successfully, here are the details: "+c);
	}

	
	@Override
	public List<Customer> readCustomers() {
		Session session=this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Customer> customerList=session.createQuery("from Customer").list();
		for(Customer c:customerList) {
			logger.info("Customer :: "+c);
		}
		return customerList;
	}

	@Override
	public Customer readCustomerById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		Customer c=(Customer)session.load(Customer.class, id);
		logger.info("Customer loaded successfully, details = "+c);
		return c;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		Customer c=(Customer)session.load(Customer.class, id);
		if(c!=null) {
			session.delete(c);
		}
		logger.info("Customer deleted successfully, details = "+c);
	}

}
