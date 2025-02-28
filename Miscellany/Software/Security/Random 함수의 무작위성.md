1. Random 함수는 실제 무작위 함수를 만드는가?
2. Pseudo Random
3. True Random 생성 방법 
4. 보안에서의 블록체인과 Pseudo Random의 차이

# Random 함수는 실제 무작위 함수를 만드는가?
- Random 함수는 실제 무작위(True Random)을 생성하지 못 함
- 컴퓨터는 모든 연산을 논리적으로 수행하는 기계로서, 결정론적 시스템(Deterministic System)이기 때문
- 대신 특정 알고리즘을 사용하여 '무작위처럼 보이는 숫자'를 생성하는 의사 난수(PSN, Pseudo Random) 방식을 사용함

## 1. True Random
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
		- ![[Pasted image 20250220023944.png]]
		- 특징:
			- 1. 빠르고 간단함
			- 주기가 짧아 일정 패턴이 생길 가능성이 있음
			- 현대 보안 시스템에서는 사용되지 않음
		- Python 코드 예제
``` python
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
```
	- 
1. True Random 생성 방법 
2. 보안에서의 블록체인과 Pseudo Random의 차이