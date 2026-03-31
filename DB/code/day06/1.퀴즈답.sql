SELECT * FROM dept;

SELECT * FROM emp;

SELECT * FROM project;

SELECT * FROM emp_project;

SELECT * FROM pay_history;

-- 1번 사원의 이름과 부서 이름을 같이 조회하세요
SELECT emp.emp_name, dept.dept_name
	FROM emp
JOIN dept
  ON emp.dept_id = dept.dept_id;

-- 2번 DEV 부서에 속한 사원의 이름과 급여를 조회하시오
SELECT emp_name, salary
		FROM emp
WHERE dept_id = 10;

SELECT emp.emp_name, emp.salary
	FROM emp
JOIN dept
	ON emp.dept_id = dept.dept_id
WHERE dept.dept_name = 'DEV';

-- 3번 부서별 사원 수를 조회하시오
SELECT dept_id,
       COUNT(*) AS emp_count
	FROM emp
GROUP BY dept_id
ORDER BY dept_id;

-- 4번 전체 평균 급여보다 높은 급여를 받는 사원을 조회하시오
SELECT emp_name, salary
	FROM emp
WHERE salary > (SELECT AVG(salary) FROM emp);

-- 5번 프로젝트에 참여하는 사원의 이름과 프로젝트 이름을 조회하시오
SELECT emp.emp_name, project.proj_name
	FROM emp_project
JOIN emp
  ON emp_project.emp_id = emp.emp_id
JOIN project
  ON emp_project.proj_id = project.proj_id;