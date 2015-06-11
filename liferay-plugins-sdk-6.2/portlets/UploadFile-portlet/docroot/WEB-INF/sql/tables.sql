create table TK_UploadFile (
	fileUploadId LONG not null primary key,
	fileEntryId LONG,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	size_ LONG
);