# JAVA

## Day01

### 프로그래밍이란
사용자에 요구에 맞춰 데이터를 처리하는 것

### 데이터/정보

데이터: 단순한 컴퓨터 환경의 특정 값을 의미  
정보: 데이터의 의미를 부여

### 데이터베이스
데이터를 기반으로 하는 관리 시스템, 데이터를 모아둔 장소를 의미
- DataBase Management System: DBMS
- DBMS를 줄여 DB
- 대부분 기업의 `도메인 정보`를 저장하고 있음  
![alt text](img/1.png)

### 데이터베이스 종류
- 관계형 데이터베이스(RDBMS)
    - Oracle
    - SQLServer
    - MySQL
    - MariaDB
    - PostgreSQL

- NoSQL 데이터베이스(빅데이터...)
    - Radis
    - MongoDB
    - Apache Cassandra

- In-Memory 데이터베이스
    - SAP HANA(빠름)

### 오라클 설치 방법
1. 로컬 설치  
![alt text](img/3.png)

2. 도커 설치  
![alt text](img/2.png)

### 오라클 설치이전
1. 도커 설치
    - https://www.docker.com/
    - Download Docker Desktop
        - Download for Windows – AMD64
        
2. 설치 후 실행
    - settings 
        - Start Docker Desktop when you sign in to your computer

### 오라클 설치
1. Docker Command 사용
    - Powershell 오픈 후 도커 실행 확인
        ```bash
        docker --version
        ```
    - 이미지 검색
        ```bash
        docker search oracle-xe
        ```
    - 이미지 다운
        ```bash
        docker pull gvenzl/oracle-xe:21-slim
        ```
    - 컨테이너 실행
        ```bash
        docker run -d --name oracle-xe -p 1521:1521 -e ORACLE_PASSWORD=비밀번호 gvenzl/oracle-xe:21-slim
        ```
    - 컨테이너 내부 접속
        ```bash
        docker exec -it oracle-xe sqlplus system/비밀번호@XE
        ```
        
    - Container DB 모드 확인 방법
        ```sql
        SELECT * FROM v$database;
        ```
    - 강의용 사용자 생성
        ```sql
        CREATE USER java IDENTIFIED BY java12345;
        GRANT CONNECT, RESOURCE TO java;
        GRANT CREATE TABLE TO java;
        GRANT all privileges TO java; -- INSERT 등 추가권한 할당
        ```

### 데이터베이스 개발 툴 DBeaver 설치
1. 개발 툴 종류
    - SQL*Plus - 콘솔 개발 화면, 가장 기초적인 SQL 실행도구, 사용 불편리함
    - Oracle SQL Developer - 오라클에서 제공하는 무료툴, 오픈소스, java 개발 툴 Eclipse를 커스텀해서 개발
    - Toad for Oracle - DB 개발 툴, 가장 강력한 SW, 상용 라이선스
    - DBeaver - 오픈소스, 거의 모든 DB를 사용, 대중성이 높음

2. DBeaver 설치
    - https://dbeaver.io/

    #### DBeaver 사용법
    - Database Navigator에서 DB연결 시작
    - 우클릭 -> create -> connection
    - 연결 정보 입력 -> test connection -> 완료
    - 주의사항: port 번호 확인, Database 이름 확인, Usernmae과 Password 일치

3. VSCODE EXTENSIONS
- Database Client  
![alt text](img/4.png)
- 설정 후 save -> connect

### 기본 사용법
- DBeaver
    - 연결된 XE - java -> Schema(Database와 같은 의미) 확장 -> JAVA 선택 -> SQL 편집기
- 샘플 DB 생성, 시퀀스 생성

    1. 테이블 생성: [쿼리](./code/day01/1.sample_schemas.sql)
    2. 시퀀스 생성: [쿼리](./code/day01/2.sequences.sql)
    3. 부서데이터 생성: [쿼리](./code/day01/3.department.sql)
    4. 직원데이터 생성: [쿼리](./code/day01/4.employee.sql)
    5. 고객데이터 생성: [쿼리](./code/day01/5.customer.sql)
    6. 상품데이터 생성: [쿼리](./code/day01/6.product.sql)
    7. 주문과 주문상세 데이터 생성: [쿼리](./code/day01/7.order_order_item.sql)

- 간단 연습: [쿼리](./code/day01/8.샘플쿼리.sql)
    - DB 파일은 확장자를 .sql
        - 근데 .sql이랑 .txt랑 차이 없음
        - ;으로 끝나는 하나의 명령을 query라고 함
        - 쿼리문은 대소문자 구분 없음

- SQL(Structured Query Language)
    - 구조화된 질의 언어
    - 관계형 데이터베이스에서 DBMS 상에 데이터를 정의, 조작, 제어하기 위해 사용하는 표준 프로그래밍 언어

## Day02

### DBeaver 사용법, 작업 시 사전지식
- 메뉴 상 용어
    - 검색 -> `DB Full-Text` = Full Text Search(대용량 데스트 내에서 필요한 단어를 검색할 때)
    - SQL 편집기 -> `실행계획` -> 현재의 쿼리가 실행되는데 비용이 얼마나 발생하는지 파악하는 기술, 최적화 실행속도 빠르게 하기전에 분석
    - 데이터베이스 -> `트랜잭션` 모드 -> 쿼리들이 실행되는 논리적 덩어리, Auo-Commit(좀 위험), None Commit  
    ![alt text](img/5.png)

### SELECT 문

- 문법 이전 데이터 타입 일부
    - NUMBER: 숫자타입, 최대 22byte
    - INTEGER: 정수타입, 모든 데이터의 기초 4byte(-21억 ~ 21억)
    - FLOAT: 실수타입, 소수점 포함, 최대 22byte
    - CHAR(n): Character 문자열 타입, 고정형, 최대 2000byte
        - CHAR(20) 기준 'Hello world'를 저장하면, 'Hello world&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'로 저장됨
        - 무조건 자리수를 20자리로 고정해서 생성
    - VARCHAR2(n): 가변형 문자형, 최대 4000byte
        - 오라클에서 VARCHAR(n)는 사용안함
        - VARCHAR2를 20으로 'Hello world'를 저장하면, 'Hello world' 뒤에 9자리는 버림
    - LONG(n): 가변길이 문자열, 최대 2Gbyte
    - LONG RAW(n): 바이너리(이진) 데이터, 0과 1의 숫자로만 저장, 최대 2Gbyte
    - CLOB: 대용량 텍스트 타입, 최대 4Gbyte
    - BLOB: 대용량 바이너리 타입, 최대 4Gbyte
    - DATE: 날짜 타입, 문자열과 다름

- 데이터 조회 3가지 방법 - [쿼리](./code/day02/1.데이터조회방법.sql)
    - 셀렉션(Selection): 행 단위 조회
    - 프로젝션(Projection): 열 단위 조회
    - JOIN: 두 개 이상 테이블을 조합하여 조회

- SELECT 문법
    - 기본쿼리, 별명 - [쿼리](./code/day02/2.기본쿼리%20및%20별명지정쿼리.sql)
    - 중복제거 - [쿼리](./code/day02/3.중복제거.sql)
    - 정렬 - [쿼리](./code/day02/4.정렬쿼리.sql)
    - WHERE절 - [쿼리](./code/day02/5.조건쿼리.sql)

    ```sql
    -- 한 줄 주석
    /* 여러 
        줄 주석 */

    -- 기본 문법
    SELECT [*|열이름 나열] FROM [dual|테이블명];

    -- 별명추가
    SELECT 컬럼명 [AS 별명],
           계산식 as "별명",
           ...
      FROM 테이블명 [테이블별명];

    -- 데이터 정렬
    SELECT 위와동일
      FROM 테이블명
    ORDER BY [정렬할 열이름(여러개)][ASC|DESC];
    /*
    ASC: ascending(오름차순)
    DESC: descending(내림차순)
    ASC는 기본값이고 생략 가능
    */

    -- 조건절 WHERE절
    -- 원하는 조건으로 다양하게 조회할 때
    SELECT 위와동일
      FROM 테이블명
    [WHERE 조회할 행을 판별하는 조건식]
    [ORDER BY [정렬할 열이름(여러개)][ASC|DESC]];
    ```

- SELECT 연산 - [쿼리](./code/day02/6.연산자.sql)
    ```sql
    -- 산술연산자 + - * /
    -- 비교연산자 > < >= <= == <>
    -- 논리 부정 연산자 NOT
    -- IN = OR과 동일
    -- BETWEEN
    -- UNION
    -- UNION ALL
    ```

- 오라클 함수 - [쿼리](./code/day02/8.오라클함수.sql)
    - 문자열 함수
        - `UPPER`(모두 대문자), `LOWER`(모두 소문자), `INITCAP`(첫 글자만 대문자)
        - `LENGTH`(문자열 길이)
        - `SUBSTR`(문자열, 시작, 길이)
        - `INSTR`(문자열, 찾을 문자열, [횟수]), 문자열에서 찾을 문자열의 위치를 리턴
        - `REPLACE`(문자열, 찾을문자열, 바꿀문자열), 찾은 문자열을 바꿀문자열로 변경
        - `LPAD`(문자열, 자리수, 채울문자열), `RPAD`(문자열, 자리수, 채울문자열), L/R 기준으로 자리수만큼 빈공간을 특정문자로 채우기
            - 날짜에서 1~9까지 한 자리일 때 자리 채울때 사용(01~09)
        - `CONCAT`(앞쪽문자열, 뒤쪽문자열), 두 문자열 합치기
        - `TRIM`(공백이있는문자열), `LTRIM`(공백이있는문자열), `RTRIM`(공백이있는문자열), 문자열 앞뒤의 빈공백 제거

    - 숫자 함수
        - `ROUND`(반올림할수, 반올림위치)
        - `CEIL`(올림할숫자)
        - `FLOOR`(내림할수)
        - `TRUNC`(숫자, 버림위치)
        - `MOD`(나머지를구할수)


## DB 특징
- 모든 언어는 index가 0부터 시작
- 단, `데이터베이스는 인덱스 1부터` 시작

