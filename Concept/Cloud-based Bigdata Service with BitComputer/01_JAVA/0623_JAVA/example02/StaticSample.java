package com.khy.example02;

public class StaticSample {

	// �ν��Ͻ� �ʵ�� �޼ҵ�
	int field;
	void method1() {
		this.field = 100;
		System.out.println(this.field);
	}
	
	// static �ʵ�� �޼���
	static int field2;
	static void method2() {
		
	}
	
	// ����ƽ ���(���� ��Ű�ڸ��� ����Ǵ� ���)
	static {
		// field1 = 10; // new�� �ν��Ͻ�ȭ �ؼ� ����ϱ� ������ ���� ���̱� ������ ���� �޼��� �߻�
		// method1();
		field2= 10;
		method2();
	}
	
	// ����ƽ �޼���(�θ��� ������ ������� ����)
	static void method3() {
		// this.field2 = 20; // this�� �ν��Ͻ��� ������ �� ��� �����ϱ� ������ ���� �߻�
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
