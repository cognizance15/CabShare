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
carmodel varchar(50),
totalseats int,
seatavail int,
drivercontact BIGINT
);
insert into driverdetails(drivername,carmodel,totalseats,seatavail,drivercontact) values("Mayank kumar","Audi A6",5,3,9988223312);
insert into driverdetails(drivername,carmodel,totalseats,seatavail,drivercontact) values("Mayank Rathi","Audi A4",5,5,9929944112);
insert into driverdetails(drivername,carmodel,totalseats,seatavail,drivercontact) values("Mayank gupta","BMW SX",5,1,9003311772);
insert into driverdetails(drivername,carmodel,totalseats,seatavail,drivercontact) values("Mayank Lohani","Gallardo A9",5,2,9883377112);



CREATE TABLE route(
rid int,
start varchar(5),
end varchar(5)
);
insert into route(rid,start,end) values(100,"A1","A2");
insert into route(rid,start,end) values(101,"A2","A3");
insert into route(rid,start,end) values(102,"A3","A4");
insert into route(rid,start,end) values(103,"A4","A5");
insert into route(rid,start,end) values(104,"A5","A6");




CREATE TABLE cabride(
FOREIGN KEY (drivername) REFERENCES driverdetails(drivername),
crid int,
source varchar(25),
destination varchar(25)	
);



CREATE TABLE userride(
FOREIGN KEY (username) REFERENCES userdetails(username),
FOREIGN KEY (crid) REFERENCES cabride(crid),
source varchar(50),
destination varchar(50),
fare int
);

