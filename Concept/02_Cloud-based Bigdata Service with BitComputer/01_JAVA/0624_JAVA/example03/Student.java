package com.khy.example03;

public class Student extends Person{

	public int studentNo = 123;
		
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn); // �θ�Ŭ������ ���� �� �� �ִ� ������ ȣ��
		this.studentNo = studentNo;
	}
	
	public Student() {
		
	}
}
