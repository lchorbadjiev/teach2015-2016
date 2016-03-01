package org.elsys.bank;

public class SavingsAccount extends BankAccount {
	private int numberOfWithdrawals;


	public SavingsAccount(int initialBalance) {
		super(initialBalance);
		numberOfWithdrawals = 0;
	}

	public int getNumberOfWithdrawals() {
		return numberOfWithdrawals;
	}
	
	public void resetNumberOfWithdrawals() {
		numberOfWithdrawals = 0;
	}
	
	@Override
	public void withdraw(long amount) {
		numberOfWithdrawals ++;
		if(numberOfWithdrawals > 5) {
			throw new RuntimeException("too many withdrawals");
		}
		balance -= amount;
	}
	
}
