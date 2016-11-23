(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsGroupDetailCtrl', FriendsGroupDetailCtrl);

    FriendsGroupDetailCtrl.$inject = ['$scope','GroupService','$stateParams','$state','$ionicModal','$ionicHistory','$ionicPopup','$flaskUtil','$cookies','$localStorage'];
    function FriendsGroupDetailCtrl($scope,GroupService,$stateParams,$state,$ionicModal,$ionicHistory,$ionicPopup,$flaskUtil,$cookies,$localStorage) {

        $scope.groupTitle=$stateParams.groupName;

        $scope.allMember=[];
        $scope.groupId=GroupService.groupId;
        $scope.groupDetail=GroupService.groupDetail;
        $scope.editGroup=false;
        $scope.groupAdminDetail=GroupService.groupAdminDetail;
        var userDetail=$cookies.getObject('CurrentUser');
        var userId=userDetail.data.userId;
        if(!$scope.groupDetail || $scope.groupDetail=="" ){
            $scope.editGroup=false;
        }else{
            $scope.editGroup=true;
        }
        $scope.goBack = function(){
            $ionicHistory.goBack();
        }
        $scope.initialize=function(){
            $scope.getMember();
        }
        $scope.isLoginAdmin=function(){
            angular.forEach($scope.allMember,function(value,key){
                if(userId==value.userId){
                    if(value.isAdmin==1) {
                        GroupService.isLoginUserAdmin=true;
                        $scope.isLoginUserAdmin=true;
                        return false;
                    }else{
                        GroupService.isLoginUserAdmin=false;
                        $scope.isLoginUserAdmin=false;
                    }
                }

            });
        }
        $scope.getMember=function() {
            GroupService.getAllGroupMember($scope.groupId).then(function (response) {
                $scope.allMember=[]

               angular.forEach(response,function(value,key){
                   haveProfilePic(value)
               })
                $scope.isLoginAdmin();



            });
        }
        function haveProfilePic(memberDetail){
            angular.forEach($localStorage["myFriendDetail"],function(value,key){
                if(value.friendProfilePicUrl!=undefined){
                    if(value.userId==memberDetail.userId){
                        memberDetail.friendProfilePicUrl=value.friendProfilePicUrl

                    }
                }



            });
            $scope.allMember.push(memberDetail)

        }


        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.updateGroup=function(groupName,groupDescription){
       GroupService.updateGroup(groupName,groupDescription,$scope.groupDetail.isDelete,$scope.groupDetail.isActive,$scope.groupDetail.createdBy,$scope.groupId,$scope.groupDetail.createdDate).then(function(response){
           $scope.groupTitle=response.groupName;
           $scope.editGroup=false;
       });
        }

        $scope.groupMemberDetail=function(data){
            $state.go('app.groupMemberDetail');
            GroupService.groupMemberDetail=data;

        }
        Array.prototype.clean = function(deleteValue) {
            for (var i = 0; i < this.length; i++) {
                if (this[i] == deleteValue) {
                    this.splice(i, 1);
                    i--;
                }
            }
            return this;
        };
        $scope.getMatchedIndex=function(){
            angular.forEach($scope.userContactList,function(value1,key1){
                angular.forEach($scope.allMember,function(value2,key2){
                    if(value1.userId==value2.userId){
                        $scope.userContactList[key1]="";
                    }
                });
            });
        }
        $scope.showInviteFriendPopup = function(){
            // $scope.searchUserContact('',$scope.startIndex, $scope.endIndex);
            $scope.searchContact={searchtext:""};
            GroupService.getMyFriendList().then(function(resopnse){
                $scope.userContactList=resopnse;
                $scope.getMatchedIndex();

                $scope.userContactList.clean("");
                $scope.userContactList.clean(undefined);
                $scope.memberNotAdded(null);

            });
            $scope.modal.show();
        };

        $scope.closeInviteFriendPopup = function () {
            $scope.modal.hide();
            //$scope.resetPopup();
        };
        $scope.resetPopup = function() {
            $scope.endIndex = 9;
            $scope.searchContact.searchtext =  "";
        };
        $scope.memberNotAdded=function(userId){
            $scope.memberToAddInGroup=[];
            var counter=-1;
            $scope.MatchedIndex=-1;
            angular.forEach($scope.userContactList,function(value,key){
                counter++
                if(value.userId!=userId){
                    memberHaveProfilePic(value)
                }else{
                    $scope.MatchedIndex=counter;
                }
            });
            if($scope.MatchedIndex!=-1){
                $scope.userContactList.splice($scope.MatchedIndex,1);
            }

        }
        function memberHaveProfilePic(memberDetail){
            angular.forEach($localStorage["myFriendDetail"],function(value,key){
                if(value.friendProfilePicUrl!=undefined){
                    if(value.userId==memberDetail.userId){
                        memberDetail.friendProfilePicUrl=value.friendProfilePicUrl

                    }
                }



            });
            $scope.memberToAddInGroup.push(memberDetail)

        }

        $scope.addUserToGroup=function(data){
            GroupService.addUserToGroup($scope.groupId,data.emailAddress,data.userId,data.fullName,0).then(function(response){
                var userId=response.userId;
                $scope.memberNotAdded(userId);
            });

        }
        $scope.finishAddingMember=function(){
            $scope.modal.hide();
            GroupService.getAllGroupMember($scope.groupId).then(function(response){
                $scope.allMember=[]
                angular.forEach(response,function(value,key){
                    haveProfilePic(value)
                })
            });
        }
        $scope.removeMember= function(data,index) {

            var confirmPopup = $ionicPopup.confirm({
                title: 'Remove from Group?',
                template: 'Select OK to Confirm!'
            });
            confirmPopup.then(function(res) {
                if(res) {
                    if(data.userName!=$scope.groupAdminDetail) {
                        GroupService.deleteGroupUser($scope.groupId, data.userId).then(function (response) {
                            $scope.allMember.splice(index, 1);
                        });
                    }else{
                        $flaskUtil.alert(data.userName +" can't be removed")
                        }

                } else {
                }
            });

        };
        $scope.filterUserContact=function(kewword){
            GroupService.searchGroupMember(kewword).then(function(response){
                $scope.userContactList=response;
                $scope.getMatchedIndex();
                $scope.userContactList.clean("");
                $scope.userContactList.clean(undefined);
                $scope.memberNotAdded(null);

            });
        }
        $scope.initialize();

    }
})();