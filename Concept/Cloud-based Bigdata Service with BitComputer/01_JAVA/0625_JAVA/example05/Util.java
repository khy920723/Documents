package com.khy.example05;

public class Util {

	// 메소드를 제네릭 선언을 할 때, 리턴타입 앞 쪽에 제네릭 선언(클래스는 앞에)
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getkey().equals(p2.getkey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}
