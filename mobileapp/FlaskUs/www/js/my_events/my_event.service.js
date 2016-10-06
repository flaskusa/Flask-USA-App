(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('myEventService', myEventService);

    myEventService.$inject = ['$http', 'SERVER'];

    function myEventService($http, SERVER) {
        var allEventURL = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var myEventsURL = "flask-rest-events-portlet.event/get-user-selected-events";
        var addUserEventURL = "flask-rest-events-portlet.event/add-user-event";
        var removeUserEventURL = "flask-rest-events-portlet.event/remove-user-event";

        this.getAllEvents = getAllEvents

        function getAllEvents(eventTypeIds,startDate, endDate, searchString, latitude, longitude) {
            return $http.get(SERVER.url + allEventURL, {
                params: {
                    eventTypeIds: eventTypeIds,
                    startDate: startDate,
                    endDate: endDate,
                    searchString: searchString,
                    latitude: latitude,
                    longitude: longitude
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling 
                });
        }

        this.getMyEvents = function() {           
            return $http.get(SERVER.url + myEventsURL)
            .then(function success(response) {
                console.log(response);
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }

        this.addUserEvent = function(eId) {
            return $http.get(SERVER.url + addUserEventURL, {
                params:{eventId:eId}
            })
            .then(function success(response) {
                return response;
            }, function failure(response) {
            });
        }

        this.removeUserEvent = function (removeEventid) {
            return $http.get(SERVER.url + removeUserEventURL, {
                params: { eventId: removeEventid }
            })
            .then(function success(response) {
                return response;
            }, function failure(response) {
            });
        }
    }
})();