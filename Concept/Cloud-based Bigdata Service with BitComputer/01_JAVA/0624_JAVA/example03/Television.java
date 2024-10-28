package com.khy.example03;

public class Television implements RemoteControl { // RemoteControl을 구현한 Televion

	private int volumn;
	
	public Television() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV On");
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Tv Off");
	}

	@Override
	public void setVolumn(int volumn) {
		// TODO Auto-generated method stub
		if(volumn > RemoteControl.MAX_VOLUMN) {
			this.volumn = RemoteControl.MAX_VOLUMN;
		}
		else if(volumn < RemoteControl.MIN_VOLUMN) {
			this.volumn = RemoteControl.MIN_VOLUMN;
		}
		else {
			this.volumn = volumn;
		}
		System.out.println("now TV's volumn" + volumn);
	}

	
}
