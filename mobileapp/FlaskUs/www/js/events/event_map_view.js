(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('eventMapViewCtrl', eventMapViewCtrl);

    eventMapViewCtrl.$inject = ['$scope', '$stateParams', '$state', '$ionicPlatform', 'EventsService', 'uiGmapGoogleMapApi', '$ionicTabsDelegate', '$timeout'];

    /* @ngInject */
    function eventMapViewCtrl($scope, $stateParams, $state, $ionicPlatform, EventsService, uiGmapGoogleMapApi, $ionicTabsDelegate, $timeout) {
        /* jshint validthis: true */
        var self = this;
        $scope.map = { center: { latitude: 42.3314, longitude: -83.0458 }, zoom: 15 };
        $scope.options = { scrollwheel: false,draggable:true };
        $scope.parkingMarkers = [];
        $scope.barMarkers = [];
        $scope.nightLifes = [];
        $scope.markerOptions = {};
        $scope.isMapMarkersSet = false;
        $scope.pan = true;
        var PRE_EVENT = "Pre-Event";
        var AT_EVENT = "During-Event";
        var POST_EVENT = "Post-Event";
        $scope.infoTypeName = "";
        $scope.infoTypeCategoryName = "";
        $scope.trafficDetails = {};
        $scope.flaskUsDetails = {};
        // $scope.searchbox = {
        //     template: 'searchbox.tpl.html',
        //     events: {
        //         places_changed: function (searchBox) { }
        //     },
        //     options: { bounds: $scope.markers, autocomplete: true }
        // }
        $scope.onClick = function (marker, eventName, model) {
            model.show = !model.show;
        };
        // initMap();
        uiGmapGoogleMapApi.then(function (maps) {
            maps.visualRefresh = true;
            $scope.markerOptions.animation = maps.Animation.DROP;
        })
        function initEventData() {
            try {
                $scope.eventDetails = $stateParams.eventDetails.Details;
                $scope.infoTypeName = setInfoType($stateParams.infoType);
                $scope.infoTypeCategoryName = $scope.setInfoTypeCategory($stateParams.infoTypeCategory);
                var venueObj = angular.fromJson($stateParams.eventDetails.Venue);
                $scope.map.center.latitude = venueObj.latitude;
                $scope.map.center.longitude = venueObj.longitude;
                var eventObj = angular.fromJson($stateParams.eventDetails.Event);
                $scope.eventName = eventObj.eventName;
            } catch (ex) {

            }
        }

        function setInfoType(infoType) {
            switch (infoType) {
                case PRE_EVENT:
                    return PRE_EVENT;
                case AT_EVENT:
                    return AT_EVENT;
                case POST_EVENT:
                    return POST_EVENT
            }
        }
        $scope.setInfoTypeCategory = function (infoTypeCategory) {
            switch (infoTypeCategory) {
                case "Parking":
                    setParkingInfo();
                    return infoTypeCategory;
                case "Bar & Restaurants":
                    setBarInfo();
                    return infoTypeCategory;
                case "Traffic":
                    setTrafficInfo();
                    return infoTypeCategory;
                case "Flask Us":
                    setFlaskUsInfo();
                    return infoTypeCategory;
                case 'Nightlife' :
                    setNightLifeInfo();
                    return infoTypeCategory;
            }
        };
        function setParkingInfo() {
            $timeout(function() {
                $ionicTabsDelegate.select(0);
                $scope.setMarkers();
            },0)
        };
        function setBarInfo() {
             $timeout(function() {
                $ionicTabsDelegate.select(1)
                $scope.setMarkers();
            },0)
        };
        function setTrafficInfo() {
            $timeout(function() {
                $ionicTabsDelegate.select(3)
                $scope.setMarkers();
            },0)
        };
        function setFlaskUsInfo() {
           $timeout(function() {
                $ionicTabsDelegate.select(4)
                $scope.setMarkers();
            },0)
        };
        function setNightLifeInfo() {
            $timeout(function() {
                $ionicTabsDelegate.select(2)
                $scope.setMarkers();
            },0)
        }
        $scope.setMarkers = function () {
            if (!$scope.isMapMarkersSet) {
                var tempObject = {};
                angular.forEach($scope.eventDetails, function (value, index) {
                    tempObject = {};
                    value = angular.fromJson(value);
                    tempObject = angular.fromJson(value.Detail);
                    tempObject.id = index;
                    if ($scope.infoTypeName == tempObject.infoTypeName) {
                        if ("Parking" == tempObject.infoTypeCategoryName || "Bar & Restaurants" == tempObject.infoTypeCategoryName) {
                            $scope.setMarkerFields(tempObject);
                            if ("Parking" == tempObject.infoTypeCategoryName) {
                                $scope.parkingMarkers.push(tempObject);
                            } else {
                                $scope.barMarkers.push(tempObject);
                            }
                        } else if ("Traffic" == tempObject.infoTypeCategoryName) {
                            $scope.trafficDetails = tempObject;
                        } else if ("Flask Us" == tempObject.infoTypeCategoryName) {
                            $scope.flaskUsDetails = tempObject;
                        }
                        else if("Nightlife" == tempObject.infoTypeCategoryName) {
                             $scope.setMarkerFields(tempObject);
                            $scope.nightLifes.push(tempObject);
                        }
                    } else {
                        if("Bar & Restaurants" == tempObject.infoTypeCategoryName) {
                             $scope.setMarkerFields(tempObject)
                             $scope.barMarkers.push(tempObject);
                        }
                    }
                })
                $scope.isMapMarkersSet = true;
            }
        };
        $scope.setMarkerFields = function (tempObject) {
            tempObject.icon = 'img/map_icons/flask_map_icon_11.png';
            tempObject.show = false;
            tempObject.templateUrl = 'markerInfo.tpl.html';
            tempObject.templateParameter = {
                id: tempObject.id,
                infoTitle: tempObject.infoTitle,
                addrLine1: tempObject.addrLine1,
                infoDesc: tempObject.infoDesc //getting a photo externally
            };
        }
        $scope.selectTab = function (index) {
            if (index == 0) { // Parking
                setParkingInfo();
            } else if (index == 1) { // Bars and Restaurants
                setBarInfo();
            } else if (index == 2) {
                setNightLifeInfo(); //Nightlife
            } else if (index == 3) { // Traffic
                setTrafficInfo();
            }else if (index == 4) { // FlaskUs
                setFlaskUsInfo();
            }
        }
        initEventData();
    }
})(); 