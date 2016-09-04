(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsGroupMemberDetailCtrl', FriendsGroupMemberDetailCtrl);

    FriendsGroupMemberDetailCtrl.$inject = ['$scope', 'GroupService'];
    function FriendsGroupMemberDetailCtrl($scope,GroupService) {
        $scope.friend=GroupService.groupMemberDetail;
        $scope.showConfirm = function(val) {
            if ( val === 1) {
                GroupService.addGroupOwner($scope.friend.groupId,$scope.friend.userId).then(function(response){
                    if(response==1){
                    }
                });
            }else{
                GroupService.removeGroupOwner($scope.friend.groupId,$scope.friend.userId).then(function(response){
                    if(response=={}){
                    }
                });
            }
        };

    }
})();