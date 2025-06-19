package com.khy.example05;

public class Account {

	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	// �Աݾ�
	public void deposit(int money) {
		balance += money;
	}
	
	// ��ݾ�
	public void withdraw(int money) throws BalanceInsufficientException { // �ش� ���ܿ� ���� �ڽ��� ȣ���� �޼������� ���� ó���� �ñ�� throws
		if(balance < money) {
			throw new BalanceInsufficientException("Not enough money"); // ���� �߻���Ű�� throw(������ ���ܰ� �߻��ϱ� ������ try catch�� ó���ؾ� ��)
			// new �����ڷ� ���ܸ� ��������
		}
		balance -= money;
	}
}
