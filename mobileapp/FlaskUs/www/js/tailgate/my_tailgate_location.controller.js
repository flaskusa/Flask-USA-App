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
        console.log($scope.taligateMarkers);
        $scope.isTailgateAdmin = false;
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
            $scope.windowOpt = {
                position: {
                    lat: $scope.taligateMarkers.latitude,
                    lng: $scope.taligateMarkers.longitude
                },
                show: true
            }
        }

        $scope.goToLocationTab = function () {
            //add cookie data for editing particular page on tab.
            $cookies.putObject("tabtoEdit", [1, 'locationTab']);
            checkTailgateId();
        }

        function checkTailgateId() {
            if (!tailGateId) {
            }
            else {
                //getting the data for editing the tailgate       
                editTailgate(tailGateId);
            }
        }

        $scope.isUserTailgateAdmin = function (tailgateId) {
            TailgateService.isUserTailgateAdmin(tailgateId).then(function (respData) {
                $scope.isTailgateAdmin = respData.data;
            });
        };

        $scope.isUserTailgateAdmin(tailGateId);

        function editTailgate(tailGateId) {
            var addTailgateParams = {}
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $cookies.putObject("editUserTailgate", respData.data);
                $state.go("app.add_my_tailgate");
            });
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

