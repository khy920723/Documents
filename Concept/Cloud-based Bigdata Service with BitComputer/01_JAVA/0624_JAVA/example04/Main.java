package com.khy.example04;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car tico = new Car(new DieselEngine());
		tico.drive();
	
		Car equus = new Car(new Engine() { // Eng������ ġ�� ��Ʈ��+�����̽��ٸ� �Է��Ͽ� ��ϸӽ�~ ����� ���� �ڵ����� �������̵� �� ���� ������
			
			@Override
			public void runEngine() {
				// TODO Auto-generated method stub
				System.out.println("Brrrrrrrrrr");
			}
		});
		equus.drive(); // Car Ŭ������ drive �޼��尡 runEngine�� ȣ���ϹǷ� �ش� ���� ��밡��
		
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
