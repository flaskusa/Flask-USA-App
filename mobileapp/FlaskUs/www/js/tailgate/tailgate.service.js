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
        function getMyTailgates(uId) {
           
            return $http.get(baseURL + myTailgatesURL, {
                params: { 'userId': uId }
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