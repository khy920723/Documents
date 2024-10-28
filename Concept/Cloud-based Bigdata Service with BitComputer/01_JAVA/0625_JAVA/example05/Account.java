package com.khy.example05;

public class Account {

	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	// 입금액
	public void deposit(int money) {
		balance += money;
	}
	
	// 출금액
	public void withdraw(int money) throws BalanceInsufficientException { // 해당 예외에 대해 자신을 호출한 메서드한테 예외 처리를 맡기는 throws
		if(balance < money) {
			throw new BalanceInsufficientException("Not enough money"); // 예외 발생시키는 throw(무조건 예외가 발생하기 때문에 try catch로 처리해야 됨)
			// new 연산자로 예외를 만들어버림
		}
		balance -= money;
	}
}
