package com.khy.example02;

public class Calculator {
	// 정사각형
	double areaRectangle(double width) {
		return width * width;
	}
	
	// 직사각형(오버로딩)
	double areaRectangle(double width, double height) { // 인자의 타입과 갯수로만 오버로딩 구분
		return width * height;
	}

}
