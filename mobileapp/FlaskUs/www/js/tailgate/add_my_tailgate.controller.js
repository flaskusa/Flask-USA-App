(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cordovaDatePicker', '$timeout', '$ionicSlideBoxDelegate', '$ionicScrollDelegate', '$filter', '$ionicModal', '$flaskUtil', '$cookies'];

    / @ngInject /
    function add_mytailgateCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cordovaDatePicker, $timeout, $ionicSlideBoxDelegate, $ionicScrollDelegate, $filter, $ionicModal, $flaskUtil, $cookies) {
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
        $scope.map = {
            draggable: true,
            center: { latitude: 43.4651, longitude: -80.5223 },
            zoom: 4
        };
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
                $scope.CurrEvent = respData.data;
                var venueID = $scope.CurrEvent.venueId;
                var currStartTime = new Date($filter('date')($scope.CurrEvent.startTime, "MM-dd-yyyy HH:mm"));
                var currEndTime = new Date($filter('date')($scope.CurrEvent.endTime, "MM-dd-yyyy HH:mm"));
                var currDate = new Date($filter('date')($scope.CurrEvent.eventDate, "MM-dd-yyyy HH:mm"));
                $scope.addTailgateParams.startTime = currStartTime;
                $scope.addTailgateParams.endTime = currEndTime;
                $scope.addTailgateParams.tailgateDate = currDate;
                TailgateService.getvenueDetails(venueID).then(function (VENUEData) {
                    angular.extend($scope, {
                        map: {
                            center: {
                                latitude: 42.3349940452867,
                                longitude: -71.0353168884369
                            },
                            zoom: 11,
                            markers: [],
                            events: {
                                click: function (map, eventName, originalEventArgs) {
                                    var e = originalEventArgs[0];
                                    var lat = e.latLng.lat(), lon = e.latLng.lng();
                                    var marker = {
                                        id: Date.now(),
                                        coords: {
                                            latitude: lat,
                                            longitude: lon
                                        }
                                    };
                                    $scope.map.markers.push(marker);
                                    console.log($scope.map.markers);
                                    $scope.$apply();
                                }
                            }
                        }
                    });
                });
                $scope.isavail = true;
            });
        }

        $scope.isavail = false;
        $scope.addmyTailgate = function (tailgatedata) {
            tailgatedata.tailgateDate = new Date(tailgatedata.tailgateDate).getTime()/1000;
            tailgatedata.endTime = new Date(tailgatedata.endTime).getTime() / 1000 + tailgatedata.tailgateDate;
            tailgatedata.startTime = new Date(tailgatedata.startTime).getTime()/1000;
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
            });
        }

        $scope.getvenuefromSelect = function (tailgatedata) {
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
            });
        }

        $scope.Details = [];
        $scope.eventDetails = [];
        $scope.eventNames = [];
        function getallEventnames() {
            TailgateService.getallEvents().then(function (respData) {
                $scope.eventDetails = respData.data.Events;
            });
        }
        $scope.editTailgate = function (tailgatId) {
            TailgateService.getTailgate(tailgatId).then(function (respData) {
                console.log(respData.data);
                $scope.addTailgateParams = {
                    tailgateName: respData.data.tailgateName,
                    tailgateDescription: respData.data.tailgateDescription,
                    eventId: respData.data.eventId,
                    eventName: respData.data.eventName,
                    endTime: respData.data.endTime,
                    startTime: respData.data.startTime,
                    venmoAccountId: respData.data.venmoAccountId,
                    amountToPay: respData.data.amountToPay
                }
            });
        }

        $scope.leaveTailgate = function () {

        }
    }
})();