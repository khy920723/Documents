package com.khy.example02;

public class Tico extends Car2{ // extends(���): ���� ���� Ŭ������ �ڵ忡 extends �ۼ� �� ��� ���� Ŭ���� �ۼ�

	Tico(String model, String color){
		this.model = model;
		this.color = color;
	}
	
	public void openRoof() {
		System.out.println("OPENNING!!!");
	}
	
	public void closeRoof() {
		System.out.println("CLOSING!!!");
	}
}
