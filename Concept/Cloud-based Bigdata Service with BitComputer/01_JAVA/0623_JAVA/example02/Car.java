package com.khy.example02;

public class Car {
	// 변수명, 필드는 항상 소문자로 작성
	String company = "NOKIA";
	String model = "Matrix-CP";
	String color = "Black";
	int horsePower = 300000;
	
	// 생성자로 대체
	/*
	void setFields(String company, String model, String color, int horsePower) {
		// this: 이 클래스가 객체가 되었을 때 자기자신을 지칭
		this.company = company;
		this.model = model;
		this.color = color;
		this.horsePower = horsePower;
	}
	*/
	
	// 생성자(constructor): 객체가 생성될 때 실행되는 메서드 정보
	Car(String company, String model, String color, int horsePower){
		// this();를 사용하여 순환하는 구조로 작성 시 초기 채워질 필드들의 값을 전부 채울 필요가 없을 경우 이런 식으로 작성(가독성 상승 및 코드 중복 회피)
		this(company, model, color); // 생성자 Car(인자 3개) 부분 호출, this에 모든 필드를 작성하게 되면 컴파일 오류 생김(무한 콜 발생)
		/*
		 * this.company = company; 
		 * this.model = model; 
		 * this.color = color;
		 */
		this.horsePower = horsePower;
	}
	
	// 생성자(인자 3개)
	// 오버로딩
	Car(String company, String model, String color){
		this(company, model);
		/*
		 * this.company = company; 
		 * this.model = model;
		 */
		this.color = color;
	}
	
	// 생성자
	Car(String company, String model){
		this(company);
		/* this.company = company; */
		this.model = model;
	}
	
	// 생성자
	Car(String company){
		this.company = company;
	}
	
	// 기본 생성자 형태이지만 위에 작성된 1개 이상의 생성자(인자 여러개)를 작성하게 되면 기본 생성자 형태를 작성해줘야 함
	Car(){
		
	}
	
	void setCompany(String c) { // 결과 리턴 할 것이 없다 void
		company = c;
	}
	
	// 필드 출력 영역
	void printFields() {
		System.out.println("company: " + company);
		System.out.println("model: " + model);
		System.out.println("color: " + color);
		System.out.println("HP: " + horsePower);
	}
	
	String getCompany() { // return 타입이 string이므로
		return company;
	}
}
