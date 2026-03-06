/* 제약조건 */

-- 1. NOT NULL
CREATE TABLE tbl_nn (
	login_id	varchar2(20)	NOT NULL,
	login_pwd	varchar2(20)	NOT NULL,
	tel			varchar2(20)
);

SELECT * FROM tbl_nn; 

INSERT INTO tbl_nn (login_id, login_pwd, tel)
VALUES ('hugo95', '12345', NULL);

-- 안됨
INSERT INTO tbl_nn (login_id, login_pwd, tel)
VALUES ('asdf95', NULL, '010-1234-5678');

INSERT INTO tbl_nn (login_id, login_pwd)
VALUES ('hugo96', '12345');

-- 안됨
INSERT INTO tbl_nn (login_id, tel)
VALUES ('hugo96', '010-0000-0000');

-- 안됨
UPDATE tbl_nn SET
	login_pwd = NULL
WHERE login_id = 'hugo95';

ALTER TABLE tbl_nn
RENAME CONSTRAINT SYS_C008533 TO NN_tblnn_loginid;


-- 2. UNIQUE 중복 허용 안함
CREATE TABLE TBL_UNQ (
	login_id	varchar2(20)	UNIQUE,
	login_pwd	varchar2(20)	NOT NULL,
	tel			varchar2(20)
);

INSERT INTO tbl_unq (login_id, login_pwd, tel)
VALUES ('hugo95', '12345', NULL);

INSERT INTO tbl_unq (login_id, login_pwd, tel)
VALUES (NULL, '12345', '010-9999-0000');

SELECT * FROM tbl_unq;

-- 3. PRIMARY KEY, UNIQUE에 NOT NULL
CREATE TABLE TBL_PK (
	login_id	varchar2(20)	PRIMARY KEY,
	login_pwd	varchar2(20)	NOT NULL,
	tel			varchar2(20)
);

INSERT INTO tbl_pk (login_id, login_pwd, tel)
VALUES ('hugo95', '12345', NULL);

INSERT INTO tbl_pk (login_id, login_pwd, tel)
VALUES (NULL, '12345', '010-9999-0000');

SELECT * FROM tbl_pk;

-- PK 생성2
-- 하나 이상의 컬럼에 PK를 지정할때
CREATE TABLE TBL_INFO (
	idx		NUMBER,
	code	NUMBER,
	cnt		varchar2(20),
	regdate DATE DEFAULT sysdate, 
	CONSTRAINT pk_tbl_info PRIMARY KEY (idx, code)
);

INSERT INTO tbl_info (idx, code, cnt)
VALUES (1, 10, 'test1');

INSERT INTO tbl_info (idx, code, cnt)
VALUES (1, 20, 'test2');

INSERT INTO tbl_info (idx, code, cnt)
VALUES (2, 10, 'test3');

SELECT * FROM tbl_info
WHERE idx = 1
AND code = 10;


-- 4. Foreign Key: 타 테이블의 PK와 연관짓는 제약조건
SELECT * FROM dept;
SELECT * FROM emp;

-- FK를 참조하는 열에 존재하지 않는 데이터 입력
INSERT INTO emp (empno, ename, deptno)
VALUES (9999, '홍길순', 50);

INSERT INTO emp (empno, ename, deptno)
VALUES (9998, '홍길동', 50);

INSERT INTO emp (empno, ename, deptno)
VALUES (9997, '가나다', 80);

-- FK 생성
CREATE TABLE dept_fk (
	deptno NUMBER CONSTRAINT dpet_fk_deptno_PK PRIMARY KEY,
	dname  varchar2(20),
	loc	   varchar2(13)
);

CREATE TABLE emp_fk (
	empno NUMBER PRIMARY KEY, -- PK이름 자동생성
	ename varchar2(20) NOT NULL,
	job   varchar2(10),
	mgr   NUMBER CONSTRAINT empfk_deptno_fk REFERENCES dept_fk(deptno) NOT NULL
);

-- INSERT ALL: 오라클 용
INSERT ALL
	INTO dept_fk (deptno, dname, loc) VALUES (10, 'DEV', 'SEOUL')
	INTO dept_fk (deptno, dname, loc) VALUES (20, 'ACCOUNTING', 'INCHEON')
	INTO dept_fk (deptno, dname, loc) VALUES (30, 'FINANCE', 'BUSAN')
SELECT * FROM dual;
	
SELECT * FROM dept_fk;

INSERT INTO emp_fk ()
values();