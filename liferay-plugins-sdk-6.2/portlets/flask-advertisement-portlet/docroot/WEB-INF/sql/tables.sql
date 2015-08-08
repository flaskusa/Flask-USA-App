create table flaskads_AdCampaign (
	campaignId LONG not null primary key,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	campaignName VARCHAR(75) null,
	customerId LONG,
	displayGeneral BOOLEAN,
	displayPreEvent BOOLEAN,
	displayDuringEvent BOOLEAN,
	displayPostEvent BOOLEAN,
	frequencyPerHour LONG
);

create table flaskads_AdCustomer (
	customerId LONG not null primary key,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	customerName VARCHAR(75) null,
	businessType VARCHAR(75) null,
	addrLine1 VARCHAR(75) null,
	addrLine2 VARCHAR(75) null,
	city VARCHAR(75) null,
	zipCode VARCHAR(75) null,
	stateId LONG,
	countryId LONG,
	email VARCHAR(75) null,
	websiteURL VARCHAR(75) null,
	businessPhoneNumber VARCHAR(75) null,
	contactPersonName VARCHAR(75) null,
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

create table flaskads_CampaignEvents (
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
	imageTitle VARCHAR(75) null,
	imageDesc VARCHAR(75) null,
	imageUUID VARCHAR(75) null,
	imageGroupId LONG
);

create table flaskads_CampaignImages (
	campaignImageId LONG not null primary key,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	imageTitle VARCHAR(75) null,
	imageDesc VARCHAR(75) null,
	imageUUID VARCHAR(75) null,
	imageGroupId LONG
);