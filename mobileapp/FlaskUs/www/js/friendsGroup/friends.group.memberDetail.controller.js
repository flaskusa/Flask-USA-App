(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsGroupMemberDetailCtrl', FriendsGroupMemberDetailCtrl);

    FriendsGroupMemberDetailCtrl.$inject = ['$scope', 'GroupService','$flaskUtil'];
    function FriendsGroupMemberDetailCtrl($scope,GroupService,$flaskUtil) {
        $scope.groupAdminDetail=GroupService.groupAdminDetail;
        $scope.friend=GroupService.groupMemberDetail;
        $scope.showConfirm = function(friend) {
            if ( friend.isAdmin === 1) {
                GroupService.addGroupOwner($scope.friend.groupId,$scope.friend.userId).then(function(response){
                    if(response==1){
                    }
                });

            }else{
                if($scope.friend.userName!=$scope.groupAdminDetail){
                GroupService.removeGroupOwner($scope.friend.groupId,$scope.friend.userId).then(function(response){
                    if(response=={}){
                    }
                });}else{
                    $flaskUtil.alert($scope.groupAdminDetail +" is super admin");
                    friend.isAdmin=1;
                }
            }
        };

    }
})();