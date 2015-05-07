create table flaskusers_FlaskAdmin (
	userId LONG not null primary key,
	roleId LONG,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	screenName VARCHAR(75) null,
	email VARCHAR(75) null,
	DOB DATE null
);

create table flaskusers_FlaskRole (
	roleId LONG not null primary key,
	roleName VARCHAR(75) null,
	roleDesc VARCHAR(75) null
);

create table flaskusers_FlaskUser (
	userId LONG not null primary key,
	roleId LONG,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	screenName VARCHAR(75) null,
	email VARCHAR(75) null,
	DOB DATE null
);