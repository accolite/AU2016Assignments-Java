CREATE TABLE employees(emp_id int identity(1,1) primary key, name varchar(50), email varchar(50), age int);

ALTER TABLE employees add designation varchar(50);

SELECT * from employees;
delete from employees where emp_id>1;
insert into employees(name,email,age,designation) values('wayne','rooney@manutd.com',30,'forward');