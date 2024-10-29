# API
<표준 API 함수적 인터페이스>
 - 자바에서 제공되는 표준API에서 한 개의 추상메소드를 가지는 인터페이스는 모두 람다식을
   이용해서 익명구현객체로 표현 가능

- 자바8 부터 java.util.function 패키지에 자주 사용되는 함수적 인터페이스를 표준 API로 제공
   제공되는 인터페이스는 아래와 같은 4가지
   
 - Consumer: 매개값은 있고 리턴값이 없음
 - Supplier: 매개값이 없고 리턴값이 있음
 - Function: 매개값, 리턴값 모두 있음(주로 매개값은 리턴값으로 매핑)
 - Operator: 매개값, 리턴값 모두 있음(주로 매개값을 연산하고 결과를 리턴)
 - Predicate: 매개값은 있고 리턴 타입은 boolean(매개값을 조사해서 true/false 리턴)

# Generic
```java
public class Course<T> {
	private String name;
	private T[] students;
	
	public Course(String name, int capacity) {
		this.name = name;
		students = (T[]) (new Object[capacity]);
	}
	
	public String getName() {
		return name;
	}
	
	public T[] getStudents() {
		return students;
	}
	public void add(T t) {
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}

}
```

```
Person <-------------  Worker
		|
		|
		+----  Student <--------- GraduateStudent
```

```
Course<?> : Person, Student, GraduateStudent 가 대상
Course<? extends Student> : Student, GraduateStudent 가 대상
Course<? super Worker> : Worker, Person 만 대상
```

```java
public class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
}

public class Worker extends Person{
	
	public Worker(String name) {
		super(name);
	}
}

public class Student extends Person{
	
	public Student(String name) {
		super(name);
	}
}

public class GraduateStudent extends Student{
	
	public GraduateStudent(String name) {
		super(name);
	}

}
```



```java
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}


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
		graduateStudentCourse.add(new GraduateStudent("대학원생"));
		
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(graduateStudentCourse);
		System.out.println();
		
		registerCourseStudent(studentCourse);
		registerCourseStudent(graduateStudentCourse);
//		registerCourseStudent(personCourse);
//		registerCourseStudent(workerCourse);
		System.out.println();
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
//		registerCourseWorker(studentCourse);
//		registerCourseWorker(graduateStudentCourse);
		
		
		
	}
```

# Lamda
<람다식>

 - 람다식은 매개변수를 가지는 코드블럭
 - 객체지향 프로그램에 함수적 프로그래밍을 도입
 - 이벤트 지향 프로그램에 적합
 - 자바 코드가 간결해짐
 - JVM이 런타임 시에 매개변수를 가지는 코드블럭을 익명객체로 전환

 ```
(타입 매개변수, ...) -> { 실행문; ....}
```

 ```java
(int a) -> { System.out.println(a) }
 (a) -> { System.out.println(a) }
  a -> System.out.println(a)
```

 매개변수가 없을 경우
 () -> { 실행문; ....}

 리턴문이 있을 경우
 (x, y) -> { .... return x + y; }

 리턴문만 있을 경우
 (x, y) -> x + y

 인터페이스(target type) 변수 = 람다식;

<함수적 인터페이스>

 - 모든 인터페이스를 람다식의 타겟타입으로 사용할 수 없음
 - 람다식은 하나의 메소드를 정의
 - 하나의 추상메소드를 가지는 인터페이스만 람다식의 타겟 타입이 됨 (함수적 인터페이스)
 - 함수적 인터페이스 작성 시 실수를 방지하기 위해 컴파일러가 체킹해 주기를 원하는 경우
   @FunctioalInterface 어노테이션을 사용

  ```java
@FunctionalInterface
  public interface TestFunctionalInterface {
	public void method();
	public void anotherMethod(); // 컴파일 에러(하나만 있어야 되므로)
  }
```
