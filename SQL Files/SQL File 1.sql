create database BusinessAnalyst ;
use BusinessAnalyst ;
Create Table Employee(
	EID  smallint,
    EName varchar (15), 
    EAge smallint,
    ESalary mediumint,
    EDesignation varchar(15)
    );
Insert into Employee values (100 , 'Thanesh' , 30 , 50000, 'Developer' );
Insert into Employee values (200 , 'Naresh' , 20 , 60000, 'BA' );
Insert into Employee values (300 , 'Hardik' , 25 , 750000, 'Manager' );
select * from Employee;
Select Eid from employee;
select Eid, Ename from employee;
select Eid, Ename , eage , esalary from employee;
select Eid, Ename , eage , esalary , edesignation from employee;
select * from employee;
use businessanalyst;
create table Employee
(
	eid int,
	Ename varchar(10), 
	Eage smallint,
	esalary mediumint,
   	EDesignation varchar(10)
);
Insert into Employee values (100 , 'Thanesh' , 30 , 50000, 'Developer' );
Insert into Employee values (200 , 'Naresh' , 20 , 60000, 'BA' );
Insert into Employee values (300 , 'Hardik' , 25 , 750000, 'Manager' );
insert into employee values (400 , 'Angel',25,50000,'BA');
insert into employee values (500 , 'Fathima',26,60000,'Software');
insert into employee values (600 , 'Ishani',35,80000,'BA');
insert into employee values (700 , 'Mangesh',22,90000,'Manager');
insert into employee values (800 , 'Konia',30,90000,'CEO');
select * from employee ;
select * from employee where EDesignation = 'BA';
Select * from Employee where edesignation = 'BA' and eage > 30 ;
update employee set esalary = 60000 where EID=100; 
update employee set esalary = 95000 where eid = 700;
select * from employee ;
update employee set eage = 23 , esalary = 98500 where eid= 700 ;
Select * from employee ;
select * from employee where edesignation ='BA';
delete from employee where eid = 200 ;
delete from employee where edesignation = 'BA';
delete from employee where edesignation ='Manager' and esalary > 80000;
select * from employee ;
truncate table employee ;
select * from employee ;
drop table employee ;
Alter table Employee Add Phone int ;
select * from employee ;
Alter Table employee add (PAN varchar(10), PIN int);
Alter table Employee Drop  PIN ;
select * from employee ;
Alter table Employee drop Phone;
select * from employee ;
Alter table employee Rename column  EID  to  id ;
Alter table employee rename column Eage to age ;
select * from employee ;
Select * from employee ;
rename  table employee to emp ;
select * from emp ;
SELECT * FROM businessanalyst.emp;
use businessanalyst;
create table Employee
(
	id int primary key,
   	Ename varchar(10) ,
	eage int , 
	esalary int , 
	edesig varchar(10),
	PAN varchar(10)
);
insert into employee value(100, 'Thanesh',30 ,50000 ,'Developer' ,'Tha123');
select * from employee;
insert into employee value(200, 'Ramesh',35 ,60000 ,'BA' ,'Ram123');
insert into employee value('400', 'Rakesh',35 ,60000 ,'BA' ,'Ram123');
insert into employee value('500', '',35 ,60000 ,'BA' ,'XYZ345');
insert into employee(id,eage ,esalary ,edesig ,pan) value('600',35 ,60000 ,'BA' ,'XYZ307745');
drop table Employee ;
create table Employee
(
	id int primary key,
    Ename varchar(10) not null  ,
    eage int , 
    esalary int , 
    edesig varchar(10),
    PAN varchar(10)
);
insert into employee value(100, 'Thanesh',30 ,50000 ,'Developer' ,'Tha123');
select * from employee;
insert into employee value(200, 'Ramesh',35 ,60000 ,'BA' ,'Ram123');
insert into employee value('400', 'Rakesh',35 ,60000 ,'BA' ,'Ram123');
insert into employee(id,eage ,esalary ,edesig ,pan) value('600',35 ,60000 ,'BA' ,'XYZ307745'); -- we cant skip the name ;
drop table employee ;
create table Employee
(
	id int primary key,
    Ename varchar(10) not null  ,
    eage int check (eage < 60), 
    esalary int  check (esalary > 25000), 
    edesig varchar(10),
    PAN varchar(10)
);
insert into employee value(400, 'Thanesh',61 ,50000 ,'Developer' ,'Tha123');
select * from employee;
insert into employee value(200, 'Ramesh',55 ,25001 ,'BA' ,'Ram123');
drop table employee ;
create table Employee
(
	id int primary key,
    Ename varchar(10) not null  ,
    eage int check (eage < 60), 
    esalary int  check (esalary > 25000), 
    edesig varchar(10),
    PAN varchar(10) unique
);
insert into employee value(100, 'Thanesh',30 ,50000 ,'Developer' ,'Tha123');
select * from employee;
insert into employee value(200, 'Ramesh',35 ,60000 ,'BA' ,'Ram123');
insert into employee value('400', 'Rakesh',35 ,60000 ,'BA' ,'Ram124');
insert into employee(id,ename ,eage ,esalary ,edesig) value('600','ABI',35 ,60000 ,'BA'); -- we cant skip the name ;
drop table employee ; 
create table Employee
(
	id int primary key,
    Ename varchar(10) not null  ,
    eage int check (eage < 60), 
    esalary int  check (esalary > 25000), 
    edesig varchar(10) default 'Jn Enginer',
    PAN varchar(10) unique
);
insert into employee value(100, 'Thanesh',30 ,50000 ,'Developer' ,'Tha123');
select * from employee;
insert into employee value(200, 'Ramesh',35 ,60000 ,'BA' ,'Ram123');
insert into employee value('400', 'Rakesh',35 ,60000 ,'BA' ,'Ram124');
insert into employee(id,ename ,eage ,esalary ,pan) value('600','ABI',35 ,60000 ,'ASH123'); -- we cant skip the name ;
select * from employee;
drop table employee;
-- constraints
create table Employee
(
	id int primary key,
    Ename varchar(10) not null  ,
    eage int check (eage < 60), 
    esalary int  check (esalary > 25000), 
    edesig varchar(10) default 'Jn Enginer',
    PAN varchar(10) unique 
);
insert into employee value(100, 'Thanesh',30 ,50000 ,'Developer' ,'Tha123');
insert into employee value(200, 'Ramesh',35 ,60000 ,'BA' ,'Ram123');
insert into employee(id,eage ,esalary ,edesig ,pan) value('600',35 ,60000 ,'BA' ,'XYZ307745'); -- we cant skip the name  we much have to enter ;
insert into employee value('500', '',35 ,60000 ,'BA' ,'Ram123'); -- it allow  bcz we are entering null manually 
insert into employee value('600', 'Rakesh',65 ,60000 ,'BA' ,'Ram123'); -- must be less the 60 
insert into employee value('700', 'Rakesh',55 ,25001 ,'BA' ,'Ram123'); -- must be less the 25000 
insert into employee value('400', 'Rakesh',35 ,60000 ,'BA' ,'Ram123'); -- same pan there so not possible , change the pan 
insert into employee value(700, 'Ramesh',35 ,60000 ,'BA' ,'Ram163');
insert into employee value('800', 'Rakesh',35 ,60000 ,'BA' ,'Ram524');
insert into employee value('888', 'MANU',35 ,60000 ,'BA' ,'');
insert into employee(id,ename ,eage ,esalary ,pan) value('900','ABI',35 ,60000 ,'ASH123'); -- we cant skip the name ;
select * from employee;
drop table employee;
drop table table2;
CREATE TABLE table1 (	id INT, name VARCHAR(50) );
INSERT INTO table1 (id, name) VALUES
(1, 'Alice'),
(2, 'Bob'),
(3, 'Charlie');
CREATE TABLE table2 (id INT,name VARCHAR(50) );
INSERT INTO table2 (id, name) VALUES
(3, 'Charlie'),
(4, 'David'),
(5, 'Eve');
SELECT id, name FROM table1
UNION
SELECT id, name FROM table2;
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    amount DECIMAL(10, 2)
);
INSERT INTO orders (order_id, customer_id, order_date, amount)
VALUES
    (1, 101, '2024-09-28', 150.00),
    (2, 102, '2024-09-28', 200.00),
    (3, 101, '2024-09-29', 100.00),
    (4, 103, '2024-09-29', 300.00),
    (5, 102, '2024-09-30', 250.00);
Select * from Orders;
select order_id , Customer_id  from orders ;
select order_id  as OID , Customer_id as CID from orders ;
Select * from Orders where order_date > '2024-09-28';
SELECT customer_id, SUM(amount) AS total_amount
FROM orders
GROUP BY customer_id;
SELECT customer_id, SUM(amount) AS total_amount
FROM orders
GROUP BY customer_id
HAVING SUM(amount) > 400;

-- aggregate functions
select max(salary) from emp_record_table ;
select min(salary) from emp_record_table ;
select count(Emp_id) from emp_record_table; -- 19 employees
select sum(salary) from emp_record_table ; -- sum = 141800 
select avg(salary) from emp_record_table ; -- 7463.1579

-- operators
use businessanalyst;
SELECT * FROM emp_record_table;
SELECT * FROM emp_record_table order by salary asc;
SELECT * FROM emp_record_table order by salary desc;
SELECT * FROM emp_record_table order by salary desc limit 3;

SELECT * FROM emp_record_table 
WHERE name LIKE 'A%';  -- names starting with 'A'

SELECT * FROM emp_record_table 
WHERE salary BETWEEN 30000 AND 50000;

SELECT DISTINCT designation FROM emp_record_table;

SELECT * FROM emp_record_table 
WHERE designation = 'Manager' AND salary > 50000;

SELECT * FROM emp_record_table 
WHERE designation = 'Manager' OR salary > 50000;

SELECT * FROM emp_record_table 
WHERE NOT designation = 'BA';

SELECT * FROM emp_record_table 
WHERE designation IN ('Manager', 'BA');

SELECT * FROM emp_record_table 
WHERE PAN IS NULL;

SELECT * FROM emp_record_table 
WHERE PAN IS NOT NULL;

SELECT name AS EmployeeName, salary AS MonthlySalary 
FROM emp_record_table;

SELECT designation, AVG(salary) AS AvgSalary 
FROM emp_record_table 
GROUP BY designation 
HAVING AVG(salary) > 40000;

SELECT designation, COUNT(*) AS Count 
FROM emp_record_table 
GROUP BY designation;


-- joins
SELECT a.id, a.name, b.order_date FROM customers a
INNER JOIN orders b ON a.id = b.customer_id;

SELECT a.id, a.name, b.order_date FROM customers a
LEFT JOIN orders b ON a.id = b.customer_id;

SELECT a.id, a.name, b.order_date FROM customers a
RIGHT JOIN orders b ON a.id = b.customer_id;

SELECT a.id, a.name, b.order_date FROM customers a
LEFT JOIN orders b ON a.id = b.customer_id
UNION
SELECT a.id, a.name, b.order_date FROM customers a
RIGHT JOIN orders b ON a.id = b.customer_id;

SELECT a.id, a.name, b.order_id FROM customers a
CROSS JOIN orders b;

SELECT a.id AS EmpID1, b.id AS EmpID2, a.name AS Name1, b.name AS Name2 FROM employee a
JOIN employee b ON a.manager_id = b.id;

-- string functions
Select concat('Thanesh', 'Kumar' ) as Name;
select replace('Rakesh' , 'k','J') as Name ;
select Right('Thanesh',3) as name ;
select left('ThaneshWara',7) as name ;
select reverse('Thanesh') as Name ;
select length('Thaneshwara') as NAme ;
select format(123456789 ,'###-###-###') as AMOUNT;

-- date functions
Select now();
select current_date();
select current_time();
select current_timestamp();
