(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('AdvertisementService', AdvertisementService);

    AdvertisementService.$inject = ['$http', 'SERVER'];

    function AdvertisementService($http, SERVER) {
        var baseURL = SERVER.url;

    }
})();