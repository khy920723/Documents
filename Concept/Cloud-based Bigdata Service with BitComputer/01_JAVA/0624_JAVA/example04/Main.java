package com.khy.example04;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car tico = new Car(new DieselEngine());
		tico.drive();
	
		Car equus = new Car(new Engine() { // Eng까지만 치고 컨트롤+스페이스바를 입력하여 어나니머스~ 기능을 쓰면 자동으로 오버라이드 할 것이 생성됨
			
			@Override
			public void runEngine() {
				// TODO Auto-generated method stub
				System.out.println("Brrrrrrrrrr");
			}
		});
		equus.drive(); // Car 클래스의 drive 메서드가 runEngine을 호출하므로 해당 문법 사용가능
		
		Car h = new Car(new Engine() {
			
			@Override
			public void runEngine() {
				// TODO Auto-generated method stub
				System.out.println("Brrrrr22222");
			}
		});
		h.drive();
	
	
	}
	

}
