CREATE TABLE userdetails(
name varchar(50),
username varchar(50) PRIMARY KEY,
password varchar(50),
age int,
gender varchar(50),
email varchar(50),
mobile BIGINT(10)
);
insert into userdetails(name,username,password,age,gender,email,mobile) values("Danish","Danish123","Danish123",22,"MALE","tux.danish@gmail.com",8826296990);
insert into userdetails(name,username,password,age,gender,email,mobile) values("mayank","mayank123","mayank123",21,"MALE","mayank.kumar@gmail.com",8813338990);
insert into userdetails(name,username,password,age,gender,email,mobile) values("pardha","pardha123","pardha123",22,"MALE","pardha@gmail.com",8872494210);
insert into userdetails(name,username,password,age,gender,email,mobile) values("safiyat","safiyat123","safiyat123",21,"MALE","safiyat.reza@gmail.com",8826299090);
insert into userdetails(name,username,password,age,gender,email,mobile) values("tux","tux123","tux123",22,"MALE","tux@gmail.com",8872973160);



CREATE TABLE driverdetails(
drivername varchar(50) PRIMARY KEY,
name varchar(50),
password varchar(50),
age int,
gender varchar(50),
email varchar(50),
carmodel varchar(50),
totalseats int,
drivercontact BIGINT(10)
);
insert into driverdetails(drivername,name,password,age,gender,email,carmodel,totalseats,seatavail,drivercontact) values("mkumar","Mayank kumar","mayank1234","22","M","mayank.kumar@gmail.com","Audi A6",5,3,9988223312);
insert into driverdetails(drivername,name,password,age,gender,email,carmodel,totalseats,seatavail,drivercontact) values("mrathi","Mayank Rathi","mayank1234","22","M","mayank.rathi@gmail.com","Audi A4",5,5,9929944112);
insert into driverdetails(drivername,name,password,age,gender,email,carmodel,totalseats,seatavail,drivercontact) values("mgupta","Mayank gupta","mayank1234","22","M","mayank.gupta@gmail.com","BMW SX",5,1,9003311772);
insert into driverdetails(drivername,name,password,age,gender,email,carmodel,totalseats,seatavail,drivercontact) values("mlohani","Mayank Lohani","mayank1234","22","M","mayank.lohani@gmail.com","Gallardo A9",5,2,9883377112);



CREATE TABLE stops(
sid int primary key not null default 101 auto_increment,
name varchar(30),
distance int
);
insert into stops(name, distance) values("Jahangirpuri", 2);
insert into stops(name, distance) values("Kashmiri Gate", 5);
insert into stops(name, distance) values("Rajiv Chowk", 7);
insert into stops(name, distance) values("Central Secretariat", 10);
insert into stops(name, distance) values("Qutab Minar", 11);
insert into stops(name, distance) values("Huda City Center", 21);

CREATE TABLE userride(
urid int primary key not null auto_increment,		#On Take/Join Ride
FOREIGN KEY (username) REFERENCES userdetails(username),	#On Take/Join Ride
FOREIGN KEY (source) REFERENCES stops(sid),
FOREIGN KEY (destination) REFERENCES stops(sid),
shareable boolean,
size int,
FOREIGN KEY (drivername) REFERENCES driverdetails(drivername),	#On Take/Join Ride
FOREIGN KEY (location) REFERENCES stops(sid),
fare int
);

