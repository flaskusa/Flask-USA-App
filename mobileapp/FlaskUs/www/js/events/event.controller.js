(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('EventsCtrl', EventsCtrl);

    EventsCtrl.$inject = ['$scope', 'EventsService', '$cordovaGeolocation', '$http', '$ionicPopup', 'SERVER', '$filter'];

    /* @ngInject */
    function EventsCtrl($scope, EventsService, $cordovaGeolocation, $http, $ionicPopup, SERVER, $filter) {
        /* jshint validthis: true */
        var self = this;
        $scope.allEvents = [];
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        var DEFAULT_ZIPCODE = 48226; /*Detroit Zip Code*/
        var currentDate = new Date();/*Today's Date*/
        $scope.startDate = $filter('date')(new Date(), 'yyyy-MM-dd h:mm');
        currentDate.setDate(currentDate.getDate() - 1 ); /*adding days to today's date*/
        $scope.startDate = $filter('date')(currentDate, 'yyyy-MM-dd h:mm');
        $scope.eventTypeIds = '';
        $scope.searchString = 'a';
        $scope.latitude = '42.34';
        $scope.longitude = '83.0456';
        currentDate.setDate(currentDate.getDate() + 60); /*adding days to today's date*/
        $scope.endDate = $filter('date')(currentDate, 'yyyy-MM-dd h:mm');

        var options = { timeout: 10000, enableHighAccuracy: false };

        $cordovaGeolocation.getCurrentPosition(options).then(function (position) {
            var lat = position.coords.latitude;
            var lng = position.coords.longitude;
            console.log(lat, lng);
            ConvertToZip(position)
            var searchstr = '';
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, lat, lng).then(function (respData) {
                $scope.allEvent = respData.data.Events;
                if ($scope.allEvent.length == 0) {
                    console.log("Empty");
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }
            });
        }, function (error) {
            console.log("Could not get location");            
            $scope.getAllfilteredEvents(DEFAULT_ZIPCODE);
        });

        function getAllEvents() {
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString,$scope.latitude,$scope.longitude).then(function (respData) {
                $scope.allEvent = respData.data.Events;
                if ($scope.allEvent.length == 0) {
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }
            });
        }
        
        $scope.getAllfilteredEvents = function (zipcode) {
            if (zipcode == undefined || zipcode == "") {
                getLatlongfromZip(DEFAULT_ZIPCODE);
            } else {
                getLatlongfromZip(zipcode);
            }                  
        }      

        $scope.filterDate = function (days) {
            var setEndDate = new Date();            
            var endDate = setEndDate.setDate(setEndDate.getDate() + parseInt(days));
            $scope.endDate = $filter('date')(setEndDate, 'yyyy-MM-dd h:mm');
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                $scope.allEvent = respData.data.Events;
                $scope.searchBox = { showBox: false };
                if ($scope.allEvent.length == 0) {
                    console.log("Empty");
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }
            });
        }
        $scope.searchBox = { showBox: false };

        function getLatlongfromZip(zipcode) {
            var addressVar = 'address=';
            EventsService.getlocation(addressVar, zipcode).then(function (respData) {
                $scope.latitude = respData.data.results[0].geometry.location.lat;
                $scope.longitude = respData.data.results[0].geometry.location.lng;
                console.log($scope.latitude, $scope.longitude);
                var searchString = '';
                EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                    $scope.allEvent = respData.data.Events;
                    $scope.searchBox = { showBox: false };
                    if ($scope.allEvent.length == 0) {
                        $scope.Event_Error = true;
                    } else {
                        $scope.Event_Error = false;
                    }
                });
            });
        }

        function ConvertToZip(pos) {
            var latlongVar = 'latlng=';
            var sensorVar = '&sensor=true';
            EventsService.getZiplocation(latlongVar, pos.coords.latitude, pos.coords.longitude, sensorVar).then(function (res){
                if (res.data.results[0]) {
                    for (var i = 0; i < res.data.results[0].address_components.length; i++) {
                        var postalCode = res.data.results[0].address_components[i].types;
                        if (postalCode == "postal_code") {
                            var My_Zip = res.data.results[0].address_components[i].long_name;
                        }
                    }
                }
                $scope.eventList = {
                    zipcode: My_Zip
                };
            });
        }
    }
})();

