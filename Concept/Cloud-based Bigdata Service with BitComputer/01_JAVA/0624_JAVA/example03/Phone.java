package com.khy.example03;

public abstract class Phone {

	public String owner;
	
	public Phone(String owner) {
		this.owner = owner;
		// TODO Auto-generated constructor stub
	}
	
	public void turnOn() {
		System.out.println("System On");
	}
	
	public void turnOff() {
		System.out.println("System Off");
	}

}
