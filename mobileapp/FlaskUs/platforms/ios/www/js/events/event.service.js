
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('EventsService', EventsService);

    EventsService.$inject = ['$http', 'SERVER'];

    function EventsService($http, SERVER) {
        var baseURL = SERVER.url;
        var allEventsURL = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var addEventURL = "flask-rest-events-portlet.event/add-event";
        var addEventdetailsURL = "flask-rest-events-portlet.event/add-event-detail";
        var getFilteredEvents = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var getEvent_Venue_Details_with_Images = "flask-rest-events-portlet.event/get-event-venue-details-with-images";
        var getEventByIdURL = "flask-rest-events-portlet.event/get-event";
        var googleMapURL = SERVER.googleApi;

        var eventServices = {
            getAllEvents: getAllEvents,
            getlocation: getlocation,
            getZiplocation: getZiplocation,
            getEventVenueDatail: getEventVenueDatail,
            getEventByEventId: getEventByEventId
        }
        function getAllEvents(eventIds, sDate, eDate, sString, lat, long) {
            return $http.get(baseURL + allEventsURL, {
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
            return $http.get(baseURL + getEvent_Venue_Details_with_Images, {
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
            return $http.get(baseURL + getEventByIdURL, {
                params: { 'eventId': eventId }
            })
            .then(function success(resp) {
                return resp;
            },
            function failure(resp) {
                console.log("Error Message");
            });

        }
        return eventServices;
    }
})();