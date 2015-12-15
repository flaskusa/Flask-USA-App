create table flaskusers_FlaskAdmin (
	userId LONG not null primary key,
	roleId LONG,
	roleName VARCHAR(75) null,
	firstName VARCHAR(100) null,
	middleName VARCHAR(100) null,
	lastName VARCHAR(100) null,
	screenName VARCHAR(100) null,
	email VARCHAR(100) null,
	DOB DATE null,
	isMale BOOLEAN,
	streetName VARCHAR(100) null,
	aptNo VARCHAR(75) null,
	areaCode VARCHAR(20) null,
	city VARCHAR(100) null,
	stateId LONG,
	stateName VARCHAR(75) null,
	countryId LONG,
	countryName VARCHAR(75) null,
	mobileNumber VARCHAR(20) null,
	portraitURL VARCHAR(75) null,
	userInterests VARCHAR(75) null
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
	DOB DATE null,
	isMale BOOLEAN,
	streetName VARCHAR(75) null,
	aptNo VARCHAR(75) null,
	areaCode VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	country VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	portraitURL VARCHAR(75) null,
	userInterests VARCHAR(75) null
);