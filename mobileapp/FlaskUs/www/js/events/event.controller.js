(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('EventsCtrl', EventsCtrl);

    EventsCtrl.$inject = ['$scope', 'EventsService'];


    /* @ngInject */
    function EventsCtrl($scope, EventsService) {
        /* jshint validthis: true */
        var self = this;
        $scope.allEvents = [];

        getAllEvents();

        function getAllEvents() {
            EventsService.getAllEvents().then(function (respData) {
                $scope.allEvent = respData.data.Events;
            });
        }
    }
})();

