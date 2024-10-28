package com.khy.example02;

public class Oopl {
	public static void main(String[] args) {

		Tico tico = new Tico("Tico", "Red");
		
		System.out.println("model: " + tico.model);
		System.out.println("color: " + tico.color);
		
		tico.drive();
		tico.stop();
		tico.openRoof();
		tico.closeRoof();
		System.out.println(tico.toString()); // 패키지명.클래스명.객체ID 출력(오브젝트를 상속받았기 때문에)
		    
	}
}

