(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', 'TailgateService', '$cordovaDatePicker', '$timeout', '$ionicSlideBoxDelegate', '$ionicScrollDelegate'];

    /* @ngInject */
    function add_mytailgateCtrl($scope, TailgateService, $cordovaDatePicker, $timeout, $ionicSlideBoxDelegate, $ionicScrollDelegate) {
        //for adding tailgate
        $ionicSlideBoxDelegate.update();
        $ionicScrollDelegate.resize()
        var self = this;
        function initialize() {
            var latlng = new google.maps.LatLng(42.3314, -83.0458);
            var myOptions = {
                zoom: 8,
                center: latlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map_canvas"),
                    myOptions);
        }
        google.maps.event.addDomListener(window, "load", initialize);


        getallEventnames();
        $scope.addmyTailgate = function (tailgatedata) {
            console.log(tailgatedata);
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
                console.log(respData.data.exception);

                //$scope.AddedSuccess = true;
                //$timeout(function () { $scope.AddedSuccess = false; }, 3000);
            });
        }

        $scope.getvenuefromSelect = function (tailgatedata) {
            console.log(tailgatedata);
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
                console.log(respData.data.exception);
            });
        }

        $scope.slidePrevious1 = function () {
            $ionicSlideBoxDelegate.previous();
        }

        $scope.slideNext1 = function () {
            $ionicSlideBoxDelegate.next();
        }

        var Slide = function () {
            this.validators = [];
            this.errorMessage = "Something went wrong!";
        }
        Slide.prototype.isValid = function () {
            if (this.validators.length == 0) {
                return true;
            }
            for (var i = 0; i < this.validators.length; i++) {
                if (!this.validators[i]()) {
                    return false;
                }
            }
            return true;
        }
        $scope.slide = -1;
        $scope.slides = [];
        $timeout(function () {
            $scope.$watch(function () {
                return $ionicSlideBoxDelegate.currentIndex();
            }, function (index) {

                $scope.errorMessage = "";

                //Initial state, don't validate
                if ($scope.slide < 0) {
                    $scope.slide = 0;
                    return;
                }

                if ($scope.slides[$scope.slide].isValid()) {
                    $scope.slide = index;
                    return;
                } else {
                    $ionicSlideBoxDelegate.slide($scope.slide);
                    $scope.errorMessage = $scope.slides[$scope.slide].errorMessage;
                }

            });
        }, 0);

        $scope.Details = [];
        $scope.eventDetails = [];
        $scope.eventNames = [];
        function getallEventnames() {
            TailgateService.getallEvents().then(function (respData) {
                console.log(respData.data.Events);
                $scope.eventDetails = respData.data.Events;
                var len = $scope.eventDetails.length - 1;
                for (var i = 0; i <= len; i++) {
                    if ($scope.eventNames.indexOf($scope.eventDetails[i].eventName) == -1) {
                        $scope.eventNames.push({ 'eventName': $scope.eventDetails[i].eventName, 'eventId': $scope.eventDetails[i].eventId })
                    }
                }
                console.log($scope.eventNames);
            });            
        }

        //Setup the slides
        $scope.slide1 = new Slide();
        $scope.slide1.validators.push(function () {
            return $scope.slide1.TailgateName && $scope.slide1.TailgateName.length != 0;
        });
        $scope.slide1.validators.push(function () {
            return $scope.slide1.Description && $scope.slide1.Description.length != 0;
        });
        $scope.slide1.validators.push(function () {
            return $scope.slide1.eventnames && $scope.slide1.eventnames.length != 0;
        });
        $scope.slide1.validators.push(function () {
            return $scope.slide1.Eventdate && $scope.slide1.Eventdate.length != 0;
        });
        $scope.slide1.validators.push(function () {
            return $scope.slide1.StartTime && $scope.slide1.StartTime.length != 0;
        });
        $scope.slide1.validators.push(function () {
            return $scope.slide1.EndTime && $scope.slide1.EndTime.length != 0;
        });
        $scope.slide1.validators.push(function () {
            return $scope.slide1.VenmoAccount && $scope.slide1.VenmoAccount.length != 0;
        });
        $scope.slide1.validators.push(function () {
            return $scope.slide1.Amount && $scope.slide1.Amount.length != 0;
        });
        $scope.slide1.errorMessage = "Please enter all the fields!";
        $scope.slides.push($scope.slide1);

        $scope.slideHasChanged = function ($index) {
            //alert('slideHasChanged $index=' + $index);
            if ($index === 0) {
                // first box
                //$scope.prevName = "";
//$scope.NextName = "LOCATION";
            }
        };
    }
})();

