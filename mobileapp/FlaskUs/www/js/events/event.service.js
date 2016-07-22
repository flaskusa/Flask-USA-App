
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('EventsService', service);

    service.$inject = ['$http'];

    function service($http) {
        var baseURL = "http://localhost:8080/api/jsonws/";
        var allEventsURL = "flask-rest-events-portlet.event/get-all-events";

        this.getAllEvents = getAllEvents;

        function getAllEvents() {
            return $http.get(baseURL + allEventsURL)
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling 
                });

        }
    }
})();