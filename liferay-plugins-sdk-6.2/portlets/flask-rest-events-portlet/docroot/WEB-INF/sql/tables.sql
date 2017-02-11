create table flaskevents_Event (
	eventId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventName VARCHAR(100) null,
	description VARCHAR(255) null,
	eventDate DATE null,
	startTime LONG,
	endTime LONG,
	eventTypeId LONG,
	eventTypeName VARCHAR(75) null,
	eventImageUUID VARCHAR(50) null,
	eventImageGroupId LONG,
	venueId LONG,
	venueName VARCHAR(75) null
);

create table flaskevents_EventDetail (
	eventDetailId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventId LONG,
	infoTypeId LONG,
	infoTypeName VARCHAR(75) null,
	infoTypeCategoryId LONG,
	infoTypeCategoryName VARCHAR(75) null,
	infoTitle VARCHAR(100) null,
	infoShortDesc VARCHAR(100) null,
	infoDesc TEXT null,
	addrLine1 VARCHAR(100) null,
	addrLine2 VARCHAR(100) null,
	city VARCHAR(100) null,
	zipCode VARCHAR(20) null,
	stateId LONG,
	stateName VARCHAR(75) null,
	countryId LONG,
	countryName VARCHAR(75) null,
	latitude VARCHAR(20) null,
	longitude VARCHAR(20) null,
	phone VARCHAR(20) null,
	mobileAppName VARCHAR(75) null,
	website VARCHAR(255) null,
	cost DOUBLE,
	hoursOfOperation VARCHAR(255) null,
	showDescription BOOLEAN
);

create table flaskevents_EventDetailImage (
	eventDetailImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventDetailId LONG,
	imageTitle VARCHAR(75) null,
	imageDesc VARCHAR(255) null,
	imageUUID VARCHAR(50) null,
	imageGroupId LONG
);

create table flaskevents_EventSubDetail (
	eventSubDetailId LONG not null primary key,
	eventDetailId LONG,
	eventSubDetailTitle VARCHAR(75) null,
	eventSubDetailDesc VARCHAR(75) null
);

create table flaskevents_EventType (
	eventTypeId LONG not null primary key,
	eventTypeKey VARCHAR(75) null,
	eventTypeName VARCHAR(100) null
);

create table flaskevents_InfoType (
	infoTypeId LONG not null primary key,
	infoTypeName VARCHAR(100) null
);

create table flaskevents_InfoTypeCategory (
	infoTypeCategoryId LONG not null primary key,
	infoTypeCategoryName VARCHAR(100) null,
	displayTemplate VARCHAR(255) null,
	infoTypeId LONG
);

create table flaskevents_UserEvent (
	userEventId LONG not null primary key,
	userId LONG,
	eventId LONG,
	createdDate DATE null
);

create table flaskevents_Venue (
	venueId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueName VARCHAR(100) null,
	venueDescription VARCHAR(255) null,
	venueZipCode VARCHAR(20) null,
	addrLine1 VARCHAR(100) null,
	addrLine2 VARCHAR(100) null,
	venueCity VARCHAR(100) null,
	venueStateId LONG,
	venueStateName VARCHAR(75) null,
	venueCountryId LONG,
	venueCountryName VARCHAR(75) null,
	venueMetroArea VARCHAR(75) null,
	longitude VARCHAR(20) null,
	latitude VARCHAR(20) null
);

create table flaskevents_VenueDetail (
	venueDetailId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueId LONG,
	infoTypeId LONG,
	infoTypeName VARCHAR(75) null,
	infoTypeCategoryId LONG,
	infoTypeCategoryName VARCHAR(75) null,
	infoTitle VARCHAR(100) null,
	infoShortDesc VARCHAR(100) null,
	infoDesc TEXT null,
	addrLine1 VARCHAR(100) null,
	addrLine2 VARCHAR(100) null,
	city VARCHAR(100) null,
	zipCode VARCHAR(20) null,
	stateId LONG,
	stateName VARCHAR(100) null,
	countryId LONG,
	countryName VARCHAR(100) null,
	latitude VARCHAR(20) null,
	longitude VARCHAR(20) null,
	phone VARCHAR(20) null,
	mobileAppName VARCHAR(75) null,
	website VARCHAR(255) null,
	cost DOUBLE,
	hoursOfOperation VARCHAR(255) null,
	showDescription BOOLEAN
);

create table flaskevents_VenueDetailImage (
	venueDetailImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueDetailId LONG,
	imageTitle VARCHAR(100) null,
	imageDesc VARCHAR(255) null,
	imageUUID VARCHAR(50) null,
	imageGroupId LONG
);

create table flaskevents_VenueImage (
	venueImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(100) null,
	venueImageUUId VARCHAR(50) null,
	venueImageGroupId LONG,
	venueId LONG
);

create table flaskevents_VenueSubDetail (
	venueSubDetailId LONG not null primary key,
	venueDetailId LONG,
	venueSubDetailTitle VARCHAR(75) null,
	venueSubDetailDesc VARCHAR(75) null
);