package org.elsys.bank;

public abstract class BankAccount {
	
	protected int balance;
	
	public BankAccount(int initialBalance) {
		balance = initialBalance;
	}
	
	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}
	
	public abstract void withdraw(int amount);
}
