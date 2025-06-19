package com.khy.example05;

public class Course<T> {

	private String name;
	private T[] students;

	public Course(String name, int capacity) {
		this.name = name;
		students = (T[]) (new Object[capacity]); // 배열을 제네릭으로 만들 유일한 방법(T타입으로 형변환)
		// 오브젝트가 최상위 부모여서 저런식으로 일단 먼저 만듦 -> T타입으로 형변환(T가 뭔지 모르니까 new로 선언할 수가 없음)
	}

	public String getName() {
		return name;
	}

	public T[] getStudents() {
		return students;
	}

	public void add(T t) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = t;
				break; // 가장 가까운 반복문에서 나옴
			}
		}
	}
}
