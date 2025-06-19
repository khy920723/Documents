**[ TIL note ]**

[20220704]

- form의 role의 역할 role은 위젯, 구조 및 동작에 대한 의미 정보를 올바르게 전달하기 위해 탄생 (웹 접근성) elements의 확장 개념으로 좀 더 명확한 구조와 의미를 부여하는 역할

1. Abstract roles (command, composite, input …)
2. Widget roles (button, checkbox, link …)
3. Document structure roles (article, cell, columnheader …)
4. Landmark roles (banner, contentinfo, form …)
5. Live region roles (alert, log, marquee …)
6. Window roles (arlertdialog, dialog) 총 6가지의 카테고리를 따르고 각각의 role-attribute는 해당 role 속성 사항에 맞게 검색하여 사용해야 함

- JSP (Java Server Pages)란? java 언어를 기반으로 하는 Server Side 스크립트 언어.
- HTML 코드에 Java 코드를 넣어 동적인 웹 페이지를 생성하는 웹 어플리케이션 도구

1. jsp를 통해 정적인 HTML과 동적으로 생성된 contents(http 요청 파라미터)를 혼합하여 사용 가능
2. 사용자가 입력한 contents에 맞게 동적인 웹 페이지 생성

- Servlet 기술 확장

1. Servlet을 보완한 스크립트 방식 표준
2. Servlet의 모든 기능 + 추가적인 기능 -> Server Pages인 만큼 서버쪽의 리소스를 사용하므로 최근 기술에서는 사용을 지양함.

- URI / URL 차이

1. URI 특정 리소스를 식별하는 통합 자원 식별자(Uniform Resource Identifier)를 의미 웹 기술에서 사용하는 논리적 또는 물리적 리소스를 식별하는 고유한 문자열 시퀀스
2. URL 흔히 웹 주소라고도 하며 컴퓨터 네트워크 상에서 리소스가 어디 있는 지 알려주기 위한 규약 (URI의 서브셋) -> URI는 식별하고 URL은 위치를 가리킴

[20220705]

- SLF4J (Simple Logging Facade for Java)란? java.util.logging, logback 및 log4j와 같은 다양한 로깅 프레임 워크에 대한 인터페이스(추상화) 역할을 하는 라이브러리

[20220706]

- Log4j 서비스 동작 과정에서 일어나는 모든 기록을 남김 Java 기반 오픈소스 유틸리티로 엔터프라이즈 애플리케이션과 웹사이트에서 많이 사용 중 -> 현재 보안 위험 노출 이슈 존재 (JNDI, LDAP)
- Lombok 자바 라이브러리 코드 에디터나 빌드 툴(IntelliJ, Eclipse, XCode …)에 추가하여 코드를 효율적으로 작성할 수 있도록 해줌 class명 위에 어노테이션을 명시해줌으로써 getter나 setter, equals와 같은 method를 따로 작성해야 하는 번거로움을 덜어 줌
- @Data 어노테이션 @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode를 한 번에 설정해 줌 -> 클래스 레벨에서 @Data 어노테이션을 붙이면 모든 필드를 대상으로 접근자와 설정자가 자동으로 생성되고 final 또는 @NonNull 필드 값을 파라미터로 받는 생성자가 만들어지며 toString, equals, hashCode 메서드가 자동으로 만들어짐
- HTTP 웹상에서 클라이언트와 서버 간에 데이터를 주고 받을 수 있는 프로토콜 클라이언트가 HTTP 프로토콜을 통해 서버에 요청을 보내면 서버는 요청에 맞는 응답을 클라이언트에게 전송
- HTTP 패킷 클라이언트는 인터넷 브라우저 주소창에 URL을 입력하고 서버는 클라이언트의 요청에 응답하여 웹페이지를 보여주게 되는데, 이 때 클라이언트가 서버로 보내는 데이터를 HTTP 패킷이라 하며 패킷은 크게 헤더(Header)와 바디(Body)로 나뉘어 짐

1. Header 헤더에는 HTTP method 방식(GET / POST 등), 클라이언트와 브라우저, 접속하고자 하는 URL 정보등이 담겨 있음
2. Body 바디는 보통 비어있으며 정보를 담아서 서버에 요청 할 수 있음

- HTTP method 방식

1. GET

- 클라이언트가 서버로 데이터를 요청하기 위해 사용되는 메서드
- URL에 쿼리 스트링(데이터)를 붙여서 서버에 전송
- 데이터를 헤더에 포함하여 전송
- URL에 정보들이 그대로 노출되기 때문에 POST 방식보다 상대적으로 보안에 취약
- 캐싱 가능 (한 번 접근 후 다시 요청할 시 빠르게 접근하기 위해 레지스터에 데이터를 저장)
- POST 방식보다 상대적으로 전송 속도가 더 빠름
- 전송하는 데이터양에 한계가 있음 (브라우저마다 GET 요청 길이 제한 존재)
- 브라우저 히스토리에 기록이 남음

2. POST

- 클라이언트가 서버로 데이터를 전송해 리소스를 추가하거나 생성하기 위해 사용되는 메서드
- 서버의 값이나 상태를 변경하기 위해 사용되므로 글쓰기/수정과 같은 작업에 적합
- 데이터들을 URL 뒤에 붙여서 서버로 보내는 것이 아닌 바디에 담아서 전송
- 요청 헤더의 Content-Type에 컨텐츠 타입을 명시
- 데이터들이 URL에 노출되지 않기 때문에 GET 방식보다 상대적으로 보안적
- 데이터들을 바디에 담기 때문에 서버로 보내는 데이터의 양은 제한 없음
- URL에 데이터가 노출되지 않으므로 캐싱불가
- 클라이언트에서의 인코딩, 서버에서 디코딩
- 요청 받는 시간제한 존재
- 브라우저 히스토리에 기록이남지 않음
- 제네릭 (Generic) 데이터 타입(data type)을 일반화(generalize) 하는 것을 의미. 클래스나 메서드에서 사용할 내부 데이터 타입을 컴파일 시에 미리 지정하는 방법 (컴파일 시에 미리 타입 검사를 수행하면 장점들을 지님)

1. 클래스나 메서드 내부에서 사용되는 객체의 타입 안정성을 높일 수 있음
2. 반화값에 대한 타입 변환 및 타입 검사에 들어가는 노력을 줄일 수 있음 -> Java에서 제네릭은 클래스와 메서드에만 선언 가능 ex) MyArray 클래스에서 사용 된 타입 변수로 Integer 타입을 사용하는 예제 class MyArray<T> { … } MyArray<Integer> myArr = new MyArray<Integer>();

- Spring Security 설정 스프링부트를 사용하면 application.yml에서 설정이 가능하지만 몇 가지만 제공하고 모든 것을 설정 할 수는 없으므로 Configuration Class를 작성하여 설정을 진행하는 것이 기본

1. Confifuration class 작성

[20220707]

- JSTL JSP 표준라이브러리(JSP Standard Tag Library)의 약어로서 자주 사용될 수 있는 커스텀 태그들을 모아 표준으로 모아놓은 태그 라이브러리
- JSTL 사용 방법 (JSP 파일에서의 사용 선언) 
<%@ taglib prefix=“c” uri=“[http://java.sun.com/jsp/jstl/core”](http://java.sun.com/jsp/jstl/core%E2%80%9D) %>

- BCryptPasswordEncoder 스프링 시큐리티 프레임워크에서 제공하는 클래스 중 하나로 비밀번호를 암호화하는데 사용할 수 있는 메서드를 가진 클래스 BCrypt 해싱함수를 사용해서 비밀번호를 인코딩해주는 메서드와 사용자에 의해 제출 된 비밀번호와 저장소에 저장되어 있는 비밀번호의 일치 여부를 확인해주는 메서드를 제공 passwordEncoder 인터페이스를 구현한 클래스 생성자의 인자값(version, strength, SecureRandom instance)을 통해 해시의 강도 조절 가능
- Spring Security 자바 서버 개발을 위해 필요로 하는 인증, 권한 부여 및 기타 보안 기능을 제공하는 프레임 워크(클래스와 인터페이스들의 모임)
- HttpSecurity 세부적인 보안기능을 설정할 수 있는 몌ㅑ를 제공
- @Transactional 어노테이션 클래스나 메서드에 붙여줄 경우 해당 범위 내 메서드가 트랜잭션이 되도록 보장

1. 연산이 고립되어 다른 연산과의 혼선으로 인해 잘못된 값을 가져오는 경우 방지
2. 연산의 원자성이 보장되어 연산 도중에 실패할 경우 변경사항이 commit 되지 않음

- SHA256 SHA(Secure Hash Algorithm) 알고리즘의 한 종류로서 256비트로 구성되며 64자리 문자열을 반환 이름에 내포되어 있듯 2^256 만큼 경우의 수를 만들기가 가능하여 개인용 컴퓨터로 무차별 대입을 수행해 해시 충돌 사례를 찾으려할 때 많은 시간이 소요될 정도로 큰 숫자 (비교적 안전) NIST에 의해 공표된 표준 해시 알고리즘인 SHA-2 계열 중 하나이며 블록체인에서 가장 많이 채택하여 사용하고 있음
- 해시 충돌 해시 함수가 서로 다른 두 개의 입력값에 대해 동일한 출력값을 내는 상황 함호학적 해시 함수의 경우 해시 함수의 안정성을 깨트리는 충돌 공격이 가능할 수 있기 때문에 의도적인 해시 충돌을 만드는 것이 어렵도록 만들어야 함
- @Configuration 어노테이션 해당 어노테이션을 단 클래스는 Bean 설정을 담당하는 클래스가 됨 (이 클래스 안에서 @Bean 어노테이션이 동봉된 메소드를 선언하면 그 메서드를 통해 스프링 빈을 정의하고 생명주기를 설정하게 됨) -> 자바 기반의 config가 싫다면 XML을 사용
- @EnableWebSecurity Security 활성화 WebSecurityConfiguration.class, SpringWebMvcImportSelector.class, OAuth2ImportSelector.class, HttpSecurityConfiguration.class 들을 import 해서 실행시켜 줌

[20220708]

- Spring Security 자바 EE 기반의 엔터프라이즈 소프트웨어 애플리케이션을 위한 포괄적인 보안 서비스들을 제공하고 오픈 플랫폼이면서 자신만의 인증 메커니즘을 만들 수 있음
- Spring Security의 보안 구성 영역

1. 인증 (Authentication) 애플리케이션의 작업을 수행할 수 있는 주체(사용자)라고 주장할 수 있는 것
2. 권한 (Authorization) 인증된 주체가 애플리케이션의 동작을 수행할 수 있도록 허락되어있는 지를 결정하는 것 -> 권한 승인이 필요한 부분으로 접근하려면 인증과정을 통해 주체가 증명 되어야만 함

- 메서드 안에서 제어문 없는 중괄호의 쓰임 메서드 안에서 쌩뚱맞은 중괄호 블락이 보인다면 이는 변수의 변수의 유효범위(scope)를 제한하기 위함 -> 변수의 유효범위를 제한하여 코딩할 때 사용하나 매우 드물게 사용
- Spring security 제작 순서

1. 디펜던시 추가 (메이븐)
2. Java Configuration 작성

- XML 기반: web.xml에 org.springframework.web.filter.DelegatingFilterProxy라는 springSecurityFilterChain 등록
- 자바 기반: WebSecurityConfigureAdapter를 상속받은 클래스에 @EnableWebSecurity 어노테이션 명시 (springSecurityFilterChain 자동 포함)

3. springSecurityFilterChain 등록

- AbstractSecurityWebApplicationInitializer를 상속받은 WebApplicationInitializer를 만듦

4. getRootConfigClasses() 메서드 추가 WebSecurityConfigurerAdapter를 상속받은 클래스를 getRootConfigClasses() 메서드에 추가하는 것으로 스프링 시큐리티에 대한 기본 적용 -> springSecurityFilterChain은 루트 컨텍스트에서 등록되어야 함
5. HttpSecurity 구성 configure(HttpSecurity http) 메서드를 통해 인증 메커니즘 구성 -> HttpSecurity의 인스턴스를 통해 인증 메커니즘을 만들며 대부분의 설정은 이 곳을 통함
6. AuthenticationManagerBuilder 객체 생성 인증 객체를 만들 수 있도록 제공 AuthenticationManagerBuilder를 메소드를 통해 주입 받아 처리하는 방식 -> WebSecurityConfigurerAdapter의 configure(AuthenticationManagerBuilder auth)를 오버라이딩 하는 것에 대한 차이는 없음

- Spring MVC를 이용한 request 추적 웹브라우저에서 링크 클릭 혹은 폼을 서브밋 할 때 요청을 처리하기 위한 작업이 수행 됨

1. 요청이 브라우저에서 떠나면서 사용자의 요구 내용 전달 -> DispatcherServlet
2. DispatcherServlet에서 다음 요청이 가야할 곳을 찾기 위해 핸들러 매핑에게 도움 요청 -> 컨트롤러 선택
3. 선택 된 컨트롤러에 DispatcherServelet이 요청을 보냄 -> 요청은 payload로 떨굼 -> 이후 컨트롤러의 처리시간 동안 대기 -> 브라우저용 정보로 반환(Model) -> 이 정보를 사용자가 보기 편한 형태로 바꾸는 View가 필요 (jsp 등)
4. Model과 View의 이름을 확인한 후 함께 DispatcherServlet으로 요청을 반환
5. DispatcherServlet은 뷰리졸버에게 전달 받은 View의 이름과 실제로 구현된 View를 매핑해줄 것을 요청 -> 렌더링을 위한 뷰가 어떤 것인 지 알게 됨
6. 일반적인 JSP로 모델 데이터를 전달해주는 View의 구현
7. 모델 데이터로 렌더링 후 응답 객체로 전달

- @Deprecated 어노테이션 해당 어노테이션이 표시되어 있는 메서드나 필드를 사용하면 빌드 할 때 warnning 메시지를 보여 줌 -> 컴파일러에게 이 메서드는 없어질거라는 것을 알려주고 쓰지 말도록 경고
- antMatchers() 다음으로 지정할 수 있는 항목
- anonymous(): 인증되지 않은 사용자가 접근 할 수 있음
- authenticated(): 인증된 사용자만 접근 할 수 있음
- fullyAuthenticated(): 완전히 인증 된 사용자만 접근 할 수 있음
- hasRole() / hasAnyRole(): 특정 권한을 가지는 사용자만 접근 할 수 있음
- hasAuthority() / hasAnyAuthority(): 특정 권한을 가지는 사용자만 접근 할 수 있음
- hasIpAddress(): 특정 아이피 주소를 가지는 사용자만 접근 할 수 있음
- access(): SpEL 표현식에 의한 결과에 따라 접근 할 수 있음
- permitAll() or denyAll(): 접근을 전부 허용하거나 제한 함
- rememberMe(): 리멤버 기능을 통해 로그인 한 사용자만 접근 할 수 있음 -> Role은 “ADMIN”으로 표현하고 Authority는 “ROLE_ADMIN”으로 표기함 (Role은 역할이고 Authority는 권한이지만 단순 표현의 차이임)
- this 자바의 this는 현재 생성 된 객체를 가리키는 예약어(=self) 메서드의 매개변수와 멤버변수가 같으면 구분해주기 위해서 멤버변수 앞에 써줌 this(): 기본 생성자를 호출 this(1): 인수 1개 짜리 정수형 값을 받아서 처리해주는 생성자 호출 this(1, “홍길동”): 인수 2개 짜리 값을 받아서 처리하는 생성자 호출 (첫 번째 인수는 정수, 두 번째 인수는 문자열 처리)

[20220711]

- map-underscore-to-camel-case 변수를 표기하는 방법

1. 스네이크 형식: board_no
2. 카멜 형식: boardNo DB에는 컬럼명이 보통 스테이크 형식이지만 서버에서 객체의 멤버 변수의 이름은 카멜케이스로 들어감 그렇기 때문에 return type을 VO로 지정했을 경우 명칭이 달라서 데이터를 못 받아오는 경우가 생겨 mybatis에서 별칭을 지정하여 나동으로 변환해주느 방법

- form 태그 사용자 의견이나 정보를 알기 위해 입력할 큰 틀을 만드는데 사용되기 때문에 웹에서 많이 사용함 form은 입력 된 데이터를 한 번에 서버로 전송 -> 전송한 데이터는 웹 서버각 처리 -> 결과에 따른 또 다른 웹 페이지를 보여줌
- form 태그 동작방법

1. 폼이 있는 웹 페이지를 방문
2. 폼 내용을 입력
3. 폼 안에 있는 모든 데이터를 웹 서버로 보냄
4. 웹 서버는 받은 폼 데이터를 처리하기 위해 웹 프로그램으로 넘김
5. 웹 프로그램은 폼 데이터를 처리
6. 처리결과에 따른 새로운 html 페이지를 웹 서버에 보냄
7. 웹 서버는 받은 html 페이지를 브라우저에게 보냄
8. 브라우저는 받은 html 페이지를 보여줌

- form 태그 속성 폼 속성을 이용하여 전송할 때 어디로 보내야하는 지 그리고 어떤 방법으로 보낼 지 정함
- action: 폼을 전송할 서버 쪽 스크립트 파일을 지정
- name: 폼을 식별하기 위한 이름을 지정
- accept-charset: 폼 전송에 사용할 문자 인코딩 지정
- target: action에서 지정한 스크립트 파일을 현재 창이 아닌 다른 위치에 열도록 지정
- method: 폼을 서버에 전송할 http 메소드 지정 (GET / POST) -> 전송할 http 메소드 종류인 GET/POST는 브라우저에서 폼 데이터를 가져와 서버로 보내는 똑같은 기능을 수행하지만 방식은 다름 (GET은 폼 데이터를 URL 끝에 붙여서 눈에 보이게 보내지만 POST 방식은 내부적으로 보이지 않게 보냄 -> 따라서 GET 방식은 데이터가 외부에 노출되어 보안에 취약하므로 GET 방식은 지정된 리소스에서 데이터를 요청하는 경우인 읽을 때 사용하는 메소드, POST 방식은 지정된 리소스에서 데이터를 저리할 경우인 read/write/modify 할 때 사용
- form을 구성하는 엘리먼트

1. 폼 엘리먼트 그룹 <field>, <legend> 태그

- filed 태그: 폼 태그 안에 관련 있는 폼 엘리먼트들을 그룹화 할 때 사용
- legend 태그: field 태그 하위에 사용하여 그룹화한 폼 엘리먼트들을 목적에 맞게 이름을 지정

2. 다양한 모양을 가진 input 태그 input 태그는 사용자가 다양하게 폼 태그에 입력할 수 있는 공간을 만들어 줌

- type: 태그 모양을 다양하게 변경 할 수 있음 (text, radio, checkbox, password, button, hidden, fileupload, submit, reset 등을 지정)
- name: 태그 이름을 지정
- readonly: 태그를 읽기 전용으로 함
- maxlength: 해당 태그 최대 글자 수 지정
- required: 해당 태그가 필수 태그로 지정
- autofocus: 웹 페이지가 로딩되자마자 이 속성을 지정한 태그로 포커스 이동 (HTML5 추가사항)
- placeholder: 태그에 입력할 값에 대한 힌트를 줌 (HTML5 추가사항)
- pattern: 정규표현식을 사용하여 특정 범위 내의 유효한 값을 입력받을 때 사용 (HTML5 추가사항)

3. 목록태그 select, optgroup, option

- select: 항목을 선택할 수 있는 태그
- optgroup: select의 하위 태그이며 select 태그 안에서 목록들을 그룹화할 경우 사용
- option: select의 하위 태그이며 목록을 나타내는 그룹

[20220712]

- Integer와 int 차이

1. int

- primitive 자료형 (long, float, double …)
- 산술 연산이 가능
- null로 초기화 불가능

2. Integer

- Wrapper 클래스 (객체)
- Unboxing을 하지 않으면 산술 연산이 불가능하지만 null 값을 처리할 수 있음
- null 값 처리가 용이하기 때문에 SQL과 연동할 경우 처리가 용이
- DB에서 자료형이 정수형이지만 null 값이 필요한 경우 VO에서 Integer를 사용할 수 있음

3. int <-> Integer 형변환

- Primitive 자료형 -> Wrapper 클래스 (Boxing)
- Wrapper 클래스 -> Primitive 자료형 (Unboxing)
- VO, DAO, DTO

1. DAO (Data Access Object)

- 데이터베이스의 data에 접근하기 위한 객체.
- 데이터베이스 접근을 하기 위한 로직과 비즈니스 로직을 분리하기 위해 사용
- Mybatis 등을 사용할 경우 커넥션 풀까지 제공하기 때문에 DAO를 별도로 만드는 경우는 드뭄

2. DTO (Data Transfer Object)

- 계층간 데이터 교환을 위한 java beans
- 계층간의 의미는 Controller, View, Business Layer, Persistent Layer 등을 말하며 각 계층간 데이터 교환을 위한 객체를 의미
- 로직을 갖지 않는 순수한 데이터 객체이고 getter, setter 메소드만 가진 클래스를 의미

3. VO (Value Object)

- DTO와 혼용하여 쓰지만 약간의 차이 존재
- DTO와 VO는 넣어진 데이터를 getter를 통해 사용하므로 주 목적은 같지만 DTO의 경우 setter를 이용해 가변적인 성격을 가진 클래스
- VO는 불변의 성격을 지님
- @Resource / @Inject / @Autowired 세 개의 어노테이션 모두 컨테이너에 생성된 빈(Bean) 객체를 자동으로 주입받을 수 있도록 해 줌 Bean 객체를 이용할 때 코드를 간결하게 해주기 때문에 필수로 사용되는 어노테이션 Bean 객체가 생성될 때 어노테이션을 스캔해서 자동으로 주입해주는데 일반적인 방법으로 해당 클래스의 인스턴스를 new로 생성하면 어노테이션은 작동하지 않음 (Bean 설정 파일에서 ref=‘다른 Bean’ 식으로 작성하는 부분을 생략 가능)
- 1. Resource 필드명 또는 생성자 파라미터 변수의 이름과 Bean 객체의 ID를 매핑시켜 먼저 찾는 방식 오버라이딩을 사용하는 경우 둘 다 달라질 수 있기 때문에 항상 이름을 명시해서 사용해주는 것이 안정적
- 의존: Java
- 사용 가능. 위치: 필드, 파라미터가 한 개인 setter
- Bean 검색 우선순위: 이름 → 타입
- Bean 강제 지정: @Resource(name=”ID”)
- Bean 없을 경우: 예외 발생
- 예시

```java
@Resource(name="sqlSessionFactory")
private SqlSessionFactory sqlFactory;
```

1. @Inject 타입이 같은 Bean을 먼저 찾고 다음으로 이름을 찾음 부모 클래스 타입에 여러 자식 클래스의 Bean 객체 중 하나를 오버라이딩 시키는 경우 예외 발생 가능

- 의존: Javax
- 사용가능 위치: 필드, 생성자, setter
- Bean 검색 우선순위: 타입 → 이름
- Bean 강제 지정: @Inject @Named(”ID”)
- Bean이 없을 경우: 예외발생
- 예시

2. Autowired

- @RequestParam 요청 매개변수에 들어있는 기본 타입 데이터를 메서드 인자로 받아올 수 있음 → 요청 매개변수랑 URL 요청의 localhost:8080?username=value&age=value의 쿼리 매개변수와 HTML 태그의 Form 데이터가 해당함
- 단일 HTTP 요청 파라미터의 값을 메서드 파라미터에 넣어주는 어노테이션
- 가져올 요청 파라미터의 이름을 @RequestParam 어노테이션의 기본 값으로 지정
- 요청 파라미터의 값은 메소드 파라미터의 타입에 따라 적절히 변환
- 해당 파라미터가 반드시 존재해야하며 없으면 HTTP 400 Bad Request 발생
- 파라미터를 필수가 아니라 선택적으로 제공하게 하려면 required 엘리먼트를 false로 설정

[20220713]

- 로그 레벨
- 로그 레벨의 구조: TRACE < DEBUG < INFO < WARN < ERROR < OFF → INFO 레벨을 설정할 경우 TRACE, DEBUG에 해당하는 정보는 로그 되지 않음 (TRACE이면 최대한의 정보가, ERROR로 하면 최소한의 정보가 노출)
- Interface 사용하기

1. 인터페이스 작성
2. 인터페이스를 상속 받는 Impl 작성
3. 사용하고자 하는 클래스에서 데이터타입을 인터페이스, 변수명을 인터페이스구현한클래스이름

```java
// ArticleService: 인터페이스
// articleServiceImpl: 인터페이스를 구현한 클래스
private ArticleService articleServiceImpl;
```

- MySQL의 CURRENT_TIMESTAMP 특정 행을 입력 할 때 생성 시간을 자동으로 기록하고 싶다면 데이터 타입에 TIMESTAMP를 넣고 DEFAULT/Expression에 CURRENT_TIMESTAMP()를 사용 (NOW() 또한 같은 값) → NOT NULL로 설정 되어있지 않으면 해당 내부 함수가 작동하지 않음 → DATETIME을 사용하는 것도 가능하지만 DATETIME은 타임존 개념이 들어가있지 않으므로 어떤 서비스를 관리하고자 하는 지가 중요 (글로벌 서비스 등)
- Mybatis의 resultMap myBatis에서 제공하는 자동 매핑으로서 해결이 어려운 경우를 위해 구조를 설계할 수 있도록 만들어진 도구 필드명이 자주 바뀌거나 매칭되는 타입이 다른 경우(number → String)에는 매핑을 AS로 할 수 없기 때문에 resultMap 사용 → 복잡한 결과 매핑을 간편하게 만들어주기 위해 만들어진 태그

```xml
<resultMap id="testMap" type="User객체경로.User">
  <result column="user_id" property="id" jdbcType="NVARCHAR" javaType="String"/>
  <result column="user_name" property="username" jdbcType="NVARCHAR" javaType="String"/>
  <result column="hashed_password" property="hashedPassword" jdbcType="NVARCHAR" javaType="String"/>
</resultMap>

<select id="selectUsers" resultMap="testMap">
  select user_id, user_name, hashed_password
  from some_table
  where id = #{id}
</select>
```

- java ↔ mySQL 타입 변환 MySQL Connector/J는 MySQL 데이터 타입과 자바 데이터 타입 간의 변환을 유연하게 처리하는데, 일반적으로 모든 MySQL 데이터 타입은 java.lang.String으로 변환할 수 있고 모든 수식 타입도 java 수식 타입으로 변환할 수 있음

```xml
// These MySQL Data Types
CHAR, VARCHAR, BLOB, TEXT, ENUM, and SET
// Can always be converted to these Java types
java.lang.String, java.io.InputStream, java.io.Reader, java.sql.Blob, java.sql.Clob

// These MySQL Data Types
FLOAT, REAL, DOUBLE PRECISION, NUMERIC, DECIMAL, TINYINT, SMALLINT, MEDIUMINT, INTEGER, BIGINT
// Can always be converted to these Java types
java.lang.String, java.lang.Short, java.lang.Integer, java.lang.Long, java.lang.Double, java.math.BigDecimal

// These MySQL Data Types
DATE, TIME, DATETIME, TIMESTAMP
// Can always be converted to these Java types
java.lang.String, java.sql.Date, java.sql.Timestamp

```

[20220714]

- @Column 어노테이션 객체 필드와 DB 테이블 컬럼을 매핑 @Column의 속성

1. name: 매핑할 테이블의 컬럼 이름을 가짐
2. insertable: 엔티티 저장
3. updateable: 엔티티 수정 시 이 필드를 함께 수정
4. table: 지정한 필드를 다른 테이블에 매핑
5. nullable: NULL을 허용할 지 허용하지 않을 지 결정
6. uique: 제약 조건을 걸 때 사용
7. columnDefinition: DB 컬럼 정보를 직접적으로 지정할 때 사용
8. length: varchar의 길이를 조정 (기본값으로 255)
9. precsion, scale: BigInteger, BigDecimal 타입에서 사용, 각각 소수점 포함 자리수, 소수의 자리수를 의미

- JPA 장단점
- 장점

1. RDB 종류와 관계없이 사용 가능하기 때문에 DB 변경이 있어도 코드 재활용 가능
2. 기본적인 CRUD 제공과 페이징 처리 등 구현되어 있는 것이 많아 비즈니스 로직에 집중할 수 있음
3. 테이블 생성, 변경 등 엔티티 관리가 간편
4. 쿼리를 직접 작성할 필요 없이 Java 코드로 간편하게 사용 가능
5. 쿼리에 로직을 담지 않아도 됨

- 단점

1. 배우기 위한 난이도 존재 (단방향, 양방향, 임베디드 관계 등 공부할 내용이 많으며 연관관계에 대한 이해가 없이 코딩을 하게되면 성능 문제를 일으킬 수 있고 원하지 않는 결과를 가져올 수 있음)

- Mybatis 장단점
- 장점

1. JPA에 비해 쉬움
2. SQL 쿼리를 그대로 사용하기 때문에 복잡한 Join 튜닝 등을 편하게 작성할 수 있음
3. SQL 쿼리의 세부 내용 변경 시 수월
4. 동적 쿼리 사용 시 JPA보다 간편하게 구현 가능 → 동적쿼리: 상황에 따라 분기처리를 통해 SQL문을 동적으로 만드는 기법

- 단점

1. DB 설정 변경 시 수정할 부분이 많음
2. Mapper 작성부터 인터페이스, 모델 설계까지 JPA보다 많은 설계와 파일/로직이 필요 (Mapper에서 select id로 사용할 인터페이스 설계, 쿼리에 파라미터로 #혹은 $로 파라미터 바인등을 위한 model 정의, resultType/ParameterType으로 전달 할 model 정의가 필요)
3. 특정 DB에 종속적 (DB가 바뀌면 DB 문법에 맞게 mapper를 전부 수정)
4. 쿼리에 로직을 녹여야 하는데 유지보수 하기가 힘들고 테스트도 까다로움

- JPA와 myBatis 두 가지를 혼용하여 사용 가능
    
- myBatis의 부적절한 열 유형 null 처리 spring mybatis 사용 시 insert, update를 할 때 null 값이 들어가면 부적합한 열 유형 오류가 발생
    
- 날짜형 데이터 타입 TIME / DATE / DATETIME / TIMESTAMP
    

1. TIME

- 시간을 표시하는 데이터 타입
- 현재 시간 뿐만 아니라 과거 시간이나 특정 이벤트끼리의 간극을 표현하는데 사용

```xml
HH:MM:SS 또는 HHH:MM:SS
```

1. DATE

- 날짜를 표시하는 데이터 타입
- 시간을 포함하지 않음
- ‘1001-01-01’부터 ‘9999-12-31’까지 입력 가능

```xml
YYYY-MM-DD
```

1. DATETIME

- 날짜와 시간을 포함하는 데이터 타입
- ‘1001-01-01 00:00:00’부터 ‘9999-12-31 23:59:59’까지 입력 가능

```xml
YYYY-MM-DD HH:MM:SS
```

1. TIMESTAMP

- 날짜와 시간을 포함하는 데이터 타입
- Date보다 정밀한 시간을 요구할 때 사용
- 시스템의 프로세스 시간, 우선순위를 정하거나 밀리세컨드(ms) 이하까지 표현하기 위해 사용

```xml
YYYY-MM-DD HH:MM:SS
```

- TIMESTAMP와 DATETIME의 차이
- TIMESTAMP

1. 타입: 숫자형
2. 용량: 4byte
3. 입력: Default Insert(AUTO)
4. 형식: 1970-01-01 ~ 2038-01-19(UTC)

- DATETIME

1. 타입: 문자형
2. 용량: 8byte
3. 입력: 명시적 INSERT
4. 형식: 1000-00-00 ~ 9999-99-99 → TIMESTAMP 형식은 UTC형으로 TIME_ZONE을 가지고 있어 동일하게 now()를 받는다면 DB내에 설정되어 있는 TIME_ZONE에 따라 입력값이 다르게 나타남
    - JSTL 자주 사용되는 태그
    - Core 가장 자주 사용되는 jstl 태그로서 일반적인 프로그램의 기능을 제공
    - Formatting 날짜, 시간, 숫자, 텍스트를 포맷하고 표시하는 formatter 기능을 제공
    - SQL RDBMS와 상호 작용하는 태그를 제공
    - XML XML 문서를 생성하고 조작하는 방법 제공
    - Functions 일반적인 문자열을 가공하고 조작하는 표준함수 제공

- mode.addAttribute() 메서드 Model에 데이터를 담을 때 addAttribute() 메서드 사용

1. 사용방법

```xml
Model addAttribute(String name, Object value)
// value 객체를 name 이름으로 추가
// view 코드에서 name으로 지정한 이름을 통해 value 사용
```

[20220715]

- Mybatis #{} ${} 차이

1. #{} 파라미터가 String 형태로 들어와 자동적으로 파라미터 형태가 됨 쿼리 주입을 예방할 수 있어 보안측면에서 유리 → #{user_id}의 user_id의 값이 abc라면 쿼리문에는 USER_ID=’abc’ 형태가 됨
    
2. ${} 파라미터가 바로 출력 해당 컬럼의 자료형에 맞추어 파라미터의 자료형이 변경 됨 쿼리 주입을 예방할 수 없어 보안측면에서 불리하므로 사용자의 입력을 전달 할 때는 사용하지 않는 편이 나음 테이블이나 컬럼명을 파라미터로 전달하고 싶을 때 사용 → #{}은 자동으로 ‘’가 붙어서 이 경우에는 사용할 수 없음
    

- SQL injection (쿼리 주입) 코드 인젝션의 한 기법으로 클라이언트의 입력값을 조작하여 서버의 데이터베이스를 공격할 수 있는 공격방식 사용자가 입력한 데이터를 제대로 필터링/이스케이핑 하지 못했을 경우 발생
- <![CDATA[…]]> Character DATA의 약자로 문자 데이터를 말함 xml에서 … 안에 들어있는 텍스트가 태그로써 파싱되지 않고 텍스트로만 인식하기 위한 방지책
- Model과 ModelAndView

1. Model model.addAttribute를 사용하여 데이터만 저장
2. ModelAndView 데이터와 이동하고자 하는 View Page를 같이 저장

[20220718]

- Database의 키 데이터베이스에서 키(key)는 조건에 만족하는 튜플을 찾거나 순서대로 정렬할 때 다른 튜플들과 구별할 수 있는 기준이 되는 속성(attribute) 하나의 릴레이션(column)에는 수 많은 튜플(row)들이 존재하는데 각 튜플들 간에 중복되는 속성값이 발생 할 수 있기 때문에 튜플을 구분하기 위한 기준이 되는 속성을 키(key)라고 함 키의 종류로는 슈퍼키, 후보키, 기본키, 대체키, 외래키 존재
    
- Database 유일성과 최소성
    
- 유일성 하나의 키값으로 튜플을 유일하게 식별할 수 있는 성질 어떤 릴레이션에 주민번호, 나이, 사는 곳, 혈액형이라는 속성이 존재 할 때 주민번호만은 중복이 절대 발생할 수 없기 때문에 각각의 튜플을 구분할 수 있는 주민번호와 같은 성질을 유일성이라고 함
    
- 최소성 키를 구성하는 속성들 중 가장 최소로 필요한 속성들로만 키를 구성하는 성질 주민번호, 이름, 나이 속성들로 이루어진 키가 있다면 현재의 키는 각 튜플을 구분할 수 있지만 주민번호만으로도 각 튜플들을 유일하게 식별 할 수 있으므로 이름, 나이를 빼면 최소성을 만족함
    
- 슈퍼키 / 후보키 / 기본키 / 대체키 / 외래키
    
- 포함 관계도 슈퍼키 > 후보키 > 기본키 ≠ 대체키
    
- 슈퍼키 super key (유일성 O, 최소성 X) 유일성의 특성을 만족하는 속성 또는 속성들의 집합을 의미 → 직업, 나이, 등급 속성으로 이루어진 키의 경우 같은 고객이 있을 수 있기 때문에 슈퍼키로 사용될 수 없지만 고객 아이디, 직업, 나이, 등급 속성으로 이루어진 키의 경우 고객 아이디가 각 튜플을 구분할 수 있는 속성이기 때문에 슈퍼키가 될 수 있음
    
- 후보키 candidate key (유일성 O, 최소성 O) 후보키는 슈퍼키 중 최소성을 만족하는 (유일성과 최소성을 만족하는) 속성 또는 속성들의 집합
    
- 기본키 primary key (후보키 중 선택받은 키) 유일성과 최소성 모두 만족하는 후보키 중 선택된 키 후보키에서 기본키를 선택함에 있어 통과해야 되는 기준 3가지가 있음
    

1. NULL 값을 가질 수 있는 속성이 포함된 후보키는 기본키로 부적절
2. 값이 자주 변경될 수 있는 속성이 포함된 후보키는 기본키로 부적절
3. 단순한 후보키를 기본키로 선택

- 대체키 alternate key (후보키 중 선택받지 못한 키) 기본키를 대체할 자격은 있지만 기본키 선택 기준에 부합하지 않아 선택받지 못한 키들을 의미 → 보조키라고도 불림
    
- 외래키 Foreign key (다른 릴레이션의 기본키를 참조) 다른 릴레이션의 기본키를 그대로 참조하는 속성 또는 속성들의 집합 → 외래키는 릴레이션 간의 관계를 올바르게 표현하기 위해 필요 → 외래키로 지정되면 참조 테이블의 기본키에 없는 값은 입력 불가 (참조 무결성 조건)
    
- 카디널리티(Cardinality)와 선택도(Selectivity)
    
- 카디널리티 특정 데이터 집합의 유니크한 값의 개수 → 데이터베이스에 성별이라는 컬럼의 경우 남자/여자라는 값을 가질 때 카디널리티는 2 → 주민번호의 경우 테이블에 존재하는 모든 레코드가 유니크 할 수 있으므로 주민번호의 카디널리티는 테이블에 들어있는 레코드의 개수
    
- 선택도 카디널리티로부터 계산할 수 있는 값 → 선택도가 1이라는 뜻은 모든 값이 유니크하다는 의미
    
- 테이블 간 외래키 연결
    
- 1:1 관계의 경우 양쪽의 기본키를 상대방 테이블의 외래키로 추가
    
- 1:N 관계의 경우 1쪽의 기본키를 N쪽의 외래키로 추가
    
- N:N 관계의 경우 양쪽의 기본키를 외래키로 갖는 별도의 테이블 생성 → 외래키를 받는 테이블에 기존 데이터가 있다면 외래키 추가 불가능 (무결성 위배)
    
- 쿠키와 세션
    
- 쿠키 저장위치: 클라이언트 사용자원: 클라이언트의 리소스 속도: 세션보다 빠름 보안: 세션보다 취약 저장형식: 텍스트
    
- 세션 저장위치: 서버 사용자원: 서버의 리소스 속도: 쿠키보다 느림 보안: 쿠키보다 좋음 저장형식: 객체
    
- 스프링이 지원하는 로그인 방식 4가지
    

1. 폼 로그인 UsernamePasswordAuthentication을 사용하여 서버사이드 랜더링에서 폼 전송 방식으로 로그인
    
2. AJAX 로그인 Basic Authentication을 사용하여 SPA 또는 모바일 환경에서 요청 헤더에 토큰을 담아 로그인 → 헤어데 직접 ID와 PW를 담기 때문에 보안에 취약
    
3. OAuth2 로그인 API에 로그인을 위임하는 방식
    
4. JWT 토큰 로그인 SPA, 모바일 환경에서 Json Web Token을 생성하여 인증하는 방식
    

[20220719]

- session 사용자가 웹 브라우저를 통해 웹 서버에 접속한 시점으로부터 웹 브라우저를 종료하여 연결을 끝내는 시점까지 같은 사용자로부터 오는 일련의 요청을 하나의 상태로 보고 그 상태를 일정하게 유지하는 기술 → 클라이언트별로 각각의 상태 정보를 서버에 저장하는 기술
    
- session의 특징
    
- 브라우저마다 개별 저장소(session 객체)를 서버에서 제공(발급)
    
- 각 클라이언트에게 고유한 ID를 부여
    
- 웹서버에 컨테이너 상태를 유지하기 위한 정보를 저장
    
- 세션 ID로 클라이언트를 구분하여 클라이언트 요구에 맞는 서비스 제공
    
- 사용했던 정보들을 서버에 저장하기 때문에 쿠키보다 보안성이 우수
    
- 서버에 저장되기 때문에 서버 부하 발생
    
- Http 프로토콜은 비접속형 프로토콜이라서 매 접속마다 새로운 네트워크 연결이 이루어지는데, 세션이 연결 유지를 가능하게 해줌
    
- session 동작 순서
    

1. 클라이언트가 페이지를 요청
2. 서버는 해당 클라이언트의 RequestHeader에서 Cookie를 확인하여 클라이언트가 해당 SessionID를 보냈는 지 확인
3. 만약 SessionID가 존재하지 않으면 서버는 SessionID를 생성하여 클라이언트에게 전달
4. 서버에서 클라이언트에게 전달한 SessionID를 쿠키를 사용하여 서버에 저장(JSessionID)
5. 클라이언트 재 접속 시 쿠키세션(JSessionID)를 이용하여 sessionID값을 서버에게 전달(3번 작업 실행)

- 세션 설정(발급) 방법

```java
HttpSession session = request.getSession(); 
//request -> HttpServletRequest
session.setAttribute("id",id);              
//key, value 형태로 설정
```

- 세션 삭제 방법

```java
// 수동 종료
HttpSession session = request.getSession(); 
//request -> HttpServletRequest

session.invalidate();                   
// 1. 세션을 즉시 종료
session.setMaxInactiveInterval(30 * 60)	
// 2. 예약 종료 (30분 후)

// 자동 종료 --> web.xml 에서 설정
<session-config>
	<session-timeout>30</session-timeout>
</session-config>
```

[20220721]

- Form 태그 클라이언트에서 서버에게 데이터를 전송할 때 사용하는 HTML 태그
    
- 전송방식
    

1. GET 방식 GET 방식은 클라이언트가 서버에게 데이터를 요청할 때 사용하는 방식 URL 뒤에 데이터가 QueryString으로 붙어서 전송 URL은 HTTP 데이터 포맷의 Header에 저장되어 전송
    
2. POST 방식 클라이언트가 서버에게 데이터를 전송할 때 사용하는 방식 HTTP 통신의 데이터 포맷은 Header, Body로 구성되어 있음 GET 방식과는 달리 POST 방식은 HTTP 데이터 포맷의 Body 부분에 데이터가 담겨진 상태로 전송
    

- JS는 실행 시 앞전에 에러가 생기면 이후의 JS 코드들은 실행되지 않음
- @RequestMapping 특정 uri로 요청을 보내면 Controller에서 어떠한 방식으로 처리할 지 정의 이 때 들어온 요청을 특정 메서드와 매핑하기 위해 사용하는 것이 @RequestMapping value는 요청 받을 url을 설정, method는 어떤 요청으로 받을 지 정의
- URL과 URI 차이
- URL은 자원이 실제로 존재하는 위치를 가리킴
- URI는 자원의 위치뿐만 아니라 자원에 대한 고유 식별자로서 URL의 의미를 포함

---

## Autowired와 private final의 차이

스프링 개발을 하다보면 private final 혹은 autowired를 사용하여 의존성을 주입함

- 스프링 프레임워크에서 의존성을 주입하는 3가지 방식

1. private final (생성자 주입: Constructor Injection) > 생성자 기반 DI
2. @Autowired (필드 주입: Field Injection) > 필드에 자동으로 의존성 주입
3. setter (수정자 주입: Setter Injection) > 수정자 주입

---

# 의존성 주입과 제어의 역전

## 의존성 주입 (DI: Dependency Injection)

어떤 객체에 스프링 컨테이너가 또 다른 객체와 의존성을 맺어주는 행위

- 의존성 주입을 적용하지 않은 경우

```java
// Gun.java
public class Gun {
    ...
    ...
}
```

```java
// Soldier.java
public class Soldier {
    private Gun gun;

    public Soldier() {
        gun = new Gun();
    }
}
```

→ 위 코드는 Soldier 클래스 내부에서 Gun 객체를 생성했기 때문에 의존성을 주입받은 것이 아닌 의존성을 스스로 만든 것

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/aa9848c3-6edd-4745-a095-b1df1ea0dfb1/Untitled.png)

- 의존성 주입을 적용한 경우

```java
// Gun.java
@Component // 스프링 컨테이너에 Bean으로 등록
public class Gun {
    ...
    ...
}
```

```java
// Soldier.java
public class Soldier {
    @Autowired // 스프링 컨테이너에 있는 Gun 타입의 Bean을 주입
    private Gun gun;
}
```

→ 위 코드는 Gun 객체(Bean)를 스프링 컨테이너에 등록하고 스프링 컨테이너에서 Soldier의 gun 멤버 변수에 Bean을 주입할 수 있게 해준 것

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1a1f51d1-621c-4e8f-9f5a-de9a3da64e26/Untitled.png)

## 제어의 역전 (IOC: Inversion of Control)

스프링 컨테이너가 필요에 따라 개발자 대신 Bean들을 관리(제어)해주는 행위

스프링 이전 상황에선 개발자가 new 연산자를 통해 객체를 생성하고 객체의 의존성을 맺어주고 초기화를 해주는 등의 직접적인 제어를 했음

하지만 스프링에서는 xml 파일 또는 어노테이션 방식으로 스프링 컨테이너에 객체(Bean)를 등록하면 스프링 컨테이너에서 Bean의 생명주기(생성 → 의존성 결정 → 초기화 → 소멸)를 전부 관리해줌

> 즉, 객체에 대한 제어권이 컨테이너로 역전되기 때문에 제어의 역전이라고 함

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/83b12e09-89e2-4eff-bbc3-616a962eacab/Untitled.png)

- 장점

1. 개발자는 객체 관리에 덜 신경쓸 수 있게 되어 다른 부분에 집중할 수 있음
2. 약한 결합을 이용하여 객체 간 의존관계를 쉽게 변경할 수 있음
3. 코드의 재사용성과 유지보수성을 높임

---

# 강한 결합과 약한 결합

## 강한 결합

```java
public class Chicken {
    public void eat() {
        System.out.println("치킨을 먹습니다.");
    }
}
```

```java
public class Person {
    private Chicken chicken;
    
    public Person() {
        this.chicken = new Chicken();
    }

    public void startEat() {
        chicken.eat();
    }
}
```

Person 클래스의 멤버 변수 타입으로 Chicken 클래스가 존재

- 단점

1. Chicken 클래스가 없으면 Person 클래스를 정의할 수 없음
2. Chicken 클래스를 다른 종류의 음식 클래스로 바꾸게 되면 Person 클래스의 코드 대부분이 변경되어야 함
3. 유지보수가 매우 힘듦

→ 따라서 Person 클래스가 Chicken 클래스에 의존성이 존재(강한 결합)

## 약한결합

약한 결합으로 의존성이 존재하려면 인터페이스(Interface)를 사용

```java
public interface Food {
    void eat();
}
```

```java
public class Chicken implements Food {
    @Override
    public void eat() {
        System.out.println("치킨을 먹습니다.");
    }
}
```

```java
public class Pizza implements Food {
    @Override
    public void eat() {
        System.out.println("피자를 먹습니다.");
    }
}
```

```java
public class Person {
    private Food food;

    public Person(Food food) {
        this.food = food;
    }

    public void startEat() {
        food.eat();
    }
}
```

Food 인터페이스를 만들어 eat() 추상 메서드를 선언하여 Chicken 클래스와 Pizza 클래스에서 eat()을 구현하게 되면 두 오브젝트 모두 Food 타입에 대입될 수 있으므로 Person 클래스에서 멤버변수 타입을 Food로 할 수 있음

Person 클래스 내부적으로 코드의 변경이 일어날 필요 없이 생성자를 통해 객체를 받아 멤버변수에 대입하기만 하면 오브젝트를 변경 가능하게 해줌

→ 강한 결합에서 벗어나 약한 결합을 이루게 해줌 (유지보수 또한 향상)

---

참고

[](https://velog.io/@damiano1027/Spring-%EC%9D%98%EC%A1%B4%EC%84%B1-%EC%A3%BC%EC%9E%85-%EC%A0%9C%EC%96%B4%EC%9D%98-%EC%97%AD%EC%A0%84)[https://velog.io/@damiano1027/Spring-의존성-주입-제어의-역전](https://velog.io/@damiano1027/Spring-%EC%9D%98%EC%A1%B4%EC%84%B1-%EC%A3%BC%EC%9E%85-%EC%A0%9C%EC%96%B4%EC%9D%98-%EC%97%AD%EC%A0%84)