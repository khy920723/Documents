package com.khy.example01;

import java.util.Scanner;
import java.util.Calendar;

public class Helloworld {
	public static void main(String[] args) {
		
		if(args.length != 2) { // args�� ���α׷��� ó�� ���� �� �� ���ڸ� �޴� ������ ��
			System.out.println("���α׷� ����");
			System.out.println("java ���α׷��� ����1 ����2");
			System.exit(0);
		}
		String str1 = args[0];
		String str2 = args[1];
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result); 
	}
}		 
		
		