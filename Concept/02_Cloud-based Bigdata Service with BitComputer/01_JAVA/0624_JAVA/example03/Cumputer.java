package com.khy.example03;

public class Cumputer extends Calculator {

	@Override // �̰� ��� ��� ����(annotation) ������ �̰� ���� �������̵� �Ǽ��� �� �� ǥ�ø� ����
	public double areaCircle(double radius) { // Ÿ�԰� ���� �� ��� ���� �Ȱ��� ���ܾ���
		System.out.println("Calculator ��ü�� areaCircle() ����");
		return Math.PI * radius *radius;

	}
}
