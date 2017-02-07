package util;

import java.util.UUID;

public class Account {

	private final String accountId = UUID.randomUUID().toString();
	private double balance;
	private final Customer customer;

	public Account(double balance, Customer customer) {
		super();
		this.balance = balance;
		this.customer = customer;
		
		//this.customer.setAccount(this); -- can also set it this way
	}

	public String getId() {
		return this.accountId;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return this.customer;
	}


	public void credit(double amount) {
		
		this.balance += amount;
	}

	public void debit(double amount) {
		
		this.balance -= amount;

	}

	@Override
	public String toString() {
		return " Account Id=" + this.accountId + ", Balance=" + this.balance + ", Customer=" + this.customer.getName();
	}
	
	

}
