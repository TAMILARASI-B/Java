-- view
CREATE VIEW IT_Employees AS
SELECT EID, EName, ESalary
FROM Employee
WHERE EAge=20;
SELECT * FROM IT_Employees;
SELECT * FROM Employee;
CREATE DATABASE HW;
use HW;
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
(5, 'Eva', 45, 90000, 'HR Manager', 'HR'),
(6, 'Frank', 29, 48000, 'Support', 'IT'),
(7, 'Grace', 32, 80000, 'Lead Developer', 'IT'),
(8, 'Hannah', 27, 46000, 'Tester', 'QA');
 
--  View 1: Basic View (Select name and designation)
CREATE VIEW view_employee AS SELECT name, designation FROM Employee;
 
--  View 2: Filtered View (Only IT department employees)
CREATE VIEW view_it_employees AS SELECT * FROM Employee WHERE department = 'IT';
 
-- View 3: Computed Column View (With yearly salary)
CREATE VIEW view_yearly_salary AS SELECT id, name, salary, salary * 12 AS yearly_salary FROM Employee;
 
--  View 4: Aggregated View (Average salary by department)
CREATE VIEW view_avg_salary_by_dept AS SELECT department, AVG(salary) AS avg_salary FROM Employee GROUP BY department;
 
--  Conditional View (Employees earning more than 60,000)
CREATE VIEW view_high_earners AS SELECT id, name, salary, designation FROM Employee WHERE salary > 60000;
 
-- Example: Querying a View
 
SELECT * FROM view_it_employees;