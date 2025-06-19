package com.khy.example02;

public class Car {
	// ������, �ʵ�� �׻� �ҹ��ڷ� �ۼ�
	String company = "NOKIA";
	String model = "Matrix-CP";
	String color = "Black";
	int horsePower = 300000;
	
	// �����ڷ� ��ü
	/*
	void setFields(String company, String model, String color, int horsePower) {
		// this: �� Ŭ������ ��ü�� �Ǿ��� �� �ڱ��ڽ��� ��Ī
		this.company = company;
		this.model = model;
		this.color = color;
		this.horsePower = horsePower;
	}
	*/
	
	// ������(constructor): ��ü�� ������ �� ����Ǵ� �޼��� ����
	Car(String company, String model, String color, int horsePower){
		// this();�� ����Ͽ� ��ȯ�ϴ� ������ �ۼ� �� �ʱ� ä���� �ʵ���� ���� ���� ä�� �ʿ䰡 ���� ��� �̷� ������ �ۼ�(������ ��� �� �ڵ� �ߺ� ȸ��)
		this(company, model, color); // ������ Car(���� 3��) �κ� ȣ��, this�� ��� �ʵ带 �ۼ��ϰ� �Ǹ� ������ ���� ����(���� �� �߻�)
		/*
		 * this.company = company; 
		 * this.model = model; 
		 * this.color = color;
		 */
		this.horsePower = horsePower;
	}
	
	// ������(���� 3��)
	// �����ε�
	Car(String company, String model, String color){
		this(company, model);
		/*
		 * this.company = company; 
		 * this.model = model;
		 */
		this.color = color;
	}
	
	// ������
	Car(String company, String model){
		this(company);
		/* this.company = company; */
		this.model = model;
	}
	
	// ������
	Car(String company){
		this.company = company;
	}
	
	// �⺻ ������ ���������� ���� �ۼ��� 1�� �̻��� ������(���� ������)�� �ۼ��ϰ� �Ǹ� �⺻ ������ ���¸� �ۼ������ ��
	Car(){
		
	}
	
	void setCompany(String c) { // ��� ���� �� ���� ���� void
		company = c;
	}
	
	// �ʵ� ��� ����
	void printFields() {
		System.out.println("company: " + company);
		System.out.println("model: " + model);
		System.out.println("color: " + color);
		System.out.println("HP: " + horsePower);
	}
	
	String getCompany() { // return Ÿ���� string�̹Ƿ�
		return company;
	}
}
