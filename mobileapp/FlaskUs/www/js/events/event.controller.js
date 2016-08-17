(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('EventsCtrl', EventsCtrl);

    EventsCtrl.$inject = ['$scope', 'EventsService', '$cordovaGeolocation', '$http', '$ionicPopup'];

    /* @ngInject */
    function EventsCtrl($scope, EventsService, $cordovaGeolocation, $http, $ionicPopup) {
        /* jshint validthis: true */
        var self = this;
        $scope.allEvents = [];
        var DEFAULT_ZIPCODE = 48226; /*Detroit Zip Code*/
        $scope.eventTypeIds = '';
        $scope.startDate = '';
        $scope.endDate = '';
        $scope.searchString = 'a';
        $scope.latitude = '';
        $scope.longitude = '';
        //getAllEvents();

        var options = { timeout: 10000, enableHighAccuracy: false };

        $cordovaGeolocation.getCurrentPosition(options).then(function (position) {
            var lat = position.coords.latitude;
            var lng = position.coords.longitude;
            console.log(lat, lng);
            ConvertToZip(position)
            var searchstr = '';
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, searchstr, lat, lng).then(function (respData) {
                $scope.allEvent = respData.data.Events;
                if (respData.data.Events.length == 0) {
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
                if (respData.data.Events.length == 0) {
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
            var startDate = new Date();
            $scope.startDate = startDate.setDate(startDate.getDate());
            var endDate = new Date();
            $scope.endDate = endDate.setDate(endDate.getDate() + parseInt(days));
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                $scope.allEvent = respData.data.Events;
                if (respData.data.Events.length == 0) {
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }
            });
        }
        $scope.searchBox = { showBox: false };

        function getLatlongfromZip(zipcode) {
            $http.get('http://maps.googleapis.com/maps/api/geocode/json?address=' + zipcode)
                .then(function (locData) {
                    console.log(locData);
                    $scope.latitude = locData.data.results[0].geometry.location.lat;
                    $scope.longitude = locData.data.results[0].geometry.location.lng;
                    var searchString = '';
                    console.log($scope.latitude, $scope.longitude);
                    EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                        $scope.allEvent = respData.data.Events;
                        $scope.searchBox = { showBox: false };
                        if (respData.data.Events.length == 0) {
                            $scope.Event_Error = true;
                        } else {
                            $scope.Event_Error = false;
                        }
                    });
                }, function (err) {
                });
        }

        function ConvertToZip(pos) {
            $http.get('http://maps.googleapis.com/maps/api/geocode/json?latlng=' + pos.coords.latitude + ',' + pos.coords.longitude + '&sensor=true').then(function (res) {
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

