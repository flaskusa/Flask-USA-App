(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendDetailCtrl', FriendDetailCtrl);

    FriendDetailCtrl.$inject = ['$scope','$stateParams','FriendsService','$flaskUtil','SERVER','$state','$ionicModal','$ionicHistory'];

    /* @ngInject */
    function FriendDetailCtrl($scope,$stateParams,FriendsService, $flaskUtil,SERVER,$state,$ionicModal,$ionicHistory) {
        $scope.friendId =FriendsService.data.userId;
        $scope.friend = {};
        $scope.picUrl = SERVER.url+"c/document_library/get_file?uuid=";
        $scope.initialize = function() {
            $scope.getFriendByUserId( $scope.friendId);
        };
        $scope.goBack = function(){
            $ionicHistory.goBack();
        }
        $scope.initializeMediatorId=function(userId){

        FriendsService.mediatorUserId=userId;
            $state.go('app.my_friends_tab.friendsGroup');
        }
        $scope.getFriendByUserId = function(userId) {
            FriendsService.getFriendByUserId(userId).then(function(response) {
                if(response != undefined && response.exception == undefined) {

                    $scope.friend = response;
                } else{
                    $flaskUtil.alert("Failed to load details");
                }
            });
        };


        $scope.blockFriend = function() {
            FriendsService.blockUser($scope.friend.userId).then(function(res) {
                $state.go("app.my_friends");
            });
        };
         $scope.sendMessage = function(message) {
             if(message == undefined || message.trim() === '') {
                 return;
             }
             FriendsService.sendMessage($scope.friend.userId,message).then(function(res) {
                 if(res != undefined && res.sendEmail == true) {
                    $scope.messageSentStatus = true;
                 }else {
                     $flaskUtil.alert("Failed to send message");
                 }
                     
            });
        };
        $scope.showSendMessagePopup = function() {
            $scope.modal.show();
           
        }
        $scope.closeSendMessagePopup = function() {
            $scope.modal.hide();
        }
         $scope.unFriend = function() {
            FriendsService.unFriend($scope.friend.userId).then(function(res) {
                $state.go("app.my_friends");
            });
        };
         $scope.$on('$destroy', function() {
            $scope.modal.remove();
        });
         $scope.$on('modal.shown', function() {
        });
        $ionicModal.fromTemplateUrl('templates/sendMessage.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
            $scope.initialize();
        }

})();