(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsCtrl', FriendsCtrl);

    FriendsCtrl.$inject = ['$scope', '$http','$ionicModal','FriendsService','$flaskUtil','$state'];

    /* @ngInject */
    function FriendsCtrl($scope, $http, $ionicModal,FriendsService,$flaskUtil,$state) {
      $scope.myFriends = [];
      $scope.userContactList = [];
      $scope.startIndex = 0;
      $scope.endIndex = 9;
      $scope.noFriendAdded = false;
      $scope.searchBox = {show:false};
      $scope.searchContact = {"searchtext" :""};
      $scope.messsage = {'messsageToSend':''};
        $scope.moreDataCanBeLoaded = true;

        $scope.myFriendTab=function(){
            $state.go("app.my_friends_tab.my_friends");
            FriendsService.mediatorUserId=0;
        }
        $scope.goBack = function () {
            $state.go("app.user_navigation_menu");
        }
        $scope.goTOGroup=function(){
            $state.go('app.my_friendDetail',{userId:0});
        }
      $scope.initialize = function() {
          $scope.getMyFriends($scope.searchContact.searchtext);
          $ionicModal.fromTemplateUrl('templates/modal.html', {
              scope: $scope
          }).then(function (modal) {
              $scope.modal = modal;
          });
      }; 

      $scope.showInviteFriendPopup = function(){
          $scope.moreDataCanBeLoaded = true;
          $scope.searchUserContact('',$scope.startIndex, $scope.endIndex);
          $scope.modal.show();
      };
      $scope.closeInviteFriendPopup = function () {
          $scope.modal.hide();
          $scope.moreDataCanBeLoaded = true;
          $scope.resetPopup();
      };
      $scope.resetPopup = function() {
          $scope.endIndex = 9;
          $scope.searchContact.searchtext =  "";
      };
        $scope.unFriend = function(userId,index) {
            FriendsService.unFriend(userId).then(function(res) {
            if(res){
                $scope.myFriends.splice(index,1)
            }else(
                $flaskUtil.alert("failed to unFriend")
            )
            });
        };
        $scope.blockFriend = function(userId) {
            FriendsService.blockUser(userId).then(function(res) {
              if(res){

              }else{
                  $flaskUtil.alert("failed to block");
              }
            });
        };
      $scope.getMyFriends = function(searchText) {
          $scope.moreDataCanBeLoaded = true;
          FriendsService.getMyFriends(searchText).then(function(response){
              if(response != undefined && Array.isArray(response))   {
                $scope.myFriends = response;
                $scope.searchBox.show  = false;
                //  $scope.noFriendAdded = $scope.myFriends.length == 0;
              }else{
                  $flaskUtil.alert("Failed to load friends List");
                  $scope.searchBox.show  = false;
              }           
          });
      };
      $scope.getAllfilteredFrieds = function(searchText) {
          $scope.getMyFriends (searchText);
      };

      $scope.filterUserContact = function(searchText) {
          $scope.endIndex = 9;
          $scope.searchUserContact(searchText,$scope.startIndex,$scope.endIndex);
      };

      $scope.getMoreUserContact = function(searchText)  {
          $scope.endIndex +=10;
          $scope.searchUserContact(searchText, $scope.startIndex, $scope.endIndex);
      }
      $scope.searchUserContact = function(searchText, startIndex, endIndex) {
           FriendsService.searchUserContact( $scope.searchContact.searchtext, $scope.startIndex, $scope.endIndex).then(function(response){
                if(response != undefined && Array.isArray(response))   {
                        $scope.userContactList = response;
                        if($scope.userContactList.length < $scope.endIndex-1) {
                            $scope.moreDataCanBeLoaded = false;
                        }else{
                            $scope.moreDataCanBeLoaded = true;
                        }
                        $scope.$broadcast('scroll.infiniteScrollComplete');
              }else{
                  $flaskUtil.alert("Failed to load contact List");
              }   
           });
      };

        $scope.unBlockUser = function(userObject) {
            FriendsService.unBlockUser(userObject.userId).then(function(response){
                if(response != undefined)   {
                    userObject.block = false;
              }else{
                  $flaskUtil.alert("Failed to unblock user");
              }   
           });
        };

        $scope.showSendMessagePopup = function() {
             $scope.modal.show();
        };

      
        $scope.sendFriendRequest = function(userObject) {
            FriendsService.sendFriendRequest(userObject.userId).then(function(response){
                if(response != undefined)   {
                    userObject.connectionRequested = true;
              }else{
                  $flaskUtil.alert("Failed to unblock user");
              }   
           });
        };



        $scope.groupMemberDetail=function(data){
            $state.go('app.my_friendDetail',{friendId:data.userId});
            FriendsService.data=data;
        }

    }

})();