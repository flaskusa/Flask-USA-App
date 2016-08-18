(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('myEventService', myEventService);

    myEventService.$inject = ['$http', 'SERVER'];

    function myEventService($http, SERVER) {
        var baseURL = SERVER.url;
        var allEventURL = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var myEventsURL = "flask-rest-events-portlet.event/get-user-selected-events";
        var addUserEventURL = "flask-rest-events-portlet.event/add-user-event";
        var removeUserEventURL = "flask-rest-events-portlet.event/remove-user-event";

        this.getAllEvents = getAllEvents

        function getAllEvents() {
            return $http.get(baseURL + allEventURL, {
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

        this.getMyEvents = function() {           
            return $http.get(baseURL + myEventsURL)
            .then(function success(response) {
                console.log(response);
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }

        this.addUserEvent = function(eId) {
            return $http.get(baseURL + addUserEventURL, {
                params:{eventId:eId}
            })
            .then(function success(response) {
                return response;
            }, function failure(response) {
            });
        }

        this.removeUserEvent = function (removeEventid) {
            return $http.get(baseURL + removeUserEventURL, {
                params: { eventId: removeEventid }
            })
            .then(function success(response) {
                return response;
            }, function failure(response) {
            });
        }
    }
})();