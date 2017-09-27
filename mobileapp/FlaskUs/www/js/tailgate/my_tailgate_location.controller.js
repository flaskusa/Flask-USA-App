(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatelocationCtrl', mytailgatelocationCtrl);

    mytailgatelocationCtrl.$inject = ['$scope', '$state', '$ionicPlatform', '$stateParams', 'TailgateService', '$cookies', 'uiGmapGoogleMapApi', 'SERVER', '$cordovaInAppBrowser', '$cordovaGeolocation', '$timeout','$ionicLoading'];

    /* @ngInject */
    function mytailgatelocationCtrl($scope, $state, $ionicPlatform, $stateParams, TailgateService, $cookies, uiGmapGoogleMapApi, SERVER, $cordovaInAppBrowser, $cordovaGeolocation, $timeout,$ionicLoading) {
        $scope.myTailgaters = [];
        var tailGateId = $cookies.get('currtailGateId');
        $scope.taligateMarkers = $cookies.getObject('currtailGateMakers');
        //console.log($scope.taligateMarkers);
        $scope.isTailgateAdmin = false;
        $scope.goBack = function () {
            $timeout(function () {
                $state.go("app.my_tailgate");
            }, 1000);            
        }
        $scope.marker = {};
        $scope.isUserMarkerShown = false;
        $scope.latitude = 43.4651;
        $scope.longitude = -80.5223;
        $scope.$root.takemeThere = function (value) {
            getReverseGeocodingData(value.coords.latitude, value.coords.longitude);
        }
        $scope.deviceInformation = ionic.Platform.device();
        $scope.deviceModel = $scope.deviceInformation.model;
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
        getGeoLocation();
        function getReverseGeocodingData(lat, lng) {
            var latlng = new google.maps.LatLng(lat, lng);
            var address = '';
            // to create Geocode request
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({ 'latLng': latlng }, function (results, status) {
                if (status !== google.maps.GeocoderStatus.OK) {
                    //console.log(status);
                }
                // to check Geoeode Status is OK or not
                if (status == google.maps.GeocoderStatus.OK) {
                    address = (results[0].formatted_address);
                    var currurl = '';
                    if ($scope.isMobile.Android()) {
                        currurl = 'http://maps.google.com/?saddr=Current%20Location&daddr=' + address;
                    }
                    else if ($scope.isMobile.iOS()) {
                        currurl = 'http://maps.apple.com/?saddr=Current%20Location&daddr=' + address;
                    }
                    else if ($scope.isMobile.Windows()) {
                        currurl = 'maps:' + address;
                    }
                    else {
                        currurl = 'http://maps.google.com/?saddr=Current%20Location&daddr=' + address;
                    }
                    //console.log(address);
                    openUrl(currurl, "_system");
                }
            });            
        }
        
        //open venue URL
        function openUrl(url, target) {
            $cordovaInAppBrowser.open(url, target, { location: 'no' }).
                then(function (event) {
                    // success
                })
                .catch(function (event) {
                    // error
                    $ionicLoading.show({ template: 'Error in Processing URL..!', noBackdrop: false, duration: 2000 });
                });
        }

        if ($scope.taligateMarkers==undefined || $scope.taligateMarkers.latitude == undefined) {
            $scope.map ={
                    center: {
                        latitude: $scope.latitude,
                        longitude: $scope.longitude
                    },
                    scrollwheel: false,
                    zoom: 19
                } // when no markers are present
        } else {
           
            callMap($scope.taligateMarkers.latitude, $scope.taligateMarkers.longitude); //taking markers from cookies
            //adding window options for marker pin
            var nameLength = $scope.taligateMarkers.name.length;
            var descLength = $scope.taligateMarkers.description.length;
            var pixxelOffsetHeight = -155;
            if (descLength > 46) {
                pixxelOffsetHeight = -175;
                setTimeout(function () { $("#descTailgateMarker").css({ height: "40px" }); }, 50);
            }
            
            $scope.windowOpt = {
                boxClass: "infobox",
                boxStyle: {
                    backgroundColor: "#040404",
                    borderRadius: "5px",
                    width: "240px"
                },
                position: {
                    lat: $scope.taligateMarkers.latitude,
                    lng: $scope.taligateMarkers.longitude
                },
                show: true,
                pane: "floatPane",
                pixelOffset: {
                    width: -114,
                    height: pixxelOffsetHeight
                },
                enableEventPropagation: false,
            }
            
        }

        $scope.goToLocationTab = function () {
            //add cookie data for editing particular page on tab.
            $cookies.putObject("tabtoEdit", [1, 'locationTab']);
            checkTailgateId();
        }

        function checkTailgateId() {
            if (!tailGateId) {
            }
            else {
                //getting the data for editing the tailgate       
                editTailgate(tailGateId);
            }
        }

        $scope.isUserTailgateAdmin = function (tailgateId) {
            TailgateService.isUserTailgateAdmin(tailgateId).then(function (respData) {
                $scope.isTailgateAdmin = respData.data;
            });
        };

        $scope.isUserTailgateAdmin(tailGateId);

        function editTailgate(tailGateId) {
            var addTailgateParams = {}
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $cookies.putObject("editUserTailgate", respData.data);
                $state.go("app.add_my_tailgate");
            });
        }
                
        //calling map on load and on events change
        function callMap(currlatitude,currlongitude){
            angular.extend($scope, {
                map: {
                    center: {
                        latitude: currlatitude,
                        longitude: currlongitude
                    },
                    zoom: 19,
                    marker: [{  
                        coords: { 'latitude': currlatitude, 'longitude': currlongitude},
                        id: 0,
                        options: { icon: 'img/map_icons/tailgateMarker.svg' },
                    }]
                }
            });
           
        }

        
        //Flask user locator when user clicks on "Find Me" button
        $scope.centerOnMe = function () {
            $scope.isUserMarkerShown = !$scope.isUserMarkerShown;
            if ($scope.isUserMarkerShown) {
                $scope.map = {
                    center: {
                        latitude: $scope.userlat,
                        longitude: $scope.userlong
                    },
                    zoom: 14
                }
                $scope.marker = {
                    id: 1,
                    coords: {
                        latitude: $scope.userlat,
                        longitude: $scope.userlong
                    },
                    options: { icon: 'img/map_icons/tailgateMarker.svg', labelContent: "You Are Here", labelAnchor: "50 85", labelClass: 'UserGeolabels' }
                }
            } else {
                $scope.marker = {};
                callMap($scope.taligateMarkers.latitude, $scope.taligateMarkers.longitude); //taking markers from cookies
            }
        }
        function getGeoLocation() {
            var posOptions = { timeout: 10000, enableHighAccuracy: false };
            $cordovaGeolocation
              .getCurrentPosition(posOptions)
              .then(function (pos) {
                  $scope.userlat = pos.coords.latitude;
                  $scope.userlong = pos.coords.longitude;
              }, function (err) {
                  // error
                  $ionicLoading.show({ template: 'Unable to Get Location', noBackdrop: false, duration: 2000 });
                  // $flaskUtil.alert("Unable to Get Location");
              });
        }

     }
})();

