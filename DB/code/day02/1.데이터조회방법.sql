-- 현재 날짜 조회
-- dual은 테이블이 아님
SELECT sysdate FROM dual;

-- 고객정보 조회
-- select all -> select *
-- * 전부 다
-- 셀렉션
SELECT * FROM EMPLOYEE;

-- 셀렉션
SELECT * FROM DEPARTMENT;

-- 프로젝션
SELECT EMP_NAME, SALARY FROM EMPLOYEE;

-- 두 테이블 조인
SELECT * FROM EMPLOYEE e
INNER JOIN DEPARTMENT d
ON e.DEPT_ID = d.DEPT_ID;