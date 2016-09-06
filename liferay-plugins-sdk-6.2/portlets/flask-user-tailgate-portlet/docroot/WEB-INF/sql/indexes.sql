create index IX_6F6902DC on flasktailgate_TailgateImages (imageUUID);
create index IX_E043D634 on flasktailgate_TailgateImages (tailgateId);

create index IX_D1593856 on flasktailgate_TailgateMarker (tailgateid);

create index IX_21DAB4DE on flasktailgate_TailgateSupplyItem (tailgateId);

create index IX_577E4B6C on flasktailgate_TailgateUsers (tailgateId);