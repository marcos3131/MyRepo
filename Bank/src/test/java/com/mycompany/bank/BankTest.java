package com.mycompany.bank;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	BankImpl mBank;

	@Before
	public void before () {
		mBank = new BankImpl();
	}
	
	@Test
	public void testCreateAccount1() {
		Long id = mBank.createAccount("Mark", "Warsaw");
		assert id == mBank.createAccount("Mark","Warsaw");
		assert mBank.getBalance(id) == 0;
	}
	
	@Test
	public void testFindAccount1() {
		Long id = mBank.createAccount("Mark","Warsaw");
		mBank.createAccount("asdf", "asdf");
		assert id == mBank.findAccount("Mark", "Warsaw");
	}
	
	@Test
	public void testFindAccount2() {
		mBank.createAccount("asdf", "asdf");
		assert mBank.findAccount("Mark", "Warsaw") == null;
	}
	
	@Test
	public void testDeposit1() {
		Long id = mBank.createAccount("Mark", "Warsaw");
		mBank.deposit(id, 100);
		assert mBank.getBalance(id) == 100;
	}
	
	@Test(expected=Bank.AccountIdException.class)
	public void testDeposit2() {
		Long id = 1L;
		mBank.getBalance(id);
	}
	
	@Test(expected=Bank.AccountIdException.class)
	public void TestGetBallance() {
		Long id = 1L;
		mBank.getBalance(id);
	}
	
	@Test
	public void testWithdraw1() {
		Long id = mBank.createAccount("Mark", "Warsaw");
		mBank.deposit(id, 100);
		mBank.withdraw(id, 80);
		assert mBank.getBalance(id) == 20;
	}
	
	@Test(expected=Bank.InsufficientFoundsException.class)
	public void testWithdraw2() {
		Long id = mBank.createAccount("Mark", "Warsaw");
		mBank.deposit(id, 100);
		mBank.withdraw(id, 200);
	}

	@Test(expected=Bank.AccountIdException.class)
	public void testTransfer1() {
		Long id = mBank.createAccount("asdf", "asdf");
		mBank.transfer(id, -100L, 100);
	}

	@Test(expected=Bank.AccountIdException.class)
	public void testTransfer2() {
		Long id = mBank.createAccount("asdf", "asdf");
		mBank.transfer(-100L, id, 100);
	}
	
	@Test(expected=Bank.InsufficientFoundsException.class)
	public void testTransfer3() {
		Long id1 = mBank.createAccount("asdf", "asdf");
		Long id2 = mBank.createAccount("asdf2", "asdf");
		mBank.transfer(id1, id2, 100);
	}
	
	@Test(expected=Bank.InsufficientFoundsException.class)
	public void testTransfer4() {
		Long id1 = mBank.createAccount("asdf", "asdf");
		Long id2 = mBank.createAccount("asdf2", "asdf");
		mBank.transfer(id1, id2, 100);
	}
	
	@Test
	public void testTransfer5() {
		Long id1 = mBank.createAccount("asdf", "asdf");
		mBank.deposit(id1, 200);
		Long id2 = mBank.createAccount("asdf2", "asdf");
		mBank.transfer(id1, id2, 100);
		assert mBank.getBalance(id1) == 100;
		assert mBank.getBalance(id2) == 100;
	}
	

}
