-- 품목의 전체 열 조회
SELECT * FROM PRODUCT;

-- 품목 전체 열 조회
SELECT PROD_ID , PROD_NAME , PRICE  FROM PRODUCT;

-- 품목 열이름 변경
-- alias 1
SELECT PROD_ID AS "품목아이디"
	 , PROD_NAME AS "품목명"
	 , PRICE AS "가격"
	FROM PRODUCT;

-- alias 2: AS 생략
SELECT PROD_ID "품목아이디"
	 , PROD_NAME "품목명"
	 , PRICE "가격"
	FROM PRODUCT;

-- alias 3: 테이블명을 동일하게 쓰면 테이블명. 으로 컬럼 지정해도되고 안해도 되고
SELECT PRODUCT.PROD_ID "품목아이디"
	 , PRODUCT.PROD_NAME "품목명"
	 , PRICE "가격"
	FROM PRODUCT;

-- alias 4: 테이블명에 별명을 지정하면, 컬럼명 사용시 별명. 으로 사용
SELECT prd.PROD_ID "품목아이디"
	 , prd.PROD_NAME "품목명"
	 , prd.PRICE "가격"
	FROM PRODUCT prd;

-- 별명 5
SELECT EMP_ID
	 , EMP_NAME
	 , SALARY 
	 , SALARY * 12 AS "ANNUAL_SALARY"
	 , HIRE_DATE
	 , DEPT_ID
FROM EMPLOYEE;