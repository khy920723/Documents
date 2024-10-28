package com.khy.example02;

public class Computer {
	// 인자를 가변적으로 받아야 할 때
	int sum1(int[] values) {
		int sum = 0;
		for(int i: values) {
			sum += i;
		}
		
		return sum;
	}
	
	// 인자를 가변적으로 받아야 할 때
	int sum2(int ... values) { // ...: 가변 인수와 같음
		int sum = 0;
		for(int i: values) {
			sum += i;
		}
		
		return sum;
	}
}
