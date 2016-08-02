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
        $scope.Details = [];
        $scope.INFO_TYPE = [];
        $scope.INFO_TYPE_CATEGORY = [];
        $scope.Pre_Game = [];
        $scope.Post_Game = [];
        $scope.During_Game = [];
        console.log($stateParams);
        $scope.currEventName = $stateParams.eventName;
        $scope.currEventId = $stateParams.eventId;
        var currEventId = $scope.currEventId;
        console.log(currEventId);
        getAllVenuImages();

        function getAllVenuImages() {
            EventsService.getVenueImages(currEventId).then(function (respData) {
                $scope.currEventData = respData.data.Event;
                $scope.currVenueData = respData.data.Venue;
                var len = respData.data.Details.length - 1;
                for (var i = 0; i <= len; i++) {                    
                    $scope.Details.push(angular.fromJson(respData.data.Details[i].Detail))
                    if ($scope.INFO_TYPE.indexOf($scope.Details[i].infoTypeName) == -1) {
                        $scope.INFO_TYPE.push($scope.Details[i].infoTypeName)
                    }
                }
                for (var i = 0; i <= len; i++) {
                    if ($scope.Details[i].infoTypeName == "Pre-Event") {
                        if ($scope.Pre_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                            $scope.Pre_Game.push($scope.Details[i].infoTypeCategoryName)
                        }
                    }else
                        if ($scope.Details[i].infoTypeName == "Post-Event") {
                            if ($scope.Post_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                                $scope.Post_Game.push($scope.Details[i].infoTypeCategoryName)
                        }
                    } else {
                            if ($scope.During_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                                $scope.During_Game.push($scope.Details[i].infoTypeCategoryName)
                        }
                    }
                    
                }
            });
        }
    }
})(); 