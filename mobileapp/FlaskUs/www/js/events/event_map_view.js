(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('eventMapViewCtrl', eventMapViewCtrl);

    eventMapViewCtrl.$inject = ['$scope', '$stateParams', '$state', '$ionicPlatform', 'EventsService', 'uiGmapGoogleMapApi', '$ionicTabsDelegate', '$timeout', 'uiGmapIsReady', '$ionicSlideBoxDelegate'];

    /* @ngInject */
    function eventMapViewCtrl($scope, $stateParams, $state, $ionicPlatform, EventsService, uiGmapGoogleMapApi, $ionicTabsDelegate, $timeout, uiGmapIsReady, $ionicSlideBoxDelegate) {
        /* jshint validthis: true */
        var self = this;
        $scope.map = { center: { latitude: 42.3314, longitude: -83.0458 }, zoom: 15, control: {} };
        $scope.map.events = [];
        $scope.map.events["click"] = function () {
            return $scope.closeOtherInfoWindows('mapClick');
        };
        $scope.options = { scrollwheel: false, disableDefaultUI: true, zoomControl: true, streetViewControl: true };
        $scope.parkingMarkers = [];
        $scope.windowOptions = { 'control': {} };
        $scope.barMarkers = [];
        $scope.nightLifes = [];
        $scope.parkingGoogleMarkers = [];
        $scope.tempParkingGoogleMarkers = [];
        $scope.markerOptions = {};
        $scope.markerOptions.control = {};
        $scope.barsGoogleMarkers = [];
        $scope.nightLifesGoogleMarkers = [];

        $scope.googleMarkerOptions = {};
        $scope.googleMarkerOptions.control = {};
        $scope.barFlaskMarkerOptions = {}
        $scope.barFlaskMarkerOptions.control = {};
        $scope.barGoogleMarkerOptions = {}
        $scope.barGoogleMarkerOptions.control = {};

        $scope.nightLifeGoogleMarkerOptions = {}
        $scope.nightLifeGoogleMarkerOptions.control = {};
        $scope.nightLifeFlaskMarkerOptions = {}
        $scope.nightLifeFlaskMarkerOptions.control = {};
        $scope.isMapMarkersSet = false;
        var PRE_EVENT = "Pre-Event";
        var AT_EVENT = "During-Event";
        var POST_EVENT = "Post-Event";
        $scope.infoTypeName = "";
        $scope.infoTypeCategoryName = "";
        $scope.trafficDetails = {};
        $scope.flaskUsDetails = {};
        $scope.mapObject = {};
        $scope.selectedIndex = -1;
        $scope.isFlaskMarkerShown = true;
        $scope.isGoogleMarkerShown = false;
        $scope.isBarFlaskMarkerShown = true;
        $scope.isBarGoogleMarkerShown = false;
        $scope.isNightLifeFlaskMarkerShown = true;
        $scope.isNightLifeGoogleMarkerShown = false;
        $scope.currentMap;
        $scope.isMobile = {
            Android: function () {
                return ionic.Platform.isAndroid();
            },
            iOS: function () {
                return ionic.Platform.isIOS();
            },
            Windows: function () {
                return ionic.Platform.isWindowsPhone();
            }
        };
        $scope.onClick = function (marker, eventName, model) {
            $scope.closeOtherInfoWindows();
            model.show = !model.show;
            if (model.show) {
                $scope.currentShownInfoWindow = model;
                $timeout(setInfoWindowEvent, 100);
            }
        };

        $scope.closeOtherInfoWindows = function (mapClick) {
            if ($scope.infoTypeName == 'Pre-Event') {
                if ($scope.selectedIndex == 0 && $scope.markerOptions.control.getPlurals().allVals.length > 0) {
                    angular.forEach($scope.markerOptions.control.getPlurals().allVals, function (val, idx) {
                        if (mapClick) {
                            $scope.$apply(function () { val.model.show = false; });
                        } else {
                            val.model.show = false;
                        }
                    })
                }
                if ($scope.selectedIndex == 1 && $scope.barFlaskMarkerOptions.control.getPlurals().allVals.length > 0) {
                    angular.forEach($scope.barFlaskMarkerOptions.control.getPlurals().allVals, function (val, idx) {
                        if (mapClick) {
                            $scope.$apply(function () { val.model.show = false; });
                        } else {
                            val.model.show = false;
                        }
                    })
                }
            } else if ($scope.selectedIndex == 0 && $scope.infoTypeName == 'During-Event') {
                if ($scope.barFlaskMarkerOptions.control.getPlurals().allVals.length > 0) {
                    angular.forEach($scope.barFlaskMarkerOptions.control.getPlurals().allVals, function (val, idx) {
                        if (mapClick) {
                            $scope.$apply(function () { val.model.show = false; });
                        } else {
                            val.model.show = false;
                        }
                    })
                }
            } else if ($scope.infoTypeName == 'Post-Event') {
                if ($scope.selectedIndex == 0 && $scope.barFlaskMarkerOptions.control.getPlurals().allVals.length > 0) {
                    angular.forEach($scope.barFlaskMarkerOptions.control.getPlurals().allVals, function (val, idx) {
                        if (mapClick) {
                            $scope.$apply(function () { val.model.show = false; });
                        } else {
                            val.model.show = false;
                        }
                    })
                }
                if ($scope.selectedIndex == 1 && $scope.nightLifeFlaskMarkerOptions.control.getPlurals().allVals.length > 0) {
                    angular.forEach($scope.nightLifeFlaskMarkerOptions.control.getPlurals().allVals, function (val, idx) {
                        if (mapClick) {
                            $scope.$apply(function () { val.model.show = false; });
                        } else {
                            val.model.show = false;
                        }
                    })
                }
            }
        }

        function infoWindowEvent() {
            var iwOuter = $('.gm-style-iw');
            var iwBackground = iwOuter.prev();
            iwBackground.children(':nth-child(2)').css({ 'display': 'none' });

            // Removes white background DIV
            iwBackground.children(':nth-child(4)').css({ 'display': 'none' });
            iwBackground.children(':nth-child(3)').find('div').children().css({ 'background': 'black' });


            var href = $scope.createMapLink($scope.currentShownInfoWindow.addrLine1);
            $("#iwTakeMeThere").attr("href", href);
            if ($scope.currentShownInfoWindow.phone == '') {
                $("#iwCallNow").removeAttr("href");
                $("#iwCallNow").removeAttr("target");
                $("#iwCallNow").attr("onclick", "alert('Phone Not Available')");
            } else {
                href = "tel:" + $scope.currentShownInfoWindow.phone;
                $("#iwCallNow").attr("href", href);
            }

            if ($scope.currentShownInfoWindow.website == '') {
                $("#iwViewWebsite").removeAttr("href");
                $("#iwViewWebsite").removeAttr("target");
                $("#iwViewWebsite").attr("onclick", "alert('website Not Available')");
            } else {
                href = $scope.currentShownInfoWindow.website;
                href = fixUrl(href);
                $("#iwViewWebsite").attr("href", href);
            }
        }
        function setInfoWindowEvent() {
            infoWindowEvent();
            $(".iw-content-toggle").click(function () {
                var toggller = $("#iw-container .iw-content");
                toggller.toggle();
                var toggleImage = $(".iw-content-toggle").find("img");
                if (!toggller.is(":visible")) {
                    toggleImage.attr("src", "img/map_icons/circle-right _arrow.png");
                } else {
                    toggleImage.attr("src", "img/map_icons/circle-down_arrow.png");
                }
            })
            $timeout(infoWindowEvent, 100);

        }


        // initMap();
        uiGmapGoogleMapApi.then(function (maps) {
            maps.visualRefresh = true;
            $scope.markerOptions.animation = maps.Animation.DROP;
            $scope.markerOptions.visible = true;
            $scope.googleMarkerOptions.animation = maps.Animation.DROP;
            $scope.googleMarkerOptions.visible = false;

            $scope.barFlaskMarkerOptions.animation = maps.Animation.DROP;
            $scope.barFlaskMarkerOptions.visible = true;
            $scope.barGoogleMarkerOptions.animation = maps.Animation.DROP;
            $scope.barGoogleMarkerOptions.visible = false;

            $scope.nightLifeFlaskMarkerOptions.animation = maps.Animation.DROP;
            $scope.nightLifeFlaskMarkerOptions.visible = true;
            $scope.nightLifeGoogleMarkerOptions.animation = maps.Animation.DROP;
            $scope.nightLifeGoogleMarkerOptions.visible = false;
        })

        uiGmapIsReady.promise()
            .then(function (maps) {
                $scope.currentMap = $scope.map.control.getGMap();
                var map2 = maps[0].map;
                getGoogleMarkers($scope.currentMap, $scope.infoTypeName);
            });


        function initEventData() {
            try {
                $scope.eventDetails = $stateParams.eventDetails.Details;
                $scope.infoTypeName = setInfoType($stateParams.infoType);
                $scope.infoTypeCategoryName = $scope.setInfoTypeCategory($stateParams.infoTypeCategory);
                $scope.setSelectedTabIndex($scope.infoTypeName, $scope.infoTypeCategoryName);
                var venueObj = angular.fromJson($stateParams.eventDetails.Venue);
                $scope.map.center.latitude = parseFloat(venueObj.latitude);
                $scope.map.center.longitude = parseFloat(venueObj.longitude);
                var eventObj = angular.fromJson($stateParams.eventDetails.Event);
                $scope.eventName = eventObj.eventName;
            } catch (ex) {

            }
        }

        $scope.setSelectedTabIndex = function (infoTypeName, infoTyepeCategory) {
            if (infoTypeName == 'Pre-Event') {
                if (infoTyepeCategory == 'Parking') {
                    $scope.selectedIndex = 0;
                } else if (infoTyepeCategory == 'Bar & Restaurants') {
                    $scope.selectedIndex = 1;
                } else if (infoTyepeCategory == 'Traffic') {
                    $scope.selectedIndex = 2;
                } else {
                    $scope.selectedIndex = 3;
                }

            } else if (infoTypeName == 'During-Event') {
                if (infoTyepeCategory == 'Bar & Restaurants') {
                    $scope.selectedIndex = 0;
                } else {
                    $scope.selectedIndex = 1;
                }
            } else {
                if (infoTyepeCategory == 'Bar & Restaurants') {
                    $scope.selectedIndex = 0;
                } else if (infoTyepeCategory == 'Nightlife') {
                    $scope.selectedIndex = 1;
                } else {
                    $scope.selectedIndex = 2;
                }
            }
        };

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
        function getGoogleMarkers(map, infoTypeName) {
            $scope.service = new google.maps.places.PlacesService(map);
            $scope.pyrmont = new google.maps.LatLng(map.center.lat(), map.center.lng());
            $scope.request = {
                location: $scope.pyrmont,
                radius: '2000'
            }
            if (infoTypeName === PRE_EVENT) {
                getPreEventGoogleMarkers();
            } else if (infoTypeName === AT_EVENT) {
                getAtEventGoogleMarker();
            } else if (infoTypeName === POST_EVENT) {
                getPostEventGoogleMarkers();
            }

        }
        function getPostEventGoogleMarkers() {
            $scope.request.types = ['bar', 'restaurant'];
            $scope.service.nearbySearch($scope.request, setGoogleBarMarker);
            $scope.request.types = ['night_club']
            $scope.service.nearbySearch($scope.request, setGoogleNightLifeMarker);
        }
        function getPreEventGoogleMarkers() {
            $scope.request.types = ['parking'];
            $scope.service.nearbySearch($scope.request, setGoogleParkingMarker);
            $scope.request.types = ['bar', 'restaurant'];
            $scope.service.nearbySearch($scope.request, setGoogleBarMarker);
        }
        function getAtEventGoogleMarker() {
            $scope.request.types = ['bar', 'restaurant'];
            $scope.service.nearbySearch($scope.request, setGoogleBarMarker);
        }
        function setGoogleNightLifeMarker(results, status) {
            if (status == google.maps.places.PlacesServiceStatus.OK) {
                for (var i = 0; i < results.length; i++) {
                    var place = results[i];
                    createGoogleNightLifeMarker(place);
                }
            }
        }
        function setGoogleParkingMarker(results, status) {
            if (status == google.maps.places.PlacesServiceStatus.OK) {
                for (var i = 0; i < results.length; i++) {
                    var place = results[i];
                    createGoogleParkingMarker(place);
                }
            }
        }
        function setGoogleBarMarker(results, status) {
            if (status == google.maps.places.PlacesServiceStatus.OK) {
                for (var i = 0; i < results.length; i++) {
                    var place = results[i];
                    createGoogleBarMarker(place);
                }
            }
        }

        function createGoogleBarMarker(place) {
            var marker = {};
            marker.id = place.id;
            marker.icon = "img/map_icons/google-map-pin.png";
            marker.latitude = place.geometry.location.lat();
            marker.longitude = place.geometry.location.lng();
            marker.show = false;
            marker.map = $scope.currentPosition;
            marker.templateUrl = "markerInfo.tpl.html";
            marker.templateParameter = {
                infoTitle: place.name,
                addrLine1: place.vicinity,
                icon: place.icon,
                type: "GOOGLE"
            };
            $scope.barsGoogleMarkers.push(marker);
        }
        function createGoogleNightLifeMarker(place) {
            var marker = {};
            marker.id = place.id;
            marker.icon = "img/map_icons/google-map-pin.png";
            marker.latitude = place.geometry.location.lat();
            marker.longitude = place.geometry.location.lng();
            marker.show = false;
            marker.map = $scope.currentPosition;
            marker.templateUrl = "markerInfo.tpl.html";
            marker.templateParameter = {
                infoTitle: place.name,
                addrLine1: place.vicinity,
                icon: place.icon,
                type: "GOOGLE"
            };
            $scope.nightLifesGoogleMarkers.push(marker);
        }
        function createGoogleParkingMarker(place) {
            var marker = {};
            marker.id = place.id;
            marker.icon = "img/map_icons/google-map-pin.png";
            marker.latitude = place.geometry.location.lat();
            marker.longitude = place.geometry.location.lng();
            marker.show = false;
            marker.map = $scope.currentPosition;
            marker.templateUrl = "markerInfo.tpl.html";
            marker.templateParameter = {
                infoTitle: place.name,
                addrLine1: place.vicinity,
                icon: place.icon,
                type: "GOOGLE"
            };
            $scope.parkingGoogleMarkers.push(marker);
        }

        $scope.setMarkerFields = function (tempObject) {
            // tempObject.icon = 'img/map_icons/flask_map_icon_11.png';
            tempObject.show = false;
            tempObject.templateUrl = 'markerInfo.tpl.html';
            tempObject.templateParameter = {
                id: tempObject.id,
                infoTitle: tempObject.infoTitle,
                addrLine1: tempObject.addrLine1,
                infoDesc: tempObject.infoDesc,
                phone: tempObject.phone,
                type: "FLASK"
            };
        };

        function fixUrl(url) {
            if (url) {
                if (url.indexOf("http://") > -1 || "https://" > -1) {
                    return url;
                } else {
                    return "http://" + url;
                }
            }
        }


        $scope.selectFlaskMarker = function () {
            $scope.isFlaskMarkerShown = !$scope.isFlaskMarkerShown;
            if ($scope.isFlaskMarkerShown) {
                $scope.markerOptions.visible = true;
                angular.forEach($scope.markerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(true);
                });
            } else {
                $scope.markerOptions.visible = false;
                angular.forEach($scope.markerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(false);
                });
            }
        };

        $scope.selectGoogleMarker = function () {
            $scope.isGoogleMarkerShown = !$scope.isGoogleMarkerShown;
            if ($scope.isGoogleMarkerShown) {
                $scope.googleMarkerOptions.visible = true;
                angular.forEach($scope.googleMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(true);
                });
            } else {
                $scope.googleMarkerOptions.visible = false;
                angular.forEach($scope.googleMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(false);
                });
            }
        };
        $scope.selectNightLifeGoogleMarker = function () {
            $scope.isNightLifeGoogleMarkerShown = !$scope.isNightLifeGoogleMarkerShown;
            if ($scope.isNightLifeGoogleMarkerShown) {
                $scope.nightLifeGoogleMarkerOptions.visible = true;
                angular.forEach($scope.nightLifeGoogleMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(true);
                });
            } else {
                $scope.nightLifeGoogleMarkerOptions.visible = false;
                angular.forEach($scope.nightLifeGoogleMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(false);
                });
            }
        }
        $scope.selectNightLifeFlaskMarker = function () {
            $scope.isNightLifeFlaskMarkerShown = !$scope.isNightLifeFlaskMarkerShown;
            if ($scope.isNightLifeFlaskMarkerShown) {
                $scope.nightLifeFlaskMarkerOptions.visible = true;
                angular.forEach($scope.nightLifeFlaskMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(true);
                });
            } else {
                $scope.nightLifeFlaskMarkerOptions.visible = false;
                angular.forEach($scope.nightLifeFlaskMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(false);
                });
            }
        }
        $scope.selectBarFlaskMarker = function () {
            $scope.isBarFlaskMarkerShown = !$scope.isBarFlaskMarkerShown;
            if ($scope.isBarFlaskMarkerShown) {
                $scope.barFlaskMarkerOptions.visible = true;
                angular.forEach($scope.barFlaskMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(true);
                });
            } else {
                $scope.barFlaskMarkerOptions.visible = false;
                angular.forEach($scope.barFlaskMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(false);
                });
            }
        };

        $scope.selectBarGoogleMarker = function () {
            $scope.isBarGoogleMarkerShown = !$scope.isBarGoogleMarkerShown;
            if ($scope.isBarGoogleMarkerShown) {
                $scope.barGoogleMarkerOptions.visible = true;
                angular.forEach($scope.barGoogleMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(true);
                });
            } else {
                $scope.barGoogleMarkerOptions.visible = false;
                angular.forEach($scope.barGoogleMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(false);
                });
            }
        };
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
                case 'Nightlife':
                    setNightLifeInfo();
                    return infoTypeCategory;
            }
        };
        function setParkingInfo() {
            $timeout(function () {
                $ionicTabsDelegate.select(0);
                $scope.setMarkers();
            }, 0)
        };
        function setBarInfo() {
            $timeout(function () {
                if ($scope.infoTypeName == 'During-Event' || $scope.infoTypeName == 'Post-Event') {
                    $ionicTabsDelegate.select(0);
                } else if ($scope.infoTypeName == 'Pre-Event') {
                    $ionicTabsDelegate.select(1);
                }
                $scope.setMarkers();
            }, 0)
        };
        function setTrafficInfo() {
            $timeout(function () {
                $ionicTabsDelegate.select(2)
                $scope.setMarkers();
            }, 0)
        };
        function setFlaskUsInfo() {
            $timeout(function () {
                if ($scope.infoTypeName == 'Pre-Event') {
                    $ionicTabsDelegate.select(3)
                } else if ($scope.infoTypeName == 'During-Event') {
                    $ionicTabsDelegate.select(1)
                } else {
                    $ionicTabsDelegate.select(2)
                }
                $scope.setMarkers();
            }, 0)
        };
        function setNightLifeInfo() {
            $timeout(function () {
                $ionicTabsDelegate.select(1)
                $scope.setMarkers();
            }, 0)
        }
        $scope.setMarkers = function () {
            if (!$scope.isMapMarkersSet) {
                var tempObject = {};
                $scope.flaskUsDetails = [];
                angular.forEach($scope.eventDetails, function (value, index) {
                    tempObject = {};
                    value = angular.fromJson(value);
                    tempObject = angular.fromJson(value.Detail);
                    tempObject.id = index;
                    if ($scope.infoTypeName == tempObject.infoTypeName) {
                        if ("Parking" == tempObject.infoTypeCategoryName || "Bar & Restaurants" == tempObject.infoTypeCategoryName) {
                            $scope.setMarkerFields(tempObject);
                            if ("Parking" == tempObject.infoTypeCategoryName) {
                                tempObject.icon = 'img/map_icons/parking.png';
                                $scope.parkingMarkers.push(tempObject);
                            } else {
                                tempObject.icon = 'img/map_icons/bar.png';
                                $scope.barMarkers.push(tempObject);
                            }
                        } else if ("Traffic" == tempObject.infoTypeCategoryName) {
                            $scope.trafficDetails = tempObject;
                        } else if ("Flask Us" == tempObject.infoTypeCategoryName) {
                            $scope.flaskUsDetails.push(tempObject);
                        }
                        else if ("Nightlife" == tempObject.infoTypeCategoryName) {
                            $scope.setMarkerFields(tempObject);
                            tempObject.icon = 'img/map_icons/nightlife.png';
                            $scope.nightLifes.push(tempObject);
                        }
                    } else {
                        if ("Bar & Restaurants" == tempObject.infoTypeCategoryName) {
                            $scope.setMarkerFields(tempObject)
                            tempObject.icon = 'img/map_icons/bar.png';
                            $scope.barMarkers.push(tempObject);
                        }
                    }
                })
                $scope.isMapMarkersSet = true;
            }
        };
        $scope.slidePrevious1 = function (slide) {
            $ionicSlideBoxDelegate.$getByHandle(slide).previous();
        }

        $scope.slideNext1 = function (slide) {
            $ionicSlideBoxDelegate.$getByHandle(slide).next();
        }

        $scope.selectTab = function (index) {
            $scope.closeOtherInfoWindows();
            $scope.selectedIndex = index;
            if ($scope.infoTypeName == 'Pre-Event') {
                if (index == 0) {
                    setParkingInfo();
                } else if (index == 1) {
                    setBarInfo();
                } else if (index == 2) {
                    setTrafficInfo();
                } else if (index == 3) {
                    setFlaskUsInfo();
                }
            } else if ($scope.infoTypeName == 'During-Event') {
                if (index == 0) {
                    setBarInfo();
                } else if (index == 1) {
                    setFlaskUsInfo();
                }
            } else if ($scope.infoTypeName == 'Post-Event') {
                if (index == 0) {
                    setBarInfo();
                } else if (index == 1) {
                    setNightLifeInfo();
                } else if (index == 2) {
                    setFlaskUsInfo();
                }
            }
        }
        $scope.createMapLink = function (address1) {
            var findUs = '';
            if ($scope.isMobile.Android()) {
                findUs = 'geo:' + address1
            }
            else if ($scope.isMobile.iOS()) {
                findUs = 'http://maps.apple.com/?saddr=Current%20Location&daddr=' + address1;
            }
            else if ($scope.isMobile.Windows()) {
                findUs = 'maps:' + address1;
            }
            else {
                findUs = 'http://maps.google.com/?saddr=Current%20Location&daddr=' + address1;
            }
            return findUs;
        }
        initEventData();
    }
    angular.module('flaskApp').controller('refreshMap', function ($scope, $controller, uiGmapIsReady, mapServices) {
        uiGmapIsReady.promise()
            .then(function (instances) {
                $scope.refreshMap_maps = instances[0].map;    // can use std google.maps methods on this returned map object
                $scope.refreshMap = function () {
                    mapServices.refreshMap();
                };
            });
    });



    /* =========== This is the service which uses the $scope.map.control functions ============== */

    angular.module('flaskApp').service('mapServices', function () {
        /*
        * service function that accepts the $scope.map.control object
        */
        this.map_control = function (scope_map_control) {
            var scope_map_controls = scope_map_control;
            this.refreshMap = function () {
                var map1 = scope_map_controls.getGMap();
                scope_map_controls.refresh({ latitude: map1.center.lat(), longitude: map1.center.lng() });
            };

        };

    });
})(); 