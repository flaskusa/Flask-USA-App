(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('my_tailgateCtrl', my_tailgateCtrl);

    my_tailgateCtrl.$inject = ['$scope', 'TailgateService', '$state', '$ionicSlideBoxDelegate', '$cookies'];

    /* @ngInject */
    function my_tailgateCtrl($scope, TailgateService, $state, $ionicSlideBoxDelegate, $cookies) {
        var self = this;
        $scope.myTailgate = [];
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
            console.log(tailgateId,index);
            TailgateService.getTailgate(tailgateId).then(function (respData) {
                console.log(respData.data);
                $scope.addTailgateParams = {
                    tailgateName: respData.data.tailgateName,
                    tailgateDescription: respData.data.tailgateDescription,
                    eventId: respData.data.eventId,
                    eventName: respData.data.eventName,
                    endTime: respData.data.endTime,
                    startTime: respData.data.startTime,
                    venmoAccountId: respData.data.venmoAccountId,
                    amountToPay: respData.data.amountToPay
                }
                console.log($scope.addTailgateParams);
            });
        }

        $scope.leaveTailgate = function (tailgateId, index) {
            console.log(tailgateId, index);
            TailgateService.deleteTailgate(tailgateId).then(function (respData) {
                console.log(respData);
                $scope.allTailgate.splice(index, 1);
            });
            
        }
    }
})();

