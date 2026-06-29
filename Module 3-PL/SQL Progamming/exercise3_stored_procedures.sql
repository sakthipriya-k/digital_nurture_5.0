SET SERVEROUTPUT ON;

-------------------------------------------------
-- CREATE TABLE
-------------------------------------------------

CREATE TABLE employee_details
(
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(50),
    department VARCHAR2(50),
    salary NUMBER
);

-------------------------------------------------
-- INSERT SAMPLE DATA
-------------------------------------------------

INSERT INTO employee_details VALUES
(101,'Sakthi','Data Analytics',35000);

INSERT INTO employee_details VALUES
(102,'Anu','Software',42000);

INSERT INTO employee_details VALUES
(103,'Kavin','Testing',30000);

COMMIT;

-------------------------------------------------
-- CREATE STORED PROCEDURE
-------------------------------------------------

CREATE OR REPLACE PROCEDURE get_employee_details
(
    p_employee_id IN NUMBER
)

IS

v_name employee_details.employee_name%TYPE;
v_department employee_details.department%TYPE;
v_salary employee_details.salary%TYPE;

BEGIN

SELECT
employee_name,
department,
salary

INTO

v_name,
v_department,
v_salary

FROM employee_details

WHERE employee_id=p_employee_id;

DBMS_OUTPUT.PUT_LINE('--------------------------');
DBMS_OUTPUT.PUT_LINE('EMPLOYEE DETAILS');
DBMS_OUTPUT.PUT_LINE('--------------------------');

DBMS_OUTPUT.PUT_LINE(
'Employee ID : ' ||
p_employee_id
);

DBMS_OUTPUT.PUT_LINE(
'Employee Name : ' ||
v_name
);

DBMS_OUTPUT.PUT_LINE(
'Department : ' ||
v_department
);

DBMS_OUTPUT.PUT_LINE(
'Salary : Rs.' ||
v_salary
);

EXCEPTION

WHEN NO_DATA_FOUND THEN

DBMS_OUTPUT.PUT_LINE(
'Employee Not Found'
);

WHEN OTHERS THEN

DBMS_OUTPUT.PUT_LINE(
'Error : ' ||
SQLERRM
);

END;
/

-------------------------------------------------
-- EXECUTE PROCEDURE
-------------------------------------------------

BEGIN

get_employee_details(101);

END;
/