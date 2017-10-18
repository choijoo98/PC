package lab2;

import java.util.ArrayList;

/**
 * Customer
 * Created on September 27, 2017
 */
public class Customer {

	/**
	 * private
	 *        save to customer name
	 */
	private String name;
	
	/**
	 * private
	 *        save to customer password
	 */
	private int pin;
	/**
	 * public
	 *        save to customer number
	 */
	public int customerNumber;
	/**
	 * list for save accounts
	 */
	public static ArrayList<Integer> accounts = new ArrayList<Integer>();

	/**
	 * Constructor to initialize
	 * @param name2 
	 *              to name
	 * @param cusPin 
	 *              to customerNumber
	 * @param cusNum 
	 *              to accounts
	 * @param cusAccount
	 *              to pin
	 */
	public Customer(String name2, int cusPin, int cusNum, int cusAccount) {
		this.name = name2;
		this.pin = cusPin;
		this.customerNumber = cusNum;
		accounts.add(cusAccount);

	}

	/**
	 * get accounts method that type is integer list
	 * @return
	 *        all customer's account numbers
	 */
	public ArrayList<Integer> getAccounts() {
		return accounts;
	}

	/**
	 * get pin method
	 * @return pin
	 */
	public int getPin() {
		return pin;
	}

}
