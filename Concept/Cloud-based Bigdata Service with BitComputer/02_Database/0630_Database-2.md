> **_CMD_**로 실행 및 로그인

# Condition Express
- CASE
- DECODE
- Aggregation Function
- 그룹 함수를 쓸 때 그룹핑을 하고 싶은 필드는 전부 group by로 묶어줘야 함(순서 또한 영향을 줌)
- group by에 조건을 추가로 하고 싶으면 having 씀

굳이 부서 번호와 실제 사원 디비를 따로 관리하는 이유: 부서명이 바뀔 경우 전체 사원 디비에 부서명이 존재하는 디비라면 전체를 바꿔야되는 부분이 있기 때문에 부서 번호를 따로 디비로 저장

## JOIN*****
- 둘 이상의 테이블을 합쳐 하나의 큰 테이블로 만드는 방법(로지컬)
- 필요성: 정규화, Foreign Key, 정규화 된 테이블로부터 결합된 현태의 정보 추출 필요 존재(join)

## 카티젼 프로덕트
- Cross Join
- 올바른 join 조건을 where 절에 부여할 필요 있음

## Simple Join
- Syntax
- join 처리방법

## Join 종류
- Cross join
- inner join
- outer join
- theta join: 조건(부등호 등)에 의한 조인
- equi-join
- natural join
- self join

## Equi-Join
> (같다라고 표현해서)

- inner
- on
- 신표준 구표준 둘 다 알아야 됨

## Theta Join
- 정의
- Non-Equi Join이라고도 함

## Outer join
- right outer join: 조인 양 옆으로 테이블이 있으므로 그 중 오른쪽에 안나오는 놈들까지 출력하게 만듦(left 동일)
- 예전 표기법도 함께 알아야 함(+기호가 헷갈리므로 인지 필요)

## Self Join
- 자기 자신과 Join
- Alias를 사용할 수 밖에 없음
- **_* e1:_** 직원**_, e2:_** 매니저 **_/_** 하지만 **_mgr_** 번호가 없는 사장은 안 나옴
- **_* outer_**를 통해 사장까지 데이터 출력

## **_SQL:1992 Syntax_**
- **_From_**절에서 바로 **_Joi_** 명시적으로 정의
## 집계함수
- *여러행으로 부터 하나의 결과값 반환

## 종류
- **_group by, order by_**


# 단일 **_SQL_** 작성법

-  최종 출력될 정보에 따라 원하는 컬럼 **_select_** 절에 추가
-  원하는 정보 가진 테이블들을 **_from_** 절에 추가
- where_**절에 알맞은 **_join_** 조건 추가
- where_**절에 알맞은 검색 조건 추가
-  필요에 따라 **_group by, having_** 등을 통해 **_grouping_**
-  정렬 조건 **_order by_** 추가

## **_ROLLUP & CUBE (_**안 중요**_)_**
**_- rollup(a, q)_**
**_- cube(a, b)_**
**_- grouping(expr...)_**
# 3. SUBQUERY_**
**_-_** 하나의 쿼리 질의문 속에 다른 쿼리 질의문이 포함된 상태

**_Single-Row Subquery_**
**_-_** 서브쿼리의 결과가 한 **_ROW_**인 경우
**_- Single-Row Operator_** 사용해야 함**_: >, <...._**

**_Multi-Row Query_**
**_- Subquery_**의 결과가 둘 이상의 **_Row_**
**_- Multi-Row_**에 대한 연산을 사용해야 함**_: ANY, ALL, IN, ...._**

**_Correlated Query_**
**_-_** 안에 있는 서브쿼리는 밖의 서브 쿼리를 참조 가능
**_- Outer Query_**와 **_Inner Query_**가 서로 연관되어 있음
**_*_** 밖의 **_outer_**는 **_Alias,_** 밖의 테이블에서 하나 씩 꺼내와 괄호 안의 서브 쿼리를 돌리는 방식
**_*_** 서브쿼리 형태의 위치는 쓰기 나름임
**_*_** 세 가지 모두 같은 결과**_(2_**번의 경우 **_inline_** 뷰까지 사용**_,_** 특히 **_from_** 절에 있는 서브쿼리문은 무조건 인라인 뷰 **_/_** 시험 안 나옴**_)_**

**_TOP-K QUERY(_**오라클**_)_**
**_-_** 조건을 만족하는 상위 **_k_**개의 결과를 빨리 얻기
**_- ROWNUM:_** 질의의 결과에 가상으로 부여되는 오라클의 슈도 컬럼

**_SET Operator_**
**_-_** 두 질의의 결과를 가지고 집합 연산
**_- UNION(_**컬럼의 갯수와 타입만 맞으면 연산 가능**_), UNION ALL, INTERSECT, MINUS_**

**_RANK_** 관련 함수

**_1. DDL_**
**_DDL_** 요약
**_- CREATE TABLE :_** 테이블 생성
**_- ALTER TABLE :_** 테이블 관련 변경
**_- DROP TABLE :_** 테이블 삭제
**_- RENAME :_** 이름 변경
**_- TRUNCATE :_** 테이블의 모든 데이터 삭제
**_- COMMENT_**

# 테이블 생성
**_Subquery_**를 이용한 테이블 생성
**_- Subquery_**의 결과와 동일한 테이블 생성됨
**_-_** 질의 결과 레코드들이 포함 됨
**_- NOT NULL_** 제약 조건만 상속됨

**_Naming Rules_**
**_-_** 테이블 컬럼 등의 이름 명명 규칙

**_TABLE_** 종류
**_- User TAbles_**
**_- Data Dictionary_**

기본 데이터 타입

**_ALTER TABLE_**
**_-_** 컬럼추가
**_-_** 컬럼 수정
**_-_** 컬럼 삭제
**_- UNUSED_** 컬럼

## 기타 테이블 관련 명령
**_-_** 테이블 삭제
**_-_** 데이터 삭제
**_- Comment_**
**_- RENAME_**
**_- ROLLBACK_** 대상이 아니다

# 제약조건
**_- Constraint_**
**_-_** 종류 **_: NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK_**

## 제약조건 정의
**_- Syntax_**
**_-_** 주의 **_:_** 제약 조건에 이름을 부여하지 않으면 오라클이 **_Sys-Cn_** 형태로 자동 부여

## 제약조건
**_- NOT NULL_**
**_- UNIQUE_**
**_- PRIMARY KEY (NOT NULL + UNIQUE)_**
**_- CHECK :_** 임의의 조건 검사**_(_**조건식이 참이어야 변경 가능**_)_**

## 제약조건
**_- FOREIGN KEY (ON DELETE CASCADE, ON DELETE ...)_** 
**_*_** 물리적으로 외래키에 대한 제약조건 작성 **_(_**제약조건에 대한 이름이 없으면 전부 **_Sys.._** 식으로 자동으로 넣어버림**_)_**

**_ADD / DROM CONSTRAINS_**
**_-_** 제약조건 추가
**_-_** 제약조건 삭제

제약조건 타입
**_'P' : 'PRIMARY KEY'_**
**_'U' : 'UNIQUE KEY'_**
**_'C' : 'CHECK'_**
**_'R' : 'FOREIGN KEY'_**

**_Data Dictionary_**
**_-_** 기존에 **_sql DB_**를 중복 실행시켰을 경우 해당 테이블을 삭제 후 다시 테이블을 생성하여 설정해야 됨

**_GRANT / REVOKE_**
권한확인

# Constraint
```sql
SELECT UC.CONSTRAINT_NAME, UC.TABLE_NAME, UCC.COLUMN_NAME,
	UC.CONSTRAINT_TYPE, UC.R_CONSTRAINT_NAME, UC.SEARCH_CONDITION
FROM USER_CONSTRAINTS UC JOIN USER_CONS_COLUMNS UCC
	ON UC.CONSTRAINT_NAME = UCC.CONSTRAINT_NAME
WHERE UC.TABLE_NAME = 'AUTHOR'
```

