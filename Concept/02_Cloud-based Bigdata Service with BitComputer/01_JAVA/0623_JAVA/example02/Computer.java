package com.khy.example02;

public class Computer {
	// ���ڸ� ���������� �޾ƾ� �� ��
	int sum1(int[] values) {
		int sum = 0;
		for(int i: values) {
			sum += i;
		}
		
		return sum;
	}
	
	// ���ڸ� ���������� �޾ƾ� �� ��
	int sum2(int ... values) { // ...: ���� �μ��� ����
		int sum = 0;
		for(int i: values) {
			sum += i;
		}
		
		return sum;
	}
}
