(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_navigation_menuCtrl', user_navigation_menuCtrl);

    user_navigation_menuCtrl.$inject = ['$scope','$rootScope', '$state','$localStorage','FriendsNotificationService','$timeout','$cookies'];

    /* @ngInject */
    function user_navigation_menuCtrl($scope, $rootScope, $state,$localStorage,FriendsNotificationService,$timeout,$cookies) {
        var self = this;
        $localStorage["myFriendDetail"] = [];
        $scope.goToMessagePage=false;
        $scope.goToFriendPage=false;
        $scope.goToRequestPage = false;
        $scope.groupMessageCount = 0;
        $scope.userMessageCount = 0;
        $rootScope.totalMessageNotification=0;
        $rootScope.totalRequestNotification = 0;
         $scope.isUserLogin=function() {
             $scope.myTimeOut = $timeout(function () {
                 var userDetail = $cookies.getObject('CurrentUser');
                 if (userDetail.data.userId > 0) {

                     $scope.initialize();
                 }
                 $scope.isUserLogin();
                 if (userDetail.data.userId > 0)
                 $timeout.cancel($scope.myTimeOut);

             }, 1000);

         }

         $scope.initialize = function () {
             FriendsNotificationService.getNotificationCount().then(function (response) {
                 $rootScope.totalRequestNotification = response;
             });
             FriendsNotificationService.getTotalUnreadMessagesCount().then(function (response1) {
                 $scope.userMessageCount = response1;
             });
             FriendsNotificationService.getTotalUnreadGroupMessagesCount().then(function (response2) {
                 $scope.groupMessageCount = response2;
             });
             $rootScope.totalMessageNotification = $scope.userMessageCount + $scope.groupMessageCount;
        }
        $scope.myEvent = function ()
        {
            $state.go("app.my_events"); 
        }

        $scope.myTailgate = function ()
        {
            $state.go("app.my_tailgate");
        }

        $scope.myFriend = function ()
        {
            if($scope.goToMessagePage==false && $scope.goToRequestPage==false)

            $state.go("app.my_friends_tab");
        }
        $scope.goToMessage=function(){
            $scope.goToMessagePage=true;

            $state.go("app.messages");
        }
        $scope.goToRequest=function(){
            $scope.goToRequestPage=true;
            $state.go("app.notifications");
        }
        $scope.isUserLogin();

    }
})();
