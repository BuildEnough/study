-- 중복 제거
SELECT distinct e.DEPT_ID 
FROM EMPLOYEE e;

-- 중복열 제거없이 전체 출력
SELECT ALL e.DEPT_ID 
FROM EMPLOYEE e;