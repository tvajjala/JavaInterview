package com.trvajjala.spring.aop;

public class CustomerService {

	public void addCustomer(Customer customer) {

		System.out.println(" Customer Added  : " + customer);
	}

	public Customer getCustomer(String name,String mobile) {
		System.out.println(" getCustomer method executing ");
		return new Customer(name,mobile);
	}
}
