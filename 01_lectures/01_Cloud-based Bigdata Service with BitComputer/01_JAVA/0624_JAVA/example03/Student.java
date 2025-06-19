package com.khy.example03;

public class Student extends Person{

	public int studentNo = 123;
		
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn); // 부모클래스의 인자 두 개 있는 생성자 호출
		this.studentNo = studentNo;
	}
	
	public Student() {
		
	}
}
