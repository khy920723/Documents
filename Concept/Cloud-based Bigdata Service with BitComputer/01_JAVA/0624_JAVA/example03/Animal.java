package com.khy.example03;

public abstract class Animal {

	public String kind;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	public void live() {
		System.out.println("Eating Pooping");
	}
	
	public abstract void sound(); // 자식 클래스에서 오버라이드 시켜줘야 함

}
