(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatelocationCtrl', mytailgatelocationCtrl);

    mytailgatelocationCtrl.$inject = ['$scope', '$state', '$stateParams', 'TailgateService', '$cookies', 'uiGmapGoogleMapApi'];

    /* @ngInject */
    function mytailgatelocationCtrl($scope, $state, $stateParams, TailgateService, $cookies, uiGmapGoogleMapApi) {
        $scope.myTailgaters = [];
        var tailGateId = $cookies.get('currtailGateId');
        $scope.taligateMarkers = $cookies.getObject('currtailGateMakers');
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }
        $scope.latitude = 43.4651;
        $scope.longitude = -80.5223;

        if ($scope.taligateMarkers==undefined || $scope.taligateMarkers.latitude == undefined) {
            $scope.map ={
                    center: {
                        latitude: $scope.latitude,
                        longitude: $scope.longitude
                    },
                    zoom: 19
                } // when no markers are present
        }else{
            callMap($scope.taligateMarkers.latitude, $scope.taligateMarkers.longitude); //taking markers from cookies
        }
                
                //calling map on load and on events change
                function callMap( currlatitude,currlongitude){
                    angular.extend($scope, {
                        map: {
                            center: {
                                latitude: currlatitude,
                                longitude: currlongitude
                            },
                            zoom: 19,
                            markers: [{  
                                coords: { 'latitude': currlatitude, 'longitude': currlongitude},
                                id: 0 
                            }]
                        }
                    });
                }
            }
})();

