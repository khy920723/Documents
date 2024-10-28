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

		animalsound(new Dog()); // 인자를 new로 객체 생성 방식으로 만들어줌
		animalSound(new Bird());
		
		 
	}
}



// 인터페이스
/*
 * 상수와 메소드만 가짐
 * 생성자 없어서 객체생성 불가능
 * 추상메소드, 디폴트메서드 및 정적메서드
 * 데이터 저장이 불가능하므로 필드 선언 불가
 * 상수필드만 선언가능(public static final 생략가능, 컴파일 과정에서 자동 첨가)
 * 추상메서드는 public abstract 특성을 가짐(생략가능, 컴파일 과정에서 자동 첨가)
 * default 메서드는 public 특성을 가짐(생략가능, 컴파일 과정에서 자동 첨가), 디폴트 지정자가 유일하게 추상 클래스 내에서 선언 가능하게 만듦
 * static 메서드는 public 특성을 가짐(생략가능, 컴파일 과정에서 자동 첨가)
 * 인터페이스를 구현하는 클래스를 구현클래스, 실제 메소드를 가지는 객체를 구현객체
 * 인터페이스를 implements 한 클래스에서 인터페이스의 추상메소드를 구현하지 않으면 해당 클래스는 추상클래스가 됨, 그렇기 때문에 선언부에 abstract 키워드 추가 필요
 */
//RemoteControl rc; // 구현했을 땐 부모 타입으로 업캐스팅
//
//rc = new Television();
///*
// * rc = new Television() { // 익명 구현 객체: 1번만 사용 할 인터페이스를 굳이 파일 만들기 귀찮을 때 해당 코드 작성
// * 방법으로 씀 
// * private int volumn; // 이렇게 만들 때 기존에 클래스로 만들었을 때와는 다르게 생성자를 구현한 코드 부분에서
// * 에러(익명 구현 객체로 작성 시 생성자 사용 불가인 듯)
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
// * }; // 실행문이기 때문에 끝에 세미콜론
// * 붙여줘야 함
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
// * System.out.println("오디오 킴");
// * 
// * }
// * 
// * @Override 
// * public void turnOff() { 
// * // TODO Auto-generated method stub
// * System.out.println("오디오 끔"); 
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
//ArrayList<String> aList = new ArrayList<String>(); // ArrayList: List 인터페이스를 상속받은 클래스
//// 크기가 가변적으로 변하는 선형리스트
//aList.add("aaaaaaa");
//aList.add("ddddddd");
//
//System.out.println(aList.get(0));
//System.out.println(aList.get(1));
//
//String hello = (String)aList.get(0);
//// String hello2 = aList.get(0); // <String>으로 제네릭하게 만들지 않으면 에러
//System.out.println(hello);


// 인스턴스 메서드(따라서 static 영역을 선언해줘야함)
/*
public static void animalSound(Animal animal) { // 인자가 애니멀 타입
	System.out.println("static");
	animal.sound();
}
*/
