-- DML

-- DEPT 테이블 복사 DEPT_TEMP 만들기
CREATE TABLE DEPT_TEMP
	AS SELECT * FROM DEPT;

-- 조회
SELECT * FROM DEPT_TEMP;

-- MARKETING 추가
INSERT INTO dept_temp(deptno, dname, loc)
VALUES (50, 'MARKETING', 'SEOUL');

-- 에러(컬럼 개수와 데이터 개수 불일치)
INSERT INTO dept_temp(deptno, dname, loc)
VALUES (60, 'STOCK',);

-- 에러(컬럼의 데이터 타입과 데이터형 불일치)
INSERT INTO dept_temp(deptno, dname, loc)
VALUES ('SEVEN', 'MARKETING', 'SEOUL');

CREATE TABLE emp_temp 
	AS SELECT * FROM emp;

SELECT * FROM emp_temp;

DELETE FROM emp_temp;