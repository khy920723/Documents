package com.khy.example03;

import java.util.ArrayList;

public class Exam03 {
	public static void main(String[] args) {
		
		
		Dog jindoDog = new Dog();
		Bird sparrow = new Bird();
		Animal animal = new Dog();

		animal.sound();
		jindoDog.sound();
		sparrow.sound();
		System.out.println("----------------------------------------------------------");

		animalsound(new Dog()); // ���ڸ� new�� ��ü ���� ������� �������
		animalSound(new Bird());
		
		 
	}
}



// �������̽�
/*
 * ����� �޼ҵ常 ����
 * ������ ��� ��ü���� �Ұ���
 * �߻�޼ҵ�, ����Ʈ�޼��� �� �����޼���
 * ������ ������ �Ұ����ϹǷ� �ʵ� ���� �Ұ�
 * ����ʵ常 ���𰡴�(public static final ��������, ������ �������� �ڵ� ÷��)
 * �߻�޼���� public abstract Ư���� ����(��������, ������ �������� �ڵ� ÷��)
 * default �޼���� public Ư���� ����(��������, ������ �������� �ڵ� ÷��), ����Ʈ �����ڰ� �����ϰ� �߻� Ŭ���� ������ ���� �����ϰ� ����
 * static �޼���� public Ư���� ����(��������, ������ �������� �ڵ� ÷��)
 * �������̽��� �����ϴ� Ŭ������ ����Ŭ����, ���� �޼ҵ带 ������ ��ü�� ������ü
 * �������̽��� implements �� Ŭ�������� �������̽��� �߻�޼ҵ带 �������� ������ �ش� Ŭ������ �߻�Ŭ������ ��, �׷��� ������ ����ο� abstract Ű���� �߰� �ʿ�
 */
//RemoteControl rc; // �������� �� �θ� Ÿ������ ��ĳ����
//
//rc = new Television();
///*
// * rc = new Television() { // �͸� ���� ��ü: 1���� ��� �� �������̽��� ���� ���� ����� ������ �� �ش� �ڵ� �ۼ�
// * ������� �� 
// * private int volumn; // �̷��� ���� �� ������ Ŭ������ ������� ���ʹ� �ٸ��� �����ڸ� ������ �ڵ� �κп���
// * ����(�͸� ���� ��ü�� �ۼ� �� ������ ��� �Ұ��� ��)
// * 
// * @Override public void turnOn() { 
// * // TODO Auto-generated method stub
// * System.out.println("TV On");
// * 
// * }
// * 
// * @Override public void turnOff() { 
// * // TODO Auto-generated method stub
// * System.out.println("Tv Off"); 
// * }
// * 
// * @Override public void setVolumn(int volumn) { 
// * // TODO Auto-generated method
// * stub 
// * if(volumn > RemoteControl.MAX_VOLUMN) { 
// * this.volumn =
// * RemoteControl.MAX_VOLUMN; 
// * } 
// * else if(volumn < RemoteControl.MIN_VOLUMN) {
// * this.volumn = RemoteControl.MIN_VOLUMN; 
// * } 
// * else { 
// * this.volumn = volumn; 
// * }
// * System.out.println("now TV's volumn" + volumn); 
// * }
// * }; // ���๮�̱� ������ ���� �����ݷ�
// * �ٿ���� ��
// */		
//rc.turnOn();
//rc.turnOff();
//
//rc = new Audio();
///*
// * rc = new Audio() { 
// * private int volumn;
// * 
// * @Override 
// * public void turnOn() { 
// * // TODO Auto-generated method stub
// * System.out.println("����� Ŵ");
// * 
// * }
// * 
// * @Override 
// * public void turnOff() { 
// * // TODO Auto-generated method stub
// * System.out.println("����� ��"); 
// * }
// * 
// * @Override
// * public void setVolumn(int volumn) { 
// * // TODO Auto-generated method
// * stub 
// * if(volumn > RemoteControl.MAX_VOLUMN) { 
// * this.volumn =
// * RemoteControl.MAX_VOLUMN; 
// * } 
// * else if(volumn < RemoteControl.MIN_VOLUMN) {
// * this.volumn = RemoteControl.MIN_VOLUMN; 
// * } 
// * else { 
// * this.volumn = volumn; 
// * }
// * System.out.println("Now Audios's Volumn: " + volumn); }
// * 
// * };
// */		
//rc.turnOn();
//rc.turnOff();
//rc.setMute(true);
//
//RemoteControl.changeBattery();
//
//System.out.println("---------------------------------");
//
//ArrayList<String> aList = new ArrayList<String>(); // ArrayList: List �������̽��� ��ӹ��� Ŭ����
//// ũ�Ⱑ ���������� ���ϴ� ��������Ʈ
//aList.add("aaaaaaa");
//aList.add("ddddddd");
//
//System.out.println(aList.get(0));
//System.out.println(aList.get(1));
//
//String hello = (String)aList.get(0);
//// String hello2 = aList.get(0); // <String>���� ���׸��ϰ� ������ ������ ����
//System.out.println(hello);


// �ν��Ͻ� �޼���(���� static ������ �����������)
/*
public static void animalSound(Animal animal) { // ���ڰ� �ִϸ� Ÿ��
	System.out.println("static");
	animal.sound();
}
*/
