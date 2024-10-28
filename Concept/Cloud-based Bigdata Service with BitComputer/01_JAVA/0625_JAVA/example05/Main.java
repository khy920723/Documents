package com.khy.example05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {

		/*
		 * Error, Exception 
		 * Error�� Exception�� �����ϴ� ����
		 * 
		 * <����ó��>
		 * �Ϲݿ���(�����ϱ� ���� ���ܸ� �� �� ����, Exception)
		 * ���࿹��(�����ϱ� ���� ��, RuntimeException)
		 * �ڹٴ� ���ܸ� Ŭ������ ����
		 * ��� ���� Ŭ������ java.lang.Exception Ŭ������ ��� ����
		 * ���࿹�ܴ� java.lang.RuntimeException�� ��ӹ���
		 */
		
		/*
		 * String data = null; 
		 * System.out.println(data.toString()); // toString(): ��ü�� ���� ������ ������ ���ڿ��� ����� �����ϴ� �޼ҵ�
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
		
		// Class c = Class.forName("java.lang.String2"); // �Ϲݿ���, �����Ϸ��� ����� ������ �˰� ����
		
		/*
		 * String data1 = null; 
		 * String data2 = null; //Fault Tolerant 
		 * try { 
		 * data1 =
		 * args[0]; 
		 * data2 = args[1]; 
		 * } catch(ArrayIndexOutOfBoundsException e) {
		 * System.out.println("Parameter "); 
		 * } finally { // ������ �������� �ؾ��� ���� ���� ��, final�� finally�� �ٸ�
		 * System.out.println("Finally"); 
		 * }
		 */
		
		
		/*
		 * Account acc = new Account();
		 * 
		 * acc.deposit(10000); 
		 * System.out.println("�ܾ�: " + acc.getBalance());
		 * System.out.println(acc.toString());
		 * 
		 * try { 
		 * acc.withdraw(50000); 
		 * } catch (BalanceInsufficientException e) { 
		 * //
		 * TODO: handle exception 
		 * System.out.println(e.getMessage());
		 * System.out.println(); 
		 * e.printStackTrace(); // �� �� �������� ���°� ���� }
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
		 * sb.append("JAVA"); // �߰� sb.append("Class"); sb.insert(5, "Programming"); //
		 * �߰��� �ش� �ε����� �߰�
		 * 
		 * System.out.println("���ڼ�: " + sb.length()); System.out.println(sb.toString());
		 */
	
		
		// Wrapper Ŭ����(�ڽ�/��ڽ�)
		/*
		Integer obj1 = new Integer(100); // Integer obj1 = 100;���� ���� ��, ����ڽ�
		Integer obj2 = new Integer(200);
		Integer obj3 = Integer.valueOf("300");
		
		int val1 = obj1.intValue();
		int val2 = obj2.intValue();
		int val3 = obj3.intValue();
		
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
		
		Integer obj = 100; // ���� �ڽ�
		System.out.println(obj.intValue());
		
		int val = obj; // ���� ��ڽ�
		System.out.println(val);
		
		int result = obj + 100; // ���� ��ڽ�
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
		Integer obj1 = 300; // Integer Ÿ���� obj ��ü ����
		Integer obj2 = 300;
		System.out.println("==: " + (obj1==obj2));
		System.out.println("���� �� ��: " + (obj1.intValue() == obj2.intValue()));
		System.out.println("equals: " + obj1.equals(obj2)); // .equals���� �����ε��� ��
		*/
		
		// ���׸�
		// ����ڰ� �� Ÿ�� ����
		/* ���� �ڵ�
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
		 * boolean result1 = Util.<Integer, String>compare(p1, p2); // Ÿ���� �ۼ�
		 * if(result1) { System.out.println("Same Object"); } else {
		 * System.out.println("Different Object"); }
		 * 
		 * Pair<String, String> p3 = new Pair<String, String>("Hong", "JAVA");
		 * Pair<String, String> p4 = new Pair<String, String>("Lee", "JAVA"); boolean
		 * result2 = Util.compare(p3, p4); // �� ���� ����(Ÿ��)�� ���� Ÿ���̿��� �������� if(result2) {
		 * System.out.println("Same Object"); } else {
		 * System.out.println("Different Object"); }
		 */
		
		
		/*
		 * <���ѵ� Ÿ�� �Ķ����> 
		 * T extends ����Ÿ��(�������̽��� ����, �� ��쿡�� extends Ű���� ���) 
		 * Ÿ�� �Ķ���Ϳ� �����Ǵ� ��ü���� Ÿ���� ���� Ÿ���̰ų� ���� Ÿ���� ���� �Ǵ� ����Ŭ������ ���� 
		 * �޼ҵ峻���� Ÿ�� �Ķ���� ������ ���� ��밡���� ���� ���� Ÿ���� �ʵ�� �޼ҵ�� ���ѵ�
		 */
		/*
		 * int result1 = Util2.compare(10, 20); // Ÿ�� ���� System.out.println(result1);
		 * 
		 * int result2 = Util2.compare(4.5, 3); System.out.println(result2);
		 */
		
		// String str = Unil2.compare("a", "b"); // Number Ŭ������ ��� ���� ���� Ÿ���̹Ƿ� �����Ͽ��� �Ұ�
		
		/*
		<���ϵ�ī�� Ÿ��>
		<?>: Unbounded Wildcards(���� ����)
		- ��� Ŭ������ �������̽��� �� �� ����
		<? extends T> Upper Bounded Wildcards(���� Ŭ���� ����)
		- T Ÿ���̳� T�� ����Ÿ�Ը� �� �� ����
		<? super T> Lower Bounded Wildcards(���� Ŭ���� ����)
		- T Ÿ���̳� T�� ����Ÿ�Ը� �� �� ����
		*/
		
		/*
		 * Course<Person> personCourse = new Course<Person>("�Ϲ��ΰ���", 5);
		 * personCourse.add(new Person("�Ϲ���")); personCourse.add(new Worker("������"));
		 * personCourse.add(new Student("�л�")); personCourse.add(new
		 * GraduateStudent("���п���"));
		 * 
		 * Course<Worker> workerCourse = new Course<Worker>("�����ΰ���", 5);
		 * workerCourse.add(new Worker("������"));
		 * 
		 * Course<Student> studentCourse = new Course<Student>("�л�����", 5);
		 * studentCourse.add(new Student("�л�")); studentCourse.add(new
		 * GraduateStudent("���п���"));
		 * 
		 * Course<GraduateStudent> graduateStudentCourse = new
		 * Course<GraduateStudent>("���п�����", 5); graduateStudentCourse.add(new
		 * GraduateStudent("���п���")); // �ڽ� ��ü 4�� ����
		 * 
		 * registerCourse(personCourse); registerCourse(workerCourse);
		 * registerCourse(studentCourse); registerCourse(graduateStudentCourse);
		 * System.out.println();
		 * 
		 * registerCourseStudent(studentCourse);
		 * registerCourseStudent(graduateStudentCourse); //
		 * registerCourseStudent(personCourse); // �� �� //
		 * registerCourseStudent(workerCourse); // �� �� System.out.println();
		 * 
		 * registerCourseWorker(personCourse); registerCourseWorker(workerCourse); //
		 * registerCourseWorker(studentCourse); // �� �� //
		 * registerCourseWorker(graduateStudentCourse); // �� ��
		 */		
		
		/*
		 * ChildProduct<Tv, String, String> product = new ChildProduct<Tv, String,
		 * String>(); product.setType(new Tv()); product.setModel("OLED TV");
		 * product.setCompany("�ݼ�");
		 * 
		 * Storage<Tv> storage = new StorageImplement<Tv>(100); storage.add(new Tv(),
		 * 0); Tv tv = storage.get(0);
		 * 
		 * System.out.println();
		 */
		
		
		// ���ٽ�
		/* ���� ���� ��
		 * MyFuctionalInterface fi = () -> { String str = "�޼ҵ� �� -1";
		 * System.out.println(str); }; fi.method();
		 * 
		 * fi = () -> { System.out.println("�޼ҵ� �� -2"); }; fi.method();
		 * 
		 * fi = () -> System.out.println("�޼ҵ� �� -3"); fi.method();
		 */
		
		/* ���� �ִ� ��
		 * MyFuctionalInterface fi = (x) -> { int result = x * 5;
		 * System.out.println(result); }; fi.method3(2);
		 * 
		 * fi = (x) -> { System.out.println(x * 5); }; fi.method3(2);
		 * 
		 * fi = x -> System.out.println(x * 5); fi.method3(2);
		 */
		
		// ���� �� ���� ��
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
		 * MyFuctionalInterface fi; // ��ü�� ������ �� �� �̻� ���� �Ǿ�� �� 
		 * fi = (x, y) -> {int
		 * result = x + y; 
		 * return result; 
		 * }; 
		 * System.out.println(fi.method4(2, 5));
		 * 
		 * MyFuctionalInterface fi2 = (x, y) -> { int result = x + y; return result; };
		 * // ��ü�� ������ �� �� �̻� ���� �Ǿ�� �� 
		 * System.out.println(fi2.method4(2, 5)); 
		 * 
		 * fi2 = (x,
		 * y) -> x * y; 
		 * System.out.println(fi2.method4(2, 5));
		 */
		
		
		// ǥ�� API �Լ��� �������̽�(�̰͵� ���ٽ����� ���)
		// 1. Consumer
		/*
		 * Consumer<String> consumer = t -> System.out.println(t + " Class");
		 * consumer.accept("Java");
		 * 
		 * BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
		 * biConsumer.accept("java", "Class");
		 * 
		 * DoubleConsumer doubleConsumer = d -> System.out.println(d + "�� 10���� ���� �������� "
		 * + d % 10 + "�Դϴ�."); doubleConsumer.accept(14.0);
		 * 
		 * ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
		 * objIntConsumer.accept("Java", 8);
		 */
		
		// 2. Supplier
		/*
		 * IntSupplier intSupplier = () -> { int num = (int)(Math.random() * 6) + 1; //
		 * �����Լ��� ���� ���� double���̱� ������ ���� ����ȯ return num; 
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
	
	// Predicate �κ�
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
	
	// <���ϵ�ī�� Ÿ��> �޼��� �κ�
	// �����Ϸ��� ����ȭ�� �޼��带 ���� ã��
	/*
	 * public static void registerCourse(Course<?> course) {
	 * System.out.println(course.getName() + " ������: " +
	 * Arrays.toString(course.getStudents())); }
	 * 
	 * public static void registerCourseStudent(Course<? extends Student> course) {
	 * System.out.println(course.getName() + " ������: " +
	 * Arrays.toString(course.getStudents())); }
	 * 
	 * public static void registerCourseWorker(Course<? super Worker> course) {
	 * System.out.println(course.getName() + " ������: " +
	 * Arrays.toString(course.getStudents())); }
	 */
	
	
	/* ���� �� ���� �� �κ�
	 * public static int sum(int x, int y) { return x + y; }
	 */
	
	
	// Function �κ�
//	private static List<Student2> list = Arrays.asList( // �迭�� ����Ʈ�� ������ִ� ����, ����ƽ���� ���� ��
//			new Student2("Hong", 10, 10), // Ŭ������ �ʵ�
//			new Student2("Lee", 90, 100));
//
//	public static void printString(Function<Student2, String> function) { // ��� Ÿ���� ��ü ���۷����� ���ڷ� ������
//		// �����Լ�����
//		// Function<Student2, String> function func = t -> t.getName();
//		// printString(t -> t.getName()); // ������ ���̹Ƿ� ���� ���� �־ ��� x
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
	
	
	// Operator �κ�
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
