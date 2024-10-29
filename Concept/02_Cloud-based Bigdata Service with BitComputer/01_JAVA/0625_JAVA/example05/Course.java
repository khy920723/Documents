package com.khy.example05;

public class Course<T> {

	private String name;
	private T[] students;

	public Course(String name, int capacity) {
		this.name = name;
		students = (T[]) (new Object[capacity]); // �迭�� ���׸����� ���� ������ ���(TŸ������ ����ȯ)
		// ������Ʈ�� �ֻ��� �θ𿩼� ���������� �ϴ� ���� ���� -> TŸ������ ����ȯ(T�� ���� �𸣴ϱ� new�� ������ ���� ����)
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
				break; // ���� ����� �ݺ������� ����
			}
		}
	}
}
