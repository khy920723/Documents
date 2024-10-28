package com.khy.example02;

public class Tico extends Car2{ // extends(상속): 새로 만든 클래스명 코드에 extends 작성 후 상속 받을 클래스 작성

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
