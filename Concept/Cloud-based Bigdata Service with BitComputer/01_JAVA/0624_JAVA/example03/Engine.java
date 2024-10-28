package com.khy.example03;

public class Engine {

	private int numOfCylinder;
	private String oil;
	
	Engine(int numOfCylinder, String oil){
		this.numOfCylinder = numOfCylinder;
		this.oil = oil;
	}
	
	public void showStatus() {
		System.out.println("Cylinder: " + numOfCylinder);
		System.out.println("Oil: " + oil);
	}
	
	public void runEngine() {
		System.out.println("엔진가동");
	}
}
