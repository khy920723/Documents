package com.khy.example06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	
//	private static final String List = null;

	public static void main(String[] args) {
		
//		String s = "Hello";
//		String t = "hello";
//		System.out.println(s.equals(t)); // ��ҹ��� ����, �� ���� ����
//		System.out.println(s.compareToIgnoreCase(t)); // ��ҹ��� ���� x, ������ 0 ����
	
		
		// �Ű������� �޼ҵ� ����
//		ToIntBiFunction<String, String> function; // ����Ÿ���� ������ ��Ƽ��
//		
//		function = (a, b) -> a.compareToIgnoreCase(b); // ��ҹ��� ����x
//		print(function.applyAsInt("Hello World", "hello world"));
//		
//		function = String::compareToIgnoreCase; // :: ���� �ִ� �޼ҵ��߿� ~�� ����ϰڴ�
//		print(function.applyAsInt("Hello World", "hello world")); // a, b�� ���� �ʾƵ� ������� �Ķ���͸� �޾� ó����
		
		
		// <������ ����>
//		Function<String, Member> function1 = Member::new; // new Member, function Ÿ���� Member ��ü�� �����ڸ� ȣ���ϰڴ�
//		// (a, b) -> {return new Ŭ����(a, b);}�� ����
//		Member member1 = function1.apply("java8"); // apply�� Fucntion�� �޼���
//		member1.printStatus();
//		
//		BiFunction<String, String, Member> function2 = Member::new;
//		Member member2 = function2.apply("Hong", "java8");
//		member2.printStatus();
		
		
		// �÷���
		// 1. List: arrayList, vector, linkedList (������ ����, �ߺ����� ����) -> �������̽�: ���� Ŭ������
		// 2. Map: hashMap, hashTable
		
		// 1. ArrayList
//		List<String> list = new ArrayList<String>(); // ����Ʈ�� ������ 10�� ���� ����, �θ� Ŭ������ ��ĳ����(�������̵� �����Ƿ�)
//		
//		list.add("Java");
//		list.add("C++");
//		list.add("Python");
//		list.add("C#");
//		list.add("Objective-C");
//		
//		int size = list.size();
//		System.out.println("������ ��: " + size);
//		System.out.println();
//		
//		String item = list.get(2);
//		System.out.println("�ε��� 2�� �׸�: " + item + "\n");
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
		// ������ ȯ�濡���� ���͸� ���
		
		
		// 2. Map
		// (key, value)�� ���
//		Map<String, Integer> map = new HashMap<String, Integer>(); // �θ� Ŭ������ ��ĳ����
//		
//		map.put("����", 90);
//		map.put("����", 85);
//		map.put("����", 95);
//		map.put("����", 100);		
//		
//		System.out.println("�� ��Ʈ�� ��: " + map.size());
//		System.out.println("��������: " + map.get("����") + "\n");
//		
//		// Ű�� �̿��Ͽ� ���� ������(���� �� ��)
		
//		Set<String> keySet = map.keySet(); // Ű ���� ��Ƽ� Set ���·� �̾���
//		Iterator<String> keyIterator = keySet.iterator(); // ���ͷ�����: �ݺ���
//		
//		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
//		
//		// Ű�ϰ� ���� ��� ������
//		while(keyIterator.hasNext()) { // �ϳ��ϳ� �̾ƿ��� �ڵ�
//			Map.Entry<String, Integer> entry = entryIterator.next();
//			String key = entry.getKey();
//			Integer value = entry.getValue();
//			System.out.println(key + ": " + value);
//		}
//		System.out.println();
//		
//		map.clear();
//		System.out.println("�� ��Ʈ�� ��: " + map.size());
		
		
		
		// ���ͷ����� ���ο��� ����غ���
//		List<String> list = Arrays.asList("����", "����", "�λ�");
//		
//		Iterator<String> iterator = list.iterator(); // ���ͷ����͸� ������ ��������
//		while(iterator.hasNext()) {
//			String city = iterator.next();
//			System.out.println(city);
//		}
//		System.out.println();
//		
//		Stream<String> stream = list.stream();
//		// while�� ���� �� ó�� �̾ƺ���(���ͷ����� ���ο��� �������� ���)
//		stream.forEach(s -> System.out.println(s)); // ������ ������ �͸�ü�� �����
		
		
		List<Student> list = Arrays.asList(
				new Student("Hong", "male", 90),
				new Student("Lee", "male", 95)
		);
		
		// �̸�: ����
		// �̸�: ����
		// ������� ���
		Stream<Student> stream = list.stream();
		stream.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		// stream.forEach(s -> {
		// String name = s.getName();
		// int score = s.getScore();
		// Sysout.println(name + " : " + score);
		// }); 
		
		
	}
	
	// ������ ���� �κ�
//	public static void print(int order) {
//		if(order == 0) {
//			System.out.println("Same String.");
//		}
//	}
}
