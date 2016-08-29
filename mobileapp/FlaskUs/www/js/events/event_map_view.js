(function () {
    'use strict';
    angular.module('flaskApp')
            .controller('eventMapViewCtrl', eventMapViewCtrl);

    eventMapViewCtrl.$inject = ['$scope', '$stateParams', '$state', '$ionicPlatform', 'EventsService'];

    /* @ngInject */
    function eventMapViewCtrl($scope, $stateParams, $state, $ionicPlatform, EventsService) {
        /* jshint validthis: true */
        var self = this;

        

        initEventData()
        initMap();

        function initEventData(){
            try{
            var eventDetails = angular.toJson($stateParams.eventDetails.Event);
            var eventObj = angular.fromJson($stateParams.eventDetails.Event);
            $scope.eventName = eventObj.eventName;
            }catch(ex){

            }
        }

        function initMap(){
          // Getting the map selector in DOM
            var mapDiv = document.getElementById("map_canvas");
            var latLng = new google.maps.LatLng(42.3314, -83.0458);
            
            var mapOptions = {
            center: latLng,
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
            };
        
            $scope.map = new google.maps.Map(mapDiv, mapOptions);

        }
        
    }
})(); 