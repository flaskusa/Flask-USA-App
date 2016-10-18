(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('my_tailgateCtrl', my_tailgateCtrl);

    my_tailgateCtrl.$inject = ['$scope', 'TailgateService', '$state', '$ionicSlideBoxDelegate', '$cookies'];

    /* @ngInject */
    function my_tailgateCtrl($scope, TailgateService, $state, $ionicSlideBoxDelegate, $cookies) {
        var self = this;
        $scope.myTailgate = [];
        $cookies.remove("editUserTailgate");
        $cookies.remove("newtailgateId");
        $cookies.remove("newtailgatedata");
        var userResponse = $cookies.getObject('CurrentUser');
        var UserId = userResponse.data.userId;
        getAlltailgates();
        $scope.goBack = function () {
            $state.go("app.user_navigation_menu");
        }

        function getAlltailgates() {
            TailgateService.getMyTailgates(UserId).then(function (respData) {
                $scope.allTailgate = respData.data;
                console.log(respData.data);
            });
        }
        $scope.editTailgate = function (tailgateId, index) {
            console.log(tailgateId, index);
            var addTailgateParams = {}
            TailgateService.getTailgate(tailgateId).then(function (respData) {
                console.log(respData.data);
                addTailgateParams.tailgateId = tailgateId;
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
                $cookies.put('currtailGateId', tailgateId);
                $state.go("app.add_my_tailgate");
                $cookies.putObject("editUserTailgate", addTailgateParams);
            });

        }

        $scope.leaveTailgate = function (tailgateId, index) {
            console.log(tailgateId, index);
            TailgateService.deleteTailgate(tailgateId).then(function (respData) {
                console.log(respData);
                $scope.allTailgate.splice(index, 1);
            });

        }
        $scope.addMyTailgate = function () {
            $cookies.put("currtailGateId", "0");
            $state.go("app.add_my_tailgate");
        }
    }
})();

