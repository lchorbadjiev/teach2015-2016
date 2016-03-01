package org.elsys.bank;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTestCase {

	private CheckingAccount account = null;
	
	@Before
	public void setUp() throws Exception {
		account = new CheckingAccount(1000);
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
	public void testWithdraw() {
		account.withdraw(100);
		assertEquals(900, account.getBalance());
	}
	
	@Test
	public void testOverdraft() {
		account.withdraw(2000);
		assertEquals(-1000, account.getBalance());
	}
	
}
