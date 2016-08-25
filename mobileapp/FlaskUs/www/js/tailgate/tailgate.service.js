(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('TailgateService', TailgateService);

    TailgateService.$inject = ['$http', 'SERVER'];

    function TailgateService($http, SERVER) {
        var baseURL = SERVER.url;
        var allTailgateURL = "flask-user-tailgate-portlet.tailgateinfo/get-all-tailgate";
        var myTailgatesURL = "flask-user-tailgate-portlet.tailgateinfo/get-all-my-tailgate";
        var getTailgateImagesURL = "flask-user-tailgate-portlet.tailgateimages/get-tailgate-images";
        var getTailGateURL = "flask-user-tailgate-portlet.tailgateinfo/get-tailgate";
        var geteventURL = "flask-rest-events-portlet.event/get-event";

        var tailgateServices = {
            getEvent :getEvent,
            getAllTailgate: getAllTailgate,
            getMyTailgates: getMyTailgates,
            getTailgate : getTailgate,
            getMyTailgateImages: getMyTailgateImages
        }

        function getEvent(eventId) {
            return $http.get(baseURL + geteventURL, {
                params: { 'eventId': eventId }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }

        function getAllTailgate() {
            return $http.get(baseURL + allTailgateURL)
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling 
                });
        }

        function getMyTailgates(uId) {           
            return $http.get(baseURL + myTailgatesURL, {
                params: { 'userId': uId }
                }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }
        function getTailgate(tailgateId) {
            return $http.get(baseURL + getTailGateURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }

        function getMyTailgateImages(tailgateId) {
            return $http.get(baseURL + getTailgateImagesURL, {
                params: { 'tailgateId': tailgateId }
                }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }

        return tailgateServices;
    }
})();