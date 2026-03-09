-- 저장프로시저 생성2
CREATE OR REPLACE PROCEDURE PRC_NOPARAM
IS

    -- DECLARE 영역
    v_empno number(4) := 7839;
    v_ename varchar2(10);
BEGIN
    SELECT ename INTO v_ename
        FROM emp
        WHERE empno = v_empno;

    DBMS_OUTPUT.PUT_LINE('V_EMPNO => ' || v_empno);
    DBMS_OUTPUT.PUT_LINE('V_ENAME => ' || v_ename);
END PRC_NOPARAM;

-- 저장프로시저 생성3
CREATE OR REPLACE PROCEDURE PRC_INOUTPARAM
(
    p_empno IN NUMBER,
    p_ename OUT varchar2
)
IS
BEGIN
    SELECT ename INTO p_ename
        FROM emp 
        WHERE empno = p_empno;

    DBMS_OUTPUT.PUT_LINE('EMPNO => ' || p_empno);
    DBMS_OUTPUT.PUT_LINE('ENAME => ' || p_ename);
END PRC_INOUTPARAM;