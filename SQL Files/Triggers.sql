CREATE DATABASE School;
USE School;
-- DROP DATABASE School;
CREATE TABLE Student(RollNo INT NOT NULL PRIMARY KEY,
FirstName Varchar(10),
Bio INT,
Physics INT,
Chemistry INT,
Maths INT,
TotalMarks INT,
Percentage INT);

-- TRIGGERS
CREATE TRIGGER Student_Marks
BEFORE INSERT ON Student FOR EACH ROW SET
new.TotalMarks=new.Bio+new.Physics+new.Chemistry+new.Maths,
new.Percentage=(new.TotalMarks/400)*100;
insert into Student values(333,'Rahul',66,77,88,55,0,0);
SELECT * FROM Student;

CREATE TABLE StudentInsertLog (
  RollNo INT,
  FirstName VARCHAR(10),
  InsertedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TRIGGER Student_Insert_Log
AFTER INSERT ON Student
FOR EACH ROW
INSERT INTO StudentInsertLog(RollNo, FirstName)
VALUES (NEW.RollNo, NEW.FirstName);
-- Insert a new student to test trigger
INSERT INTO Student VALUES(334,'Priya',70,80,85,75,0,0);
SELECT * FROM StudentInsertLog;

CREATE TABLE StudentDeleteLog (
  RollNo INT,
  FirstName VARCHAR(10),
  DeletedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TRIGGER Student_Before_Delete
BEFORE DELETE ON Student
FOR EACH ROW
INSERT INTO StudentDeleteLog(RollNo, FirstName)
VALUES (OLD.RollNo, OLD.FirstName);
DELETE FROM Student WHERE RollNo = 334; -- or any existing RollNo
SELECT * FROM StudentDeleteLog;

CREATE TABLE DeletedStudents (
  RollNo INT,
  FirstName VARCHAR(10),
  DeletedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TRIGGER Student_After_Delete
AFTER DELETE ON Student
FOR EACH ROW
INSERT INTO DeletedStudents(RollNo, FirstName)
VALUES (OLD.RollNo, OLD.FirstName);
INSERT INTO Student VALUES (336, 'Anu', 65, 70, 75, 80, 0, 0);
DELETE FROM Student WHERE RollNo = 336;
SELECT * FROM DeletedStudents;

-- DROP TRIGGER IF EXISTS Student_Marks;



CREATE TABLE Product (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(50),
    Price DECIMAL(10,2),
    Quantity INT,
    TotalValue DECIMAL(10,2)
);
 
CREATE TRIGGER Calc_Total_Before_Insert
BEFORE INSERT ON Product
FOR EACH ROW
SET NEW.TotalValue = NEW.Price * NEW.Quantity;
 
CREATE TABLE Product_Log (
    ProductID INT,
    ActionType VARCHAR(20),
    ActionTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
 
CREATE TRIGGER trg_before_insert_product
BEFORE INSERT ON Product
FOR EACH ROW
SET NEW.TotalValue = NEW.Price * NEW.Quantity;
 
CREATE TRIGGER trg_after_insert_product
AFTER INSERT ON Product
FOR EACH ROW
INSERT INTO Product_Log (ProductID, ActionType)
VALUES (NEW.ProductID, 'AFTER INSERT');
 
CREATE TRIGGER trg_before_delete_product
BEFORE DELETE ON Product
FOR EACH ROW
INSERT INTO Product_Log (ProductID, ActionType)
VALUES (OLD.ProductID, 'BEFORE DELETE');
 
CREATE TRIGGER trg_after_delete_product
AFTER DELETE ON Product
FOR EACH ROW
INSERT INTO Product_Log (ProductID, ActionType)
VALUES (OLD.ProductID, 'AFTER DELETE');
 
INSERT INTO Product (ProductID, ProductName, Price, Quantity)
VALUES (1, 'Laptop', 40000, 2);
 
SELECT * FROM Product;
 
SELECT * FROM Product_Log;
 
DELETE FROM Product WHERE ProductIDS = 1;