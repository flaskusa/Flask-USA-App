(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('myEventService', myEventService);

    myEventService.$inject = ['$http', 'REST_API'];

    function myEventService($http, REST_API) {
        var baseURL = REST_API.url;
        //var allEventURL = "flask-user-tailgate-portlet.tailgateinfo/get-all-tailgate";
        var myEventsURL = "flask-rest-events-portlet.event/get-user-selected-events";

        //this.getAllevents = getAllevents

        //function getAllevents() {
        //    return $http.get(baseURL + allEventURL)
        //        .then(function success(response) {
        //            return response;
        //        }, function failure(response) {
        //            //add errror handling 
        //        });
        //}

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
    }
})();