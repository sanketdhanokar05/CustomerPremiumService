package com.abc.cpservice.service;


import com.abc.cpservice.model.Product;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ProductService {
	
	
	@Autowired
	private RestTemplate restTemplate;
	@HystrixCommand(fallbackMethod = "getProductDetailsFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"), })
	 public Product getProductDetails(int productId) {

	 Product product = null;

	 String resourceUrl = "http://ProductService/ecom/customer/get/" + productId;

	 ResponseEntity<Product> productResponseEntity = restTemplate.getForEntity(resourceUrl, Product.class);

	 if (productResponseEntity.getStatusCode() == HttpStatus.OK) {
	product = productResponseEntity.getBody();

	 return product;
	}
	return product;

	 }
	
	@SuppressWarnings("unused")
	private Product getProductDetailsFallback(int productId) {
		Product product = new Product();
        product.setProductId(0);
        return product;
		
		
	}
	
}