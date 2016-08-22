(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('EventsCtrl', EventsCtrl);

    EventsCtrl.$inject = ['$scope', 'EventsService', '$cordovaGeolocation', '$http', '$ionicPopup', 'SERVER', '$filter', '$cookies'];

    /* @ngInject */
    function EventsCtrl($scope, EventsService, $cordovaGeolocation, $http, $ionicPopup, SERVER, $filter, $cookies) {
        /* jshint validthis: true */
        var self = this;
        $scope.allEvents = [];
        $scope.get_geolocation_data ;
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
        var current_time = currentDate.getTime();
        var constant_time = currentDate.getTime();
        constant_time += 60 * 60 * 1000;
        $scope.storedTime = '';

        $scope.get_geolocation_data = $cookies.getObject('user_location_data');
        console.log($scope.timestamp);

        if (isLocationStored && isExpired) {
            getEventList();
        } else {
            get_event_list_from_cookie($scope.get_geolocation_data.coords);
            $scope.storedTime = $scope.get_geolocation_data.timestamp;
            $scope.latitude = $scope.get_geolocation_data.coords.latitude;
            $scope.longitude = $scope.get_geolocation_data.coords.longitude;
            ConvertToZip($scope.get_geolocation_data.coords);
        }

        function isLocationStored() {            
            if ($scope.get_geolocation_data.code = "TIMEOUT") {
                return false;
            } else {                
                return true;
            }
        }

        function isExpired(){
            return (constant_time < current_time - storedTime);
        }

        function getEventList() {
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                $scope.allEvent = respData.data.Events;
                if ($scope.allEvent.length == 0) {
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }
            });
        }

        function get_event_list_from_cookie(data) {
            $scope.latitude = data.latitude;
            $scope.longitude = data.longitude;
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString,$scope.latitude,$scope.longitude).then(function (respData) {
                $scope.allEvent = respData.data.Events;
                if ($scope.allEvent.length == 0) {
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }
            });
        }

        $scope.searchBox = { showBox: false };

        $scope.getDatafromsearch = function (searchList) {
            $scope.searchBox = { showBox: false };
            var setEndDate = new Date();
            var endDate = setEndDate.setDate(setEndDate.getDate() + parseInt(searchList.days));
            $scope.endDate = $filter('date')(setEndDate, 'yyyy-MM-dd h:mm');
            $scope.searchString = searchList.searchString;
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (resp) {
                $scope.allEvent = resp.data.Events;                
                if ($scope.allEvent.length == 0) {
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }
            });
        }

        function getLatlongfromZip(zipcode) {
            var addressVar = 'address=';
            $scope.my_data2 = EventsService.getlocation(addressVar, zipcode).then(function (respData) {
                return respData;
            });
           
        }

        function ConvertToZip(pos) {
            var latlongVar = 'latlng=';
            var sensorVar = '&sensor=true';
            EventsService.getZiplocation(latlongVar, pos.latitude, pos.longitude, sensorVar).then(function (res){
                if (res.data.results[0]) {
                    for (var i = 0; i < res.data.results[0].address_components.length; i++) {
                        var postalCode = res.data.results[0].address_components[i].types;
                        if (postalCode == "postal_code") {
                            var My_Zip = res.data.results[0].address_components[i].long_name;
                        }
                    }
                }
                $scope.searchList = {
                    zipcode: My_Zip
                };
            });
        }
    }
})();

