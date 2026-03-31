-- UPDATE

-- dept_temp2 생성
CREATE TABLE dept_temp2
	AS SELECT * FROM dept;

-- 확인 조회
SELECT * FROM dept_temp2;

-- 전체 데이터 수정(조심)
UPDATE DEPT_TEMP2
	SET loc = 'SEOUL';

--DELETE FROM dept_temp2;

INSERT INTO dept_temp2(deptno, dname, loc)
SELECT deptno, dname, loc
	FROM DEPT_TEMP;

-- 일반적인 UPDATE
UPDATE DEPT_TEMP2
	SET loc = 'BUSAN'
WHERE deptno = 40;

-- 서브쿼리로 업데이트
UPDATE DEPT_TEMP2
	SET loc = 'LOC ANGELUS'
WHERE deptno = (SELECT deptno
				FROM dept_temp2
			  WHERE dname = 'OPERATIONS');

SELECT * FROM dept_temp2;


-- DELETE
SELECT * FROM EMP_TEMP;

-- JOB이 CLERK인 데이터 삭제
DELETE FROM EMP_TEMP
	WHERE job = 'CLERK';