package com.khy.example06;

public class Member {

	private String name = "Someone";
	private String id = "None";

	public Member() {
		System.out.println("Member() running");
	}

	public Member(String id) {
		System.out.println("Member(String id) running");
		this.id = id;
	}
	
	public Member(String name, String id) {
		System.out.println("Member(String name, String id) running");
		this.name = name;
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	public void printStatus() {
		System.out.println("name: " + name);
		System.out.println("id: " + id);
	}
	
	
	
}
