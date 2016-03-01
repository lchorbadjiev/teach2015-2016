package org.elsys.bank;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(int initialBalance) {
		super(initialBalance);
	}

	@Override
	public void withdraw(int amount) {
		balance -= amount;
	}

}
