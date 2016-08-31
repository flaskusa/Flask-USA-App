(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgateDetailsCtrl', mytailgateDetailsCtrl);

    mytailgateDetailsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService' ,'$cookies'];

    /* @ngInject */
    function mytailgateDetailsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies) {
        $scope.myTailgaters = [];
        var tailGateId = $stateParams.tailgateId;
        $cookies.put('tailGateId', tailGateId);
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        getMyTailgate();
        $scope.goBack=function() {
            $state.go("app.my_tailgate");
        }
        function initMap() {
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

        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                console.log(respData);
                $scope.myTailgate = respData.data;
                getlocationName($scope.myTailgate.eventId);
                getMyTailgateImages(tailGateId);
                getTailgaters(tailGateId);
                getTailgateMarkers(tailGateId);
            });
        }
        function getlocationName(evntId) {
            TailgateService.getEvent(evntId).then(function (respData) {
                console.log(respData);
                $scope.myeventLocation = respData.data;
            });
        }
        function getMyTailgateImages(tailGateId) {
            TailgateService.getMyTailgateImages(tailGateId).then(function (respData) {
                console.log(respData);
                $scope.myTailgateImages = respData.data;
            });
        }
        function getTailgaters(tailGateId) {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (respData) {
                console.log(respData);
                $scope.myTailgaters = respData.data;
            });
        }
        function getTailgateMarkers(tailGateId) {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (respData) {
                console.log(respData);
                $scope.myTailgatermarkers = respData.data;
            });
        }
    }
})();

