package com.khy.example03;

public class Child extends Parent {
	
	public String childField;
	
	public void method3() {
		System.out.println("Child-method3()");
	}
	
	@Override
	public void method2() {
		System.out.println("Child-method2()");
	}
}
