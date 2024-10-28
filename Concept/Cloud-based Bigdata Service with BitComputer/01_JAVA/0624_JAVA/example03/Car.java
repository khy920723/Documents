package com.khy.example03;

public class Car {

	private Engine engine;
	
	public Car(Engine engine) {
		this.engine = engine;
		// TODO Auto-generated constructor stub
	}
	
	public void drive() {
		engine.runEngine();
	}

}
