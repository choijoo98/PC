package lab2;

import java.util.ArrayList;
/**
 * Bank
 * Created on September 27, 2017
 */
public class Bank {

	/**
	 * private
	 *        save to bank name
	 */
	private String bankName;
	/**
	 * list for save customers
	 */
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	/**
	 * constructor with specific bank's name
	 * @param bankName
	 *                save for bank names
	 */
	public Bank(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * get bank's name method
	 * @return bank's name
	 */
	public String getBankname() {
		return bankName;
	}

	/**
	 * get customers method that type is customers list
	 * @return Customers
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	/**
	 * add method that save new customer to customers list
	 * @param e
	 *         information of Customers
	 */
	public void AddAccount(Customer e) {
		customers.add(e);
	}

}
