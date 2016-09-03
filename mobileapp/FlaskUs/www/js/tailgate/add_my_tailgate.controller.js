(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', 'TailgateService', '$cordovaDatePicker', '$timeout', '$ionicSlideBoxDelegate', '$ionicScrollDelegate'];

    /* @ngInject */
    function add_mytailgateCtrl($scope, TailgateService, $cordovaDatePicker, $timeout, $ionicSlideBoxDelegate, $ionicScrollDelegate) {
        //for adding tailgate
        $ionicSlideBoxDelegate.update();
        $ionicScrollDelegate.resize()
        var self = this;

        $scope.pageFlow = {
            disableOtherTabs : true
        }

        $scope.pageFlow.disableOtherTabs = false;

        getallEventnames();
        $scope.addmyTailgate = function (tailgatedata) {
            console.log(tailgatedata);
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
                console.log(respData.data.exception);
            });
        }

        $scope.getvenuefromSelect = function (tailgatedata) {
            console.log(tailgatedata);
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
                console.log(respData.data.exception);
            });
        }

        $scope.Details = [];
        $scope.eventDetails = [];
        $scope.eventNames = [];
        function getallEventnames() {
            TailgateService.getallEvents().then(function (respData) {
                console.log(respData.data.Events);
                $scope.eventDetails = respData.data.Events;
                var len = $scope.eventDetails.length - 1;
                for (var i = 0; i <= len; i++) {
                    if ($scope.eventNames.indexOf($scope.eventDetails[i].eventName) == -1) {
                        $scope.eventNames.push({ 'eventName': $scope.eventDetails[i].eventName, 'eventId': $scope.eventDetails[i].eventId })
                    }
                }
                console.log($scope.eventNames);
            });            
        }

        $scope.slideHasChanged = function ($index) {
            if ($index === 0) {
            }
        };
    }
})();

