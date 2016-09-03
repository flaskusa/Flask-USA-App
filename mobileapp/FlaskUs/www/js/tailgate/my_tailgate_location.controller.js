(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatelocationCtrl', mytailgatelocationCtrl);

    mytailgatelocationCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies', 'uiGmapGoogleMapApi'];

    /* @ngInject */
    function mytailgatelocationCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies, uiGmapGoogleMapApi) {
        $scope.myTailgaters = [];
        var tailGateId = $cookies.get('currtailGateId');
        $scope.taligateMarkers = angular.fromJson($cookies.get('currtailGateMakers'));
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }

        var Markers = [
          {
              "id": "0",
              "coords": {
                  "latitude": $scope.taligateMarkers.latitude,
                  "longitude": $scope.taligateMarkers.longitude
              },
              "window": {
                  "title": $scope.taligateMarkers.name
              }
          }
        ];
        $scope.map = {
            draggable:true,
            center: { latitude: 43.4651, longitude: -80.5223},
            zoom: 4
        };
        $scope.markers = Markers;
    }
})();

