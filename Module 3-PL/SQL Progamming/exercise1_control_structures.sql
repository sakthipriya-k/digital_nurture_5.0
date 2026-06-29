SET SERVEROUTPUT ON;

DECLARE
    employee_name VARCHAR2(50) := 'Sakthi';
    employee_id NUMBER := 101;
    monthly_salary NUMBER := 45000;
    bonus NUMBER := 0;
    performance_rating CHAR(1) := 'A';

BEGIN

    DBMS_OUTPUT.PUT_LINE('--------------------------------');
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE PERFORMANCE EVALUATION');
    DBMS_OUTPUT.PUT_LINE('--------------------------------');

    DBMS_OUTPUT.PUT_LINE('Employee ID : ' || employee_id);
    DBMS_OUTPUT.PUT_LINE('Employee Name : ' || employee_name);
    DBMS_OUTPUT.PUT_LINE('Monthly Salary : ' || monthly_salary);

    IF performance_rating = 'A' THEN
        bonus := monthly_salary * 0.20;

    ELSIF performance_rating = 'B' THEN
        bonus := monthly_salary * 0.15;

    ELSIF performance_rating = 'C' THEN
        bonus := monthly_salary * 0.10;

    ELSE
        bonus := monthly_salary * 0.05;

    END IF;

    DBMS_OUTPUT.PUT_LINE('Performance Rating : ' || performance_rating);
    DBMS_OUTPUT.PUT_LINE('Bonus Allocated : ' || bonus);

    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('Generating Next 5 Months Salary Projection');

    FOR i IN 1..5 LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Month ' || i ||
            ' Expected Salary : ' ||
            (monthly_salary + bonus)
        );

    END LOOP;

    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('Process Completed Successfully');

END;
/
