create index IX_BD6B6406 on Contacts_Entry (userId);
create index IX_C257DE32 on Contacts_Entry (userId, emailAddress);

create index IX_7FA884DC on Contacts_FlaskMessages (unread);

create index IX_656336EB on Contacts_FlaskRecipients (messageId);
create index IX_32CB26A1 on Contacts_FlaskRecipients (userId);
create index IX_AD570D71 on Contacts_FlaskRecipients (userId, messageId);
create index IX_EC8E8438 on Contacts_FlaskRecipients (userId, read_);