package com.khy.example05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {

		/*
		 * Error, Exception 
		 * Error가 Exception을 포함하는 관계
		 * 
		 * <예외처리>
		 * 일반예외(실행하기 전에 예외를 알 수 있음, Exception)
		 * 실행예외(실행하기 전엔 모름, RuntimeException)
		 * 자바는 예외를 클래스로 관리
		 * 모든 예외 클래스는 java.lang.Exception 클래스를 상속 받음
		 * 실행예외는 java.lang.RuntimeException을 상속받음
		 */
		
		/*
		 * String data = null; 
		 * System.out.println(data.toString()); // toString(): 객체가 가진 정보나 값들을 문자열로 만들어 리턴하는 메소드
		 */

		/*
		 * String data1 = args[0]; 
		 * String data2 = args[1]; 
		 * System.out.println(data1);
		 * System.out.println(data2);
		 */
	
		/*
		 * String data1 = "100"; 
		 * String data2 = "a100";
		 * 
		 * int val1 = Integer.parseInt(data1); 
		 * int val2 = Integer.parseInt(data2);
		 * 
		 * int result = val1 + val2; 
		 * System.out.println(result);
		 */
		
		/*
		 * try { 
		 * Class c = Class.forName("java.lang.String2"); 
		 * }
		 * catch(ClassNotFoundException e) { 
		 * System.out.println("No Class"); 
		 * }
		 */
		
		// Class c = Class.forName("java.lang.String2"); // 일반예외, 컴파일러가 명백히 오류를 알고 있음
		
		/*
		 * String data1 = null; 
		 * String data2 = null; //Fault Tolerant 
		 * try { 
		 * data1 =
		 * args[0]; 
		 * data2 = args[1]; 
		 * } catch(ArrayIndexOutOfBoundsException e) {
		 * System.out.println("Parameter "); 
		 * } finally { // 무조건 마지막에 해야할 일이 있을 때, final과 finally는 다름
		 * System.out.println("Finally"); 
		 * }
		 */
		
		
		/*
		 * Account acc = new Account();
		 * 
		 * acc.deposit(10000); 
		 * System.out.println("잔액: " + acc.getBalance());
		 * System.out.println(acc.toString());
		 * 
		 * try { 
		 * acc.withdraw(50000); 
		 * } catch (BalanceInsufficientException e) { 
		 * //
		 * TODO: handle exception 
		 * System.out.println(e.getMessage());
		 * System.out.println(); 
		 * e.printStackTrace(); // 맨 밑 에러부터 보는게 순서 }
		 */
		
		
		/*
		 * Member m1 = new Member("JAVA"); 
		 * Member m2 = new Member("JAVA"); 
		 * Member m3 =
		 * new Member("C++");
		 * 
		 * if(m1.equals(m2)) { 
		 * System.out.println("m1 m2 same mem"); 
		 * } 
		 * else {
		 * System.out.println("m1 m2 different mem");
		 * 
		 * if(m1.equals(m3)) { 
		 * System.out.println("m1 m3 same mem"); 
		 * } 
		 * else {
		 * System.out.println("m1 m3 different mem"); 
		 * } 
		 * }
		 */
		
		
		/*
		 * StringBuilder sb = new StringBuilder();
		 * 
		 * sb.append("JAVA"); // 추가 sb.append("Class"); sb.insert(5, "Programming"); //
		 * 중간에 해당 인덱스에 추가
		 * 
		 * System.out.println("문자수: " + sb.length()); System.out.println(sb.toString());
		 */
	
		
		// Wrapper 클래스(박싱/언박싱)
		/*
		Integer obj1 = new Integer(100); // Integer obj1 = 100;으로 현재 씀, 오토박싱
		Integer obj2 = new Integer(200);
		Integer obj3 = Integer.valueOf("300");
		
		int val1 = obj1.intValue();
		int val2 = obj2.intValue();
		int val3 = obj3.intValue();
		
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
		
		Integer obj = 100; // 오토 박싱
		System.out.println(obj.intValue());
		
		int val = obj; // 오토 언박싱
		System.out.println(val);
		
		int result = obj + 100; // 오토 언박싱
		System.out.println(result);
		*/
		
		
		/*
		 * int val1 = Integer.parseInt("10"); 
		 * double val2 = Double.parseDouble("3.14");
		 * boolean val3 = Boolean.parseBoolean("true");
		 * 
		 * System.out.println(val1); 
		 * System.out.println(val2); 
		 * System.out.println(val3);
		 */
		
		/*
		Integer obj1 = 300; // Integer 타입의 obj 객체 생성
		Integer obj2 = 300;
		System.out.println("==: " + (obj1==obj2));
		System.out.println("내부 값 비교: " + (obj1.intValue() == obj2.intValue()));
		System.out.println("equals: " + obj1.equals(obj2)); // .equals에서 오버로딩이 됨
		*/
		
		// 제네릭
		// 사용자가 들어갈 타입 정함
		/* 기존 코드
		Box box = new Box();
		box.setObject("Hong");
		String name = (String)box.getObject();
		
		box.setObject(new Apple());
		Apple apple = (Apple)box.getObject();
		*/
		/*
		Box<String> box = new Box<String>();
		box.setObject("Hong");
		String name = box.getObject();
		
		Box<Apple> box2 = new Box<Apple>();
		box2.setObject(new Apple());
		Apple apple = box2.getObject();
		*/
		
		
		/*
		 * Pair<Integer, String> p1 = new Pair<Integer, String>(1, "JAVA");
		 * Pair<Integer, String> p2 = new Pair<Integer, String>(1, "JAVA");
		 * 
		 * boolean result1 = Util.<Integer, String>compare(p1, p2); // 타입을 작성
		 * if(result1) { System.out.println("Same Object"); } else {
		 * System.out.println("Different Object"); }
		 * 
		 * Pair<String, String> p3 = new Pair<String, String>("Hong", "JAVA");
		 * Pair<String, String> p4 = new Pair<String, String>("Lee", "JAVA"); boolean
		 * result2 = Util.compare(p3, p4); // 두 개의 인자(타입)이 같은 타입이여서 생략가능 if(result2) {
		 * System.out.println("Same Object"); } else {
		 * System.out.println("Different Object"); }
		 */
		
		
		/*
		 * <제한된 타입 파라미터> 
		 * T extends 상위타입(인터페이스도 가능, 이 경우에도 extends 키워드 사용) 
		 * 타입 파라미터에 지정되는 구체적인 타입은 상위 타입이거나 상위 타입의 하위 또는 구현클래스만 가능 
		 * 메소드내에서 타입 파라미터 변수를 갖고 사용가능한 것은 상위 타입의 필드와 메소드로 제한됨
		 */
		/*
		 * int result1 = Util2.compare(10, 20); // 타입 생략 System.out.println(result1);
		 * 
		 * int result2 = Util2.compare(4.5, 3); System.out.println(result2);
		 */
		
		// String str = Unil2.compare("a", "b"); // Number 클래스를 상속 받지 않은 타입이므로 컴파일에서 불가
		
		/*
		<와일드카드 타입>
		<?>: Unbounded Wildcards(제한 없음)
		- 모든 클래스나 인터페이스가 올 수 있음
		<? extends T> Upper Bounded Wildcards(상위 클래스 제한)
		- T 타입이나 T의 하위타입만 올 수 있음
		<? super T> Lower Bounded Wildcards(하위 클래스 제한)
		- T 타입이나 T의 상위타입만 올 수 있음
		*/
		
		/*
		 * Course<Person> personCourse = new Course<Person>("일반인과정", 5);
		 * personCourse.add(new Person("일반인")); personCourse.add(new Worker("직장인"));
		 * personCourse.add(new Student("학생")); personCourse.add(new
		 * GraduateStudent("대학원생"));
		 * 
		 * Course<Worker> workerCourse = new Course<Worker>("직장인과정", 5);
		 * workerCourse.add(new Worker("직장인"));
		 * 
		 * Course<Student> studentCourse = new Course<Student>("학생과정", 5);
		 * studentCourse.add(new Student("학생")); studentCourse.add(new
		 * GraduateStudent("대학원생"));
		 * 
		 * Course<GraduateStudent> graduateStudentCourse = new
		 * Course<GraduateStudent>("대학원과정", 5); graduateStudentCourse.add(new
		 * GraduateStudent("대학원생")); // 코스 객체 4개 생성
		 * 
		 * registerCourse(personCourse); registerCourse(workerCourse);
		 * registerCourse(studentCourse); registerCourse(graduateStudentCourse);
		 * System.out.println();
		 * 
		 * registerCourseStudent(studentCourse);
		 * registerCourseStudent(graduateStudentCourse); //
		 * registerCourseStudent(personCourse); // 못 들어감 //
		 * registerCourseStudent(workerCourse); // 못 들어감 System.out.println();
		 * 
		 * registerCourseWorker(personCourse); registerCourseWorker(workerCourse); //
		 * registerCourseWorker(studentCourse); // 못 들어감 //
		 * registerCourseWorker(graduateStudentCourse); // 못 들어감
		 */		
		
		/*
		 * ChildProduct<Tv, String, String> product = new ChildProduct<Tv, String,
		 * String>(); product.setType(new Tv()); product.setModel("OLED TV");
		 * product.setCompany("금성");
		 * 
		 * Storage<Tv> storage = new StorageImplement<Tv>(100); storage.add(new Tv(),
		 * 0); Tv tv = storage.get(0);
		 * 
		 * System.out.println();
		 */
		
		
		// 람다식
		/* 인자 없는 놈
		 * MyFuctionalInterface fi = () -> { String str = "메소드 콜 -1";
		 * System.out.println(str); }; fi.method();
		 * 
		 * fi = () -> { System.out.println("메소드 콜 -2"); }; fi.method();
		 * 
		 * fi = () -> System.out.println("메소드 콜 -3"); fi.method();
		 */
		
		/* 인자 있는 놈
		 * MyFuctionalInterface fi = (x) -> { int result = x * 5;
		 * System.out.println(result); }; fi.method3(2);
		 * 
		 * fi = (x) -> { System.out.println(x * 5); }; fi.method3(2);
		 * 
		 * fi = x -> System.out.println(x * 5); fi.method3(2);
		 */
		
		// 인자 두 개인 놈
		/*
		 * MyFuctionalInterface fi = (x, y) -> { int result = x + y; return result; };
		 * System.out.println(fi.method4(2, 5));
		 * 
		 * fi = (x, y) -> { return x + y; }; System.out.println(fi.method4(2, 5));
		 * 
		 * fi = (x, y) -> x + y; System.out.println(fi.method4(2, 5));
		 * 
		 * fi = (x, y) -> sum(x, y); System.out.println(fi.method4(2, 5));
		 */
		
		/*
		 * MyFuctionalInterface fi; // 객체는 무조건 한 번 이상 선언 되어야 함 
		 * fi = (x, y) -> {int
		 * result = x + y; 
		 * return result; 
		 * }; 
		 * System.out.println(fi.method4(2, 5));
		 * 
		 * MyFuctionalInterface fi2 = (x, y) -> { int result = x + y; return result; };
		 * // 객체는 무조건 한 번 이상 선언 되어야 함 
		 * System.out.println(fi2.method4(2, 5)); 
		 * 
		 * fi2 = (x,
		 * y) -> x * y; 
		 * System.out.println(fi2.method4(2, 5));
		 */
		
		
		// 표준 API 함수적 인터페이스(이것도 람다식으로 사용)
		// 1. Consumer
		/*
		 * Consumer<String> consumer = t -> System.out.println(t + " Class");
		 * consumer.accept("Java");
		 * 
		 * BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
		 * biConsumer.accept("java", "Class");
		 * 
		 * DoubleConsumer doubleConsumer = d -> System.out.println(d + "를 10으로 나눈 나머지는 "
		 * + d % 10 + "입니다."); doubleConsumer.accept(14.0);
		 * 
		 * ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
		 * objIntConsumer.accept("Java", 8);
		 */
		
		// 2. Supplier
		/*
		 * IntSupplier intSupplier = () -> { int num = (int)(Math.random() * 6) + 1; //
		 * 랜덤함수의 리턴 값이 double형이기 때문에 강제 형변환 return num; 
		 * };
		 * 
		 * int num = intSupplier.getAsInt(); 
		 * System.out.println("Dice num: " + num);
		 */
		
		// 3. Function
//		System.out.println("[Student Name]");
//		printString(t -> t.getName());
//		
//		System.out.println("[English Score]");
//		printInt(t -> t.getEnglishScore());
		
		
		// 4. Operator
//		int max = maxOrMin(
//				(a, b) -> {
//					if(a >= b)
//						return a;
//					else
//						return b;
//		});
//		System.out.println("Max: " + max);
//		
//		int min = maxOrMin(
//				(a, b) -> {
//					if(a <= b)
//						return a;
//					else
//						return b;
//				});
//		System.out.println("Min: " + min);
	
		
		// 5. Predicate
		double maleAvg = avg(t -> t.getSex().equals("male"));
		System.out.println("male avg: " + maleAvg);
		
		double femaleAvg = avg(t -> t.getSex().equals("female"));
		System.out.println("female avg: " + femaleAvg);
	
	}
	
	// Predicate 부분
	private static List<Student3> list = Arrays.asList(
			new Student3("Hong", "male", 90),
			new Student3("Kim", "female", 90),
			new Student3("Park", "male", 85),
			new Student3("Lee", "female", 87)
	);
	
	public static double avg(Predicate<Student3> predicate) {
		int count = 0, sum = 0;
		for(Student3 student: list) {
			if(predicate.test(student)) {
				count++;
				sum += student.getScore();
			}
		}
		return (double) sum / count;
	}
	
	// <와일드카드 타입> 메서드 부분
	// 컴파일러가 최적화된 메서드를 먼저 찾음
	/*
	 * public static void registerCourse(Course<?> course) {
	 * System.out.println(course.getName() + " 수강생: " +
	 * Arrays.toString(course.getStudents())); }
	 * 
	 * public static void registerCourseStudent(Course<? extends Student> course) {
	 * System.out.println(course.getName() + " 수강생: " +
	 * Arrays.toString(course.getStudents())); }
	 * 
	 * public static void registerCourseWorker(Course<? super Worker> course) {
	 * System.out.println(course.getName() + " 수강생: " +
	 * Arrays.toString(course.getStudents())); }
	 */
	
	
	/* 인자 두 개인 놈 부분
	 * public static int sum(int x, int y) { return x + y; }
	 */
	
	
	// Function 부분
//	private static List<Student2> list = Arrays.asList( // 배열을 리스트로 만들어주는 역할, 스태틱으로 선언 됨
//			new Student2("Hong", 10, 10), // 클래스의 필드
//			new Student2("Lee", 90, 100));
//
//	public static void printString(Function<Student2, String> function) { // 펑션 타입의 객체 레퍼런스를 인자로 던져라
//		// 메인함수에선
//		// Function<Student2, String> function func = t -> t.getName();
//		// printString(t -> t.getName()); // 우측이 값이므로 우측 값을 넣어도 상관 x
//		for (Student2 student : list) {
//			System.out.println(function.apply(student));
//		}
//		System.out.println();
//	}
//
//	public static void printInt(ToIntFunction<Student2> function) {
//		for (Student2 student : list) {
//			System.out.println(function.applyAsInt(student));
//		}
//	}
	
	
	// Operator 부분
//	private static int[] scores = {94, 96, 86};
//	
//	public static int maxOrMin(IntBinaryOperator operator) {
//		int result = scores[0];
//		for(int score: scores) {
//			result = operator.applyAsInt(result, score);
//		}
//		return result;
//	};

}
