package com.khy.example03;

public class GasolineEngine extends Engine {

	/*
	 * GasolineEngine(int cylinder, String oil){ super(cylinder, oil); }
	 */
	
	
	
	@Override
	public void runEngine() {
		System.out.println("Brrrrrrr!");
	}

	// source -> generate ~superclass ��� Ŭ������ ����
	public GasolineEngine(int numOfCylinder, String oil) {
		super(numOfCylinder, oil);
		// TODO Auto-generated constructor stub
	}
}
