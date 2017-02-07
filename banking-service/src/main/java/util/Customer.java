package util;

import java.util.List;
import java.util.UUID;

public class Customer {
	
	private final String name;
	private final String id = UUID.randomUUID().toString();
	private List<Account> account;
	
	public Customer(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public String getId() {
		return this.id;
	}


	public List<Account> getAccount() {
		return this.account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
	

	@Override
	public String toString() {
		return "Customer Name=" + this.name + ", Id=" + this.id + ", Account=" + this.account + "\n";
	}

}
