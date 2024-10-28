package com.khy.example03;

public class Audio implements RemoteControl {

	private int volumn;
	private boolean mute;
	
	public Audio() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("¿Àµð¿À Å´");
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("¿Àµð¿À ²û");
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
		System.out.println("Now Audios's Volumn: " + volumn);
	}

	@Override
	public void setMute(boolean mute) {
		// TODO Auto-generated method stub
		this.mute = mute;
		if(mute) {
			System.out.println("Audio Mute on");
		}
		else {
			System.out.println("Audio Mute off");
		}
	}
	
	
	
	

}
