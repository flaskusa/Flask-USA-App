create table flaskinvitation_InvitationInfo (
	inviationId LONG not null primary key,
	name VARCHAR(100) null,
	email VARCHAR(255) null,
	description VARCHAR(2000) null,
	invitedDate VARCHAR(75) null
);