(function () {
    'use strict';
    angular.module('flaskApp')
            .controller('prePostGameCtrl', prePostGameCtrl);

    prePostGameCtrl.$inject = ['$scope', '$stateParams', 'EventsService', '$ionicSlideBoxDelegate'];

    /* @ngInject */
    function prePostGameCtrl($scope, $stateParams, EventsService, $ionicSlideBoxDelegate) {
        /* jshint validthis: true */
        var self = this;
        $scope.eventInfo = [];
        console.log($stateParams);
        $scope.currEventName = $stateParams.eventName;
        $scope.currEventId = $stateParams.eventId;
        var currEventId = $scope.currEventId;
        console.log(currEventId);
        getAllVenuImages();

        function getAllVenuImages() {
            EventsService.getVenueImages(currEventId).then(function (respData) {
                $scope.currEventData = respData.Event;
            });
        }
    }
})();