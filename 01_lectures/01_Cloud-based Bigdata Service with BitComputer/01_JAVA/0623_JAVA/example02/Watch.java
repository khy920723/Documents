package com.khy.example02;

public class Watch {
	
	// static 사용 시 주의사항
	static String company = "Rolex";
	static String model = "Rolex";
	static String feature = "feature";

	static {
		feature = company + "-" + model + "한정판";
	
	}
}
