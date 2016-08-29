(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgateDetailsCtrl', mytailgateDetailsCtrl);

    mytailgateDetailsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService'];

    /* @ngInject */
    function mytailgateDetailsCtrl($scope, $state, SERVER, $stateParams, TailgateService) {
        $scope.myTailgaters = [];
        var tailGateId = $stateParams.tailgateId;
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
       // initMap();
        getMyTailgate();
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

