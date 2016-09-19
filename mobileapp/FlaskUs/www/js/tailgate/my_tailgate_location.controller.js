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

        $scope.latitude = 43.4651;
        $scope.longitude =-80.5223;
                if(!$scope.taligateMarkers){
                  callMap($scope.latitude,$scope.longitude);
                }else{
                  callMap($scope.taligateMarkers.latitude,$scope.taligateMarkers.longitude);
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
                  coords: { latitude: $scope.taligateMarkers.latitude, longitude: $scope.taligateMarkers.longitude }, 
                          id: 4 ,
                          window: { title: $scope.taligateMarkers.name}
                        }]
                        }
                    });
                }
            }
})();

