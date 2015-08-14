CREATE TABLE userdetails(
name varchar(50),
username varchar(50) PRIMARY KEY,
password varchar(50),
userType varchar(10),
age int,
gender varchar(50),
email varchar(50),
mobile BIGINT(10)
);
insert into userdetails(name,username,password,userType,age,gender,email,mobile) values("Danish","Danish123","Danish123","d",22,"MALE","tux.danish@gmail.com",8826296990);
insert into userdetails(name,username,password,userType,age,gender,email,mobile) values("mayank","mayank123","mayank123","p",21,"MALE","mayank.kumar@gmail.com",8813338990);
insert into userdetails(name,username,password,userType,age,gender,email,mobile) values("pardha","pardha123","pardha123","p",22,"MALE","pardha@gmail.com",8872494210);
insert into userdetails(name,username,password,userType,age,gender,email,mobile) values("safiyat","safiyat123","safiyat123","p",21,"MALE","safiyat.reza@gmail.com",8826299090);
insert into userdetails(name,username,password,userType,age,gender,email,mobile) values("tux","tux123","tux123","p",22,"MALE","tux@gmail.com",8872973160);



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
insert into driverdetails(drivername,name,password,age,gender,email,carmodel,totalseats,drivercontact) values("mkumar","Mayank kumar","mayank1234","22","M","mayank.kumar@gmail.com","Audi A6",5,9988223312);
insert into driverdetails(drivername,name,password,age,gender,email,carmodel,totalseats,drivercontact) values("mrathi","Mayank Rathi","mayank1234","22","M","mayank.rathi@gmail.com","Audi A4",5,9929944112);
insert into driverdetails(drivername,name,password,age,gender,email,carmodel,totalseats,drivercontact) values("mgupta","Mayank gupta","mayank1234","22","M","mayank.gupta@gmail.com","BMW SX",5,9003311772);
insert into driverdetails(drivername,name,password,age,gender,email,carmodel,totalseats,drivercontact) values("mlohani","Mayank Lohani","mayank1234","22","M","mayank.lohani@gmail.com","Gallardo A9",5,9883377112);



CREATE TABLE stops(
sid int primary key not null auto_increment,
name varchar(30),
distance int
);
insert into stops(sid, name, distance) values(101, "Jahangirpuri", 2);
insert into stops(name, distance) values("Kashmiri Gate", 5);
insert into stops(name, distance) values("Rajiv Chowk", 7);
insert into stops(name, distance) values("Central Secretariat", 10);
insert into stops(name, distance) values("Qutab Minar", 11);
insert into stops(name, distance) values("Huda City Center", 21);

CREATE TABLE userride(
urid int primary key not null auto_increment,		#On Take/Join Ride
username varchar(50),
FOREIGN KEY (username) REFERENCES userdetails(username),	#On Take/Join Ride
source int,
FOREIGN KEY (source) REFERENCES stops(sid),
destination int,
FOREIGN KEY (destination) REFERENCES stops(sid),
shareable boolean,
size int,
drivername varchar(50),
FOREIGN KEY (drivername) REFERENCES driverdetails(drivername),	#On Take/Join Ride
location int,
FOREIGN KEY (location) REFERENCES stops(sid),
fare int
);

CREATE TABLE cabride(
crid int primary key not null auto_increment,
source int,
FOREIGN KEY (source) REFERENCES stops(sid),
destination int,
FOREIGN KEY (destination) REFERENCES stops(sid),
shareable boolean,
seatsavailable int,
drivername varchar(50),
FOREIGN KEY (drivername) REFERENCES driverdetails(drivername),	#On Take/Join Ride
location int,
FOREIGN KEY (location) REFERENCES stops(sid)
);
insert into cabride(crid,shareable,seatsavailable,drivername) values(1002, 1, 5, "mkumar");
insert into cabride(crid,shareable,seatsavailable,drivername) values(1002, 1, 5, "mrathi");
insert into cabride(crid,shareable,seatsavailable,drivername) values(1002, 1, 5, "mgupta");
insert into cabride(crid,shareable,seatsavailable,drivername) values(1002, 1, 5, "mlohani");
