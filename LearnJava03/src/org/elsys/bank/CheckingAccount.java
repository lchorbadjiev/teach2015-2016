package org.elsys.bank;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(int initialBalance) {
		super(initialBalance);
	}

	@Override
	public void withdraw(long amount) {
		balance = balance - amount;
	}

}
