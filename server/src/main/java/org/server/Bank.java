package org.server;

public interface Bank {
	/**
	 * Tworzy nowe lub zwaraca Id istniejącego konta.
	 * @param name
	 * @param address
	 * @return Id utworzonego lub istniejącego konta.
	 */
	Long createAccount (String name, String address);
	
	/**
	 * Znajduje identyfikator konta
	 * @param name
	 * @param address
	 * @return Id konta lub null, gdy brak konta o podanych parametrach
	 */
	Long findAccount (String name, String address);
	
	/**
	 * Dodaje srodki konta
	 * @param Id
	 * @param amount srodki
	 * @throws AccountIdException, gdy Id konta jest nieprawidłowe
	 */
	void deposit (Long Id, double amount);
	
	/**
	 * Zwraca ilość środków na koncie.
	 * @param Id
	 * @return środki
	 * @throws AccountIdException, gdy Id konta jest nieprawidłowe
	 */
	double getBalance (Long Id);
	
	/**
	 * Pobiera srodki z konta.
	 * @param Id
	 * @param amount srodki
	 * @throws AccountIdException, gdy Id konta jest nieprawidłowe
	 * @throws InsufficientFoundsException, gdy srodki na koncienie sa wystarczajace do wykonania operacji
	 */
	void withdraw (Long Id, double amount);
	
	/**
	 * Przelewa srodki miedzy kontami.
	 * @param IdSource
	 * @param IdDestination
	 * @param account srodki
	 * @throws AccountIdException
	 * @throws InsufficientFoundsException
	 */
	void transfer (Long IdSource, Long IdDestination, double ammount);
	
	public class InsufficientFoundsException extends RuntimeException {};
	public class AccountIdException extends RuntimeException {};
	
}
