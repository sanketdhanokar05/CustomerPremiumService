package com.abc.cpservice.model;

import java.time.LocalDate;

public class PremiumModel {
	
	private int premiumId;
	private int customerId;
	private int productId;
	private double premiumAmount;
	private LocalDate paidDate;
	private LocalDate dueDate;
	public int getPremiumId() {
		return premiumId;
	}
	public void setPremiumId(int premiumId) {
		this.premiumId = premiumId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public LocalDate getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
