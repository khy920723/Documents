package com.khy.example02;

public class StaticSample {

	// 인스턴스 필드와 메소드
	int field;
	void method1() {
		this.field = 100;
		System.out.println(this.field);
	}
	
	// static 필드와 메서드
	static int field2;
	static void method2() {
		
	}
	
	// 스태틱 블록(실행 시키자마자 실행되는 블록)
	static {
		// field1 = 10; // new로 인스턴스화 해서 사용하기 전까지 없는 것이기 때문에 에러 메세지 발생
		// method1();
		field2= 10;
		method2();
	}
	
	// 스태틱 메서드(부르기 전까진 실행되지 않음)
	static void method3() {
		// this.field2 = 20; // this는 인스턴스가 존재할 때 사용 가능하기 때문에 에러 발생
		// this.method2();
		field2 = 20;
		method2();
		
	}
	
	static void method4() {
		StaticSample myInstance = new StaticSample();
		myInstance.field = 10;
		myInstance.method1();
	}
}
