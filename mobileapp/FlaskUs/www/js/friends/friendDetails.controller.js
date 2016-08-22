(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendDetailCtrl', FriendDetailCtrl);

    FriendDetailCtrl.$inject = ['$scope','$stateParams','FriendsService','$flaskUtil','SERVER'];

    /* @ngInject */
    function FriendDetailCtrl($scope,$stateParams,FriendsService, $flaskUtil,SERVER) {
        $scope.userId = $stateParams.userId;
        $scope.friend = {};
        $scope.picUrl = SERVER.hostName+"c/document_library/get_file?uuid=";
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
            }
            $scope.initialize();
        }

})();