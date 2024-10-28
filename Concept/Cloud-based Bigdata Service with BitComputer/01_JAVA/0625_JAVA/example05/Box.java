package com.khy.example05;

// 제네릭 만들기(객체를 쓸 때 타입을 지정하겠다)
public class Box<T> { // 타입 변수는 대문자로 씀(철자는 상관 없음)

	private T t; // T타입에 어떤 것이 올 지 모르니까 이렇게 작성
	
	public T getObject() {
		return t;
	}
	
	public void setObject(T t) {
		this.t = t;
	}
	
	// 기존 형태
	/*
	private Object object; // T타입에 어떤 것이 올 지 모르니까 이렇게 작성
	
	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	*/
}
