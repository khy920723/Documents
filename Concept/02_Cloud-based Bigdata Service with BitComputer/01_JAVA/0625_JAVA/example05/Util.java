package com.khy.example05;

public class Util {

	// �޼ҵ带 ���׸� ������ �� ��, ����Ÿ�� �� �ʿ� ���׸� ����(Ŭ������ �տ�)
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getkey().equals(p2.getkey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}
