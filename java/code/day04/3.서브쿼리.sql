/* 1.서브쿼리 */

-- 사원이름 JONES인 사원 급여 조회
SELECT *
	FROM emp e
WHERE e.ename = 'JONES';

-- 급여가 2975보다 높은 사원 조회
SELECT *
	FROM emp e
WHERE e.sal > 2975;

-- 서브쿼리
SELECT *
	FROM emp e
WHERE e.sal > (SELECT sal FROM emp WHERE ename = 'JONES');

/* 2.단일행 서브쿼리 */
-- SCOTT 직원의 입사날짜보다 이전에 입사한 직원조회
SELECT e.HIREDATE
	FROM emp e
WHERE e.ename = 'SCOTT';

SELECT *
	FROM emp o
WHERE o.HIREDATE < (SELECT e.HIREDATE FROM emp e WHERE e.ename = 'SCOTT');

-- 모든 직원의 평균 급여보다 높은 급여를 받는 직원 조회
SELECT *
	FROM emp o
WHERE o.sal >= (SELECT avg(e.sal) FROM EMP e)
AND o.deptno = 20;

-- 서브쿼리와 조인을 같이 사용가능
SELECT o.*, d.DNAME 
	FROM emp o, dept d
WHERE o.DEPTNO = d.DEPTNO 
AND o.sal >= (SELECT avg(e.sal) FROM EMP e)
AND o.deptno = 20;

/* 3.다중행 서브쿼리 */
-- deptno가 20, 30인 직원 조회
SELECT *
	FROM emp e
WHERE e.DEPTNO in(10,30);

-- RESEARCH, SALES인 부서에 다니는 직원들만 조회
SELECT *
	FROM emp e
WHERE e.DEPTNO IN (SELECT d.deptno FROM dept d WHERE d.dname IN ('RESEARCH', 'SALES'));

-- 각 부서별 최고 급여와 동일한 급여를 받는 사원 조회
SELECT *
	FROM emp o
WHERE o.sal IN (SELECT max(e.sal)
					FROM emp e 
				GROUP BY e.deptno);

-- IN 구문을 쓰면 다중행 데이터 조회 가능
-- IN도 OR 구문과 동일
SELECT *
	FROM emp
 WHERE DEPTNO IN (10, 20, 30);

-- ANY, SOME 서브쿼리 반환 결과들 중 메인쿼리의 조건이 하나라도 참이면 -> OR 조건
SELECT *
	FROM emp o
WHERE o.sal = ANY (SELECT max(e.sal)
					FROM emp e 
				GROUP BY e.deptno);

-- 30번 부서 사원들의 최대 급여보다 적은 급여를 받는 사원정보 조회
SELECT *
	FROM emp o
WHERE sal < ANY (SELECT sal
					FROM emp
				WHERE DEPTNO = 30);

-- ALL -> AND 조건
-- 30번 부서 사원들의 모든 급여보다 적은 급여를 받는 사원정보 조회
SELECT *
	FROM emp o
WHERE sal < ALL (SELECT sal
					FROM emp
				WHERE DEPTNO = 30);

-- 서브쿼리 결과 값이 존재하면
-- 내가 찾는 부서가 있다면 모든 직원 조회
SELECT *
	FROM emp o
WHERE EXISTS (SELECT loc
				FROM dept
			WHERE deptno = 10);

/* 4.다중열 서브쿼리 */
SELECT * 
	FROM emp o
WHERE (o.sal, o.DEPTNO) IN (SELECT max(e.sal), e.deptno
				  FROM emp e
			 GROUP BY e.deptno);

-- FROM절
-- 가상테이블
SELECT e.EMPNO 
	 , e.DEPTNO
	 , to_char(e.HIREDATE, 'yyyy-mm-dd') AS "입사일"
	FROM emp e;

/* 5.FROM절 서브쿼리 */
-- 가상의 테이블을 만들어서 실제 테이블인 것처럼 사용가능
SELECT *
	FROM dept d, (SELECT EMPNO
						,DEPTNO
						, to_char(HIREDATE, 'yyyy-mm-dd') AS "입사일"
					FROM emp) e
WHERE d.deptno = e.deptno;

-- 복잡한 서브쿼리도 가능
SELECT count(*), sub1.DEPTNO 
  FROM (
         SELECT d.deptno, d.dname, d.loc, e.empno, e.입사일
           FROM dept d, (SELECT empno
                              , deptno 
                              , to_char(hiredate, 'yyyy-mm-dd') AS "입사일"
                           FROM emp) e
          WHERE d.deptno = e.deptno
        ) sub1
 GROUP BY sub1.DEPTNO;

-- 둘 다 서브쿼리로 사용
SELECT e10.empno, e10.ename, e10.deptno, d.dname, d.loc
	FROM (SELECT * FROM emp WHERE deptno = 10) e10,
		 (SELECT * FROM dept) d
WHERE e10.deptno = d.deptno;

-- WITH절로 가상 테이블을 위로 올려서 정의
-- 가독성, 성능개선
WITH
e10 AS (SELECT * FROM emp WHERE deptno = 10),
d AS (SELECT * FROM dept)
SELECT e10.empno, e10.ename, e10.deptno, d.dname, d.loc
	FROM e10, d
WHERE e10.deptno = d.deptno;

/* 상호연관 서브쿼리 */
-- 메인쿼리의 데이터를 서브쿼리에 사용, 그 결과를 다시 메인 쿼리에 반영
SELECT *
	FROM emp e1
WHERE e1.sal > (SELECT MIN(SAL) FROM emp WHERE deptno = e1.deptno)
ORDER BY e1.deptno, e1.sal;

/* 6.SELECT절 서브쿼리 */
SELECT e.empno
	 , e.ename
	 , e.job
	 , e.sal
	 , (SELECT grade FROM salgrade WHERE e.sal BETWEEN losal AND hisal) AS "SALGRADES"
	 , e.deptno
	 , (SELECT dname FROM dept WHERE deptno = e.deptno) AS "DEPARTMENTS"
	FROM emp e
ORDER BY e.empno;

-- JOIN으로 변경 가능, 서브쿼리보다 JOIN으로 변경한게 성능 좋음
SELECT e.empno
	 , e.ename
	 , e.job
	 , e.sal
	 , s.grade AS "SALGRADES"
	 , e.deptno
	 , d.dname AS "DEPARTMENTS"
	FROM emp e, dept d, salgrade s
WHERE e.deptno = d.DEPTNO
	AND e.sal BETWEEN s.losal AND s.hisal
ORDER BY e.empno;
