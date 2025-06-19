package com.khy.example05;

public class BalanceInsufficientException extends RuntimeException{

	public BalanceInsufficientException() {
		
	}
	
	public BalanceInsufficientException(String Message) {
		super(Message); // 부모클래스 호출, 인자 전달
	}
	
}
