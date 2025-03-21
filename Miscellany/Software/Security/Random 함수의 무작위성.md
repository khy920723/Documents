1. Random 함수는 실제 무작위 함수를 만드는가?
2. Pseudo Random
3. True Random 생성 방법 
4. 보안에서의 블록체인과 Pseudo Random의 차이

# Random 함수는 실제 무작위 함수를 만드는가?
- Random 함수는 실제 무작위(True Random)을 생성하지 못 함
- 컴퓨터는 모든 연산을 논리적으로 수행하는 기계로서, 결정론적 시스템(Deterministic System)이기 때문
- 대신 특정 알고리즘을 사용하여 '무작위처럼 보이는 숫자'를 생성하는 의사 난수(PSN, Pseudo Random) 방식을 사용함

## 1. True Random?
- 완전히 예측 불가능한 숫자
- 물리적 / 자연적 현상을 기반으로 난수를 생성
- CPU 연산만으로는 만들 수 없는 개념

## 2. 컴퓨터가 True Random을 생성하지 못하는 이유
- 컴퓨터는 모든 연산을 예측 가능한 방식으로 수행
	- 컴퓨터의 기본 원리의 한계
		- 입력(Input) -> 연산(Processing) -> 출력(Output)
		- 때문에 연산이 바뀌지 않는 이상, 같은 입력이 들어가면 항상 같은 결과를 출력해야함
	- 의사 난수 생성기(PRNG)의 한계
		- 난수를 정해진 수학적 알고리즘(연산)으로 계산하기 때문에 결과적으로 일정한 패턴을 가짐
		- 시드(Seed)값이 동일하면 항상 같은 난수 시퀀스를 생성함
- 따라서 의사 난수 생성기(PRNG)는 실제 난수가 아닌, 난수처럼 보이는 수열을 만드는 것이며, 이를 의사 난수(Pseudo Radom)이라고 함

# Pseudo Random
- 의사 난수(Pseudo Random Number) 생성은 수학적 알고리즘을 기반으로 동작
- 대표적인 방식으로 LCG(Linear Congruential Generator, 선형 합동 생성기)와 MT19937(메르센 트위터), CSPRNG(Cryptographically Secure PRNG, 암호학적 보안 난수 생성기)가 존재
	- **1. LCG (Linear Congruential Generator, 선형 합동 생성기)**
		- 가장 오래되고 간단한 난수 생성 알고리즘
		- 특징:
			- 1. 빠르고 간단함
			- 주기가 짧아 일정 패턴이 생길 가능성이 있음
			- 현대 보안 시스템에서는 사용되지 않음
	- **2. 메르센 트위스터 (MT19937)**
		- LCG보다 고품질의 의사 난수를 생성하는 알고리즘으로, 대부분의 프로그래밍 언어에서 기본 난수 생성기로 사용
			- 특징:
				- 주기가 길고 품질이 높아 일반적인 용도에 적합
				- 암호학적으로 안전하지는 않음
				- Python의 random 모듈은 메르센 트위스터를 사용함
	- **3. 암호학적 안전 난수 생성기 (CSPRNG, Cryptographically Secure PRNG)**
		- 암호학적으로 안전한 난수 생성
		- 특징:
			- 보안이 중요한 환경에서는 secrets 모듈(CSPRNG)을 사용하고, 일반적인 난수 생성에는 random()을 사용
			- 예측이 어렵고, 보안 키, 인증 코드 등에 사용됨
```python
// LCG Python example code
class LCG:
    def __init__(self, seed=42, a=1664525, c=1013904223, m=2**32):
        self.state = seed
        self.a = a
        self.c = c
        self.m = m

    def random(self):
        self.state = (self.a * self.state + self.c) % self.m
        return self.state / self.m  # 0과 1 사이의 난수 반환

# LCG 난수 생성기 사용 예시
lcg = LCG(seed=1234)
print(lcg.random())  # 0.191482... (0~1 사이의 난수)
print(lcg.random())  # 0.722582...


// 메르센 트위스터 Python example code
class LCG:
    def __init__(self, seed=42, a=1664525, c=1013904223, m=2**32):
        self.state = seed
        self.a = a
        self.c = c
        self.m = m

    def random(self):
        self.state = (self.a * self.state + self.c) % self.m
        return self.state / self.m  # 0과 1 사이의 난수 반환

# LCG 난수 생성기 사용 예시
lcg = LCG(seed=1234)
print(lcg.random())  # 0.191482... (0~1 사이의 난수)
print(lcg.random())  # 0.722582...


// CSPRNG Python example code
import secrets

print(secrets.token_hex(16))  # 32자리(16바이트) 랜덤 문자열 (보안용 토큰 생성)
```
- 의사 난수 생성기로 만들어진 결과값이 예측될 확률
	- 시드(Seed) 값이 노출될 시, PRNG의 모든 출력이 100% 예측 가능
	- 시드 값이 노출 안 됐을 시, 주기가 짧거나 알고리즘이 약하면 일부 또는 전체가 예측 가능
	- PRNG의 내부 상태(Seed, State)가 크고 복잡할 수록 예측이 어려워짐
	- 각 의사 난수 생성기의 예측 확률
		- **1. LCG**
			- 출력값이 몇 개만 주어져도 전체 패턴을 예측할 확률 100%
			- LCG 방식에서 몇 개의 난수 출력값을 알고 있다면, 수식을 역으로 풀어 곱셈 계수(a), 덧셈 계수(c), 나눗셈 계수(m), 시드(seed)들을 역추적 가능
		- **2. 메르센 트위스터**
			- 주기가 길고 품질이 뛰어나지만, 완전히 예측 불가능하지 않음
			- 메르센 트위스터(MT19937)의 내부 상태는 624개의 32비트 정수(약 19937 비트)로 구성되어 있어, 624개의 연속된 난수를 알고 있다면, 이후 모든 난수를 100% 예측 가능
			- 난수 복구 공격(Randomness Recovery Attack)이 가능하여 몇 개의 난수를 수집하면 전체 상태를 역으로 계산 가능
		- **3. CSPRNG**
			- 예측 확률은 거의 0%에 가까움
			- 내부 상태가 외부에서 알 수 없도록 설계되었으며, 충분한 엔트로피(Entropy)를 사용하고, 출력을 기반으로 내부 상태를 역추적 할 수 없도록 설계됨

# True Random 생성 방법
- 진짜 무작위(True Random)을 만드려면, 컴퓨터 내부가 아닌 외부 환경에서 데이터를 얻어야 함.
- **TRNG (True Random Number Generator)**
	- 하드웨어를 이용하여 환경적 요인을 기반으로 난수를 생성 방식
	- **1. 약자 역학적 현상 활용 (QRNG, Quantum Random Number Generator)**
		- 광자의 양자적 변화를 감지하여 예측 불가능한 난수 생성
		- 보안성이 매우 높아 암호화 분야에서 사용
		- IBM, Google 등의 양자 컴퓨터
	- **2. 전자 잡음(Noise) 활용**
		- CPU 내부의 전자 신호 변동을 기반으로 난수 생성
		- Intel RDRAND, RDSEED 명령어
	- **3. 자연적 환경 정보 활용**
		- 키보드 입력 시간, 마우스 움직임, CPU 온도 변화, 마이크로폰 잡음 등
		- 리눅스 /dev/random (사용자의 입력 이벤트를 활용해 난수 생성)
- TRNG의 단점
	- True Random 방식은 속도가 느림
	- 추가 하드웨어가 필요하거나 외부 입력이 필수적
	- 따라서 일반적인 프로그래밍(게임 및 시뮬레이션)에서는 TRNG보다 PRNG를 주로 사용함

# 보안에서의 Block chain과 PRNG의 차이
- 블록 체인과 난수 생성은 다른 개념이지만, 공통적으로 '예측 불가능성'이 주요 포인트
- 블록 체인은 '데이터 무결성'과 '보안'이 목표
- 난수 생성기(PRNG)은 '무작위성'위 목표

## 1. 블록 체인과 PRNG
- 블록 체인
	- 정의
		- 탈중앙화된 분산 원장 기술로, 데이터의 무결성과 보안을 보장하는 시스템
	- 목적
		- 거래 기록을 안전하게 저장하고, 변경 불가능한 데이터 시스템을 유지
	- 예측 가능성
		- 블록 체인의 해시 값은 예측할 수 없지만, 시스템 자체는 결정론적
		- 해시 함수는 입력값이 같으면 항상 같은 출력
	- 보안성
		- 블록체인은 해시 함수, 작업 증명(PoW) 등을 통해 조작이 어려움
	- 사용 예시
		- 암호화폐(Bitcoin 등)
		- 스마트 계약
		- 공급망 관리
- 의사 난수 생성기(PRNG)
	- 정의
		- 수학적 알고리즘을 이용해 무작위처럼 보이는 숫자를 생성하는 시스템
	- 목적
		- 난수를 생성하여 무작위성이 필요한 프로그램(암호화 등)에 사용
	- 예측 가능성
		- PRNG는 시드(Seed) 값을 알면 완전히 예측이 가능
		- PRNG는 수학적 알고리즘을 따르는 결정론적 시스템
	- 보안성
		- PRNG는 내부 알고리즘이 공개되거나 시드를 알면 쉽게 예측 가능
	- 사용 예시
		- 게임(랜덤 드롭)
		- 암호화(키 생성)
		- 데이터 샘플링
		- 시뮬레이션
