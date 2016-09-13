(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsNotificationCtrl', FriendsNotificationCtrl);

    FriendsNotificationCtrl.$inject = ['$scope', '$http','$ionicModal','FriendsNotificationService','$flaskUtil','$state','$ionicHistory'];

    /* @ngInject */
    function FriendsNotificationCtrl($scope, $http, $ionicModal,FriendsNotificationService,$flaskUtil,$state,$ionicHistory) {


        $scope.goToNotifications = function () {
            $state.go('app.notifications');

        }
        $scope.goToMessages = function () {
            $state.go('app.messages');
        }
        $scope.goBack = function(){
            $ionicHistory.goBack();
        }
        $scope.initialize=function() {
            FriendsNotificationService.getNotificationCount().then(function (response) {
                $scope.notificationCount = response;
            })
            FriendsNotificationService.getMessageCount().then(function (response) {
                $scope.messageCount = response;
            })
        }


    }

})();