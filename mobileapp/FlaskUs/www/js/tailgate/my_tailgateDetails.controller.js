(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgateDetailsCtrl', mytailgateDetailsCtrl);

    mytailgateDetailsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService' ,'$cookies'];

    /* @ngInject */
    function mytailgateDetailsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies) {
        $cookies.remove("currtailGateMakers");
        $scope.myTailgaters = [];
        $scope.allMessages = [];
        $scope.userFirstName = [];
        $scope.messageUser = [];
        var userResponse = $cookies.getObject('CurrentUser');
        var tailGateId = $stateParams.tailgateId;
        var userId = [];
        var userMessage = [];
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
                console.log(respData.data.length);
                $scope.allMessages = respData.data;
                for (var i = 0; i < $scope.allMessages.length; i++) {
                    userId = respData.data[i].userId;
                    userMessage = respData.data[i].messageText;
                    console.log(userId);
                    getTailgateUser(userId,userMessage); 
                }
            });
        }
        
        function getTailgateUser(userId,userMessage) {
            TailgateService.getAllUser(userId).then(function (respData) {
                console.log(respData.data);
                $scope.userFirstName.push(respData.data);
                $scope.messageUser.push({ message: userMessage, username: respData.data.firstName });
                console.log($scope.messageUser);
            });
        }

        $scope.checkTailgateId = function () {
            if (!tailGateId ) {
                console.log("TAILGATE ID IS 0");
            }
            else {
                editTailgate(tailGateId);
            }
        }

        function editTailgate(tailGateId) {
            console.log(tailGateId);
            var addTailgateParams = {}
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                console.log(respData.data);
                addTailgateParams.tailgateName = respData.data.tailgateName;
                addTailgateParams.tailgateDescription = respData.data.tailgateDescription;
                addTailgateParams.eventId = respData.data.eventId;
                addTailgateParams.eventName = respData.data.eventName;
                addTailgateParams.endTime = respData.data.endTime;
                addTailgateParams.startTime = respData.data.startTime;
                addTailgateParams.venmoAccountId = respData.data.venmoAccountId;
                addTailgateParams.amountToPay = respData.data.amountToPay;
                addTailgateParams.tailgateDate = respData.data.tailgateDate;
                console.log(addTailgateParams);
                $state.go("app.add_my_tailgate");
                $cookies.putObject("editUserTailgate", addTailgateParams);
            });
        }

    }
})();

