create table flask_Event (
	eventId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventName VARCHAR(75) null,
	description VARCHAR(75) null,
	eventDate DATE null,
	startTime DATE null,
	endTime DATE null,
	eventTypeId LONG,
	eventImage BLOB,
	venueId LONG
);

create table flask_EventDetail (
	eventDetailId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventId LONG,
	infoTypeId LONG,
	infoTypeCategoryId LONG,
	eventDetailInfoName VARCHAR(75) null,
	eventDetailInfoDesc VARCHAR(75) null,
	eventDetailInfoComment VARCHAR(75) null,
	eventDetailAddressLine1 VARCHAR(75) null,
	eventDetailAddressLine2 VARCHAR(75) null,
	eventDetailInfocity VARCHAR(75) null,
	eventDetailZip VARCHAR(75) null,
	eventDetailState VARCHAR(75) null,
	eventDetailCountry VARCHAR(75) null,
	eventDetailLatitude VARCHAR(75) null,
	eventDetailLongitude VARCHAR(75) null,
	eventDetailPhone VARCHAR(75) null,
	eventDetailWebsite VARCHAR(75) null,
	eventDetailCost DOUBLE,
	hoursOfOperation VARCHAR(75) null
);

create table flask_EventDetailImage (
	eventDetailImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventDetailId LONG,
	eventDetailImagetitle VARCHAR(75) null,
	eventDetailImageDesc VARCHAR(75) null,
	eventDetailImageData BLOB
);

create table flask_EventType (
	eventTypeId LONG not null primary key,
	eventTypeKey VARCHAR(75) null,
	eventTypeName VARCHAR(75) null
);

create table flask_InfoType (
	infoTypeId LONG not null primary key,
	infoTypeName VARCHAR(75) null
);

create table flask_InfoTypeCategory (
	infoTypeCategoryId LONG not null primary key,
	infoTypeCategoryName VARCHAR(75) null,
	displayTemplate VARCHAR(75) null
);

create table flask_Venue (
	venueId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueName VARCHAR(75) null,
	venueDescription VARCHAR(75) null,
	venueZipCode VARCHAR(75) null,
	venueStreetAddress VARCHAR(75) null,
	venueCity VARCHAR(75) null,
	stateOrProvince VARCHAR(75) null,
	venueCountry VARCHAR(75) null,
	venueMetroArea VARCHAR(75) null
);

create table flask_VenueDetail (
	venueDetailId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueId LONG,
	infoTypeId LONG,
	infoTypeCategoryId LONG,
	venueDetailInfoName VARCHAR(75) null,
	venueDetailInfoDesc VARCHAR(75) null,
	venueDetailInfoComment VARCHAR(75) null,
	venueDetailAddressLine1 VARCHAR(75) null,
	venueDetailAddressLine2 VARCHAR(75) null,
	venueDetailCity VARCHAR(75) null,
	venueDetailState VARCHAR(75) null,
	venueDetailCountry VARCHAR(75) null,
	venueDetailLatitude VARCHAR(75) null,
	venueDetailLongitude VARCHAR(75) null,
	venueDetailPhone VARCHAR(75) null,
	venueDetailWebsite VARCHAR(75) null,
	venueDetailCost DOUBLE,
	venueDetailhoursOfOperation VARCHAR(75) null
);

create table flask_VenueDetailImage (
	venueDetailImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueDetailId LONG,
	venueDetailImageTitle VARCHAR(75) null,
	venueDetailImageDesc VARCHAR(75) null,
	venueDetailImageData BLOB
);

create table flask_VenueImage (
	venueImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	venueImage BLOB,
	venueId LONG
);

create table flaskevents_Event (
	eventId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventName VARCHAR(75) null,
	description VARCHAR(75) null,
	eventDate DATE null,
	startTime DATE null,
	endTime DATE null,
	eventTypeId LONG,
	eventImage BLOB,
	venueId LONG
);

create table flaskevents_EventDetail (
	eventDetailId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventId LONG,
	infoTypeId LONG,
	infoTypeCategoryId LONG,
	eventDetailInfoName VARCHAR(75) null,
	eventDetailInfoDesc VARCHAR(75) null,
	eventDetailInfoComment VARCHAR(75) null,
	eventDetailAddressLine1 VARCHAR(75) null,
	eventDetailAddressLine2 VARCHAR(75) null,
	eventDetailInfocity VARCHAR(75) null,
	eventDetailZip VARCHAR(75) null,
	eventDetailState VARCHAR(75) null,
	eventDetailCountry VARCHAR(75) null,
	eventDetailLatitude VARCHAR(75) null,
	eventDetailLongitude VARCHAR(75) null,
	eventDetailPhone VARCHAR(75) null,
	eventDetailWebsite VARCHAR(75) null,
	eventDetailCost DOUBLE,
	hoursOfOperation VARCHAR(75) null
);

create table flaskevents_EventDetailImage (
	eventDetailImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventDetailId LONG,
	eventDetailImagetitle VARCHAR(75) null,
	eventDetailImageDesc VARCHAR(75) null,
	eventDetailImageData BLOB
);

create table flaskevents_EventType (
	eventTypeId LONG not null primary key,
	eventTypeKey VARCHAR(75) null,
	eventTypeName VARCHAR(75) null
);

create table flaskevents_InfoType (
	infoTypeId LONG not null primary key,
	infoTypeName VARCHAR(75) null
);

create table flaskevents_InfoTypeCategory (
	infoTypeCategoryId LONG not null primary key,
	infoTypeCategoryName VARCHAR(75) null,
	displayTemplate VARCHAR(75) null
);

create table flaskevents_Venue (
	venueId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueName VARCHAR(75) null,
	venueDescription VARCHAR(75) null,
	venueZipCode VARCHAR(75) null,
	addrLine1 VARCHAR(75) null,
	addrLine2 VARCHAR(75) null,
	venueCity VARCHAR(75) null,
	venueStateId LONG,
	venueCountryId LONG,
	venueMetroArea VARCHAR(75) null
);

create table flaskevents_VenueDetail (
	venueDetailId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueId LONG,
	infoTypeId LONG,
	infoTypeCategoryId LONG,
	venueDetailInfoName VARCHAR(75) null,
	venueDetailInfoDesc VARCHAR(75) null,
	venueDetailInfoComment VARCHAR(75) null,
	venueDetailAddressLine1 VARCHAR(75) null,
	venueDetailAddressLine2 VARCHAR(75) null,
	venueDetailCity VARCHAR(75) null,
	venueDetailState VARCHAR(75) null,
	venueDetailCountry VARCHAR(75) null,
	venueDetailLatitude VARCHAR(75) null,
	venueDetailLongitude VARCHAR(75) null,
	venueDetailPhone VARCHAR(75) null,
	venueDetailWebsite VARCHAR(75) null,
	venueDetailCost DOUBLE,
	venueDetailhoursOfOperation VARCHAR(75) null
);

create table flaskevents_VenueDetailImage (
	venueDetailImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueDetailId LONG,
	venueDetailImageTitle VARCHAR(75) null,
	venueDetailImageDesc VARCHAR(75) null,
	venueDetailImageData BLOB
);

create table flaskevents_VenueImage (
	venueImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	venueImage BLOB,
	venueId LONG
);