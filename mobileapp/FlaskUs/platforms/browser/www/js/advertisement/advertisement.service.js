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
        function getAllAdvertisementDetail(allEventId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getAdvertisementDetailUrl, {
                params: { eventIdList: allEventId }
            })
            .then(function (resp) {
                deferred.resolve(resp.data);
            }, function (reason) {
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        return advertisementServices;
    }
})();