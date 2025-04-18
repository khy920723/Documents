# CPU 아키텍쳐 (x86, ARM, 64bit, 32bit)
## 1. 개념 정의 및 예시
### x86
- 정의
	- 인텔이 개발한 32비트 기반의 CISC(복잡 명령어 집합) 아키텍쳐
- 예시
	- Intel Pentium, AMD Athlon 등
- 이름의 유래
	- 8086 -> 80186 -> 80286 -> 80386 -> ... 라인업에서 유래
- 비고
	- 현재는 주로 'x86'이라는 용어가 32비트 CPU 아키텍처 전체를 의미 함
### X86-64 (x64)
- 정의
	- AMD가 x86 기반을 확장한 64비트 아키텍쳐
- 예시
	- AMD64, Intel 64
		- 이름은 다르지만 본질적으로 같음
- 중복 개념 주의
	- x64, x86-64, AMD64, Intel 64 모두 같은 64비트 확장 아키텍처
	- 다르게 부르는 이유는 상표명, 출시 시기, 제조사 차이 때문
- 비고
	- 현재 Windows, Linux, macOS 대부분이 이 구조를 기반으로 함
### ARM (Advanced RISC Machine)
- 정의
	- 저전력 고효율의 RISC 기반 CPU 아키텍쳐
- 예시
	- 스마트폰, 테블릿, Apple Silicon, 라즈베리파이
- 특징
	- 모바일/IoT/임베디드 기기에 적합
	- 최근엔 PC와 서버 시장까지 진출
### 32bit / 64bit
- 정의
	- CPU나 운영체제(OS), 프로그램이 한 번에 처리할 수 있는 데이터 크기 또는 주소 길이를 의미
	- 32bit는 4GB 메모리까지 주소 지정 가능
	- 64bit는 이론상 16EB(엑사바이트)까지 가능
- 예시
	- Windows 10 64 bit
	- Ubuntu 32bit
	- ARMv7 (32bit)
	- ARMv8 (64bit)
## 2. 하드웨어와 소프트웨어 개념 분류
### x86, x64, ARM
- 유형
	- 하드웨어
- 설명
	- CPU 설계 구조 (Instruction Set Architecture: ISA)
### 32bit, 64bit
- 유형
	- 하드웨어 + 소프트웨어 혼합
- 설명
	- CPU 설계 기준이지만 OS와 소프트웨어도 동일 기준을 따라야 함
	- 
## 3. 각 요소들의 장단점
### x86 (32bit)
- 장점
	- 호환성이 높음
	- 구형 장비 지원
- 단점
	- 메모리 4GB 제한
	- 느린 처리
### x64 (x86-64)
- 장점
	- 대용량 메모리
	- 빠른 성능
- 단점
	- 약간 더 많은 메모리 사용
### ARM (32/64bit)
- 장점
	- 저전력
	- 고효율
	- 모바일 최적
- 단점
	- 일부 소프트웨어 호환성이 떨어짐
## 4. 기술 진화의 흐름
### 과거
- x86, 32bit
	- 대부분의 PC에서 사용
	- Windows XP, 7 초기
### 현재
- x64, ARM 64bit
	- 데스크탑 x64
	- 모바일/애플 ARM64
### 미래
- ARM 완전 전환, RISC-V
	- 저전력 ARM이 서버 및 데스크탑 시장 장악
	- RISC-V는 개방형 아키텍쳐로 연구 활발
## 5. 추가 정보
- 운영체제는 CPU 아키텍쳐 + 비트수를 지원해야 정상 작동 함
- 가상화/에뮬레이션 및 소프트웨어 호환성
	- 서로 다른 아키텍쳐 간 소프트웨어 실행 시 성능 저하가 발생하거나 실행 불가
- ARM의 확장성
	- 현재 AWS, Azure, Google Cloud에서도 ARM 서버 사용 중
- RISC-V
	- 차세대 오픈소스 CPU 아키텍쳐로 많은 기업이 관심을 가지는 중