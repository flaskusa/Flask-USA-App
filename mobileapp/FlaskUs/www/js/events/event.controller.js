(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('EventsCtrl', EventsCtrl);

    EventsCtrl.$inject = ['$scope', 'EventsService', '$cordovaGeolocation', '$http', '$ionicPopup'];

    /* @ngInject */
    function EventsCtrl($scope, EventsService, $cordovaGeolocation, $http, $ionicPopup) {
        /* jshint validthis: true */
        var self = this;
        $scope.allEvents = [];

        getAllEvents();

        function getAllEvents() {
            EventsService.getAllEvents().then(function (respData) {
                $scope.allEvent = respData.data.Events;
            });
        }       

        $scope.getAllfilteredEvents = function (eventList) {
            $http.get('http://maps.googleapis.com/maps/api/geocode/json?address=' + eventList)
                .then(function (locData) {
                    $scope.latitude = locData.data.results[0].geometry.location.lat;
                    $scope.longitude = locData.data.results[0].geometry.location.lng;
                    console.log($scope.latitude, $scope.longitude);
                    EventsService.getfilteredEvents($scope.latitude, $scope.longitude).then(function (respData) {
                        $scope.allEvent = respData.data.Events;
                        if (respData.data.Events.length == 0) {
                            showAlert();
                           
                        }
                    });
                  }, function (err) {
                      
                  });   
            
        }   
        $scope.searchBox = { showBox: false };
        function showAlert() {

            var alertPopup = $ionicPopup.alert({
                title: 'Alert',
                template: 'No Event at this ZipCode, Please Enter Zip Code Again'
            });

            alertPopup.then(function (res) {
                // Custom functionality....
                getAllEvents();
            });
        };
    }
})();

