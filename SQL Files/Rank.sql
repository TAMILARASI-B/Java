-- rank
SELECT name, department, salary,
       RANK() OVER (ORDER BY salary DESC) AS salary_rank
FROM Employee;
SHOW VARIABLES LIKE 'datadir';
