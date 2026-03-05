--조인
SELECT d.DEPTNO, d.DNAME, d.LOC 
	 , e.EMPNO, e.ENAME, e.JOB 
	 , TO_CHAR(e.HIREDATE, 'yyyy-mm-dd') AS hiredate
	 , e.sal
	FROM DEPT d, emp e
WHERE d.DEPTNO = e.DEPTNO
ORDER BY e.EMPNO ASC;

-- 셀프조인
-- e1 상사를 찾는 테이블
-- e2 상사 테이블
SELECT e1.empno, e1.ename, e1.MGR 
	 , e1.HIREDATE
	 , e2.EMPNO AS mgr_empno
	 , e2.ename AS mgr_ename
	FROM EMP e1, EMP e2
WHERE e1.mgr = e2.EMPNO;

-- 외부 조인: 등가 조인에 일치하지 않는 데이터도 조회해줌
-- MGR 상사가 있는지 확인
SELECT e1.empno, e1.ename, e1.MGR 
	 , e1.HIREDATE
	 , e2.EMPNO AS mgr_empno
	 , e2.ename AS mgr_ename
	FROM EMP e1, EMP e2
WHERE e1.mgr = e2.EMPNO (+);

-- 잘못된 조인, e2의 empno를 상사컬럼으로, e1의 mgr 부하컬럼으로 했기때문에 잘못됨
SELECT e1.empno AS mgr_empno, e1.ename AS mgr_ename, e1.MGR 
	 , e1.HIREDATE
	 , e2.EMPNO AS empno
	 , e2.ename AS ename
	FROM EMP e1, EMP e2
WHERE e1.mgr(+) = e2.EMPNO;

/* 외부조인 */
-- 1. 일반 inner 조인
SELECT d.DEPTNO, d.DNAME, d.LOC
	 , e.EMPNO, e.ENAME, e.JOB, e.HIREDATE, e.SAL
	FROM dept d, emp e
WHERE d.DEPTNO = e.DEPTNO;

-- 왼쪽 외부 조인
SELECT d.DEPTNO, d.DNAME, d.LOC
	 , e.*
	FROM dept d, emp e
WHERE d.DEPTNO = e.DEPTNO(+);

-- 오른쪽 외부 조인
SELECT d.DEPTNO, d.DNAME, d.LOC
	 , e.*
	FROM emp e, dept d
WHERE e.DEPTNO(+) = d.DEPTNO;

-- 오른쪽 외부 조인
SELECT d.DEPTNO, d.DNAME, d.LOC
	 , e.*
	FROM dept d, emp e
WHERE d.DEPTNO(+) = e.DEPTNO;

-- 왼쪽 외부 조인
SELECT d.DEPTNO, d.DNAME, d.LOC
	 , e.*
	FROM dept d, emp e
WHERE d.DEPTNO = e.DEPTNO(+)
	AND e.EMPNO IS null;

