CREATE TABLE Employee (
  EmpID INT PRIMARY KEY,
  EmpName VARCHAR(50),
  Salary INT
);
INSERT INTO Employee VALUES
(1, 'Arun', 25000),
(2, 'Meena', 30000),
(3, 'Raj', 40000),
(4, 'Divya', 20000);

DELIMITER //
CREATE PROCEDURE OrderSalary()
BEGIN
  SELECT * FROM Employee ORDER BY Salary;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GreaterSalary()
BEGIN
  SELECT * FROM Employee WHERE Salary > 20000;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GreaterSalarydynamic(IN salLimit INT)
BEGIN
  SELECT * FROM Employee WHERE Salary > salLimit;
END//
DELIMITER ;


CALL OrderSalary();
CALL GreaterSalary();
CALL GreaterSalarydynamic(25000);

-- DROP PROCEDURE IF EXISTS GreaterSalary;