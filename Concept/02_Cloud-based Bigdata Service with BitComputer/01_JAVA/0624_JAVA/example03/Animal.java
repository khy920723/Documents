package com.khy.example03;

public abstract class Animal {

	public String kind;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	public void live() {
		System.out.println("Eating Pooping");
	}
	
	public abstract void sound(); // �ڽ� Ŭ�������� �������̵� ������� ��

}
