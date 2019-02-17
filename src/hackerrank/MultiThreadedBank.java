package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiThreadedBank {
	
	public static void main(String[] args) {
		//Design the Account and Transaction class to provided the facility of multi-threaded deposit and withdraw.
	}

}

class Account {
	private int balance = 0;

	public synchronized String deposit(int money) {
		String output = "Depositing " + money;
		this.balance += money;
		return output;
	}

	public synchronized String withdraw(int money) {
		String output = "Withdrawing " + money;
		if (this.balance >= money) {
			this.balance -= money;
		} else {
			output += " (Insufficient Balance)";
		}
		return output;
	}

	public int getBalance() {
		return this.balance;
	}
}

class Transaction {
	private Account account;
	private List<String> transactions = Collections.synchronizedList(new ArrayList<String>());

	public Transaction(Account account) {
		this.account = account;
	}

	public String deposit(int money) {
		String txn = this.account.deposit(money);
		this.transactions.add(txn);
		return txn;

	}

	public String withdraw(int money) {
		String txn = this.account.withdraw(money);
		this.transactions.add(txn);
		return txn;
	}

	public List<String> getTransactions() {
		return this.transactions;
	}
}
