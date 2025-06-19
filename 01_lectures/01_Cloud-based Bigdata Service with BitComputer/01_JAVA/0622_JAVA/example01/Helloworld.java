package com.khy.example01;

import java.util.Scanner;
import java.util.Calendar;

public class Helloworld {
	public static void main(String[] args) {
		
		if(args.length != 2) { // args는 프로그램을 처음 실행 할 때 인자를 받는 역할을 함
			System.out.println("프로그램 사용법");
			System.out.println("java 프로그램명 숫자1 숫자2");
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
		
		