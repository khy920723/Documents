package com.khy.example03;

public interface RemoteControl {

	public int MAX_VOLUMN = 10; // 상수라 대문자로 씀(static final)
	public int MIN_VOLUMN = 0;
	
	public void turnOn(); // abstract
	public void turnOff();
	public void setVolumn(int volumn);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("Mute on");
		}
		else {
			System.out.println("Mute off");
		}
	}
	
	public static void changeBattery() {
		System.out.println("Changing Battery");
	}
	
}
