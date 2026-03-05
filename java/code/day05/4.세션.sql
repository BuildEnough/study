SELECT * FROM DEPT_TCL;

UPDATE DEPT_TCL
    SET loc = 'SEOUL'
WHERE deptno = 60;

INSERT INTO dept_tcl (deptno, dname, loc)
VALUES (90, 'TEST', 'TEST');

ROLLBACK;