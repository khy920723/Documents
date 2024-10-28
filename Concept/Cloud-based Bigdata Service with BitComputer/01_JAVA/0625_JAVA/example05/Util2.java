package com.khy.example05;

public class Util2 {

	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue(); // Number의 doubleValue() 메서드, double 값을 가져옴
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
	}
}
