
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('EventsService', EventsService);

    EventsService.$inject = ['$http','REST_API'];

    function EventsService($http, REST_API) {
        var baseURL = REST_API.url;
        var allEventsURL = "/flask-rest-users-portlet.flaskadmin/get-flask-regular-users";

        this.getAllEvents = getAllEvents;

        function getAllEvents() {
            return $http.get(baseURL + allEventsURL)
                .then(function success(response) {
                    console.log(response);
                    return response;
                }, function failure(response) {
                    console.log(response);
                    //add errror handling 
                });

        }
    }
})();