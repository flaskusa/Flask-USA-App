create table flaskads_AdCampaign (
	campaignId LONG not null primary key,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	campaignName VARCHAR(100) null,
	customerId LONG,
	displayGeneral BOOLEAN,
	displayPreEvent BOOLEAN,
	displayDuringEvent BOOLEAN,
	displayPostEvent BOOLEAN,
	frequencyPerHour LONG,
	eventTypeId LONG,
	imageTitle VARCHAR(100) null,
	imageDesc VARCHAR(255) null,
	imageUUID VARCHAR(75) null,
	imageGroupId LONG,
	showAlways BOOLEAN
);

create table flaskads_AdCustomer (
	customerId LONG not null primary key,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	customerName VARCHAR(100) null,
	businessType VARCHAR(100) null,
	addrLine1 VARCHAR(100) null,
	addrLine2 VARCHAR(100) null,
	city VARCHAR(75) null,
	zipCode VARCHAR(75) null,
	stateId LONG,
	countryId LONG,
	email VARCHAR(255) null,
	websiteURL VARCHAR(255) null,
	businessPhoneNumber VARCHAR(75) null,
	contactPersonName VARCHAR(255) null,
	contactPersonNumber VARCHAR(75) null
);

create table flaskads_CampaignEvent (
	campaignEventId LONG not null primary key,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	campaignId LONG,
	eventId LONG
);

create table flaskads_CampaignImage (
	campaignImageId LONG not null primary key,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	imageTitle VARCHAR(100) null,
	imageDesc VARCHAR(255) null,
	imageUUID VARCHAR(75) null,
	imageGroupId LONG,
	campaignId LONG
);