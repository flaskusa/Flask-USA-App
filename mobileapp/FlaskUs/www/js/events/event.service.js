
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('EventsService', EventsService);

    EventsService.$inject = ['$http'];

    function EventsService($http) {
        var baseURL = "http://localhost:8080/api/jsonws/";
        var allEventsURL = "flask-rest-events-portlet.event/get-all-events";
        var addEventURL = "/flask-rest-events-portlet.event/add-event";
        var addEventdetailsURL = "/flask-rest-events-portlet.event/add-event-detail";
        var getFilteredEvents = "/flask-rest-events-portlet.event/get-simple-filtered-events";
        var getEventLogo = "/c/document_library/get_file";

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