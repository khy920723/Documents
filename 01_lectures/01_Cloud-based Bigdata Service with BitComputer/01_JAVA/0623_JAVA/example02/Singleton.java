package com.khy.example02;

public class Singleton {

	// Ŭ���� �δ��� static ������ �ø� (static �޸𸮿�)
	// �� ��, ���� �Լ��� ����Ǳ� ���� static �޸𸮿� �ø��� ���๮�� ���� ��� ������� ���ѹ���
	private static Singleton singleton = new Singleton(); // static �޸��� singleton�� Heap �޸��� ��ü�� ���۷����� ����

	private Singleton() {

	};

	static Singleton getInstance() {
		return singleton;
	}

}
