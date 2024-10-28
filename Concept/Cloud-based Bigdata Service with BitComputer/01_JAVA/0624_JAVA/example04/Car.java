package com.khy.example04;

public class Car {

	private Engine carEngine;
	
	public Car(Engine carEngine) {
		this.carEngine = carEngine;
	}
	
	public void drive() {
		carEngine.runEngine();
	}
}
