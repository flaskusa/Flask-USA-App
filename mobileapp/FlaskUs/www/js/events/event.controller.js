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

        $scope.eventTypeIds = '';
        $scope.startDate = '';
        $scope.endDate = '';
        $scope.searchString = 'a';
        $scope.latitude = '';
        $scope.longitude = '';

        getAllEvents($scope.eventTypeIds, $scope.startDate , $scope.endDate ,$scope.searchString ,$scope.latitude ,$scope.longitude);

        function getAllEvents() {
            EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate , $scope.endDate ,$scope.searchString ,$scope.latitude ,$scope.longitude).then(function (respData) {
                $scope.allEvent = respData.data.Events;
            });
        }
        
        $scope.getAllfilteredEvents = function (eventList) {
            $http.get('http://maps.googleapis.com/maps/api/geocode/json?address=' + eventList)
                .then(function (locData) {
                    $scope.latitude = locData.data.results[0].geometry.location.lat;
                    $scope.longitude = locData.data.results[0].geometry.location.lng;
                    var searchString = '';
                    console.log($scope.latitude, $scope.longitude);
                    EventsService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                        $scope.allEvent = respData.data.Events;
                        if (respData.data.Events.length == 0) {
                            showAlert();
                        }
                    });
                  }, function (err) {                      
                  });   
            
        }
        $scope.onchange = function (id) {
            var startDate = new Date();
            $scope.StartDate = startDate.setDate(startDate.getDate());
            var endDate = new Date();
            $scope.EndDate = endDate.setDate(endDate.getDate() - parseInt(id));
            EventsService.getAllEvents($scope.eventTypeIds, $scope.StartDate, $scope.EndDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                $scope.allEvent = respData.data.Events;
                if (respData.data.Events.length == 0) {
                    showAlert();
                }
            });
        }
        $scope.done = true;
        $scope.searchBox = { showBox: false };

        function showAlert() {
            var alertPopup = $ionicPopup.alert({
                title: 'Alert',
                template: 'There are No events'
            });

            alertPopup.then(function (res) {
                // Custom functionality....
                getAllEvents();
            });
        };
    }
})();

