(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('eventMapViewCtrl', eventMapViewCtrl);

    eventMapViewCtrl.$inject = ['$scope', '$stateParams', '$state', '$ionicPlatform', 'EventsService', 'uiGmapGoogleMapApi', '$ionicTabsDelegate', '$timeout', 'uiGmapIsReady', '$flaskUtil'];

    /* @ngInject */
    function eventMapViewCtrl($scope, $stateParams, $state, $ionicPlatform, EventsService, uiGmapGoogleMapApi, $ionicTabsDelegate, $timeout, uiGmapIsReady, $flaskUtil) {
        /* jshint validthis: true */
        var self = this;
        $scope.map = { center: { latitude: 42.3314, longitude: -83.0458 }, zoom: 15, control: {} };
        $scope.map.events = [];
        $scope.map.events["click"] = function () {
            angular
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
        $scope.currentUserLocation;
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
            model.show = !model.show;
            if (model.show) {
                $scope.currentShownInfoWindow = model;

                setTimeout(setInfoWindowEvent, 100);
            }
        };
        function setInfoWindowEvent() {
            var iwOuter = $('.gm-style-iw');

            /* Since this div is in a position prior to .gm-div style-iw.
             * We use jQuery and create a iwBackground variable,
             * and took advantage of the existing reference .gm-style-iw for the previous div with .prev().
            */
            var iwBackground = iwOuter.prev();

            // Removes background shadow DIV
            iwBackground.children(':nth-child(2)').css({ 'display': 'none' });

            // Removes white background DIV
            iwBackground.children(':nth-child(4)').css({ 'display': 'none' });

            // Moves the infowindow 115px to the right.
            // iwOuter.parent().parent().css({ left: '115px' });

            // // Moves the shadow of the arrow 76px to the left margin.
            iwBackground.children(':nth-child(1)').attr('style', function (i, s) { return s + 'left: 76px !important;' });

            // // Moves the arrow 76px to the left margin.
            iwBackground.children(':nth-child(3)').attr('style', function (i, s) { return s + 'left: 76px !important;' });

            // Changes the desired tail shadow color.
            iwBackground.children(':nth-child(3)').find('div').children().css({ 'box-shadow': 'rgba(72, 181, 233, 0.6) 0px 1px 6px', 'z-index': '1', 'background': 'black' });
            $(".iw-content-toggle").click(function () {
                var toggller = $("#iw-container .iw-content")
                toggller.toggle();
                var toggleImage = $(".iw-content-toggle").find("img");
                if (toggller.is(":visible")) {
                    toggleImage.attr("src", "img/map_icons/circle-down_arrow.png");
                } else {
                    toggleImage.attr("src", "img/map_icons/circle-right _arrow.png");
                }
            })

            // Reference to the div that groups the close button elements.
            // var iwCloseBtn = iwOuter.next();

            // // Apply the desired effect to the close button
            // iwCloseBtn.css({ opacity: '1', right: '38px', top: '3px', border: '7px solid #48b5e9', 'border-radius': '13px', 'box-shadow': '0 0 5px #3990B9' });

            // // If the content of infowindow not exceed the set maximum height, then the gradient is removed.
            // if ($('.iw-content').height() < 140) {
            //     $('.iw-bottom-gradient').css({ display: 'none' });
            // }

            // // The API automatically applies 0.7 opacity to the button after the mouseout event. This function reverses this event to the desired value.
            // iwCloseBtn.mouseout(function () {
            //     $(this).css({ opacity: '1' });
            // })
            var href = $scope.createMapLink($scope.currentShownInfoWindow.addrLine1);
            $("#iwTakeMeThere").attr("href",href);
            // $("#iwTakeMeThere").on("click", takeMeToPlace);
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
                $scope.setUserLocation();
                // $scope.setDomReadyEvent();
            });

        $scope.setUserLocation = function () {
            navigator.geolocation.getCurrentPosition(
                function (position) {
                    $scope.currentUserLocation = position;
                },
                function errorCallback(error) {
                }
            );
        };
        // $scope.setDomReadyEvent = function () {
        //     angular.forEach($scope.windowOptions.control.getGWindows(), function (infoWindow, idx) {
        //         google.maps.event.addListener(infoWindow, 'domready', function () {
        //             alert("test");
        //         });
        //     });
        // };
        function initEventData() {
            try {
                $scope.eventDetails = $stateParams.eventDetails.Details;
                $scope.infoTypeName = setInfoType($stateParams.infoType);
                $scope.infoTypeCategoryName = $scope.setInfoTypeCategory($stateParams.infoTypeCategory);
                var venueObj = angular.fromJson($stateParams.eventDetails.Venue);
                $scope.map.center.latitude = parseFloat(venueObj.latitude);
                $scope.map.center.longitude = parseFloat(venueObj.longitude);
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



        function takeMeToPlace() { // check
            var slat = $scope.currentUserLocation.coords.latitude;
            var slng = $scope.currentUserLocation.coords.longitude;
            // var dlat = $scope.currentShownInfoWindow.position.lat();
            // var dlng = $scope.currentShownInfoWindow.position.lng();
            if (navigator.platform) {
                if ((navigator.platform.indexOf("iPhone") != -1)
                    || (navigator.platform.indexOf("iPod") != -1)
                    || (navigator.platform.indexOf("iPad") != -1) || (navigator.platform.indexOf("android") != -1))
                    window.open("maps://maps.google.com/maps?saddr=" + slat + "," + slng + "&daddr=" + dlat + "," + dlng + " ", "_system");
                else {
                    window.open("http://maps.google.com/maps?saddr=" + slat + "," + slng + "&daddr=" + dlat + "," + dlng + " ", "_system");
                }
            } else {
                flaskUtil.alert("falied to get your location");
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
            // mapServices.refreshMap();
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
                $ionicTabsDelegate.select(1)
                $scope.setMarkers();
            }, 0)
        };
        function setTrafficInfo() {
            $timeout(function () {
                $ionicTabsDelegate.select(3)
                $scope.setMarkers();
            }, 0)
        };
        function setFlaskUsInfo() {
            $timeout(function () {
                $ionicTabsDelegate.select(4)
                $scope.setMarkers();
            }, 0)
        };
        function setNightLifeInfo() {
            $timeout(function () {
                $ionicTabsDelegate.select(2)
                $scope.setMarkers();
            }, 0)
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
                                tempObject.icon = 'img/map_icons/parking.png';
                                $scope.parkingMarkers.push(tempObject);
                            } else {
                                tempObject.icon = 'img/map_icons/bar.png';
                                $scope.barMarkers.push(tempObject);
                            }
                        } else if ("Traffic" == tempObject.infoTypeCategoryName) {
                            $scope.trafficDetails = tempObject;
                        } else if ("Flask Us" == tempObject.infoTypeCategoryName) {
                            $scope.flaskUsDetails = tempObject;
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

        $scope.selectTab = function (index) {
            $scope.selectedIndex = index;
            if (index == 0) { // Parking
                setParkingInfo();
            } else if (index == 1) { // Bars and Restaurants
                setBarInfo();
            } else if (index == 2) {
                setNightLifeInfo(); //Nightlife
            } else if (index == 3) { // Traffic
                setTrafficInfo();
            } else if (index == 4) { // FlaskUs
                setFlaskUsInfo();
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