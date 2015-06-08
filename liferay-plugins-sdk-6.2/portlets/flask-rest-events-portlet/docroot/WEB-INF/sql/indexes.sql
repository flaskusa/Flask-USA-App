create index IX_86A03324 on flask_Event (eventDate);
create index IX_1A274FA6 on flask_Event (venueId);

create index IX_8D06EFC0 on flask_EventDetail (eventId);

create index IX_614684B4 on flask_EventDetailImage (eventDetailId);

create index IX_7B8E5F54 on flask_Venue (venueMetroArea);

create index IX_BF5B01E0 on flask_VenueDetail (venueId);

create index IX_DD870C9E on flask_VenueDetailImage (venueDetailId);

create index IX_4C0E747C on flask_VenueImage (venueId);

create index IX_FBD34BAB on flaskevents_Event (eventDate);
create index IX_B084DDED on flaskevents_Event (venueId);

create index IX_8A5C6CC7 on flaskevents_EventDetail (eventId);

create index IX_206C6D4D on flaskevents_EventDetailImage (eventDetailId);

create index IX_28E8832D on flaskevents_Venue (venueMetroArea);

create index IX_BCB07EE7 on flaskevents_VenueDetail (venueId);

create index IX_9CACF537 on flaskevents_VenueDetailImage (venueDetailId);

create index IX_F121BA95 on flaskevents_VenueImage (venueId);