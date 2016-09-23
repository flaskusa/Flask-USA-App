(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsMessageCtrl', FriendsMessageCtrl);

    FriendsMessageCtrl.$inject = ['$scope', '$http', '$ionicModal', 'FriendsNotificationService', '$flaskUtil', '$state','$ionicHistory','$timeout'];

    /* @ngInject */
    function FriendsMessageCtrl($scope, $http, $ionicModal, FriendsNotificationService, $flaskUtil, $state,$ionicHistory,$timeout) {
        $scope.allMessages=[];

        $scope.getNotification=function() {
            $scope.myTimeOut= $timeout(function () {
                FriendsNotificationService.getMessageCount().then(function (response2) {
                    $scope.messageCount = response2;
                    if ($scope.copyCount) {
                        if ($scope.copyCount != $scope.messageCount) {
                            FriendsNotificationService.getMyAllMessages().then(function (response) {
                                $scope.allMessages = response;
                                $scope.getMessagesTime();
                            });
                        }
                    }

                    $scope.copyCount = angular.copy($scope.messageCount);
                });
                $scope.getNotification();
                $scope.$on('$locationChangeStart', function() {
                    $timeout.cancel($scope.myTimeOut);
                });
            }, 5000);
        }
        $scope.getTimeWithInterval=function(){
            $scope.messageTimeOut=$timeout(function(){
                $scope.getMessagesTime();
                $scope.getTimeWithInterval();
            },10000);

        };
        $scope.getMessagesTime=function() {
            angular.forEach($scope.allMessages, function (value, key) {
                $scope.messageDate = new Date(value.dateTime);
                var result = getTimeDifference();
                value.diffDate = result;

            });
        }


    FriendsNotificationService.getMyAllMessages().then(function(response){
       $scope.allMessages=response;
        angular.forEach($scope.allMessages,function(value,key){
            $scope.messageDate=new Date(value.dateTime);
            var result=getTimeDifference();
            value.diffDate=result;
        });
    });
        $scope.goBack = function(){
            $ionicHistory.goBack();
        }
   function getTimeDifference(){
       var todayDate=new Date();
       var differenceTravel = todayDate.getTime()-$scope.messageDate.getTime();
       var seconds = Math.floor((differenceTravel) / (1000));
       var days=parseInt((seconds/(3600*24) ));
       var hours=parseInt(seconds/3600);
       var minutes=parseInt(seconds/60);
       var months=parseInt(days/30);
       var year=parseInt(months/12);
       if(seconds<60){
           return seconds+" seconds ago"
       }
       else if(minutes<60){
           return minutes+' minutes ago';
       }else if(hours<24){
           return hours+" hours ago";
       }
       else if(days<31){
           return days+" days ago"
       }else if(months<12){
           return months+" months ago"

       }else {
           year+" years ago"
       }
   }


    $scope.deleteMessage=function(messageId,index){
    FriendsNotificationService.deleteMessageById(messageId).then(function(response){
        if(response){
            $scope.allMessages.splice(index,1);
        }

    })
    }
        $timeout(function(){
            $scope.getTimeWithInterval();
        },10000);
    }


})();