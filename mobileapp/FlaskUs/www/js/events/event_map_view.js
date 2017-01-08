(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('eventMapViewCtrl', eventMapViewCtrl);

    eventMapViewCtrl.$inject = ['$scope', '$stateParams', '$state', '$ionicPlatform', 'EventsService', 'uiGmapGoogleMapApi', '$ionicTabsDelegate', '$timeout', 'uiGmapIsReady', '$ionicSlideBoxDelegate', '$cordovaInAppBrowser', 'SERVER'];

    /* @ngInject */
    function eventMapViewCtrl($scope, $stateParams, $state, $ionicPlatform, EventsService, uiGmapGoogleMapApi, $ionicTabsDelegate, $timeout, uiGmapIsReady, $ionicSlideBoxDelegate, $cordovaInAppBrowser, SERVER) {
        /* jshint validthis: true */
        var self = this;
        var baseImagePath = SERVER.hostName + "c/document_library/get_file";
        $scope.map = { center: { latitude: 42.3314, longitude: -83.0458 }, zoom: 14, control: {} };
        $scope.map.events = [];
        $scope.searchBox={"showBox":false};
        $scope.searchObj={"searchString":""};
        $scope.searchParkingMarkers=[];
        $scope.searchBarMarkers=[];
        $scope.searchHotelMarkers=[];
        $scope.searchNightLifesMarkers=[];
        $scope.postEventSearch=false;
        $scope.duringEventSearch=false;
        $scope.preEventSearch=false;
        $scope.showSearchBox={"value":true};
        $scope.map.events["click"] = function () {
            return $scope.closeOtherInfoWindows('mapClick');
        };
        $scope.options = { scrollwheel: false, disableDefaultUI: true, zoomControl: true, streetViewControl: true };
        $scope.parkingMarkers = [];
        $scope.hotelMarkers = [];
        $scope.windowOptions = { 'control': {} };
        $scope.barMarkers = [];
        $scope.nightLifes = [];
        $scope.parkingGoogleMarkers = [];
        $scope.tempParkingGoogleMarkers = [];
        $scope.markerOptions = {};
        $scope.markerOptions.control = {};
        $scope.barsGoogleMarkers = [];
        $scope.hotelGoogleMarkers = [];
        $scope.nightLifesGoogleMarkers = [];
        $scope.venueMapDetail=[];
        $scope.venueInfoDetail=[];
        $scope.gettingHomeDetail=[];

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

        $scope.hotelGoogleMarkerOptions = {}
        $scope.hotelGoogleMarkerOptions.control = {};
        $scope.hotelFlaskMarkerOptions = {}
        $scope.hotelFlaskMarkerOptions.control = {};
        $scope.zoomMapImage=false;

        $scope.isMapMarkersSet = false;
        var PRE_EVENT = "Pre-Event";
        var AT_EVENT = "During-Event";
        var POST_EVENT = "Post-Event";
        $scope.infoTypeName = "";
        $scope.infoTypeCategoryName = "";
        $scope.trafficDetails = [];
        $scope.flaskUsDetails = {};
        $scope.mapObject = {};
        $scope.selectedIndex = -1;
        $scope.isFlaskMarkerShown = true;
        $scope.isGoogleMarkerShown = false;
        $scope.isBarFlaskMarkerShown = true;
        $scope.isBarGoogleMarkerShown = false;
        $scope.isNightLifeFlaskMarkerShown = true;
        $scope.isNightLifeGoogleMarkerShown = false;
        $scope.isHotelFlaskMarkerShown = true;
        $scope.isHotelGoogleMarkerShown = false;
        $scope.currentMap;
        $scope.toggleQueDiv = true;
        $scope.toggleMsgDiv = function () {
            $scope.hideDiv = false;
            if ($scope.toggleQueDiv == false) {
                $scope.toggleQueDiv = !$scope.toggleQueDiv;
                if ($scope.toggleQueDiv == true) {
                    $timeout(function () {
                        $scope.hideDiv = true;
                    }, 500);
                }
            } else {
                $timeout(function () {
                    $scope.toggleQueDiv = !$scope.toggleQueDiv;
                }, 30);
            }


        }
        $scope.toggleZoomImage=function(){
            $scope.zoomMapImage=!$scope.zoomMapImage
        }
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
        $scope.setNewMarker=function(searchItem,index){
           if(searchItem.infoTypeCategoryName=="Parking") {
               $timeout(function () {
                   $scope.searchBox.showBox = false;
                   angular.forEach($scope.parkingMarkers,function(value,key){
                       if(value.id==searchItem.id) {
                           $scope.parkingMarkers.splice(key, 1);
                       }
                   })

               }, 200);

               $timeout(function () {

                   $scope.parkingMarkers.push(searchItem);
               }, 500)
           }else if(searchItem.infoTypeCategoryName=="Bar & Restaurants"){
               $timeout(function () {
                   $scope.searchBox.showBox = false;
                   angular.forEach($scope.barMarkers,function(value,key){
                       if(value.id==searchItem.id) {
                           $scope.barMarkers.splice(key, 1);
                       }
                   })

               }, 200);

               $timeout(function () {
                   $scope.barMarkers.push(searchItem);
               }, 500)
           }
           else if(searchItem.infoTypeCategoryName=="Nightlife"){
               $timeout(function () {
                   $scope.searchBox.showBox = false;
                   angular.forEach($scope.nightLifes,function(value,key){
                       if(value.id==searchItem.id)
                           $scope.nightLifes.splice(key, 1);
                   })

               }, 200);

               $timeout(function () {
                   $scope.nightLifes.push(searchItem);
               }, 500)
           }

           else if(searchItem.infoTypeCategoryName=="Hotels"){
               $timeout(function () {
                   $scope.searchBox.showBox = false;
                   angular.forEach($scope.hotelMarkers,function(value,key){
                       if(value.id==searchItem.id)
                           $scope.hotelMarkers.splice(key, 1);
                   })

               }, 200);

               $timeout(function () {
                   $scope.hotelMarkers.push(searchItem);
               }, 500)
           }

        }
        $scope.onClick = function (marker, eventName, model) {
            $scope.closeOtherInfoWindows();
            model.show = !model.show;
            if (model.show) {
                $scope.currentShownInfoWindow = model;
                $timeout(setInfoWindowEvent, 100);
            }
        };
        document.addEventListener("deviceready", onDeviceReady, false);
        function onDeviceReady() {

        }
        $scope.closeOtherInfoWindows = function (mapClick) {
            if ($scope.infoTypeName == 'Pre-Event') {
                if ($scope.selectedIndex == 0 && $scope.markerOptions.control &&  $scope.markerOptions.control.getPlurals &&  $scope.markerOptions.control.getPlurals().allVals.length > 0) {
                    angular.forEach($scope.markerOptions.control.getPlurals().allVals, function (val, idx) {
                        if (mapClick) {
                            $scope.$apply(function () { val.model.show = false; });
                        } else {
                            val.model.show = false;
                        }
                    })
                }
                if ($scope.selectedIndex == 1 && $scope.barFlaskMarkerOptions.control && $scope.barFlaskMarkerOptions.control.getPlurals && $scope.barFlaskMarkerOptions.control.getPlurals().allVals.length > 0) {
                    angular.forEach($scope.barFlaskMarkerOptions.control.getPlurals().allVals, function (val, idx) {
                        if (mapClick) {
                            $scope.$apply(function () { val.model.show = false; });
                        } else {
                            val.model.show = false;
                        }
                    })
                }
            } else if ($scope.selectedIndex == 2 && $scope.infoTypeName == 'During-Event') {
                if ($scope.barFlaskMarkerOptions.control && $scope.barFlaskMarkerOptions.control.getPlurals && $scope.barFlaskMarkerOptions.control.getPlurals().allVals.length > 0) {
                    angular.forEach($scope.barFlaskMarkerOptions.control.getPlurals().allVals, function (val, idx) {
                        if (mapClick) {
                            $scope.$apply(function () { val.model.show = false; });
                        } else {
                            val.model.show = false;
                        }
                    })
                }
            }else if ($scope.infoTypeName == 'Post-Event') {
                    if ($scope.selectedIndex == 0 && $scope.barFlaskMarkerOptions.control && $scope.barFlaskMarkerOptions.control.getPlurals && $scope.barFlaskMarkerOptions.control.getPlurals().allVals.length > 0) {
                        angular.forEach($scope.barFlaskMarkerOptions.control.getPlurals().allVals, function (val, idx) {
                            if (mapClick) {
                                $scope.$apply(function () { val.model.show = false; });
                            } else {
                                val.model.show = false;
                            }
                        })
                    }
                    if ($scope.selectedIndex == 1 && $scope.nightLifeFlaskMarkerOptions.control && $scope.nightLifeFlaskMarkerOptions.control.getPlurals && $scope.nightLifeFlaskMarkerOptions.control.getPlurals().allVals.length > 0) {
                        angular.forEach($scope.nightLifeFlaskMarkerOptions.control.getPlurals().allVals, function (val, idx) {
                            if (mapClick) {
                                $scope.$apply(function () { val.model.show = false; });
                            } else {
                                val.model.show = false;
                            }
                        })
                    }
                    if ($scope.selectedIndex == 2 && $scope.hotelFlaskMarkerOptions.control && $scope.hotelFlaskMarkerOptions.control.getPlurals && $scope.hotelFlaskMarkerOptions.control.getPlurals().allVals.length > 0) {
                        angular.forEach($scope.hotelFlaskMarkerOptions.control.getPlurals().allVals, function (val, idx) {
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


            var takeMeThere = $scope.createMapLink($scope.currentShownInfoWindow.addrLine1);

            $("#iwTakeMeThere").on("click", function () {
                openUrl(takeMeThere, "_system");
            });
            var telephoneToCall;
            if ($scope.currentShownInfoWindow.phone == '') {
                $("#iwCallNow").text("Not Available");
            } else {
                telephoneToCall = "tel:" + $scope.currentShownInfoWindow.phone;
                $("#iwCallNow").on("click", function () {
                    openUrl(telephoneToCall, "_system");
                });
            }
            var websiteUrl;
            if ($scope.currentShownInfoWindow.website == '') {
                $("#iwViewWebsite").text('Not Available');
            } else {
                websiteUrl = $scope.currentShownInfoWindow.website;
                websiteUrl = fixUrl(websiteUrl);
                $("#iwViewWebsite").on("click", function () {
                    openUrl(websiteUrl, "_system");
                });
            }
        }

        function openUrl(url, target) {
            $cordovaInAppBrowser.open(url, target, { location: 'no' }).
                then(function (event) {
                    // success
                })
                .catch(function (event) {
                    // error
                });
        }
        function setInfoWindowEvent() {
            infoWindowEvent();
            $timeout(function () {
                $(".iw-content-toggle").click(function () {
                    var toggller = $("#iw-container #iw-content");
                    var toggleImage = $(".iw-content-toggle").find("img");
                    if (toggller.is(":visible")) {
                        toggleImage.attr("src", "img/map_icons/circle_arrow_left.svg");
                    } else {
                        toggleImage.attr("src", "img/map_icons/circle_arrow_down.svg");
                    }
                   toggller.slideToggle("slow", function () {
                       
                    });

                    // toggller.toggle();
                })
                infoWindowEvent();
            }, 100);

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

            $scope.hotelFlaskMarkerOptions.animation = maps.Animation.DROP;
            $scope.hotelFlaskMarkerOptions.visible = true;
            $scope.hotelGoogleMarkerOptions.animation = maps.Animation.DROP;
            $scope.hotelGoogleMarkerOptions.visible = false;

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
            $scope.searchBox.showBox=false;
            $scope.searchObj.searchString="";
            if (infoTypeName == 'Pre-Event') {
                $scope.preEventSearch=true;
                $scope.postEventSearch=false;
                $scope.duringEventSearch=false;

                if (infoTyepeCategory == 'Parking') {
                    $scope.selectedIndex = 0;
                    $scope.showSearchBox.value=true;

                } else if (infoTyepeCategory == 'Bar & Restaurants') {
                    $scope.selectedIndex = 1;
                    $scope.showSearchBox.value=true;
                } else if (infoTyepeCategory == 'Traffic') {
                    $scope.selectedIndex = 2;
                    $scope.showSearchBox.value=false;
                } else {
                    $scope.selectedIndex = 3;
                    $scope.showSearchBox.value=false;
                }

            } else if (infoTypeName == 'During-Event') {
                $scope.duringEventSearch=true;
                $scope.postEventSearch=false;
                $scope.preEventSearch=false;
                if (infoTyepeCategory == 'Venue Map') {
                    $scope.selectedIndex = 0;
                    $scope.showSearchBox.value=false;
                }
                if (infoTyepeCategory == 'Venue Info') {
                    $scope.selectedIndex = 1;
                    $scope.showSearchBox.value=false;
                }if (infoTyepeCategory == 'Bar & Restaurants') {
                    $scope.selectedIndex = 2;
                    $scope.showSearchBox.value=true;
                }else {
                    $scope.selectedIndex = 3;
                    $scope.showSearchBox.value=false;
                }
            } else {
                $scope.postEventSearch=true;

                $scope.duringEventSearch=false;
                $scope.preEventSearch=false;
                if (infoTyepeCategory == 'Bar & Restaurants') {
                    $scope.selectedIndex = 0;
                    $scope.showSearchBox.value=true;
                } else if (infoTyepeCategory == 'Nightlife') {
                    $scope.selectedIndex = 1;
                    $scope.showSearchBox.value=true;
                } else if (infoTyepeCategory == 'Hotels') {
                    $scope.selectedIndex = 2;
                    $scope.showSearchBox.value=true;
                } else if (infoTyepeCategory == 'Getting home') {
                    $scope.selectedIndex = 3;
                    $scope.showSearchBox.value=false;
                }

                else {
                    $scope.selectedIndex = 4;
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
            $scope.request.types = ['hotel']
            $scope.service.nearbySearch($scope.request, setGoogleHotelMarker);
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
        function setGoogleHotelMarker(results, status) {
            if (status == google.maps.places.PlacesServiceStatus.OK) {
                for (var i = 0; i < results.length; i++) {
                    var place = results[i];
                    createGoogleHotelMarker(place);
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
        function createGoogleHotelMarker(place) {
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
            $scope.hotelGoogleMarkers.push(marker);
        }

        $scope.setMarkerFields = function (tempObject) {
            // tempObject.icon = 'img/map_icons/flask_map_icon_11.png';
            tempObject.show = false;
            tempObject.isIconVisibleOnClick = "true";
            var templateName;
            if(tempObject.infoTypeCategoryName == "Parking") {
                templateName = "markerParkingInfo.tpl.html";
                tempObject.templateParameter = {
                id: tempObject.id,
                infoTitle: tempObject.infoTitle,
                cost: "$"+tempObject.cost,
                addrLine1: tempObject.addrLine1,
                infoDesc1 :"15 min walk to stadium",
                subTitle: "$"+tempObject.cost + " | " + "15 min walk to stadium",
                infoDesc: tempObject.infoDesc,
                phone: tempObject.phone,
                type: "FLASK"
            };
            } else{
                templateName = "markerBarInfo.tpl.html";
                tempObject.templateParameter = {
                id: tempObject.id,
                infoTitle: tempObject.infoTitle,
                addrLine1: tempObject.addrLine1,
                infoDesc: tempObject.infoDesc,
                phone: tempObject.phone,
                type: "FLASK"
            }
        }
            tempObject.templateUrl = templateName;
            
            
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
                 $scope.closeOtherInfoWindows();
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

        $scope.selectHotelGoogleMarker = function () {
            $scope.isHotelGoogleMarkerShown = !$scope.isHotelGoogleMarkerShown;
            if ($scope.isHotelGoogleMarkerShown) {
                $scope.hotelGoogleMarkerOptions.visible = true;
                angular.forEach($scope.hotelGoogleMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(true);
                });
            } else {
                $scope.hotelGoogleMarkerOptions.visible = false;
                angular.forEach($scope.hotelGoogleMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(false);
                });
            }
        }
        $scope.selectHotelFlaskMarker = function () {
            $scope.isHotelFlaskMarkerShown = !$scope.isHotelFlaskMarkerShown;
            if ($scope.isHotelFlaskMarkerShown) {
                $scope.hotelFlaskMarkerOptions.visible = true;
                angular.forEach($scope.hotelFlaskMarkerOptions.control.getGMarkers(), function (value, idx) {
                    value.setVisible(true);
                });
            } else {
                $scope.closeOtherInfoWindows();
                $scope.hotelFlaskMarkerOptions.visible = false;
                angular.forEach($scope.hotelFlaskMarkerOptions.control.getGMarkers(), function (value, idx) {
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
                $scope.closeOtherInfoWindows();
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
                case 'Hotels':
                    setHotelInfo();
                    return infoTypeCategory;
                case 'Venue Map':
                    setVenueMapInfo();
                    return infoTypeCategory;
                case 'Venue Info':
                    setVenueDetailInfo();
                    return infoTypeCategory;
                case 'Getting home':
                    setGettingHomeInfo();
                    return infoTypeCategory;

            }
        };
        function setHotelInfo() {
            $timeout(function () {
                $ionicTabsDelegate.select(2);
                $scope.showSearchBox.value=true;
                $scope.setMarkers();
            }, 0)
        };
        function setVenueMapInfo() {
            $timeout(function () {
                $ionicTabsDelegate.select(0);
                $scope.showSearchBox.value=false;
                $scope.setMarkers();
            }, 0)
        };
        function setVenueDetailInfo() {
            $timeout(function () {
                $ionicTabsDelegate.select(1);
                $scope.showSearchBox.value=false;
                $scope.setMarkers();
            }, 0)
        };
        function setParkingInfo() {
            $timeout(function () {
                $ionicTabsDelegate.select(0);
                $scope.showSearchBox.value=true;
                $scope.setMarkers();
            }, 0)
        };
        function setBarInfo() {
            $timeout(function () {
                if ($scope.infoTypeName == 'During-Event') {
                    $ionicTabsDelegate.select(2);
                    $scope.showSearchBox.value=true;
                } else if ($scope.infoTypeName == 'Post-Event') {
                    $ionicTabsDelegate.select(0);
                    $scope.showSearchBox.value=true;
                }else if ($scope.infoTypeName == 'Pre-Event') {
                    $ionicTabsDelegate.select(1);
                    $scope.showSearchBox.value=true;
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
                        $ionicTabsDelegate.select(3)
                } else{
                        $ionicTabsDelegate.select(4);
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
        function setGettingHomeInfo(){
            $timeout(function () {
                $ionicTabsDelegate.select(3);
                $scope.setMarkers();
            }, 0)


        }
        $scope.callNow=function(phonenumber){
           var telephoneToCall = "tel:" + phonenumber;
                openUrl(telephoneToCall, "_system");
        };
        $scope.openApp=function(AppName) {
            if (AppName.mobileAppName==""){
                var telephoneToCall = "tel:" + AppName.phone;
            openUrl(telephoneToCall, "_system");
        }

                var scheme;

            if(AppName.mobileAppName.toLowerCase()=="uber") {
                if (device.platform === 'iOS') {
                    scheme = 'uber://';
                }
                else if (device.platform === 'Android') {
                    scheme = 'com.ubercab';
                }

                appAvailability.check(
                    scheme,
                    function () {
                        window.open('uber://', '_system', 'location=no');
                        console.log('uber is available');
                    },
                    function () {
                        if (AppName.phone!="") {
                            var telephoneToCall = "tel:" + AppName.phone;
                            openUrl(telephoneToCall, "_system");
                        } else {
                            window.open('https://m.uber.com/ul/?action=setPickup', '_system', 'location=no');
                            console.log('uber is not available');
                        }
                    }
                );
            }else if(AppName.mobileAppName.toLowerCase()=="lyft"){
                if (device.platform === 'iOS') {
                    scheme = 'lyft://';
                }
                else if (device.platform === 'Android') {
                    scheme = 'me.lyft.android';
                }

                appAvailability.check(
                    scheme,
                    function () {
                        window.open('lyft://', '_system', 'location=no');
                        console.log('uber is available');
                    },
                    function () {
                        if (AppName.phone != "") {
                            var telephoneToCall = "tel:" + AppName.phone;
                            openUrl(telephoneToCall, "_system");
                        } else {
                            window.open('https://www.lyft.com/', '_system', 'location=no');
                            console.log('uber is not available');
                        }
                    }
                );
            }

        }
        
        $scope.setMarkers = function () {
            if (!$scope.isMapMarkersSet) {
                var tempObject = {};
                var ImgObj = [];
                $scope.flaskUsDetails = [];
                angular.forEach($scope.eventDetails, function (value, index) {
                    tempObject = {};
                    ImgObj = []
                    ImgObj = angular.fromJson(value.DetailImages);
                    value = angular.fromJson(value);
                    tempObject = angular.fromJson(value.Detail);
                    tempObject.id = index;
                    if ($scope.infoTypeName == tempObject.infoTypeName) {
                        if ("Parking" == tempObject.infoTypeCategoryName || "Bar & Restaurants" == tempObject.infoTypeCategoryName) {
                            $scope.setMarkerFields(tempObject);
                            if ("Parking" == tempObject.infoTypeCategoryName) {
                                tempObject.icon = 'img/map_icons/parking.svg';
                                $scope.parkingMarkers.push(tempObject);
                                $scope.searchParkingMarkers=$scope.parkingMarkers;
                            } else {
                                tempObject.icon = 'img/map_icons/bar.svg';
                                $scope.barMarkers.push(tempObject);
                                $scope.searchBarMarkers=$scope.barMarkers;

                            }
                        } else if ("Traffic" == tempObject.infoTypeCategoryName) {
                            $scope.trafficDetails.push(tempObject);
                        } else if ("Flask Us" == tempObject.infoTypeCategoryName) {
                            if (ImgObj.length != 0) {
                                tempObject.imageUrl = baseImagePath + "?uuid=" + angular.fromJson(ImgObj[0].DetailImage).imageUUID + "&groupId=" + angular.fromJson(ImgObj[0].DetailImage).imageGroupId;
                            }
                            $scope.flaskUsDetails.push(tempObject);
                        }
                        else if ("Nightlife" == tempObject.infoTypeCategoryName) {
                            $scope.setMarkerFields(tempObject);
                            tempObject.icon = 'img/map_icons/nightlife.svg';
                            $scope.nightLifes.push(tempObject);
                            $scope.searchNightLifesMarkers= $scope.nightLifes;
                        }
                         else if ("Hotels" == tempObject.infoTypeCategoryName) {
                            $scope.setMarkerFields(tempObject);
                            tempObject.icon = 'img/map_icons/hotel.svg';
                            $scope.hotelMarkers.push(tempObject);
                            $scope.searchHotelMarkers=$scope.hotelMarkers;
                        }
                        else if ("Venue Map" == tempObject.infoTypeCategoryName) {
                            if (ImgObj.length != 0) {
                                tempObject.imageUrl = baseImagePath + "?uuid=" + angular.fromJson(ImgObj[0].DetailImage).imageUUID + "&groupId=" + angular.fromJson(ImgObj[0].DetailImage).imageGroupId;
                            }
                            $scope.venueMapImageUrl=tempObject.imageUrl;
                            $scope.venueMapDetail.push(tempObject);
                        }
                        else if ("Venue Info" == tempObject.infoTypeCategoryName) {
                            $scope.venueInfoDetail.push(tempObject);
                        }
                        else if ("Getting home" == tempObject.infoTypeCategoryName) {
                            $scope.gettingHomeDetail.push(tempObject);

                        }
                    } else {
                        if ("Bar & Restaurants" == tempObject.infoTypeCategoryName) {
                            $scope.setMarkerFields(tempObject)
                            tempObject.icon = 'img/map_icons/bar.svg';
                            $scope.barMarkers.push(tempObject);
                            $scope.searchBarMarkers=$scope.barMarkers;
                        }
                       
                    }
                })
                $ionicSlideBoxDelegate.update();
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
            //$scope.isMapMarkersSet = false;
            $scope.closeOtherInfoWindows();
            $scope.searchBox.showBox=false;
            $scope.searchObj.searchString="";
            $scope.selectedIndex = index;
            if ($scope.infoTypeName == 'Pre-Event') {
                if (index == 0) {
                    setParkingInfo();
                    $scope.showSearchBox.value=true;
                } else if (index == 1) {
                    setBarInfo();
                    $scope.showSearchBox.value=true;
                } else if (index == 2) {
                    setTrafficInfo();
                    $scope.showSearchBox.value=false;
                } else if (index == 3) {
                    setFlaskUsInfo();
                    $scope.showSearchBox.value=false;
                }
            } else if ($scope.infoTypeName == 'During-Event') {
                if (index == 0) {
                     setVenueMapInfo();
                    $scope.showSearchBox.value=false;
                } else if (index == 1) {
                   setVenueDetailInfo();
                } else if (index == 2) {
                     setBarInfo();
                    $scope.showSearchBox.value=true;
                } else if (index == 3) {
                    setFlaskUsInfo();
                    $scope.showSearchBox.value=false;
                }
            } else if ($scope.infoTypeName == 'Post-Event') {
                if (index == 0) {
                    setBarInfo();
                    $scope.showSearchBox.value=true;
                } else if (index == 1) {
                    setNightLifeInfo();
                } else if (index == 4) {
                    setFlaskUsInfo();
                    $scope.showSearchBox.value=false;
                } else if (index == 2) {
                    setHotelInfo();
                    $scope.showSearchBox.value=true;
                }else if(index==3){
                    setGettingHomeInfo();
                    $scope.showSearchBox.value=false;
                }
            }
        }
        $scope.createMapLink = function (address1) {
            var findUs = '';
            if ($scope.isMobile.Android()) {
                findUs = 'http://maps.google.com/?saddr=Current%20Location&daddr=' + address1;
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