package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankService service = new BankService();

		try (Scanner scanner = new Scanner(System.in)) {

			while (true) {

				System.out.println("\nWelcome To The Bank. What would you like to do ?");
				System.out.println("             Menu \n            ------" + "\n1.  Add New Customer " + "\n2.  Print all customers "
						+ "\n3.  Find a customer by ID \n4.  Delete a customer by ID "
						+ "\n5.  Credit an account for a given customer ID"
						+ "\n6.  Debit an account for a given customer ID" + "\n7.  Find Customers with Negative Balance"
						+ "\n8.  Find Customers by \"string\"" + "\n9.  Add account for a Customer" + "\n10. Exit");

				String input = scanner.nextLine();

				switch (input) {

				case "1":
					System.out.println("Enter Customer Name");
					String name = scanner.nextLine();
					Customer c1 = new Customer(name);
					System.out.println("Enter Initial Balance");
					double balance = Double.parseDouble(scanner.nextLine());
					Account acc1 = new Account(balance, c1);
					List<Account> accountList = new ArrayList<>();
					c1.setAccount(accountList);
					c1.getAccount().add(acc1);
					service.save(c1);
					System.out.println("Account Created!");
					break;

				case "2":
					System.out.println("Customer List");
					System.out.println(service.findAllCustomers());
					break;

				case "3":
					System.out.println("Enter Customer ID");
					String id = scanner.nextLine();
					System.out.println(service.findCustomerByID(id));
					break;

				case "4":
					System.out.println("Enter the ID to delete");
					String deleteID = scanner.nextLine();
					service.delete(deleteID);
					System.out.println("Customer Deleted");
					break;

				case "5":
					System.out.println("Enter Customer ID & Account ID");
					String idC = scanner.nextLine();
					String acIdCredit = scanner.nextLine();
					System.out.println("Enter Amount to Credit");
					Double amountC = Double.parseDouble(scanner.nextLine());

					service.findCustomerByID(idC).getAccount().forEach(account -> {
						if (account.getId().contentEquals(acIdCredit)) {
							account.credit(amountC);
							System.out.println("Amount Credited");
						}
					});

					break;

				case "6":
					System.out.println("Enter Customer ID & Account ID");
					String idD = scanner.nextLine();
					String acIdDebit = scanner.nextLine();
					System.out.println("Enter Amount to Debit");
					Double amountD = Double.parseDouble(scanner.nextLine());

					service.findCustomerByID(idD).getAccount().forEach(account -> {
						if (account.getId().contentEquals(acIdDebit)) {
							account.debit(amountD);
							System.out.println("Amount Debited");
						}
					});
					break;

				case "7":
					System.out.println("Customers with negative balance\n");
					System.out.println(service.findCustomerNegativeBalance());
					break;

				case "8":
					System.out.println("Enter the word to search");
					String searchWord = scanner.nextLine();
					System.out.println(service.findCustomerByName(searchWord));
					break;

				case "9":
					System.out.println("Enter Customer ID");
					String custID = scanner.nextLine();

					if (service.getDatabase().containsKey(custID)) {

						System.out.println("Enter Initial Balance for the Accout");
						double balanceNew = Double.parseDouble(scanner.nextLine());
						Account accNew = new Account(balanceNew, service.getDatabase().get(custID));
						service.getDatabase().get(custID).getAccount().add(accNew);
						System.out.println("Account Added");

					} else {

						System.out.println("Customer doesn't exist. Create the customer");

					}
					break;

				case "10":
					System.out.println("Exiting App...");
					System.exit(0);

				default:
					service.try1();
					System.err.println("Enter an option from 1 to 10");

				}
			}

		} catch (Exception e) {

			System.err.println("Invalid Input Given");
			e.printStackTrace();

		}

	}

}
