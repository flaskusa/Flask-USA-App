create index IX_8E6C3AF5 on flasktailgate_SupplyItem (supplyListId);

create index IX_7AC2FD9E on flasktailgate_SupplyList (userId);

create index IX_6F6902DC on flasktailgate_TailgateImages (imageUUID);
create index IX_E043D634 on flasktailgate_TailgateImages (tailgateId);

create index IX_D1593856 on flasktailgate_TailgateMarker (tailgateid);

create index IX_7E210D9B on flasktailgate_TailgateMessageBoard (tailgateId);
create index IX_81ED69CB on flasktailgate_TailgateMessageBoard (userId);

create index IX_21DAB4DE on flasktailgate_TailgateSupplyItem (tailgateId);
create index IX_BFCB2A8E on flasktailgate_TailgateSupplyItem (userId);

create index IX_577E4B6C on flasktailgate_TailgateUsers (tailgateId);