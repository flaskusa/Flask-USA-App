create index IX_CDD38FE8 on flaskads_AdCampaign (customerId);

create index IX_43BA1CE7 on flaskads_AdCustomer (contactPersonName);
create index IX_7019D966 on flaskads_AdCustomer (customerName);

create index IX_99234D2D on flaskads_CampaignEvent (campaignId);
create index IX_6C81EED7 on flaskads_CampaignEvent (eventId);

create index IX_E7C5FBB7 on flaskads_CampaignImage (imageUUID);