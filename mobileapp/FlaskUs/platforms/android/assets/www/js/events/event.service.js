
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('EventsService', EventsService);

    EventsService.$inject = ['$http','REST_API'];

    function EventsService($http, REST_API) {
        var baseURL = REST_API.url;
        var allEventsURL = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var addEventURL = "flask-rest-events-portlet.event/add-event";
        var addEventdetailsURL = "flask-rest-events-portlet.event/add-event-detail";
        var getFilteredEvents = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var getEvent_Venue_Details_with_Images = "flask-rest-events-portlet.event/get-event-venue-details-with-images";

        this.getAllEvents = getAllEvents;
        this.getVenueImages = getVenueImages;
        function getAllEvents() {
            return $http.get(baseURL + allEventsURL, {
                params: {
                    eventTypeIds: '',
                    startDate: '',
                    endDate: '',
                    searchString: 'a',
                    latitude: '',
                    longitude: ''
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling 
                });
        }
        this.getfilteredEvents = getfilteredEvents;
        function getfilteredEvents(data1,data2) {
            return $http.get(baseURL + allEventsURL, {
                params: {
                    eventTypeIds: '',
                    startDate: '',
                    endDate: '',
                    searchString: '',
                    latitude: data1,
                    longitude: data2
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling 
                });
        }

        function getVenueImages(currEventId) {
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
    }
})();