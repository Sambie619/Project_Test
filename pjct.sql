create database project_test;
use project_test;

create table department (
    dept_id int primary key auto_increment,
    dept_name varchar(50) not null unique
);

create table project (
    project_id int primary key auto_increment,
    project_name varchar(50) not null unique
);

create table employee_work (
    work_id int primary key auto_increment,
    emp_name varchar(50) not null,
    city varchar(50) not null,
    work_date date not null,
    dept_id int not null,
    project_id int not null,
    foreign key (dept_id) references department(dept_id),
    foreign key (project_id) references project(project_id)
);

insert into department(dept_name) values
('HR'),
('IT'),
('Sales');

insert into project(project_name) values
('Payroll System'),
('Website'),
('CRM');