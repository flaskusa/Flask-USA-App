(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendDetailCtrl', FriendDetailCtrl);

    FriendDetailCtrl.$inject = ['$scope','$stateParams','FriendsService','$flaskUtil','SERVER','$state'];

    /* @ngInject */
    function FriendDetailCtrl($scope,$stateParams,FriendsService, $flaskUtil,SERVER,$state) {
        $scope.userId = $stateParams.userId;
        $scope.friend = {};
        $scope.picUrl = SERVER.url+"c/document_library/get_file?uuid=";
        $scope.initialize = function() {
            $scope.getFriendByUserId($scope.userId);
        }; 
        $scope.getFriendByUserId = function(userId) {
            FriendsService.getFriendByUserId(userId).then(function(response) {
                if(response != undefined && response.exception == undefined) {

                    $scope.friend = response;
                } else{
                    $flaskUtil.alert("Failed to load details");
                }
            })
        };

        $scope.blockFriend = function() {
            FriendsService.blockUser($scope.friend.userId).then(function(res) {
                $state.go("app.my_friends");
            });
        };
         $scope.sendMessage = function() {
             FriendsService.sendMessage().then(function(res) {
            });
        };
         $scope.unFriend = function() {
            FriendsService.unFriend($scope.friend.userId).then(function(res) {
                $state.go("app.my_friends");
            });
        };
            $scope.initialize();
        }

})();