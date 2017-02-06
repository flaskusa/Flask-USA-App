(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsNotificationCtrl', FriendsNotificationCtrl);

    FriendsNotificationCtrl.$inject = ['$scope', '$http','$ionicModal','FriendsNotificationService','$flaskUtil','$state','$ionicHistory','UserService','SERVER'];

    /* @ngInject */
    function FriendsNotificationCtrl($scope, $http, $ionicModal,FriendsNotificationService,$flaskUtil,$state,$ionicHistory,UserService,SERVER) {

        $scope.requestDetail=[];
        $scope.requestedUserDetail=[];
        $scope.notificationCount=0;
        $scope.messageCount = 0;
        $scope.mId = [];
        $scope.allMessages = {};
        $scope.flag = [];
        $scope.profileUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        $scope.showEmptymessage=false;
        $scope.goToNotifications = function (){
            $state.go('app.notifications');

        }
        $scope.goToNavigator=function(){
            $state.go("app.user_navigation_menu");
        }

        $scope.initialize = function () {
            FriendsNotificationService.getNotificationCount().then(function (response1) {
                $scope.notificationCount = response1;
            });
            FriendsNotificationService.getMyAllMessages().then(function (response) {
                $scope.allMessages = response;
                for (var i = 0; i < $scope.allMessages.length; i++) {
                    if ($scope.allMessages[i].read == false) {
                        $scope.flag.push($scope.allMessages[i].messageId);
                    }
                }
                $scope.messageCount = $scope.flag.length;
            });
        }


        $scope.goToMessages = function () {
            $state.go('app.messages');            
              /*  for (var i = 0; i < $scope.allMessages.length; i++) {
                    $scope.mId.push($scope.allMessages[i].messageId);
                }
                for(var j=0;j<$scope.mId.length;j++){
                    FriendsNotificationService.setReadMessage($scope.mId[j]).then(function (response) {
                        $scope.readFlag = response;
                        console.log($scope.readFlag);
                    })
                }  */
        }


        $scope.goBack = function(){
            $ionicHistory.goBack();
        }
        
       $scope.getRequestToConfirm=function(){
           FriendsNotificationService.getRequestToConfirm().then(function(response1){
               $scope.requestDetail=response1;
               if($scope.requestDetail.length==0) {
                   $scope.showEmptymessage = true;
               }
               angular.forEach($scope.requestDetail,function(value,key) {
                   FriendsNotificationService.getUserById(value.userId).then(function (response2) {


                           if(response2.portraitId>0){
                           $scope.getUserProfile(response2)
                               }else{
                               $scope.requestedUserDetail.push(response2);
                               $scope.showEmptymessage=true;
                           }

                   });
               });
           });
       };
        $scope.getUserProfile = function(response2) {
            UserService.getUserProfile(response2.userId).then(function(res) {
                if(res.data.fileEntryId != undefined) {

                    var userProfileUrl = $scope.profileUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                    response2.requestedPersonPicUrl=userProfileUrl;
                    $scope.requestedUserDetail.push(response2);
                    $scope.showEmptymessage=true;
                }else {
                    $scope.requestedUserDetail.push(response2);
                }
            },function(err) {

            })
        }

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