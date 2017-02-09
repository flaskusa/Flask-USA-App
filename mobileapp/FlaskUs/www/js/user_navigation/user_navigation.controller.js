(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_navigation_menuCtrl', user_navigation_menuCtrl);

    user_navigation_menuCtrl.$inject = ['$scope','$rootScope', '$state','$localStorage','FriendsNotificationService','$timeout','$cookies'];

    /* @ngInject */
    function user_navigation_menuCtrl($scope, $rootScope, $state,$localStorage,FriendsNotificationService,$timeout,$cookies) {
        var self = this;
        $localStorage["myFriendDetail"] = [];
        $scope.flag=[];
        $scope.goToMessagePage=false;
        $scope.goToFriendPage=false;
        $scope.goToRequestPage=false;

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

            FriendsNotificationService.getNotificationCount().then(function (response1) {


            FriendsNotificationService.getMyAllMessages().then(function (response) {
                $scope.allMessages = response;
                for (var i = 0; i < $scope.allMessages.length; i++) {
                    if ($scope.allMessages[i].read == false) {
                        $scope.flag.push($scope.allMessages[i].messageId);
                    }
                }
                $rootScope.totalMessageNotification = parseInt($scope.flag.length);
                $rootScope.totalRequestNotification = response1;

            });
            });
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
