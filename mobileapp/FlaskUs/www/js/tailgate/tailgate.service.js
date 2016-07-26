(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('TailgateService', TailgateService);

    TailgateService.$inject = ['$http'];

    function TailgateService($http) {
        var baseURL = "http://test@liferay.com:test@146.148.83.30/api/jsonws";
        var allTailgateURL = "/flask-user-tailgate-portlet.tailgateinfo/get-all-tailgate";
        var myTailgatesURL = "/flask-user-tailgate-portlet.tailgateinfo/get-all-my-tailgate";

        this.getAllTailgate = getAllTailgate

        function getAllTailgate() {
            return $http.get(baseURL + allTailgateURL)
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling 
                });
        }

        this.getMyTailgates = getMyTailgates

        function getMyTailgates() {
            return $http.get(baseURL + myTailgatesURL, {
                params: { 'userId': '20198' }
                }
            )
            .then(function success(response) {
                console.log(response);
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }
    }
})();