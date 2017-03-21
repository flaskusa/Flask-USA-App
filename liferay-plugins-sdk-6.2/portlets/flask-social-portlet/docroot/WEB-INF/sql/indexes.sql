create index IX_6C32549F on Contacts_DeviceAwsEndpoint (userDeviceRegistrationId);

create index IX_BD6B6406 on Contacts_Entry (userId);
create index IX_C257DE32 on Contacts_Entry (userId, emailAddress);

create index IX_AAAC3600 on Contacts_FlaskGroupMessages (groupId);

create index IX_535EF312 on Contacts_FlaskGroupRecipients (groupId);
create index IX_6FE6850F on Contacts_FlaskGroupRecipients (groupMessageId);

create index IX_7FA884DC on Contacts_FlaskMessages (unread);

create index IX_BB317323 on Contacts_FlaskRecipients (groupId);
create index IX_2726F85D on Contacts_FlaskRecipients (groupId, userId);
create index IX_656336EB on Contacts_FlaskRecipients (messageId);
create index IX_32CB26A1 on Contacts_FlaskRecipients (userId);
create index IX_AD570D71 on Contacts_FlaskRecipients (userId, messageId);
create index IX_EC8E8438 on Contacts_FlaskRecipients (userId, read_);
create index IX_441C2F72 on Contacts_FlaskRecipients (userId, read_, groupId);
create index IX_2FA7575C on Contacts_FlaskRecipients (userId, read_, senderId);
create index IX_A5CECA85 on Contacts_FlaskRecipients (userId, senderId);

create index IX_549A594C on Contacts_FlaskUserDeviceRegistration (deviceToken);
create index IX_48681CDA on Contacts_FlaskUserDeviceRegistration (userEmail);
create index IX_7988B001 on Contacts_FlaskUserDeviceRegistration (userId);

create index IX_A14183F7 on Contacts_NotificationAuditLog (receiverEmail);
create index IX_665C7EF1 on Contacts_NotificationAuditLog (senderEmail);