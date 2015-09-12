create table flasktailgate_TailgateImages (
	tailgateImageId LONG not null primary key,
	tailgateId LONG,
	userId LONG,
	imageTitle VARCHAR(75) null,
	imageDesc VARCHAR(75) null,
	imageUUID VARCHAR(75) null,
	imageGroupId LONG,
	createdDate DATE null,
	modifiedDate DATE null
);

create table flasktailgate_TailgateInfo (
	tailgateId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	tailgateName VARCHAR(75) null,
	tailgateDescription VARCHAR(75) null,
	eventId LONG,
	eventName VARCHAR(75) null,
	tailgateDate DATE null,
	startTime DATE null,
	endTime DATE null,
	isActive INTEGER,
	isDelete INTEGER,
	venmoAccountId VARCHAR(75) null,
	amountToPay DOUBLE
);

create table flasktailgate_TailgateMarker (
	tailgatemarkerid LONG not null primary key,
	tailgateid LONG,
	latitude VARCHAR(75) null,
	longitude VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table flasktailgate_TailgateUsers (
	tailgateUserId LONG not null primary key,
	tailgateId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	isAdmin INTEGER,
	groupId LONG,
	emailAddress VARCHAR(75) null,
	isPaid BOOLEAN,
	paymentMode VARCHAR(75) null,
	description VARCHAR(75) null
);

create table flasktailgate_UserTailgate (
	tailgateId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	tailgateName VARCHAR(75) null,
	tailgateDescription VARCHAR(75) null,
	eventId LONG,
	eventName VARCHAR(75) null,
	tailgateDate DATE null,
	startTime DATE null,
	endTime DATE null
);