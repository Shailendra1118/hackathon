package com.booking.redhat.api;

import java.util.List;

public interface CustomerApi {
	
	List<Customer> searchCustomers(Criteria<Customer> criteria);
	List<Customer> searchCustomers(Criteria<Customer> cri1, Criteria<Address> cri2);
	List<Customer> searchCustomers(Criteria<Customer> criteria, int limit);
	
	//certainly it can be approved more to handle more criteria 
}
