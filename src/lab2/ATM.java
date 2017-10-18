package lab2;


import java.util.Scanner;


/**
 * ATM Created on September 27, 2017
 */
public class ATM {

	/** 
	 * private
	 *        TRANSACT save for withdraw state
	 */
	private static final int TRANSACT = 4;
	
	/** 
	 * private
	 *        START save for start state
	 */
	private static final int START = 1;

	/**
	 * private
	 *        save state
	 */
	private int state;
	/** 
	 * private
	 *        current bank
	 */
	
	private static Bank bank;
	/** 
	 * private
	 *        current Customer's information  
	 */
	
	public static Customer currentCustomer;
	/** 
	 * public
	 *       current Account's information  
	 */
	
	public static Account currentAccount;
	/**
	 * public
	 *       object for input data
	 */
	private static Scanner s;

	/**
	 * default constructor
	 */
	public ATM() {

	}

	/**
	 * constructor with bank's information
	 * 
	 * @param aBank
	 *             the ATM on which the session is performed
	 */
	public ATM(Bank aBank) {
		bank = aBank;
		currentCustomer.customerNumber = -1;
		currentAccount = null;
		state = START;
	}

	/**
	 * define method withdraw
	 * 
	 * @param value
	 *             current amount of withdraw
	 */
	public void withdraw(double value) {

		assert state == TRANSACT;
		currentAccount.withdraw(value);

	}

	public static void main(String[] args) {

		
	}
}
