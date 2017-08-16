(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('AdvertisementService', AdvertisementService);

    AdvertisementService.$inject = ['$http', 'SERVER','$cookies','$timeout','$q'];

    function AdvertisementService($http, SERVER, $cookies, $timeout, $q) {
        // var baseURL = SERVER.url;

        var getAdvertisementDetailUrl="flask-advertisement-portlet.campaignevent/get-event-campaign-images";
        var advertisementServices = {
            getAllAdvertisementDetail: getAllAdvertisementDetail
        }
        function getAllAdvertisementDetail(allEventId){
            return $http.get(SERVER.url + getAdvertisementDetailUrl, {
                params: {eventIdList:allEventId}
            })
                .then(function success(resp) {
                    return resp.data;
                },
                function failure(resp) {
                    console.log("Error Message");
                    return $q.$inject(resp);
                });
        }

        return advertisementServices;
    }
})();