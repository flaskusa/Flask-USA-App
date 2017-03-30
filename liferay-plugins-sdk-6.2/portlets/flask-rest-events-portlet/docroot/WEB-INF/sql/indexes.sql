create index IX_FBD34BAB on flaskevents_Event (eventDate);
create index IX_B084DDED on flaskevents_Event (venueId);

create index IX_8A5C6CC7 on flaskevents_EventDetail (eventId);
create index IX_409A6D35 on flaskevents_EventDetail (infoTypeId);
create index IX_22142ECA on flaskevents_EventDetail (infoTypeId, infoTypeCategoryId);

create index IX_206C6D4D on flaskevents_EventDetailImage (eventDetailId);

create index IX_E09566C6 on flaskevents_EventSubDetail (eventDetailId);

create index IX_A604D2BC on flaskevents_UserEvent (userId);
create index IX_7FFFEC09 on flaskevents_UserEvent (userId, eventId);

create index IX_28E8832D on flaskevents_Venue (venueMetroArea);
create index IX_AA9715D5 on flaskevents_Venue (venueZipCode);

create index IX_BCB07EE7 on flaskevents_VenueDetail (venueId);

create index IX_9CACF537 on flaskevents_VenueDetailImage (venueDetailId);

create index IX_EECBBC33 on flaskevents_VenueDeviceImage (DeviceType);
create index IX_85E73EB on flaskevents_VenueDeviceImage (VenueId);
create index IX_8BCD0CAF on flaskevents_VenueDeviceImage (VenueId, DeviceType);
create index IX_E5006813 on flaskevents_VenueDeviceImage (deviceType);
create index IX_BADCAF9 on flaskevents_VenueDeviceImage (venueDetailImageId);
create index IX_90EC540B on flaskevents_VenueDeviceImage (venueId);
create index IX_6444BFD8 on flaskevents_VenueDeviceImage (venueId, aspectRatio);
create index IX_152068AF on flaskevents_VenueDeviceImage (venueId, deviceType);

create index IX_F121BA95 on flaskevents_VenueImage (venueId);

create index IX_BD417FF0 on flaskevents_VenueSubDetail (venueDetailId);