Use acsell

CREATE TABLE category(categoryid int PRIMARY KEY IDENTITY(1,1) NOT NULL, categoryname nvarchar(50) NOT NULL);

CREATE TABLE location(locationid int PRIMARY KEY IDENTITY(1,1) NOT NULL, locationname nvarchar(50) NOT NULL);

CREATE TABLE photo(photoid int PRIMARY KEY IDENTITY(1,1) NOT NULL, postid int NULL, url varchar(50) NULL);

CREATE TABLE post( postid int PRIMARY KEY IDENTITY(1,1) NOT NULL, title nvarchar(50) NOT NULL, description varchar(max) NOT NULL, location int NULL, category int NULL, status int NULL, price int NULL, created_date datetime NULL) 

CREATE TABLE subscription(userid nvarchar(25) NULL,categoryid int NULL) 

CREATE TABLE users( userid nvarchar(25) PRIMARY KEY NOT NULL, username nvarchar(50) NOT NULL, email nvarchar(50) NOT NULL, mobile nvarchar(50) NOT NULL, role int NOT NULL)



