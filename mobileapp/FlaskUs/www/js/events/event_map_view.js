(function () {
    'use strict';
    angular.module('flaskApp')
            .controller('eventMapViewCtrl', eventMapViewCtrl);

    eventMapViewCtrl.$inject = ['$scope', '$stateParams', '$state','EventsService', '$ionicSlideBoxDelegate', '$ionicScrollDelegate'];

    /* @ngInject */
    function eventMapViewCtrl($scope, $stateParams, $state, EventsService, $ionicSlideBoxDelegate, $ionicScrollDelegate) {
        /* jshint validthis: true */
        var self = this;
        
    }
})(); 