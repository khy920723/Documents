package com.khy.example05;

// ���׸� �����(��ü�� �� �� Ÿ���� �����ϰڴ�)
public class Box<T> { // Ÿ�� ������ �빮�ڷ� ��(ö�ڴ� ��� ����)

	private T t; // TŸ�Կ� � ���� �� �� �𸣴ϱ� �̷��� �ۼ�
	
	public T getObject() {
		return t;
	}
	
	public void setObject(T t) {
		this.t = t;
	}
	
	// ���� ����
	/*
	private Object object; // TŸ�Կ� � ���� �� �� �𸣴ϱ� �̷��� �ۼ�
	
	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	*/
}
