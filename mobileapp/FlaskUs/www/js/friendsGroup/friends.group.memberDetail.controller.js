(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsGroupMemberDetailCtrl', FriendsGroupMemberDetailCtrl);

    FriendsGroupMemberDetailCtrl.$inject = ['$scope', '$ionicPopover','GroupService','$timeout','$ionicPopup'];
    function FriendsGroupMemberDetailCtrl($scope, $ionicPopover,GroupService,$timeout, $ionicPopup) {
        $scope.friend=GroupService.groupMemberDetail;
        $scope.showConfirm = function(val) {
            if ( val === 1) {
                var confirmPopup = $ionicPopup.confirm({
                    title: 'Make Admin',
                    template: 'Select OK to Confirm!'
                });
                confirmPopup.then(function(res) {
                    if(res) {
                        GroupService.addGroupOwner($scope.friend.groupId,$scope.friend.userId).then(function(response){
                            if(response==1){
                            }
                        })

                    } else {
                        return $scope.friend.isAdmin;
                    }
                });
            }else{
                GroupService.removeGroupOwner($scope.friend.groupId,$scope.friend.userId).then(function(response){
                    if(response=={}){
                        alert($scope.friend.userName+' is user now');
                    }
                });
            }
        };

    }
})();