create table flasktailgate_SupplyItem (
	supplyItemId LONG not null primary key,
	supplyItemName VARCHAR(75) null,
	supplyListId LONG,
	createdDate DATE null,
	modifiedDate DATE null
);

create table flasktailgate_SupplyList (
	supplyListId LONG not null primary key,
	supplyListName VARCHAR(75) null,
	isSystem BOOLEAN,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null
);

create table flasktailgate_TailgateImages (
	tailgateImageId LONG not null primary key,
	tailgateId LONG,
	userId LONG,
	imageTitle VARCHAR(100) null,
	imageDesc VARCHAR(255) null,
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
	tailgateName VARCHAR(100) null,
	tailgateDescription VARCHAR(255) null,
	eventId LONG,
	eventName VARCHAR(100) null,
	tailgateDate DATE null,
	startTime LONG,
	endTime LONG,
	isActive INTEGER,
	isDelete INTEGER,
	venmoAccountId VARCHAR(75) null,
	amountToPay DOUBLE,
	logoId LONG
);

create table flasktailgate_TailgateMarker (
	tailgatemarkerid LONG not null primary key,
	tailgateid LONG,
	latitude VARCHAR(75) null,
	longitude VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table flasktailgate_TailgateMessageBoard (
	tailgateMessageId LONG not null primary key,
	messageText VARCHAR(75) null,
	tailgateId LONG,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null
);

create table flasktailgate_TailgateSupplyItem (
	tailgateSupplyItemId LONG not null primary key,
	supplyListItemName VARCHAR(75) null,
	tailgateId LONG,
	itemAssignedUserId LONG,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null
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