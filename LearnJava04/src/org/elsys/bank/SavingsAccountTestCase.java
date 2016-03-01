package org.elsys.bank;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTestCase {
	private SavingsAccount account;

	@Before
	public void setUp() throws Exception {
		account = new SavingsAccount(1000);
	}

	@After
	public void tearDown() throws Exception {
		account = null;
	}

	@Test
	public void testInitialBalance() {
		assertEquals(1000, account.getBalance());
	}

	@Test
	public void testDeposit() {
		account.deposit(1000);
		assertEquals(2000, account.getBalance());
	}

	@Test
	public void testSingleWithdrawal() {
		account.withdraw(100);
		assertEquals(900, account.getBalance());
	}

	@Test
	public void testFiveWithdrawals() {
		for (int i = 0; i < 5; i++) {
			account.withdraw(100);
		}
		assertEquals(5, account.getNumWithdrawals());
		assertEquals(500, account.getBalance());
	}

	@Test(expected = RuntimeException.class)
	public void testSixthWithdrawal() {
		for (int i = 0; i < 5; i++) {
			account.withdraw(100);
		}
		account.withdraw(100);
	}

	@Test
	public void testOverdraft() {
		account.withdraw(2000);
		assertEquals(-1000, account.getBalance());
	}
}
