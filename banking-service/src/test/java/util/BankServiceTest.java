package util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BankServiceTest {

	BankService service = new BankService();
	

	Customer c1 = new Customer("Masie Doe");
	List<Account> accountList1 = new ArrayList<>();
	Account acc1 = new Account(5000.0, c1);

	Customer c2 = new Customer("Jane Doe");
	List<Account> accountList2 = new ArrayList<>();
	Account acc2 = new Account(2000.0, c2);

	Customer c3 = new Customer("Jimmy Dae");
	List<Account> accountList3 = new ArrayList<>();
	Account acc3 = new Account(1000.0, c3);

	@Before
	public void verifyInitialState() {

		assertNoCustomers();
		c1.setAccount(accountList1);
		c1.getAccount().add(acc1);
		c2.setAccount(accountList2);
		c2.getAccount().add(acc2);
		c3.setAccount(accountList3);
		c3.getAccount().add(acc3);
	}

	@Test
	public void saveCustomers() {
		service.save(c1);
		assertNumCustomers(1);
		service.save(c2);
		assertNumCustomers(2);
		service.save(c3);
		assertNumCustomers(3);
	}

	@Test
	public void deleteCustomers() {
		saveThreeCustomers();
		service.delete(c1.getId());
		assertNumCustomers(2);
	}

	@Test
	public void findByIdTest() {

		saveThreeCustomers();
		Customer c = service.findCustomerByID(c1.getId());
		assertThat(c).isEqualTo(c);

	}

	@Test
	public void findAllTest() {

		saveThreeCustomers();
		List<Customer> cList = service.findAllCustomers();
		assertThat(cList).containsExactly(c1, c2, c3);
	}

	@Test
	public void findCustomerByFalseID() {
		Customer retrievedCustomer = service.findCustomerByID("1234");
		assertThat(retrievedCustomer).isNull();
	}

	@Test
	public void creditTest() {

		c1.getAccount().get(0).credit(1500);
		assertEquals(6500, c1.getAccount().get(0).getBalance(), 0.0);

	}
	
	@Test
	public void debitTest() {

		c2.getAccount().get(0).debit(1500);
		assertEquals(500, c2.getAccount().get(0).getBalance(), 0.0);

	}
	
	@Test
	public void findCustomerNegativeBalanceTest(){
		
		saveThreeCustomers();
		c2.getAccount().get(0).debit(10000);
		
		assertThat(service.findCustomerNegativeBalance()).containsExactly(c2);
		
	}
	
	@Test
	public void findCustomerByNameTest(){
		
		saveThreeCustomers();
		
		String word = "oe";
	
		assertThat(service.findCustomerByName(word)).containsExactly(c1,c2);

	}
	
	private void assertNoCustomers() {
		assertNumCustomers(0);
	}

	public void assertNumCustomers(int expected) {

		assertThat(service.findAllCustomers()).hasSize(expected);
	}

	private void saveThreeCustomers() {
		service.save(c1);
		service.save(c2);
		service.save(c3);
	}

}
