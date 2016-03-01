package org.elsys.bank;

public abstract class BankAccount {

	protected long balance;
	
	public BankAccount(int initialBalance) {
		balance = initialBalance;
	}
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(long amount) {
		balance += amount;
	}
	
	abstract public void withdraw(long amount);
}
