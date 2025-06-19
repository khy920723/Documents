package com.khy.example02;

public class Singleton {

	// 클래스 로더가 static 내용을 올림 (static 메모리에)
	// 이 떄, 메인 함수가 실행되기 전에 static 메모리에 올리고 실행문이 있을 경우 실행까지 시켜버림
	private static Singleton singleton = new Singleton(); // static 메모리의 singleton이 Heap 메모리의 객체를 레퍼런스로 가짐

	private Singleton() {

	};

	static Singleton getInstance() {
		return singleton;
	}

}
