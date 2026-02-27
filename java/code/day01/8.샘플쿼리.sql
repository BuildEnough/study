-- 부서 테이블의 개수 확인
SELECT count(*) FROM DEPARTMENT;

SELECT count(*) FROM EMPLOYEE;

SELECT count(*) FROM PRODUCT;

SELECT count(*) FROM ORDERS;

SELECT count(*) FROM ORDER_ITEM;


-- 주문 테이블에서 앞쪽 데이터 5개만 조회
SELECT * FROM orders WHERE rownum <= 5;