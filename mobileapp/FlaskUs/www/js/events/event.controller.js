(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('EventsCtrl', EventsCtrl);

    EventsCtrl.$inject = ['$scope', 'EventsService', '$cordovaGeolocation', '$http', '$ionicPopup', 'SERVER', '$filter', '$cookies', '$localStorage'];

    /* @ngInject */
    function EventsCtrl($scope, EventsService, $cordovaGeolocation, $http, $ionicPopup, SERVER, $filter, $cookies, $localStorage) {
        /* jshint validthis: true */
        var self = this;
        $scope.allEvents = [];
        $scope.localstorageData = [];
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
        $scope.current_time = currentDate.getTime();
        $scope.constant_time = currentDate.getTime();
        $scope.constant_time += 60 * 60 * 1000;
        $scope.storedTime = '';
        $scope.vId = [];
        $scope.city = [];
        $scope.venuesId = [];
        $scope.searchstringList = {
            searchString: 'a',
            days: '60'
        };


        // $scope.localstorageData = $localStorage.getObject('user_location_data');
        // Retrieve the object from ng-storage  
        $scope.localstorageData = $localStorage.things;
        //
        console.log($scope.localstorageData);
        console.log('stored time', $scope.storedTime);
        function islocalstorageEmpty() {
            if ($scope.localstorageData && $scope.localstorageData.length) {
                return false;
            }
            //
        }

        function isExpired() {
            if ($scope.constant_time < $scope.current_time - $scope.storedTime) {
                return false;
            }
        }

        if (islocalstorageEmpty() && isExpired()) {
            get_from_localStorage();
            $scope.storedTime = $scope.localstorageData.timestamp;
        } else {
            get_event_list();
        }

        function get_event_list(){
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                console.log(respData);
                $scope.allEvent = respData.data.Events;
                for (var i = 0; i < $scope.allEvent.length; i++) {
                    $scope.vId.push($scope.allEvent[i].venueId);
                }
                if ($scope.allEvent.length == 0) {
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }
                getVenueName();
            });
        }

        //Get venue name for event details
        function getVenueName() {
            EventsService.getAllVenues().then(function (respData) {
                console.log(respData);
                $scope.allVenues = respData;
                for (var i = 0; i < $scope.allVenues.length; i++) {
                    $scope.venuesId.push($scope.allVenues[i].venueId);
                }
                for (var j = 0; j < $scope.vId.length; j++) {
                    if ($scope.venuesId[j] == $scope.vId[j]) {
                            $scope.city.push({cityName:$scope.allVenues[j].venueCity});
                    }
                }

            });
        }

        function get_from_localStorage() {
            $scope.latitude = $scope.localstorageData.coords.latitude;
            $scope.longitude = $scope.localstorageData.coords.longitude;
            ConvertToZip($scope.latitude, $scope.longitude);
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                console.log(respData);
                $scope.allEvent = respData.data.Events;
                if ($scope.allEvent && $scope.allEvent.length) {
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }
            });
        }

        $scope.searchBox = { showBox: false };
        $scope.locationList = [];
        $scope.get_data_from_search = function (searchstringList) {
            $scope.searchBox = { showBox: false };
            var addressVar = 'address=';
            var setEndDate = new Date();
            var endDate = setEndDate.setDate(setEndDate.getDate() + parseInt(searchstringList.days));
            $scope.endDate = $filter('date')(setEndDate, 'yyyy-MM-dd h:mm');
            $scope.searchString = searchstringList.searchString;
            EventsService.getlocation(addressVar, searchstringList.zipcode).then(function (respData) {
                $scope.locationList = respData.data.results[0].geometry.location;
                $scope.latitude = $scope.locationList.lat;
                $scope.longitude = $scope.locationList.lng;
                EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (resp) {
                    $scope.allEvent = resp.data.Events;
                    if ($scope.allEvent.length ==0) {
                        $scope.Event_Error = true;
                    } else {
                        $scope.Event_Error = false;
                    }
                });

            });
        }        

        function ConvertToZip(latitude,longitude) {
            var latlongVar = 'latlng=';
            var sensorVar = '&sensor=true';
            EventsService.getZiplocation(latlongVar, latitude, longitude, sensorVar).then(function (res) {
                if (res.data.results[0]) {
                    for (var i = 0; i < res.data.results[0].address_components.length; i++) {
                        var postalCode = res.data.results[0].address_components[i].types;
                        if (postalCode == "postal_code") {
                            var My_Zip = res.data.results[0].address_components[i].long_name;
                        }
                    }
                }
                $scope.searchstringList = {
                    searchString :'a',
                    days : '60',
                    zipcode: My_Zip
                };
            });
        }
    }
})();

