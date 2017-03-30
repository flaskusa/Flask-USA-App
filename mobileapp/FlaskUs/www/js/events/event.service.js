
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('EventsService', EventsService);

    EventsService.$inject = ['$http', 'SERVER'];

    function EventsService($http, SERVER) {
        var allEventsURL = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var addEventURL = "flask-rest-events-portlet.event/add-event";
        var addEventDetailsURL = "flask-rest-events-portlet.event/add-event-detail";
        var getFilteredEvents = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var getEvent_Venue_Details_with_Images = "flask-rest-events-portlet.event/get-event-venue-details-with-images";
        var getEventByIdURL = "flask-rest-events-portlet.event/get-event";
        var addContentDuringGameUrl="/flask-rest-events-portlet.event/add-event-detail";
        var updateEventDuringGame="/flask-rest-events-portlet.event/update-event-detail";
        var deleteEventDetailUrl = "/flask-rest-events-portlet.event/delete-event-detail";
        var getAllVenuesURL = "flask-rest-events-portlet.venue/get-all-venues";
        var getVenuesByIdURL = "flask-rest-events-portlet.venue/get-venue";
        var getAllEventDetailWithImageUrl = "/flask-rest-events-portlet.event/get-event-details-with-images";
        var getVenueDetailsURL = "/flask-rest-events-portlet.venue/get-venue-details";
        var getVenueDetailURL = "/flask-rest-events-portlet.venue/get-venue-detail";
        var getVenueDetailWithImageURL = "flask-rest-events-portlet.venue/get-venue-details-with-images";
        var deleteEventDetailImage = "/flask-rest-events-portlet.event/delete-event-detail-image";
        var getVenueDeviceImageURL = "/flask-rest-events-portlet.venue/get-venue-images-by-venue-id-and-device-type";
        var googleMapURL = SERVER.googleApi;

        var eventServices = {
            getAllEvents: getAllEvents,
            getlocation: getlocation,
            getZiplocation: getZiplocation,
            getEventVenueDatail: getEventVenueDatail,
            getEventByEventId: getEventByEventId,
            addContentDuringEvent:addContentDuringEvent,
            updateEventDetailDuringEvent:updateEventDetailDuringEvent,
            deleteEventDetailById: deleteEventDetailById,
            getAllEventDetailWithImage:getAllEventDetailWithImage,
            getAllVenues: getAllVenues,
            getVenueDetails:getVenueDetails,
            getVenueDetail: getVenueDetail,
            deleteEventDetailImageById: deleteEventDetailImageById,
            getVenueDetailWithImage: getVenueDetailWithImage,
            getVenueDeviceImage: getVenueDeviceImage
        }
        function getAllEvents(eventIds, sDate, eDate, sString, lat, long) {
            return $http.get(SERVER.url + allEventsURL, {
                params: {
                    eventTypeIds: eventIds,
                    startDate: sDate,
                    endDate: eDate,
                    searchString: sString,
                    latitude: lat,
                    longitude: long
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling 
                });
        }
        function getlocation(addressVar, zipcode) {
            return $http.get(googleMapURL + addressVar + zipcode)
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling
                });
        }
        function getZiplocation(latlongVar, lat, long, sensorVar) {
            return $http.get(googleMapURL + latlongVar + lat + ',' + long + sensorVar)
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling
                });
        }
        function getEventVenueDatail(currEventId) {
            return $http.get(SERVER.url + getEvent_Venue_Details_with_Images, {
                    params: { 'eventId': currEventId }
                }
            )
                .then(function success(resp) {
                    return resp;
                },
                function failure(resp) {
                    console.log("Error Message");
                });
        }

        function getEventByEventId(eventId) {
            return $http.get(SERVER.url + getEventByIdURL, {
                params: { 'eventId': eventId }
            })
                .then(function success(resp) {
                    return resp;
                },
                function failure(resp) {
                    console.log("Error Message");
                });

        }
        function addContentDuringEvent(infoTitle,infoDesc,eventId,infoTypeCategoryId,infoTypeId) {
            return $http.get(SERVER.url + addContentDuringGameUrl, {
                params: {
                    "eventId": eventId,
                    "infoTypeId":infoTypeId ,
                    "infoTypeCategoryId": infoTypeCategoryId,
                    infoTitle: infoTitle,
                    "infoShortDesc": '',
                    "infoDesc": infoDesc,
                    "addrLine1": '',
                    "addrLine2": '',
                    "zipCode": '',
                    "city": '',
                    "stateId":0 ,
                    "countryId": 0,
                    "latitude": '',
                    "longitude": '',
                    "phone": '',
                    "mobileAppName": '',
                    "website": '',
                    "cost": 0,
                    "hoursOfOperation": '',
                    "showDescription": true

                }
            })
                .then(function success(resp) {
                    return resp;
                },
                function failure(resp) {
                    console.log("Error Message");
                });

        }
        function updateEventDetailDuringEvent(infoTitle,infoDesc,eventId,eventDetailId,infoTypeCategoryId,infoTypeId) {
            return $http.get(SERVER.url + updateEventDuringGame, {
                params: {eventDetailId: eventDetailId,
                    infoTypeId: infoTypeId,
                    infoTypeCategoryId: infoTypeCategoryId,
                    infoTitle: infoTitle,
                    infoShortDesc: '',
                    infoDesc: infoDesc,
                    addrLine1: '',
                    addrLine2: '',
                    zipCode: '',
                    city: '',
                    stateId: 0,
                    countryId: 0,
                    latitude: '',
                    longitude: '',
                    phone: '',
                    mobileAppName: '',
                    website: '',
                    cost: 0,
                    hoursOfOperation: '',
                    showDescription: true}
            })
                .then(function success(resp) {
                    return resp;
                },
                function failure(resp) {
                    console.log("Error Message");
                });

        }
        function deleteEventDetailById(eventDetailId) {
            return $http.get(SERVER.url + deleteEventDetailUrl, {
                params: {"eventDetailId":eventDetailId}
            })
                .then(function success(resp) {
                    return resp;
                },
                function failure(resp) {
                    console.log("Error Message");
                });

        }
        function deleteEventDetailImageById(eventDetailImageId) {
            return $http.get(SERVER.url + deleteEventDetailImage, {
                params: {"eventDetailImageId":eventDetailImageId}
            })
                .then(function success(resp) {
                    return resp;
                },
                function failure(resp) {
                    console.log("Error Message");
                });

        }

        // Get All venues for event details
        function getAllVenues() {
            return $http.get(SERVER.url + getAllVenuesURL)
                .then(function success(resp) {
                    return resp.data;
                },
                function failure(resp) {
                    console.log("Error Message");
                });
        }
        //get all event detail with image
        function getAllEventDetailWithImage(eventId) {
            return $http.get(SERVER.url + getAllEventDetailWithImageUrl,{
                params: {eventId:eventId}})
                .then(function success(resp) {
                    return resp.data;
                },
                function failure(resp) {
                    console.log("Error Message");
                });
        }
        // Get venue by id for event details
        function getVenueByid(vid) {
            return $http.get(SERVER.url + getVenuesByIdURL, {
                params: { "venueId ": venueId }
            })
                .then(function success(resp) {
                    return resp.data;
                },
                function failure(resp) {
                    console.log("Error Message");
                });
        }

        function getVenueDetails(venueId) {
            return $http.get(SERVER.url + getVenueDetailsURL, {
                params: { "venueId": venueId }
            })
                .then(function success(resp) {
                    return resp.data;
                },
                function failure(resp) {
                    console.log("Error Message");
                });
        }

        function getVenueDetail(venueDetailId) {
            return $http.get(SERVER.url + getVenueDetailURL, {
                params: { "venueDetailId ": venueDetailId }
            })
                .then(function success(resp) {
                    return resp.data;
                },
                function failure(resp) {
                    console.log("Error Message");
                });
        }

        function getVenueDetailWithImage(venueId) {
            return $http.get(SERVER.url + getVenueDetailWithImageURL, {
                params: { "venueId ": venueId }
            })
                .then(function success(resp) {
                    return resp.data;
                },
                function failure(resp) {
                    console.log("Error Message");
                });
        }
        //get venue image as per device
        function getVenueDeviceImage(venueId, deviceType, aspectRatio) {
            return $http.get(SERVER.url + getVenueDeviceImageURL, {
                params: {
                    "venueId": venueId,
                    "deviceType": deviceType,
                    "aspectRatio": aspectRatio
                }
            })
                .then(function success(resp) {
                    return resp.data;
                },
                function failure(resp) {
                    console.log("Error Message");
                });
        }

        return eventServices;
    }
})();