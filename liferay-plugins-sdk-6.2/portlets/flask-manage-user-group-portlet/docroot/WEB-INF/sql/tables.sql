create table flaskgroup_FlaskGroup (
	groupId LONG not null primary key,
	groupName VARCHAR(75) null,
	groupDescription VARCHAR(75) null,
	createdDate VARCHAR(75) null,
	createdBy VARCHAR(75) null,
	isActive INTEGER,
	isDelete INTEGER
);

create table flaskgroup_FlaskGroupUsers (
	groupUserId LONG not null primary key,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	isAdmin INTEGER
);