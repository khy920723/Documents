package com.khy.example05;

public class BalanceInsufficientException extends RuntimeException{

	public BalanceInsufficientException() {
		
	}
	
	public BalanceInsufficientException(String Message) {
		super(Message); // �θ�Ŭ���� ȣ��, ���� ����
	}
	
}
