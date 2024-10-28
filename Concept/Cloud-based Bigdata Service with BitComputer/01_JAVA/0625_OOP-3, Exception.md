## Error, Exception 

> Error가 Exception을 포함하는 관계



- 예외처리

1. 일반예외(실행하기 전에 예외를 알 수 있음, Exception)
2. 실행예외(실행하기 전엔 모름, RuntimeException)
3. 자바는 예외를 클래스로 관리
4. 모든 예외 클래스는 java.lang.Exception 클래스를 상속 받음
5. 실행예외는 java.lang.RuntimeException을 상속받음

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
			
		  String data = null; 
		  System.out.println(data.toString()); // toString(): 객체가 가진 정보나 값들을 문자열로 만들어 리턴하는 메소드
		
	}
}
```

> 컴파일 시 주의 문구와 함께 결과값이 나오지 않음(예외처리 하지 않았기 때문)

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
		
			  String data1 = args[0]; 
			  String data2 = args[1]; 
			  System.out.println(data1);
			  System.out.println(data2);

	}
}
```

> 컴파일 시 주의 문구와 함께 결과값이 나오지 않음(예외처리 하지 않았기 때문)

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
				
		  String data1 = "100"; 
		  String data2 = "a100";
		  
		  int val1 = Integer.parseInt(data1); 
		  int val2 = Integer.parseInt(data2);
		  
		  int result = val1 + val2; 
		  System.out.println(result);	 
	}
}
```

> 컴파일 시 주의 문구와 함께 결과값이 나오지 않음(예외처리 하지 않았기 때문)



- try - catch

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
		
		 try { 
			 Class c = Class.forName("java.lang.String2"); 
		 }
		 catch(ClassNotFoundException e) { 
			 System.out.println("No Class"); 
		 }
        
     // Class c = Class.forName("java.lang.String2"); // 일반예외, 컴파일러가 명백히 오류를 알고 있음(빨간 줄)
	}
}
```

```
No Class
```

> 예외 처리 완료



```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
		
		
		  String data1 = null; 
		  String data2 = null; //Fault Tolerant 
		  try { 
			  data1 = args[0]; 
			  data2 = args[1]; 
		  } catch(ArrayIndexOutOfBoundsException e) {
			  System.out.println("Parameter "); 
		  } finally { // 무조건 마지막에 해야할 일이 있을 때, final과 finally는 다름
			  System.out.println("Finally"); 
		  }
		 
	}
}
```

```
Parameter 
Finally
```

> 예외 처리 완료



```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
		
		  Account acc = new Account();
		  
		  acc.deposit(10000); 
		  System.out.println("잔액: " + acc.getBalance());
		  System.out.println(acc.toString());
		  
		  try { 
			  acc.withdraw(50000); 
		  } catch (BalanceInsufficientException e) { 
			  // TODO: handle exception 
			  System.out.println(e.getMessage());
			  System.out.println(); 
			  e.printStackTrace(); // 맨 밑 에러부터 보는게 순서 
		  }
		 
	}
}

```

```java
package com.khy.example05;

public class Account {

	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	// 입금액
	public void deposit(int money) {
		balance += money;
	}
	
	// 출금액
	public void withdraw(int money) throws BalanceInsufficientException { // 해당 예외에 대해 자신을 호출한 메서드한테 예외 처리를 맡기는 throws
		if(balance < money) {
			throw new BalanceInsufficientException("Not enough money"); // 예외 발생시키는 throw(무조건 예외가 발생하기 때문에 try catch로 처리해야 됨)
			// new 연산자로 예외를 만들어버림
		}
		balance -= money;
	}
}
```

```
잔액: 10000
com.khy.example05.Account@6aaa5eb0
Not enough money

com.khy.example05.BalanceInsufficientException: Not enough money
	at com.khy.example05.Account.withdraw(Account.java:19)
	at com.khy.example05.Main.main(Main.java:13)

```

> 에러까지 출력 완료





## Override

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
		
		  Member m1 = new Member("JAVA"); 
		  Member m2 = new Member("JAVA"); 
		  Member m3 =
		  new Member("C++");
		  
		  if(m1.equals(m2)) { 
			  System.out.println("m1 m2 same mem"); 
		  } 
		  else {
			  System.out.println("m1 m2 different mem");
		  
		  if(m1.equals(m3)) { 
			  System.out.println("m1 m3 same mem"); 
		  } 
		  else {
			  System.out.println("m1 m3 different mem"); 
		  } 
		  }
		 	 
	}
}
```

```java
package com.khy.example05;

public class Member {

	public String id;
	
	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Member) {
			Member member = (Member) obj; // 강제형변환
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
		
}
```

```
m1 m2 same mem
```



- StringBuilder 클래스

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
		
		
		  StringBuilder sb = new StringBuilder();
		  
		  sb.append("JAVA"); // 추가 
		  sb.append("Class"); 
		  sb.insert(5, "Programming"); // 중간에 해당 인덱스에 추가
		  
		  System.out.println("문자수: " + sb.length()); System.out.println(sb.toString());
		 		 	 
	}
}
```

```
문자수: 20
JAVACProgramminglass
```





##  Wrapper 클래스

- 박싱/언박싱

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
			
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
			 
	}
}
```

```
100
200
300
100
100
200
```



- 타입과 오버로딩

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
			
		
		  int val1 = Integer.parseInt("10"); 
		  double val2 = Double.parseDouble("3.14");
		  boolean val3 = Boolean.parseBoolean("true");
		  
		  System.out.println(val1); 
		  System.out.println(val2); 
		  System.out.println(val3);
		 
		
		
		  Integer obj1 = 300; // Integer 타입의 obj 객체 생성
		  Integer obj2 = 300;
		  System.out.println("==: " + (obj1==obj2));
		  System.out.println("내부 값 비교: " + (obj1.intValue() == obj2.intValue()));
		  System.out.println("equals: " + obj1.equals(obj2)); // .equals에서 오버로딩이 됨
			 
	}
}
```

```
10
3.14
true
==: false
내부 값 비교: true
equals: true
```





## 제네릭

> 사용자가 들어갈 타입 정함

- 기존 코드

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
			
		Box box = new Box();
		box.setObject("Hong");
		String name = (String)box.getObject();
		
		box.setObject(new Apple());
		Apple apple = (Apple)box.getObject();
		
	}
}
```

```java
package com.khy.example05;

public class Box {

	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
}
```

```java
package com.khy.example05;

public class Apple {

}
```



- 제네릭

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
			
		Box<String> box = new Box<String>();
		box.setObject("Hong");
		String name = box.getObject();
		
		Box<Apple> box2 = new Box<Apple>();
		box2.setObject(new Apple());
		Apple apple = box2.getObject();
		
	}
}
```

```java
package com.khy.example05;

// 제네릭 만들기(객체를 쓸 때 타입을 지정하겠다)
public class Box<T> { // 타입 변수는 대문자로 씀(철자는 상관 없음)

	private T t; // T타입에 어떤 것이 올 지 모르니까 이렇게 작성
	
	public T getObject() {
		return t;
	}
	
	public void setObject(T t) {
		this.t = t;
	}
}
```

```java
package com.khy.example05;

public class Apple {

}
```



```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
					
		  Pair<Integer, String> p1 = new Pair<Integer, String>(1, "JAVA");
		  Pair<Integer, String> p2 = new Pair<Integer, String>(1, "JAVA");
		  
		  boolean result1 = Util.<Integer, String>compare(p1, p2); // 타입을 작성
		  if(result1) { 
			  System.out.println("Same Object"); 
			  } 
		  else {
		  System.out.println("Different Object"); 
		  }
		  
		  Pair<String, String> p3 = new Pair<String, String>("Hong", "JAVA");
		  Pair<String, String> p4 = new Pair<String, String>("Lee", "JAVA"); 
		  boolean result2 = Util.compare(p3, p4); // 두 개의 인자(타입)이 같은 타입이여서 생략가능 
		  if(result2) {
			  System.out.println("Same Object"); 
			  } 
		  else {
			  System.out.println("Different Object"); 
			  }
	}
}
```

```java
package com.khy.example05;

public class Pair<K, V> {

	private K key;
	private V value;
	
	
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public K getkey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
}
```





## 제한된 타입 파라미터

1. T extends 상위타입(인터페이스도 가능, 이 경우에도 extends 키워드 사용) 
2. 타입 파라미터에 지정되는 구체적인 타입은 상위 타입이거나 상위 타입의 하위 또는 구현클래스만 가능
3. 메소드내에서 타입 파라미터 변수를 갖고 사용가능한 것은 상위 타입의 필드와 메소드로 제한됨

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
					
		
		  int result1 = Util2.compare(10, 20); // 타입 생략 System.out.println(result1);
		  
		  int result2 = Util2.compare(4.5, 3); 
		  System.out.println(result2);
		 
		
		// String str = Unil2.compare("a", "b"); // Number 클래스를 상속 받지 않은 타입이므로 컴파일에서 불가
	}
}
```

```java
package com.khy.example05;

public class Pair<K, V> {

	private K key;
	private V value;
	
	
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public K getkey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
}
```





## 와일드카드 타입

1. <?>: Unbounded Wildcards(제한 없음)

> 모든 클래스나 인터페이스가 올 수 있음

2. <? extends T> Upper Bounded Wildcards(상위 클래스 제한)

> T 타입이나 T의 하위타입만 올 수 있음

3. <? super T> Lower Bounded Wildcards(하위 클래스 제한)

> T 타입이나 T의 상위타입만 올 수 있음

```java
package com.khy.example05;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		  Course<Person> personCourse = new Course<Person>("일반인과정", 5);
		  personCourse.add(new Person("일반인")); 
		  personCourse.add(new Worker("직장인"));
		  personCourse.add(new Student("학생")); 
		  personCourse.add(new GraduateStudent("대학원생"));
		  
		  Course<Worker> workerCourse = new Course<Worker>("직장인과정", 5);
		  workerCourse.add(new Worker("직장인"));
		  
		  Course<Student> studentCourse = new Course<Student>("학생과정", 5);
		  studentCourse.add(new Student("학생")); 
		  studentCourse.add(new GraduateStudent("대학원생"));
		  
		  Course<GraduateStudent> graduateStudentCourse = new Course<GraduateStudent>("대학원과정", 5); 
		  graduateStudentCourse.add(new GraduateStudent("대학원생")); // 코스 객체 4개 생성
		  
		  registerCourse(personCourse); 
		  registerCourse(workerCourse);
		  registerCourse(studentCourse); 
		  registerCourse(graduateStudentCourse);
		  System.out.println();
		  
		  registerCourseStudent(studentCourse);
		  registerCourseStudent(graduateStudentCourse); 
		  // registerCourseStudent(personCourse); // 못 들어감
		  // registerCourseStudent(workerCourse); // 못 들어감 
		  System.out.println();
		  
		  registerCourseWorker(personCourse); 
		  registerCourseWorker(workerCourse); 
		  // registerCourseWorker(studentCourse); // 못 들어감 
		  // registerCourseWorker(graduateStudentCourse); // 못 들어감
		 	
	}
	
	// <와일드카드 타입> 메서드 부분
	// 컴파일러가 최적화된 메서드를 먼저 찾음
	  public static void registerCourse(Course<?> course) {
		  System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents())); 
		  }
	  
	  public static void registerCourseStudent(Course<? extends Student> course) {
		  System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents())); 
		  }
	  
	  public static void registerCourseWorker(Course<? super Worker> course) {
		  System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents())); 
		  } 
}
```

```java
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
```

```java
package com.khy.example05;

public class Person {

	private String name;
	
	public Person(String name) {
		this.name = name;
	}
}
```

```java
package com.khy.example05;

public class Worker extends Person{
	
	public Worker(String name) {
		super(name);
	}
}
```

```java
package com.khy.example05;

public class Student extends Person{

	public Student(String name) {
		super(name);
	}
}
```

```java
package com.khy.example05;

public class GraduateStudent extends Student {

	public GraduateStudent(String name) {
		super(name);
	}
}
```

```
일반인과정 수강생: [com.khy.example05.Person@668bc3d5, com.khy.example05.Worker@3cda1055, com.khy.example05.Student@7a5d012c, com.khy.example05.GraduateStudent@3fb6a447, null]
직장인과정 수강생: [com.khy.example05.Worker@79b4d0f, null, null, null, null]
학생과정 수강생: [com.khy.example05.Student@6b2fad11, com.khy.example05.GraduateStudent@79698539, null, null, null]
대학원과정 수강생: [com.khy.example05.GraduateStudent@73f792cf, null, null, null, null]

학생과정 수강생: [com.khy.example05.Student@6b2fad11, com.khy.example05.GraduateStudent@79698539, null, null, null]
대학원과정 수강생: [com.khy.example05.GraduateStudent@73f792cf, null, null, null, null]

일반인과정 수강생: [com.khy.example05.Person@668bc3d5, com.khy.example05.Worker@3cda1055, com.khy.example05.Student@7a5d012c, com.khy.example05.GraduateStudent@3fb6a447, null]
직장인과정 수강생: [com.khy.example05.Worker@79b4d0f, null, null, null, null]
```





## 인터페이스, 상속

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
		
		
		  ChildProduct<Tv, String, String> product = new ChildProduct<Tv, String, String>(); 
		  product.setType(new Tv()); 
		  product.setModel("OLED TV");
		  product.setCompany("금성");
		  
		  Storage<Tv> storage = new StorageImplement<Tv>(100); 
		  storage.add(new Tv(), 0); 
		  Tv tv = storage.get(0);
		  
		  System.out.println();	 	
	}
}
```

```java
package com.khy.example05;

public class Product<T, M> {

	private T type;
	private M model;
	/**
	 * @return the type
	 */
	public T getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(T type) {
		this.type = type;
	}
	/**
	 * @return the model
	 */
	public M getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(M model) {
		this.model = model;
	}
}
```

```java
package com.khy.example05;

public class ChildProduct<T, M, C> extends Product<T, M> { // 부모 클래스의 제네릭 타입이 2개 이므로 자신도 최소 2개 이상은 가져야 함

	// 코드는 C 부분만 작성
	
	private C company;

	/**
	 * @return the company
	 */
	public C getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(C company) {
		this.company = company;
	}
}

```

```java
package com.khy.example05;

public interface Storage<T> {

	public void add(T item, int index);
	public T get(int index);
}

```

```java
package com.khy.example05;

public class StorageImplement<T> implements Storage<T> {
	
	private T[] array;

	public StorageImplement(int capacity) {
		this.array = (T[])(new Object[capacity]);
	}

	@Override
	public void add(T item, int index) {
		// TODO Auto-generated method stub
		array[index] = item;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return array[index];
	}
	
}
```





## 람다식

- 인자 없는 놈

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {

		MyFuctionalInterface fi = () -> { 
			  String str = "메소드 콜 -1";
			  System.out.println(str); 
		}; 
		  fi.method();
		  
		  fi = () -> { System.out.println("메소드 콜 -2");}; 
		  fi.method();
		  
		  fi = () -> System.out.println("메소드 콜 -3"); 
		  fi.method();
		 	
	}
}
```

```java
package com.khy.example05;

@FunctionalInterface
public interface MyFuctionalInterface {

	public void method(); // 추상메소드는 하나만
}

```

```
메소드 콜 -1
메소드 콜 -2
메소드 콜 -3
```



- 인자 있는 놈

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {

		  MyFuctionalInterface fi = (x) -> { 
			  int result = x * 5;
			  System.out.println(result); 
		  }; 
		  fi.method3(2);
		  
		  fi = (x) -> { System.out.println(x * 5); }; 
		  fi.method3(2);
		  
		  fi = x -> System.out.println(x * 5); 
		  fi.method3(2);
		  
	}	 
}
```

```java
package com.khy.example05;

@FunctionalInterface
public interface MyFuctionalInterface {
	
	public void method3(int x); // 추상메소드는 하나만

}
```

```
10
10
10
```



- 인자 두 개인 놈

```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {
		
		  MyFuctionalInterface fi = (x, y) -> { int result = x + y; return result; };
		  System.out.println(fi.method4(2, 5));
		  
		  fi = (x, y) -> { return x + y; }; 
		  System.out.println(fi.method4(2, 5));
		  
		  fi = (x, y) -> x + y; 
		  System.out.println(fi.method4(2, 5));
		  
		  fi = (x, y) -> sum(x, y); 
		  System.out.println(fi.method4(2, 5));
		 
	}
	
	 public static int sum(int x, int y) { return x + y; }

}
```

```java
package com.khy.example05;

@FunctionalInterface
public interface MyFuctionalInterface {
	
	public int method4(int x, int y); // 리턴 타입이 있어야 하므로, 추상메소드는 하나만
}
```

```
7
7
7
7
```



```java
package com.khy.example05;

public class Main {
	public static void main(String[] args) {

		  MyFuctionalInterface fi; // 객체는 무조건 한 번 이상 선언 되어야 함 
		  fi = (x, y) -> {int result = x + y; 
		  return result; 
		  }; 
		  System.out.println(fi.method4(2, 5));
		  
		  MyFuctionalInterface fi2 = (x, y) -> { int result = x + y; return result; };
		  // 객체는 무조건 한 번 이상 선언 되어야 함 
		  System.out.println(fi2.method4(2, 5)); 
		  
		  fi2 = (x, y) -> x * y; 
		  System.out.println(fi2.method4(2, 5)); 
	}

}
```

```java
package com.khy.example05;

@FunctionalInterface
public interface MyFuctionalInterface {
	
	public int method4(int x, int y); // 리턴 타입이 있어야 하므로, 추상메소드는 하나만
}
```

```
7
7
10
```





## 표준 API 함수적 인터페이스

> 이것도 람다식으로 사용

- Consumer

```java
package com.khy.example05;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class Main {
	public static void main(String[] args) {
		
		  Consumer<String> consumer = t -> System.out.println(t + " Class");
		  consumer.accept("Java");
		  
		  BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
		  biConsumer.accept("java", "Class");
		  
		  DoubleConsumer doubleConsumer = d -> System.out.println(d + "를 10으로 나눈 나머지는 "
		  + d % 10 + "입니다."); doubleConsumer.accept(14.0);
		  
		  ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
		  objIntConsumer.accept("Java", 8);
		 
	}
}
```

```
Java Class
javaClass
14.0를 10으로 나눈 나머지는 4.0입니다.
Java8
```



- Supplier

```java
package com.khy.example05;

import java.util.function.IntSupplier;

public class Main {
	public static void main(String[] args) {
		
		  IntSupplier intSupplier = () -> { 
			  int num = (int)(Math.random() * 6) + 1; // 랜덤함수의 리턴 값이 double형이기 때문에 강제 형변환 
			  return num; 
		  };
		  
		  int num = intSupplier.getAsInt(); 
		  System.out.println("Dice num: " + num);	 
	}

}
```

```
Dice num: 4
```



- Function

```java
package com.khy.example05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Main {
	public static void main(String[] args) {
		
		// 3. Function
		System.out.println("[Student Name]");
		printString(t -> t.getName());
		
		System.out.println("[English Score]");
		printInt(t -> t.getEnglishScore());
		
	}
	
	// Function 부분
	// 배열을 리스트로 만들어주는 역할, 스태틱으로 선언 됨
	// 클래스의 필드
	private static List<Student2> list = Arrays.asList(new Student2("Hong", 10, 10), new Student2("Lee", 90, 100));
	
	public static void printString(Function<Student2, String> function) { // 펑션 타입의 객체 레퍼런스를 인자로 던져라
		// 메인함수에선
		// Function<Student2, String> function func = t -> t.getName();
		// printString(t -> t.getName()); // 우측이 값이므로 우측 값을 넣어도 상관 x
		for (Student2 student : list) {
			System.out.println(function.apply(student));
		}
		System.out.println();
	}
	
	public static void printInt(ToIntFunction<Student2> function) {
		for (Student2 student : list) {
			System.out.println(function.applyAsInt(student));
		}
	}

}
```

```java
package com.khy.example05;

public class Student2 {

	private String name;
	private int englishScore;
	private int mathScore;
	
	public Student2(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the englishScore
	 */
	public int getEnglishScore() {
		return englishScore;
	}

	/**
	 * @return the mathScore
	 */
	public int getMathScore() {
		return mathScore;
	}
	
}
```

```
[Student Name]
Hong
Lee

[English Score]
10
90
```



- Operator

```java
package com.khy.example05;

import java.util.function.IntBinaryOperator;

public class Main {
	public static void main(String[] args) {
		
		int max = maxOrMin(
				(a, b) -> {
					if(a >= b)
						return a;
					else
						return b;
		});
		System.out.println("Max: " + max);
		
		int min = maxOrMin(
				(a, b) -> {
					if(a <= b)
						return a;
					else
						return b;
				});
		System.out.println("Min: " + min);
		
	}
	// Operator 부분
	private static int[] scores = {94, 96, 86};
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for(int score: scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	};
}
```

```
Max: 96
Min: 86
```



- Predicate

```java
package com.khy.example05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		
		// 5. Predicate
		double maleAvg = avg(t -> t.getSex().equals("male"));
		System.out.println("male avg: " + maleAvg);
		
		double femaleAvg = avg(t -> t.getSex().equals("female"));
		System.out.println("female avg: " + femaleAvg);
		
	}

////Predicate 부분
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
}
```

```
male avg: 87.5
female avg: 88.5
```

