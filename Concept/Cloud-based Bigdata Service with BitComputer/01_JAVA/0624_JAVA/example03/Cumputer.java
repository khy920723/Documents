package com.khy.example03;

public class Cumputer extends Calculator {

	@Override // 이건 없어도 상관 없음(annotation) 하지만 이걸 쓰면 오버라이드 실수를 할 때 표시를 해줌
	public double areaCircle(double radius) { // 타입과 인자 등 모든 것이 똑같이 생겨야함
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return Math.PI * radius *radius;

	}
}
