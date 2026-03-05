-- JOIN
SELECT d.DEPTNO, d.DNAME, d.LOC
	 , e.EMPNO, e.ENAME, e.JOB, e.HIREDATE, e.SAL
	FROM dept d JOIN emp e
		ON d.deptno = e. deptno;

-- INNER JOIN
SELECT d.DEPTNO, d.DNAME, d.LOC
	 , e.EMPNO, e.ENAME, e.JOB, e.HIREDATE, e.SAL
	FROM dept d INNER JOIN emp e
		ON d.deptno = e. deptno
	WHERE d.DEPTNO = 30;

-- OUTER JOIN
SELECT d.DEPTNO, d.DNAME, d.LOC
	 , e.EMPNO, e.ENAME, e.JOB, e.HIREDATE, e.SAL
	FROM dept d LEFT OUTER JOIN emp e
		ON d.deptno = e.deptno;

SELECT d.DEPTNO, d.DNAME, d.LOC
	 , e.EMPNO, e.ENAME, e.JOB, e.HIREDATE, e.SAL
	FROM dept d RIGHT OUTER JOIN emp e
		ON d.deptno = e.deptno;

-- 세 테이블 조인
SELECT d.DEPTNO, d.DNAME
	 , e.EMPNO, e.ENAME, e.JOB, e.SAL
	 , s.GRADE
	FROM emp e
		INNER JOIN dept d
				ON e.DEPTNO = d.DEPTNO
			  JOIN salgrade s
			  	ON e.SAL BETWEEN s.LOSAL AND s.HISAL
ORDER BY d.DEPTNO, e.EMPNO;

-- 오라클 쿼리로 변경
SELECT d.DEPTNO, d.DNAME
	 , e.EMPNO, e.ENAME, e.JOB, e.SAL
	 , s.GRADE
	FROM emp e, dept d, salgrade s
	WHERE e.DEPTNO = d.DEPTNO AND e.SAL
BETWEEN s.LOSAL AND s.HISAL
ORDER BY d.DEPTNO, e.EMPNO;

