package org.server;
import java.util.ArrayList;

import org.apache.log4j.Logger;


public class BankImpl implements Bank {
	
	class Account {
		Account(Long _id, String _name, String _address, double _amount) {
			id = _id; name = _name; address = _address; amount = _amount;
		}
		Long id;
		String name;
		String address;
		double amount;
	}
	
	ArrayList<Account> mAccounts;
	Long mId;
	private final Logger logger = Logger.getLogger(getClass());
	
	BankImpl() {
		logger.info("Wejscie do klasy glownej");
		mAccounts = new ArrayList<Account> ();
		mId = 0L;
	}

	public Long createAccount(String name, String address) {
		logger.info("Wejscie do metody createAccount");
		for (Account a : mAccounts) if (a.name == name && a.address == address) return a.id;
		mAccounts.add(new Account (++mId, name, address, 0.0));
		return mId;
	}

	public Long findAccount(String name, String address) {
		logger.info("Wejscie do metody findAccount");
		for (Account a : mAccounts) if (a.name == name && a.address == address) return a.id;
		return null;
	}

	public void deposit(Long Id, double amount) {
		logger.info("Wejscie do metody deposit");
		for (Account a : mAccounts) if (a.id == Id) { a.amount += amount; return; }
	}

	public double getBalance(Long Id) {
		logger.info("Wejscie do metody getBallance");
		for (Account a : mAccounts) if (a.id == Id) return a.amount;
		throw new AccountIdException();
	}

	public void withdraw(Long Id, double amount) {
		logger.info("Wejscie do metody withdraw");
		for (Account a : mAccounts)
			if (a.id == Id) {
				if (a.amount >= amount) {
					a.amount -= amount; return;
				}
				else throw new InsufficientFoundsException();
			}
		throw new AccountIdException();
	}

	public void transfer(Long IdSource, Long IdDestination, double amount) {
		logger.info("Wejscie do metody transfer");
		boolean IdSourceExist = false;
		boolean IdDestinationExist = false;
		for (Account a : mAccounts) {
			if (a.id == IdSource)
				IdSourceExist = true;
			if (a.id == IdDestination)
				IdDestinationExist = true;
		}
		if (IdSourceExist && IdDestinationExist) {
			for (Account a : mAccounts) {
				if (a.id == IdSource) {
					if (a.amount >= amount) a.amount -= amount;
					else throw new InsufficientFoundsException();
				}
				if (a.id == IdDestination) a.amount += amount;
			}
		} else throw new AccountIdException();
	}
        
        static void main (String [] args) {
            
        }

}
