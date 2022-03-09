package com.abc.cpservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.cpservice.model.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


	
	
	@Service
	public class CustomerService {
	@Autowired
	private RestTemplate restTemplate;
     
	@HystrixCommand(fallbackMethod = "getCustomerDetailsFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"), })
	 public Customer getCustomerDetails(int customerId) {

	 Customer customer = null;
	 
	 String resourceUrl = "http://CustomerService/lifeinsurance/customer/get/" + customerId;

	 ResponseEntity<Customer> customerResponseEntity = restTemplate.getForEntity(resourceUrl, Customer.class);

	 if (customerResponseEntity.getStatusCode() == HttpStatus.OK) {
	customer = customerResponseEntity.getBody();

	 return customer;
	}
	return customer;

	 }
	@SuppressWarnings("unused")
	private Customer getCustomerDetailsFallback(int customerId) {
		Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setCustomerName("");
        customer.setEmail(null);
        customer.setMobileNo(null);
        customer.setAddress(null);
        customer.setGovtId(customerId);
        return customer;
		
		
	}
	}
	



