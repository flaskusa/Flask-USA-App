(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsCtrl', FriendsCtrl);

    FriendsCtrl.$inject = ['$scope', '$http','$ionicModal','FriendsService','$flaskUtil'];

    /* @ngInject */
    function FriendsCtrl($scope, $http, $ionicModal,FriendsService,$flaskUtil) {
      $scope.myFriends = [];
      $scope.userContactList = [];
      $scope.startIndex = 0;
      $scope.endIndex = 9;
      $scope.noFriendAdded = false;
      $scope.searchBox = {show:false};
      $scope.searchContact = {"searchtext" :""};
      $scope.initialize = function() {
          $scope.getMyFriends($scope.searchContact.searchtext);
      }; 

      $scope.showInviteFriendPopup = function(){
          $scope.searchUserContact('',$scope.startIndex, $scope.endIndex);
          $scope.modal.show();
      };

      $scope.closeInviteFriendPopup = function () {
          $scope.modal.hide();
          $scope.resetPopup();
      };
      $scope.resetPopup = function() {
          $scope.endIndex = 9;
          $scope.searchContact.searchtext =  "";
      };
      $scope.getMyFriends = function(searchText) {
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
        $scope.sendFriendRequest = function(userObject) {
            FriendsService.sendFriendRequest(userObject.userId).then(function(response){
                if(response != undefined)   {
                    userObject.connectionRequested = true;
              }else{
                  $flaskUtil.alert("Failed to unblock user");
              }   
           });
        };
      $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.initialize();
    }

})();