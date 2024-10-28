package com.khy.example03;

public class GasolineEngine extends Engine {

	/*
	 * GasolineEngine(int cylinder, String oil){ super(cylinder, oil); }
	 */
	
	
	
	@Override
	public void runEngine() {
		System.out.println("Brrrrrrr!");
	}

	// source -> generate ~superclass 기능 클릭으로 만듦
	public GasolineEngine(int numOfCylinder, String oil) {
		super(numOfCylinder, oil);
		// TODO Auto-generated constructor stub
	}
}
