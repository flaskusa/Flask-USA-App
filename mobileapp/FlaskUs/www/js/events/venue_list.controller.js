(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('VenueCtrl', VenueCtrl);

    VenueCtrl.$inject = ['$scope', 'EventsService', '$cordovaGeolocation', '$http', '$ionicPopup', 'SERVER', '$filter', '$cookies', '$localStorage', '$ionicSlideBoxDelegate', '$rootScope', '$ionicModal', "$state",'$ionicHistory'];

    /* @ngInject */
    function VenueCtrl($scope, EventsService, $cordovaGeolocation, $http, $ionicPopup, SERVER, $filter, $cookies, $localStorage, $ionicSlideBoxDelegate, $rootScope, $ionicModal, $state, $ionicHistory) {
        /* jshint validthis: true */
        var self = this;
        $scope.allVenues = [];
        $scope.venuesId = [];
        var location = 'geolocation';
        var searchStringList = angular.copy($scope.searchstringList);
        $scope.allEventId = [];
        
        $scope.$on('$ionicView.beforeEnter', function () {
            if (navigator.connection.type == "none" || navigator.connection.type == undefined) {
                getVenueNamefromLocalstorage();
            } else {
                getVenueName();
            }
        });

        //Get venue name for event details
        function getVenueName() {
            EventsService.getAllVenues().then(function (respData) {
                if(respData !=undefined){
                    $scope.allVenues = respData;
                    $localStorage.allVenues = respData;
                    $cookies.putObject("eventVenues", $scope.allVenues);
                    for (var i = 0; i < $scope.allVenues.length; i++) {
                        $scope.venuesId.push($scope.allVenues[i].venueId);
                    }
                }

                if ($scope.allVenues.length== undefined && $scope.allVenues.length == 0) {                    
                    $scope.venue_Error = true;
                } else {
                    $scope.venue_Error = false;
                }

            });
        }

        function getVenueNamefromLocalstorage() {
            //EventsService.getAllVenues().then(function (respData) {
            $scope.allVenues = $localStorage.allVenues;
            if($scope.allVenues !=undefined){
                $cookies.putObject("eventVenues", $scope.allVenues);
                for (var i = 0; i < $scope.allVenues.length; i++) {
                    $scope.venuesId.push($scope.allVenues[i].venueId);
                }
            }
            if ($scope.allVenues== undefined || $scope.allVenues.length == 0) {                    
                $scope.venue_Error = true;
            } else {
                $scope.venue_Error = false;
            }

            //});
        }

    }
})();

