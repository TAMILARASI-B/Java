/* What is a Cursor?
 
A cursor allows row-by-row processing of query results. Basic steps:
 
	Declare the cursor
	Open the cursor
	Fetch from the cursor
	Loop through rows
	Close the cursor
 */
 
CREATE TABLE Employee (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    salary DECIMAL(10, 2),
    designation VARCHAR(50),
    department VARCHAR(50)
);
 
INSERT INTO Employee (id, name, age, salary, designation, department) VALUES
(1, 'Alice', 28, 50000, 'Developer', 'IT'),
(2, 'Bob', 35, 75000, 'Manager', 'Sales'),
(3, 'Charlie', 25, 45000, 'Tester', 'QA'),
(4, 'David', 30, 55000, 'Developer', 'IT'),
(5, 'Eva', 45, 90000, 'HR Manager', 'HR');
 
DELIMITER //
CREATE PROCEDURE print_employee_names()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE emp_name VARCHAR(50);
    -- Declare cursor
    DECLARE emp_cursor CURSOR FOR
        SELECT name FROM Employee;
    -- Declare continue handler for end of data
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    -- Open cursor
    OPEN emp_cursor;
    read_loop: LOOP
        FETCH emp_cursor INTO emp_name;
        IF done THEN
            LEAVE read_loop;
        END IF;
        -- Print or process each name
        SELECT emp_name AS employee_name;
    END LOOP;
    -- Close cursor
    CLOSE emp_cursor;
END //
DELIMITER ;
 
call print_employee_names();
 
 
DELIMITER //
CREATE PROCEDURE increase_it_salaries()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE emp_id INT;
    DECLARE current_salary DECIMAL(10,2);
    -- Declare cursor
    DECLARE salary_cursor CURSOR FOR
        SELECT id, salary FROM Employee WHERE department = 'IT';
    -- Declare handler
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    -- Open cursor
    OPEN salary_cursor;
    update_loop: LOOP
        FETCH salary_cursor INTO emp_id, current_salary;
        IF done THEN
            LEAVE update_loop;
        END IF;
        -- Update salary with 10% hike
        UPDATE Employee
        SET salary = current_salary * 1.10
        WHERE id = emp_id;
    END LOOP;
    -- Close cursor
    CLOSE salary_cursor;
END //
DELIMITER ;
 
call increase_it_salaries();