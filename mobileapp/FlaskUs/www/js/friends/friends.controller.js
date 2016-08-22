(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsCtrl', FriendsCtrl);

    FriendsCtrl.$inject = ['$scope', '$http','$ionicModal','FriendsService','$flaskUtil'];

    /* @ngInject */
    function FriendsCtrl($scope, $http, $ionicModal,FriendsService,$flaskUtil) {
      $scope.myFriends = [];
      $scope.startIndex = 0;
      $scope.endIndex = 9;
      $scope.noFriendAdded = false;
      $scope.initialize = function() {
          $scope.getMyFriends();
      }; 

      $scope.getMyFriends = function() {
          FriendsService.getMyFriends().then(function(response){
              if(response != undefined && Array.isArray(response))   {
                $scope.myFriends = response;
                 $scope.noFriendAdded = $scope.myFriends.length == 0;
              }else{
                  $flaskUtil.alert("Failed to load friends List");
              }           
          });
      }
      $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.initialize();
    }

})();