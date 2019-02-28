package com.ata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ata_tbl_creditcard")
public class PaymentBean {
	@Id
	String creditCardNumber; 
	String validFrom;
	String validTo;
	
	@Column(name="creditbalance")
	double balance;
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "PaymentBean [creditCardNumber=" + creditCardNumber + ", validFrom=" + validFrom + ", validTo=" + validTo
				+ ", balance=" + balance + "]";
	} 
	
	
}
