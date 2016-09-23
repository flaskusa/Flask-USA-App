(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsNotificationCtrl', FriendsNotificationCtrl);

    FriendsNotificationCtrl.$inject = ['$scope', '$http','$ionicModal','FriendsNotificationService','$flaskUtil','$state','$ionicHistory'];

    /* @ngInject */
    function FriendsNotificationCtrl($scope, $http, $ionicModal,FriendsNotificationService,$flaskUtil,$state,$ionicHistory) {

        $scope.requestDetail=[];
        $scope.requestedUserDetail=[]
        $scope.goToNotifications = function () {
            $state.go('app.notifications');

        }
        $scope.goToNavigator=function(){
            $state.go("app.user_navigation_menu");
        }
        $scope.goToMessages = function () {
            $state.go('app.messages');
        }
        $scope.goBack = function(){
            $ionicHistory.goBack();
        }
        $scope.initialize=function() {
            FriendsNotificationService.getNotificationCount().then(function (response1) {

                    $scope.notificationCount = response1;
                });
            FriendsNotificationService.getMessageCount().then(function (response2) {
                $scope.messageCount = response2;
            });

        }
       $scope.getRequestToConfirm=function(){
           FriendsNotificationService.getRequestToConfirm().then(function(response1){
               $scope.requestDetail=response1;
               angular.forEach($scope.requestDetail,function(value,key) {
                   FriendsNotificationService.getUserById(value.userId).then(function (response2) {
                       $scope.requestedUserDetail.push(response2);
                   });
               });
           });
       };
        $scope.addSocialRelation=function(userId,index){
            FriendsNotificationService.addSocialRelation(userId).then(function(response){
                $scope.requestedUserDetail.splice(index,1);
            });
        }
        $scope.deleteSocialRelation=function(userId,index){
            FriendsNotificationService.deleteRequest(userId).then(function(response){
                $scope.requestedUserDetail.splice(index,1);
            })

        }

    }

})();