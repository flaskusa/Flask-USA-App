(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_my_tailgateCtrl', add_my_tailgateCtrl);

    add_my_tailgateCtrl.$inject = ['$scope', '$state', 'SERVER','$stateParams', 'TailgateService'];

    /* @ngInject */
    function add_my_tailgateCtrl($scope, $state, SERVER, $stateParams, TailgateService) {
        console.log($stateParams);
        var tailGateId = $stateParams.tailgateId;
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        getMyTailgate();
        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                console.log(respData);
                $scope.myTailgate = respData.data;
                getlocationName($scope.myTailgate.eventId);
                getMyTailgateImages(tailGateId);
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
    }
})();

