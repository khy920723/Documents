package com.khy.example02;

public class CapsulationPX {

	private int speed;
	private boolean stop;
	
	// getter
	public int getSpeen() {
		return speed;
	}
	
	// setter
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
		}
		else {
			this.speed = speed;
		}
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}
}
