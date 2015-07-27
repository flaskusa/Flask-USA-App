create index IX_FBD34BAB on flaskevents_Event (eventDate);
create index IX_B084DDED on flaskevents_Event (venueId);

create index IX_8A5C6CC7 on flaskevents_EventDetail (eventId);
create index IX_409A6D35 on flaskevents_EventDetail (infoTypeId);
create index IX_22142ECA on flaskevents_EventDetail (infoTypeId, infoTypeCategoryId);

create index IX_206C6D4D on flaskevents_EventDetailImage (eventDetailId);

create index IX_A604D2BC on flaskevents_UserEvent (userId);
create index IX_7FFFEC09 on flaskevents_UserEvent (userId, eventId);

create index IX_C63B7D77 on flaskevents_UserEvents (userId);

create index IX_28E8832D on flaskevents_Venue (venueMetroArea);
create index IX_AA9715D5 on flaskevents_Venue (venueZipCode);

create index IX_BCB07EE7 on flaskevents_VenueDetail (venueId);

create index IX_9CACF537 on flaskevents_VenueDetailImage (venueDetailId);

create index IX_F121BA95 on flaskevents_VenueImage (venueId);