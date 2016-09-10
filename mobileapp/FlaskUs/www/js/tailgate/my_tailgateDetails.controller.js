(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgateDetailsCtrl', mytailgateDetailsCtrl);

    mytailgateDetailsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService' ,'$cookies'];

    /* @ngInject */
    function mytailgateDetailsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies) {
        $scope.myTailgaters = [];
        $scope.allMessages = [];
        var tailGateId = $stateParams.tailgateId;
        $cookies.put('currtailGateId', tailGateId);
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        getMyTailgate();
        get_message_list(tailGateId);
        $scope.goBack=function() {
            $state.go("app.my_tailgate");
        }

        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {

                $scope.myTailgate = respData.data;
                getlocationName($scope.myTailgate.eventId);
                getMyTailgateImages(tailGateId);
                getTailgaters(tailGateId);
                getTailgateMarkers(tailGateId);
            });
        }
        function getlocationName(evntId) {
            TailgateService.getEvent(evntId).then(function (respData) {

                $scope.myeventLocation = respData.data;
            });
        }
        function getMyTailgateImages(tailGateId) {
            TailgateService.getMyTailgateImages(tailGateId).then(function (respData) {

                $scope.myTailgateImages = respData.data;
            });
        }
        function getTailgaters(tailGateId) {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (respData) {

                $scope.myTailgaters = respData.data;
            });
        }
        function getTailgateMarkers(tailGateId) {
            TailgateService.getMapMarkers(tailGateId).then(function (respData) {
                $cookies.putObject('currtailGateMakers', respData.data);
            });
        }

        //save message Function
        $scope.saveMessage = function (msg) {
            console.log(msg);
            $scope.tailgateDetailId = tailGateId;
            console.log($scope.tailgateDetailId);
            TailgateService.saveMessage(msg, tailGateId).then(function (respData) {
                console.log(respData);
            });
        }

        function get_message_list(tailGateId) {
            TailgateService.getAllMessages(tailGateId).then(function (respData) {
                console.log(respData.data);
                $scope.allMessages = respData.data;
            });
        }
    }
})();

