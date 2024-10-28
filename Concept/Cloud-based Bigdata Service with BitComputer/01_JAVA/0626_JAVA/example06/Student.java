package com.khy.example06;

public class Student {

	private String name;
	private String sex;
	private int score;
	
	public Student(String name, String sex, int score) {
		this.name = name;
		this.sex = sex;
		this.score = score;
	}
	
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}
