(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', 'TailgateService', '$cordovaDatePicker', '$timeout', '$ionicSlideBoxDelegate', '$ionicScrollDelegate', '$filter'];

    / @ngInject /
    function add_mytailgateCtrl($scope, TailgateService, $cordovaDatePicker, $timeout, $ionicSlideBoxDelegate, $ionicScrollDelegate, $filter) {
        //for adding tailgate
        var self = this;
        $scope.CurrEvent = [];
        $scope.addTailgateParams = {
            tailgateName: '',
            tailgateDescription: '',
            eventId: '',
            eventName: '',
            venmoAccountId: '',
            amountToPay: ''
        }

        $scope.pageFlow = {
            disableOtherTabs: true
        }

        $scope.pageFlow.disableOtherTabs = false;

        getallEventnames();

        $scope.LoadSessionData = function () {
            var EventId = 0;
            var shownVal = document.getElementById("envtName").value;
            var EventCol = document.querySelector("#EventNameList option[value='" + shownVal + "']");
            if (EventCol == null) {
                EventId = 0;
            } else {
                EventId = EventCol.getAttribute("data_Id");
            }
            $scope.addTailgateParams.eventId = EventId;
            getEventDetails(EventId);
        }
        function getEventDetails(eventId) {
            TailgateService.getEvent(eventId).then(function (respData) {
                console.log(respData.data);
                $scope.CurrEvent = respData.data;
                var currStartTime = new Date($filter('date')($scope.CurrEvent.startTime, "MM-dd-yyyy HH:mm"));
                var currEndTime = new Date($filter('date')($scope.CurrEvent.endTime, "MM-dd-yyyy HH:mm"));
                var currDate = new Date($filter('date')($scope.CurrEvent.eventDate, "MM-dd-yyyy HH:mm"));
                $scope.addTailgateParams.startTime = currStartTime;
                $scope.addTailgateParams.endTime = currEndTime;
                $scope.addTailgateParams.tailgateDate = currDate;
                $scope.isavail = true;
            });

        }
        $scope.isavail = false;
        $scope.addmyTailgate = function (tailgatedata) {
            console.log(tailgatedata);
            tailgatedata.tailgateDate = new Date(tailgatedata.tailgateDate).getTime();
            tailgatedata.endTime = new Date(tailgatedata.endTime).getTime();
            tailgatedata.startTime = new Date(tailgatedata.startTime).getTime();
            console.log($scope.tailgatedata);
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
                console.log(respData.data);
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
            });
        }

        $scope.slideHasChanged = function ($index) {
            if ($index === 0) {
            }
        };
    }
})();