package com.khy.example06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	
//	private static final String List = null;

	public static void main(String[] args) {
		
//		String s = "Hello";
//		String t = "hello";
//		System.out.println(s.equals(t)); // 대소문자 구분, 참 거짓 리턴
//		System.out.println(s.compareToIgnoreCase(t)); // 대소문자 구분 x, 같으면 0 리턴
	
		
		// 매개변수의 메소드 참조
//		ToIntBiFunction<String, String> function; // 리턴타입이 무조건 인티저
//		
//		function = (a, b) -> a.compareToIgnoreCase(b); // 대소문자 구분x
//		print(function.applyAsInt("Hello World", "hello world"));
//		
//		function = String::compareToIgnoreCase; // :: 여기 있는 메소드중에 ~를 사용하겠다
//		print(function.applyAsInt("Hello World", "hello world")); // a, b로 주지 않아도 순서대로 파라미터를 받아 처리함
		
		
		// <생성자 참조>
//		Function<String, Member> function1 = Member::new; // new Member, function 타입의 Member 객체의 생성자를 호출하겠다
//		// (a, b) -> {return new 클래스(a, b);}와 같음
//		Member member1 = function1.apply("java8"); // apply는 Fucntion의 메서드
//		member1.printStatus();
//		
//		BiFunction<String, String, Member> function2 = Member::new;
//		Member member2 = function2.apply("Hong", "java8");
//		member2.printStatus();
		
		
		// 컬렉션
		// 1. List: arrayList, vector, linkedList (순서가 있음, 중복저장 가능) -> 인터페이스: 구현 클래스들
		// 2. Map: hashMap, hashTable
		
		// 1. ArrayList
//		List<String> list = new ArrayList<String>(); // 디폴트로 사이즈 10개 공간 생김, 부모 클래스로 업캐스팅(오버라이드 했으므로)
//		
//		list.add("Java");
//		list.add("C++");
//		list.add("Python");
//		list.add("C#");
//		list.add("Objective-C");
//		
//		int size = list.size();
//		System.out.println("데이터 수: " + size);
//		System.out.println();
//		
//		String item = list.get(2);
//		System.out.println("인덱스 2번 항목: " + item + "\n");
//		
//		for(int i = 0; i< list.size(); i++) {
//			String str = list.get(i);
//			System.out.println(i + ": " + str);
//		}
//		System.out.println();
//		
//		list.remove(2);
//		list.remove(2);
//		list.remove("C++");
//		
//		for(String s: list) {
//			System.out.println(s);
//		}
		// 쓰레드 환경에서는 벡터를 사용
		
		
		// 2. Map
		// (key, value)의 모습
//		Map<String, Integer> map = new HashMap<String, Integer>(); // 부모 클래스로 업캐스팅
//		
//		map.put("국어", 90);
//		map.put("영어", 85);
//		map.put("수학", 95);
//		map.put("과학", 100);		
//		
//		System.out.println("총 엔트리 수: " + map.size());
//		System.out.println("국어점수: " + map.get("국어") + "\n");
//		
//		// 키를 이용하여 값을 가져옴(구현 안 함)
		
//		Set<String> keySet = map.keySet(); // 키 값만 모아서 Set 형태로 뽑아줌
//		Iterator<String> keyIterator = keySet.iterator(); // 이터레이터: 반복자
//		
//		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
//		
//		// 키하고 값을 모두 가져옴
//		while(keyIterator.hasNext()) { // 하나하나 뽑아오는 코드
//			Map.Entry<String, Integer> entry = entryIterator.next();
//			String key = entry.getKey();
//			Integer value = entry.getValue();
//			System.out.println(key + ": " + value);
//		}
//		System.out.println();
//		
//		map.clear();
//		System.out.println("총 엔트리 수: " + map.size());
		
		
		
		// 이터레이터 내부에서 출력해보기
//		List<String> list = Arrays.asList("서울", "대전", "부산");
//		
//		Iterator<String> iterator = list.iterator(); // 이터레이터를 밖으로 내보내서
//		while(iterator.hasNext()) {
//			String city = iterator.next();
//			System.out.println(city);
//		}
//		System.out.println();
//		
//		Stream<String> stream = list.stream();
//		// while로 뽑은 것 처럼 뽑아보기(이터레이터 내부에서 돌려보는 방식)
//		stream.forEach(s -> System.out.println(s)); // 컨슈머 형식의 익명객체를 해줘라
		
		
		List<Student> list = Arrays.asList(
				new Student("Hong", "male", 90),
				new Student("Lee", "male", 95)
		);
		
		// 이름: 점수
		// 이름: 점수
		// 모양으로 출력
		Stream<Student> stream = list.stream();
		stream.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		// stream.forEach(s -> {
		// String name = s.getName();
		// int score = s.getScore();
		// Sysout.println(name + " : " + score);
		// }); 
		
		
	}
	
	// 생성자 참조 부분
//	public static void print(int order) {
//		if(order == 0) {
//			System.out.println("Same String.");
//		}
//	}
}
