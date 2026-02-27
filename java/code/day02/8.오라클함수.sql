-- 문자열 함수
SELECT CUST_NAME
     , lower(CUST_NAME) AS "고객명"
     , initCap(lower(CUST_NAME)) AS "고객명"
     , CITY 
     , upper(CITY) AS "도시명"
  FROM CUSTOMER;

-- where 절에도 사용가능
SELECT *
  FROM CUSTOMER
WHERE lower(CITY) = 'seoul';

-- 문자열 길이
SELECT city, length(city)
  FROM CUSTOMER;

-- 문자열 추출
SELECT EMP_NAME ,SUBSTR(EMP_NAME, 4, 2)
  FROM EMPLOYEE;

-- 문자열에서 찾기
SELECT INSTR('HELLO, ORACLE!', 'L') AS "첫 번째 L위치"
     , INSTR('HELLO, ORACLE!', 'L', 5) AS "다섯 번째 이후 L위치"
     , INSTR('HELLO, ORACLE!', 'L', 2, 2) AS "2번째 위치 이후 두 번째 나타나는 L위치"
  FROM dual;

-- 문자열 교체
SELECT replace('Oh, Hello Oracle', 'Hello', 'Hell') FROM dual;

-- 빈공간을 특정 문자로 채우기
SELECT lpad('Matrix', 20, '#')
     , rpad('Matrix', 20, '#')
  FROM dual;

SELECT lpad(1, 2, '0') FROM dual;

-- 두 문자열 합치기
SELECT concat('Hello', ' World')
  FROM dual;

-- 공백 제거
SELECT trim('   Marvel Universe     ')
     , Ltrim('   Marvel Universe     ')
     , Rtrim('   Marvel Universe     ')
  FROM dual;

SELECT 1 AS "같아요"
  FROM dual
WHERE 'Hello World' = trim('     Hello World     ');

-- 숫자 함수
SELECT round(1234.3456)
     , round(1234.3456, 3) -- 소수점 세번 째 자리까지 반올림
     , ceil(3.14)
     , floor(3.14)
     , trunc(1234.3456, 3)
     , mod(10, 3)
  FROM dual;