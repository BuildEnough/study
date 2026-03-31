-- scott 계정
-- 부서번호와 직군별 그룹화
SELECT DEPTNO
	 , count(*)
	 , max(sal)
	 , avg(sal)
	FROM emp
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- ROLLUP, CUBE를 몰라도 SUBQUERY로 구현 가능

-- ROLLUP 함수를 적용한 그룹화
SELECT DEPTNO
	 , count(*)
	 , max(sal)
	 , avg(sal)
	FROM emp
GROUP BY ROLLUP(DEPTNO)
ORDER BY DEPTNO;

-- ROLLUP: 첫 번째 컬럼의 값으로 소계, 전체 총계 도출
SELECT DEPTNO, JOB
	 , count(*)
	 , max(sal)
	 , avg(sal)
 	 , GROUPING(JOB)
	 , GROUPING(DEPTNO)
	 , GROUPING_ID(DEPTNO, JOB)
	FROM emp
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY DEPTNO;

-- CUBE: 각각의 컬럼별로 소계, 전체 총계 도출
SELECT DEPTNO, JOB
	 , count(*)
	 , max(sal)
	 , avg(sal)
	FROM emp
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY DEPTNO;

-- GROUPING 함수: SELECT 절에 GROUPING 적용
SELECT DEPTNO, JOB
	 , count(*)
	 , max(sal)
	 , avg(sal)
	 , GROUPING(JOB)
	 , GROUPING(DEPTNO)
	 , GROUPING_ID(DEPTNO, JOB)
	FROM emp
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY DEPTNO;

-- PIVOT
-- PIVOT 몰라도 CASE WHEN으로 구현 가능
-- 부서별, 직책별로 그룹화 최고 급여 조회
SELECT DEPTNO, JOB , MAX(SAL)
	FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;

-- PIVOT 함수 사용
SELECT * 
	FROM (SELECT DEPTNO, JOB, SAL
		  	FROM EMP)
PIVOT (MAX(SAL) FOR DEPTNO IN (10, 20, 30))
ORDER BY JOB;


