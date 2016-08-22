(function () {
    'use strict';
    angular.module('flaskApp')
            .controller('eventMapViewCtrl', eventMapViewCtrl);

    eventMapViewCtrl.$inject = ['$scope', '$stateParams', '$state','EventsService'];

    /* @ngInject */
    function eventMapViewCtrl($scope, $stateParams, $state, EventsService) {
        /* jshint validthis: true */
        var self = this;
        var eventDetails = angular.toJson($stateParams.eventDetails.Event);
        var eventObj = angular.fromJson($stateParams.eventDetails.Event);
        $scope.eventName = eventObj.eventName;
        console.log(JSON.stringify($stateParams));
    }
})(); 