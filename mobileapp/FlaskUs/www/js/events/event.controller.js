(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('EventsCtrl', EventsCtrl);

    EventsCtrl.$inject = ['$scope', 'EventsService', '$cordovaGeolocation', '$http', '$ionicPopup', 'SERVER', '$filter', '$cookies', '$localStorage','$ionicSlideBoxDelegate','$rootScope'];

    /* @ngInject */
    function EventsCtrl($scope, EventsService, $cordovaGeolocation, $http, $ionicPopup, SERVER, $filter, $cookies, $localStorage,$ionicSlideBoxDelegate,$rootScope) {
        /* jshint validthis: true */
        var self = this;
        $scope.allEvents = [];
        $scope.localstorageData = {};
        $scope.showAddv=false;
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        var DEFAULT_ZIPCODE = 48226; /*Detroit Zip Code*/
        var currentDate = new Date();/*Today's Date*/
        $scope.startDate = $filter('date')(new Date(), 'yyyy-MM-dd ');
        currentDate.setDate(currentDate.getDate() - 1 ); /*adding days to today's date*/
        $scope.startDate = $filter('date')(currentDate, 'yyyy-MM-dd');
        $scope.eventTypeIds = '';
        $scope.searchString = 'a';
        $scope.latitude = '42.34';
        $scope.longitude = '83.0456';
        currentDate.setDate(currentDate.getDate() + 60); /*adding days to today's date*/
        $scope.endDate = $filter('date')(currentDate, 'yyyy-MM-dd');
        $scope.current_time = currentDate.getTime();
        $scope.constant_time = currentDate.getTime();
        $scope.constant_time += 60 * 60 * 1000;
        $scope.storedTime = '';
        $scope.vId = [];
        $scope.city = [];
        $scope.venuesId = [];
        var location = 'geolocation';
        $scope.searchstringList = {
            searchString: '',
            days: '60'
        };
        var searchStringList=angular.copy($scope.searchstringList);
        $scope.allEventId=[];
            getAllEventDetail()

        // $scope.localstorageData = $localStorage.getObject('user_location_data');
        // Retrieve the object from ng-storage
        $rootScope.$on("LocationOptionSelected", function(){
            //do something
            getAllEventDetail();
        });

        function getAllEventDetail(){
            if($localStorage.things) {
                $scope.localstorageData = $localStorage.things;
                $scope.storedTime = $scope.localstorageData.timestamp;
            }
            console.log($scope.localstorageData);

            if ($scope.localstorageData.latitude!=undefined && $scope.localstorageData.latitude!="" && $scope.localstorageData.longitude!="") {
                get_from_localStorage();

            } else {
                get_event_list();
            }
        }

        function get_event_list() {
            getVenueName();
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                console.log(respData);
                $scope.allEvent = respData.data.Events;
                for (var i = 0; i < $scope.allEvent.length; i++) {
                    $scope.vId.push($scope.allEvent[i].venueId);
                    $scope.allEventId.push($scope.allEvent[i].eventId)
                }
                $cookies.put("AllEventId",$scope.allEventId);
                $scope.showAddv=true;
                if ($scope.allEvent.length == 0) {
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }                
            });
        }

        //Get venue name for event details
        function getVenueName() {
            EventsService.getAllVenues().then(function (respData) {
                $scope.allVenues = respData;
                $cookies.putObject("eventVenues",$scope.allVenues);
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

        //Get venue name for event details
        $scope.getVenueNameForVenueId  = function (venueId) {
            var venueCity = ""
            if ($scope.allVenues == undefined) {
                return "";
            }
            for (var i = 0; i < $scope.allVenues.length; i++) {
                if( $scope.allVenues[i].venueId == venueId){
                    venueCity = $scope.allVenues[i].venueCity;
                    return venueCity;
                }
            }
            return venueCity;
        }

        function get_from_localStorage() {
            getVenueName();
            $scope.latitude = $scope.localstorageData.latitude;
            $scope.longitude = $scope.localstorageData.longitude;
            ConvertToZip($scope.latitude, $scope.longitude);
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                console.log(respData);
                $scope.allEvent = respData.data.Events;
                for (var i = 0; i < $scope.allEvent.length; i++) {
                    $scope.vId.push($scope.allEvent[i].venueId);
                    $scope.allEventId.push($scope.allEvent[i].eventId)
                }
                $cookies.put("AllEventId",$scope.allEventId);
                $scope.showAddv=true;
                if ($scope.allEvent && $scope.allEvent.length==0) {
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
                if($scope.searchString==""){
                    $scope.searchString="a";
                }
                    EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (resp) {
                        $scope.allEvent = resp.data.Events;
                        if ($scope.allEvent.length == 0) {
                            $scope.Event_Error = true;
                        } else {
                            $scope.Event_Error = false;
                        }
                    });
            });
            $("#searchChip").show();
        }

        /*
        Function for clearing the search results
        */
        $scope.clearSearchResults = function () {
            $("#searchChip").hide();
            $scope.searchstringList.searchString = null;
            $scope.searchstringList.days = "60";
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, 'a', $scope.latitude, $scope.longitude).then(function (resp) {
                $scope.allEvent = resp.data.Events;
                if ($scope.allEvent.length == 0) {
                    $scope.Event_Error = true;
                } else {
                    $scope.Event_Error = false;
                }
            });
        };

        function ConvertToZip(latitude,longitude) {
            var latlongVar = 'latlng=';
            var sensorVar = '&sensor=true';
            var My_Zip=""
                EventsService.getZiplocation(latlongVar, latitude, longitude, sensorVar).then(function (res) {
                if (res.data.results[0]) {
                    for (var i = 0; i < res.data.results[0].address_components.length; i++) {
                        var postalCode = res.data.results[0].address_components[i].types;
                        if (postalCode == "postal_code") {
                            My_Zip = res.data.results[0].address_components[i].long_name;
                        }
                    }
                }
                $scope.searchstringList = angular.copy(searchStringList);
            });
        }
    }
})();

