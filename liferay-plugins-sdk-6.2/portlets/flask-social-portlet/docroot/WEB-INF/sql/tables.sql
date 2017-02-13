create table Contacts_DeviceAwsEndpoint (
	deviceEndPointId LONG not null primary key,
	awsEndpoint VARCHAR(75) null,
	userDeviceRegistrationId LONG
);

create table Contacts_Entry (
	entryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	fullName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	comments STRING null
);

create table Contacts_FlaskMessages (
	messageId LONG not null primary key,
	senderEmail VARCHAR(75) null,
	senderUserId LONG,
	senderName VARCHAR(75) null,
	recipients VARCHAR(75) null,
	message VARCHAR(75) null,
	sendEmail BOOLEAN,
	dateTime DATE null
);

create table Contacts_FlaskRecipients (
	recipientId LONG not null primary key,
	userId LONG,
	email VARCHAR(75) null,
	messageId LONG,
	read_ BOOLEAN,
	receivedDateTime DATE null
);

create table Contacts_FlaskUserDeviceRegistration (
	userDeviceRegistrationId LONG not null primary key,
	userId LONG,
	userEmail VARCHAR(75) null,
	devicePlatform VARCHAR(75) null,
	deviceDetails VARCHAR(75) null,
	deviceToken VARCHAR(75) null,
	registrationTime DATE null,
	active_ BOOLEAN,
	lastNotificationTime DATE null,
	lastNotificationMsg VARCHAR(75) null
);

create table Contacts_NotificationAuditLog (
	notificationAuditLogId LONG not null primary key,
	senderEmail VARCHAR(75) null,
	receiverEmail VARCHAR(75) null,
	messageReason VARCHAR(75) null,
	message VARCHAR(75) null,
	notificationTime DATE null
);