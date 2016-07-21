(function() {
    'use strict';
    angular.module('flaskApp', [$scope, EventsService])
        .controller('EventsCtrl', allEvents);

    /* @ngInject */
    function allEvents($scope, EventsService) {
        /* jshint validthis: true */
        var self = this;
        $scope.allEvents = [];

        getAllEvents();

        function getAllEvents() {
            EventsService.getAllEvents().then(function (respData) {
                $scope.allEvent = respData.data;
            });
        }
    }
})();

