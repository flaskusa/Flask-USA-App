(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('AdvertisementCtrl', AdvertisementCtrl);

    AdvertisementCtrl.$inject = ['$scope', '$stateParams', '$state', 'SERVER', '$ionicPopup', '$timeout', 'AdvertisementService', '$flaskUtil', '$ionicSlideBoxDelegate','$cordovaInAppBrowser','$ionicScrollDelegate','$cookies'];
    function AdvertisementCtrl($scope, $stateParams, $state, SERVER, $ionicPopup, $timeout, AdvertisementService, $flaskUtil, $ionicSlideBoxDelegate,$cordovaInAppBrowser,$ionicScrollDelegate,$cookies) {
        $scope.imageDetail = [];
        var baseURL = SERVER.hostName;
        var baseImagePath = baseURL+"c/document_library/get_file";
        $scope.ImageUrls = [];
        $scope.showPopup = function (index) {
            $scope.fullImageUrl = baseImagePath + "?uuid=" + $scope.imageDetail[index].fullScreenUUID + "&groupId=" + $scope.imageDetail[index].fullScreenGroupId;
            $scope.popupTitle = $scope.imageDetail[index].campaignName;
            $scope.phoneNumber = $scope.imageDetail[index].phone;
            $scope.website = $scope.imageDetail[index].url;
            $scope.address = $scope.imageDetail[index].addrLine1 + ", " + $scope.imageDetail[index].city + ", " + $scope.imageDetail[index].zipCode;
            $scope.href = $scope.createMapLink($scope.address);
            $scope.data = {};
            $scope.myPopup = $ionicPopup.show({
                cssClass: 'custom-class custom-popup',
                templateUrl: 'templates/advertisementPopup.html',
                scope: $scope
            });
            $scope.popupClose = function () {
                $scope.myPopup.close();
            }

        };

        $scope.initialize=function() {
            AdvertisementService.getAllAdvertisementDetail().then(function (response) {
                if (response.Images != undefined) {
                    $scope.ImageUrls = [];
                    $scope.imageDetail = response.Images;
                    angular.forEach($scope.imageDetail, function (vlaue, key) {
                        var imageURL = baseImagePath + "?uuid=" + vlaue.imageUUID + "&groupId=" + vlaue.imageGroupId;
                        $scope.ImageUrls.push(imageURL);

                    })

                } else {
                    $flaskUtil.alert("failed to load")
                }
            });
        }
        $scope.getAdvertisement=function() {
            var allEventId=$cookies.get('AllEventId');
            $scope.myTimeOut=$timeout(function(){

                if(allEventId!=undefined){
                    $scope.initialize();

                }
                $scope.getAdvertisement();
                if(allEventId!=undefined) {
                    $timeout.cancel($scope.myTimeOut);
                }
            }, 20);
        }
        $scope.getAdvertisement();

        $scope.openUrlForAdv = function () {
            openUrl($scope.href, "_system");
        }
        function openUrl(url, target) {
            $cordovaInAppBrowser.open(url, target, {location: 'no'}).
                then(function (event) {
                    // success
                })
                .catch(function (event) {
                    // error
                });
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

        $scope.createMapLink = function (address1) {
            var findUs = '';
            if ($scope.isMobile.Android()) {
                findUs = 'https://www.google.com/maps/q?' + address1;
            }
            else if ($scope.isMobile.iOS()) {
                findUs = 'http://maps.apple.com/?q=' + address1;
            }
            else if ($scope.isMobile.Windows()) {
                findUs = 'maps:' + address1;
            }
            else {
                findUs = 'http://maps.google.com/?q=' + address1;
            }
            return findUs;
        }

        $timeout(function () {
            $ionicSlideBoxDelegate.$getByHandle('image-viewer').update();
        }, 5000);





    }
})();