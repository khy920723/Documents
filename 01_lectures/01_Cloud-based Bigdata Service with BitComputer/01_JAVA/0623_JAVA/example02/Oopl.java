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
		System.out.println(tico.toString()); // ��Ű����.Ŭ������.��üID ���(������Ʈ�� ��ӹ޾ұ� ������)
		    
	}
}

