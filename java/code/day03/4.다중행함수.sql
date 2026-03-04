-- sum 함산 함수
SELECT sum(SALARY)
	FROM EMPLOYEE;

-- 각 레코드(row, 행)로 개수를 구할 수 있음
SELECT count(*)
	FROM EMPLOYEE;

-- 특정 컬럼의 개수로 구할 수 있음
SELECT count(DISTINCT DEPT_ID)
	FROM EMPLOYEE;

-- salary 합산
SELECT AVG(SALARY)
	FROM EMPLOYEE;

-- min, max는 날짜도 가능
SELECT MIN(SALARY), MAX(SALARY)
	FROM EMPLOYEE