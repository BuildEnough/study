# 5주차
# 2026-03-03(18일차)

## 1. 다중행 함수
## 2. GROUP, HAVING
## 3. ROLLUP, CUBE, GROUPING SETS
## 4. PIVOT


# 2026-03-04(19일차)
## 1. 도커 업데이트
- 멈춰있는 컨테이너 실행
    ```bash
    docker start [도커컨테이너ID]
    ```
- 실행 중인 컨테이너 종료
    ```bash
    docker stop [도커컨테이너ID]
    ```
- 컴퓨터 부팅시 도커 자동실행 명령어(powershell에서 실행)  
    ```bash
    docker update --restart-always [도커컨테이너ID]
    ```
## 2. 쿼리, 조인, 서브쿼리
## 3. DML


# 2026-03-05(20일차)
## 1. DML
- INSERT
- `SELECT 쿼리를 사용해서 INSERT하는 방법`
    - SELECT문 위에 INSERT문 맞춰서 쓰면 됨
        ```sql
        INSERT INTO emp_temp (empno, ename , job, mgr, hiredate, sal, comm, deptno)
        SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno 
            FROM emp e, salgrade s
        WHERE e.sal BETWEEN s.losal AND s.hisal AND s.grade = 1;
        ```
## 2. TCL
## 3. DDL


## 기타 
- uae 아말 프로젝트


# 2026-03-06(21일차)
## 1. sql 퀴즈 풀이
## 2. DDL
## 3. 인덱스, 뷰, 시퀀스
## 4. 제약조건
## 5. PK, FK