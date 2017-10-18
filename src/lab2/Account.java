package lab2;


/**
 * @author Choijoo
 * Account
 * Created on September 27, 2017
 */
public class Account {
	/** 
	 * private
	 *          balance for account  {@link Account#balance} / {@link #balance} 
	 *           
	 */
	private double balance = 0;
	
	
	/**
	 * public
	 *       save for account numbers
	 */
	public static int  accountNumbers;

	/**
	 *  constructor with specific account id and initial balance
	 * @param bal
	 *           save for current balance
	 * @param id
	 *           contain customer's account number
	 */
	public Account(double bal, int id) {
		if (balance >= 0) {
			balance = bal;
		} else {
			balance = 0;
		}
		accountNumbers = id;
	}

	/**
	 * define method deposit
	 * @param amount
	 *              amount of deposit
	 */
	public void deposit(double amount) {

		balance = balance + amount;
	}

	/**
	 * define method withdraw
	 * @param amount
	 *              amount of withdraw
	 */
	public void withdraw(double amount) {

		if (amount <= balance) {

			balance = balance - amount;
		} else {

			System.err.println("!!!!");
		}

	}

	/**
	 * get balance method
	 * @return current balance
	 *        
	 */
	public double getBalance() {
		return balance;
	}

}
