/* JOIN */
-- 관계형(Relational) DB, RDB에서 테이블을 합쳐서 표현하는 방법
SELECT *
	FROM emp;

SELECT *
	FROM dept;

-- 합치기(그냥합치기 - 카테시안 곱)
SELECT * 
	FROM emp, dept;

-- inner 조인
SELECT * 
	FROM emp, dept
	WHERE emp.DEPTNO  = dept.DEPTNO;

-- 이름 사용
SELECT emp.EMPNO, emp.ENAME, emp.JOB, emp.MGR,
	   emp.HIREDATE, emp.SAL, dept.DEPTNO, dept.DNAME 
	FROM emp, dept
	WHERE emp.DEPTNO  = dept.DEPTNO;

-- 별칭 사용
SELECT e.EMPNO, e.ENAME, e.JOB, e.MGR,
	   e.HIREDATE, e.SAL, d.DEPTNO, d.DNAME 
	FROM emp e, dept d
	WHERE e.DEPTNO  = d.DEPTNO;

-- 비등가조인
SELECT *
	FROM emp;

SELECT * 
	FROM SALGRADE;

SELECT *
	FROM emp e, SALGRADE s
	WHERE e.sal BETWEEN s.losal AND s.hisal;