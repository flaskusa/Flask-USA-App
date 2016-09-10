(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsGroupMemberDetailCtrl', FriendsGroupMemberDetailCtrl);

    FriendsGroupMemberDetailCtrl.$inject = ['$scope', 'GroupService','$flaskUtil','$cookies'];
    function FriendsGroupMemberDetailCtrl($scope,GroupService,$flaskUtil,$cookies) {
        $scope.groupAdminDetail=GroupService.groupAdminDetail;
        $scope.friend=GroupService.groupMemberDetail;
        var userDetail=$cookies.getObject('CurrentUser');
        var userId=userDetail.data.userId;
        $scope.disableToggleButton=false;
        $scope.isLoginUserAdmin=GroupService.isLoginUserAdmin;
        if($scope.friend.userName==$scope.groupAdminDetail){
            $scope.disableToggleButton=true;
        }
        $scope.showConfirm = function(friend) {
            if ( friend.isAdmin === 1) {
                if($scope.isLoginUserAdmin==true){
                GroupService.addGroupOwner($scope.friend.groupId,$scope.friend.userId).then(function(response){
                    if(response==1){
                    }
                });
                    }else{
                    friend.isAdmin=0;
                    $flaskUtil.alert("you are not authorized ");

                }

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