(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('AdvertisementService', AdvertisementService);

    AdvertisementService.$inject = ['$http', 'SERVER','$cookies','$timeout'];

    function AdvertisementService($http, SERVER,$cookies,$timeout) {
        var baseURL = SERVER.url;
            var allEventId = $cookies.get('AllEventId');

        var getAdvertisementDetailUrl="/flask-advertisement-portlet.campaignevent/get-event-campaign-images";
        var advertisementServices = {
            getAllAdvertisementDetail: getAllAdvertisementDetail

        }
        function getAllAdvertisementDetail(){
            return $http.get(baseURL + getAdvertisementDetailUrl, {
                params: {eventIdList:allEventId}
            })
                .then(function success(resp) {
                    return resp.data;
                },
                function failure(resp) {
                    console.log("Error Message");
                });
        }

        return advertisementServices;
    }
})();