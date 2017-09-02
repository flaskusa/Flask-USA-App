(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('AdvertisementCtrl', AdvertisementCtrl);

    AdvertisementCtrl.$inject = ['$scope', '$stateParams', '$state', 'SERVER', '$ionicPopup', '$timeout', 'AdvertisementService', '$flaskUtil', '$ionicSlideBoxDelegate','$cordovaInAppBrowser','$ionicScrollDelegate','$cookies','IonicClosePopupService'];
    function AdvertisementCtrl($scope, $stateParams, $state, SERVER, $ionicPopup, $timeout, AdvertisementService, $flaskUtil, $ionicSlideBoxDelegate,$cordovaInAppBrowser,$ionicScrollDelegate,$cookies,IonicClosePopupService) {
        $scope.imageDetail = [];
        // var baseURL = SERVER.hostName;
        var baseImagePath = SERVER.hostName+"c/document_library/get_file";
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
            IonicClosePopupService.register($scope.myPopup);

            $scope.popupClose = function () {
                $scope.myPopup.close();
            }

        };


        $scope.initialize=function(allEventId) {
            AdvertisementService.getAllAdvertisementDetail(allEventId).then(function (response) {
                    if (response.Images != undefined) {
                        $scope.ImageUrls = [];
                        $scope.imageDetail = response.Images;
                        angular.forEach($scope.imageDetail, function (vlaue, key) {
                            var imageURL = baseImagePath + "?uuid=" + vlaue.imageUUID + "&groupId=" + vlaue.imageGroupId;
                            $scope.ImageUrls.push(imageURL);
                        })
                        showAdv();
                    }
            });
        }
       /* $scope.checkForCookiesChanges=function(allEventId){
            var copyAllEventId=angular.copy(allEventId);
            $scope.myTimeOut2=$timeout(function(){
                $scope.counter++
                var allEventIds = $cookies.get('AllEventId');
                if(allEventIds!=angular.copy(copyAllEventId) && copyAllEventId!==undefined){
                    $scope.changeDetected=true;
                    $scope.initialize(allEventIds);
                }

                $scope.checkForCookiesChanges(copyAllEventId);
                if($scope.counter==4){
                    if($scope.changeDetected!=true) {
                        $scope.initialize(allEventId);
                    }
                    $timeout.cancel($scope.myTimeOut2);
                }else if($scope.changeDetected==true){
                    $timeout.cancel($scope.myTimeOut2);

                }
            },200);

        }*/
        $scope.getAdvertisement=function() {
            var allEventId=$cookies.get('AllEventId');
            $scope.myTimeOut=$timeout(function(){

                if(allEventId!=undefined){
                    $scope.initialize(allEventId);


                }
                $scope.getAdvertisement();
                if(allEventId!=undefined) {
                    $timeout.cancel($scope.myTimeOut);
                }
            }, 200);
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
        $scope.openWebsite=function(websiteUrl){
           var websiteUrl = fixUrl(websiteUrl);
                openUrl(websiteUrl, "_system");

        }
        function fixUrl(url) {
            if (url) {
                if (url.indexOf("http://") > -1 || "https://" > -1) {
                    return url;
                } else {
                    return "http://" + url;
                }
            }
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
        $scope.callNow=function(phonenumber){
            var telephoneToCall = "tel:" + phonenumber;
            openUrl(telephoneToCall, "_system");
        };

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
        $scope.$on ('$ionicView.beforeEnter',
        ionic.trigger('resize', {target: window}));
        function showAdv() {
            //$timeout(function () {
                $ionicSlideBoxDelegate.$getByHandle('advertisement-viewer').update();
            //}, 2000);
        }
    }
})();