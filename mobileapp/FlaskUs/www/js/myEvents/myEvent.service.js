(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('myEventService', myEventService);

    myEventService.$inject = ['$http', 'REST_API'];

    function myEventService($http, REST_API) {
        var baseURL = REST_API.url;
        var allEventURL = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var myEventsURL = "flask-rest-events-portlet.event/get-user-selected-events";
        var addUserEventURL = "flask-rest-events-portlet.event/add-user-event";

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

        this.getMyEvents = getMyEvents
        function getMyEvents() {
           
            return $http.get(baseURL + myEventsURL)
            .then(function success(response) {
                console.log(response);
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }

        this.addUserEvent = addUserEvent
        function addUserEvent(eId) {
            return $http.get(baseURL + addUserEventURL, {
                params:{eventId:eId}
            })
            .then(function success(response) {
                return response;
            }, function failure(response) {
            });
        }
    }
})();