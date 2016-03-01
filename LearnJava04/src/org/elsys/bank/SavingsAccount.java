package org.elsys.bank;

public class SavingsAccount extends BankAccount {

	private int numWithdrawals;

	public SavingsAccount(int initialBalance) {
		super(initialBalance);
		numWithdrawals = 0;
	}

	public void resetNumWithdrawals() {
		numWithdrawals = 0;
	}

	public int getNumWithdrawals() {
		return numWithdrawals;
	}

	@Override
	public void withdraw(int amount) {
		if (numWithdrawals >= 5) {
			throw new RuntimeException("too many withdrawals");
		}
		numWithdrawals++;
		balance -= amount;
	}

}
