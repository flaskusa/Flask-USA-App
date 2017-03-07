(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsGroupCtrl', FriendsGroupCtrl);

    FriendsGroupCtrl.$inject = ['$scope','GroupService','$cookies','$state','$flaskUtil','$ionicPopup','$stateParams','FriendsService','$timeout'];

    /* @ngInject */
    function FriendsGroupCtrl($scope,GroupService,$cookies,$state,$flaskUtil,$ionicPopup,$stateParams,FriendsService,$timeout) {
        $scope.initialize = function() {
            getAllGroups();
        };

        $scope.userId=FriendsService.mediatorUserId;
        $scope.addingInGroup=false;
        $scope.allMember=[];
        $scope.memberToAddInGroup=[];
        $scope.groups = [];
        $scope.groups=GroupService.group;
        $scope.searchBox={showBox:false};
        var userDetail=$cookies.getObject('CurrentUser');
        var userId=userDetail.data.userId;
        if($scope.userId && $scope.userId!=0){
            $scope.addingInGroup = true;
        }
        $scope.goToCreate=function(){
            $state.go('app.createGroup');
        }

        function isUserAvailableInGroup(groupId){
           return GroupService.getAllGroupMember(groupId).then(function (response) {
                $scope.allMember = response;
                $scope.isGroupMemberIsAvailable = false;
                angular.forEach($scope.allMember, function (value, key) {
                    if (value.userId == $scope.userId) {
                        $scope.isGroupMemberIsAvailable = true;
                        return $scope.isGroupMemberIsAvailable;
                    }
                });
               return $scope.isGroupMemberIsAvailable;
            });

        }
        $scope.isLoginAdmin=function(){
            angular.forEach($scope.allMember,function(value,key){
                if(userId==value.userId){
                    if(value.isAdmin==1) {
                        $scope.isLoginUserAdmin=true;
                        return false;
                    }else{
                        $scope.isLoginUserAdmin=false;
                    }
                }

            });
        }
        $scope.leaveGroup = function (groupId, index) {
            console.log($scope.groups);
            var confirmPopup = $ionicPopup.confirm({
                title: 'Leave Group?'

            });
            confirmPopup.then(function(res) {
                if(res) {
                    GroupService.leaveGroup(groupId,userId).then(function(response){
                        if (response) {
                            for (var i = 0; i < $scope.groups.length; i++) {
                                if ($scope.groups[i].groupId == groupId) {
                                    $scope.groups.splice(i, 1);
                                }
                            }
                        }else{
                            $flaskUtil.alert("failed to leave");
                        }
                    });
                } else {
                }
            });

        }
        $scope.addFriendToGroup=function(index,groupId,showDivByIndex){
            $scope.isGroupMemberIsAvailable == false;
            GroupService.getMyFriendList().then(function (resopnse) {
                $scope.userContactList = resopnse;

            GroupService.groupId=groupId;
                $scope.addUserToGroup = function () {
                    GroupService.addUserToGroup(groupId, $scope.matchedUser.emailAddress, $scope.matchedUser.userId, $scope.matchedUser.fullName, 0).then(function (response) {
                                $scope.groups[index].showDivByIndex=true;
                                $timeout(function () {  $scope.groups.splice(index, 1);
                                   },1000);

                            });
                        }

                        angular.forEach($scope.userContactList, function (value, key) {
                            if (value.userId == $scope.userId) {
                                $scope.matchedUser = value;
                                $scope.addUserToGroup();
                                $scope.isGroupMemberIsAvailable == true;
                                return false;

                            }
                        });
            });
        }
        $scope.doneAdding=function(){
            FriendsService.mediatorUserId=0;
            $state.go('app.my_friends_tab.my_friends');
        };

        $scope.goBack = function () {
            $state.go("app.user_navigation_menu");
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
        function getAllGroups() {
            GroupService.getAllGroups(userId).then(function(response){
                if(response.message!="Authenticated access required") {
                    if ($scope.addingInGroup == true) {
                        $scope.showDoneButton=false;
                        $scope.groupsToAdd=[];
                        $scope.groupsToAdd = response;
                        $scope.counter=0;
                        angular.forEach($scope.groupsToAdd, function (value,key) {
                            isUserAvailableInGroup(value.groupId).then(function(res){
                                $scope.counter++;
                            if($scope.isGroupMemberIsAvailable==true){
                                $scope.groupsToAdd[key]="";
                            }
                                if(res==false){
                                $scope.isLoginAdmin();
                                if($scope.isLoginUserAdmin==false){
                                    $scope.groupsToAdd[key]=""
                                }
                            }
                               if($scope.counter==response.length){
                                    $scope.groupsToAdd.clean("");
                                    $scope.groupsToAdd.clean(undefined);
                                    $scope.groups=$scope.groupsToAdd;
                                    $scope.showDoneButton=true;
                                }
                       });
                        })

                    }
                    else{
                        $scope.groups=response;
                    }
                }

            });
        }
        $scope.getGroupDetail=function(group) {
            if ($scope.addingInGroup == false) {
                GroupService.groupId = group.groupId;
                GroupService.groupDetail = "";
                GroupService.groupAdminDetail = group.createdBy;
                $state.go('app.groupDetail', {groupName: group.groupName});
            }
        }
        $scope.deleteGroup = function(groupId) {

                var confirmPopup = $ionicPopup.confirm({
                    title: 'Delete Group?'
                });
                confirmPopup.then(function(res) {
                    if(res) {
                        GroupService.deleteGroup(groupId).then(function(response){
                            if (response.statusText == "OK") {
                                for(var i=0;i<$scope.groups.length;i++){
                                    if ($scope.groups[i].groupId == groupId) {
                                        $scope.groups.splice(i,1);
                                    }
                                }
                                
                            }
                            else{
                                $flaskUtil.alert("failed to delete");
                            }
                        });
                    } else {
                    }
                });

        }

        $scope.editGroup=function(data){
            GroupService.groupDetail=data;
            GroupService.groupId=data.groupId;
            GroupService.groupAdminDetail=data.createdBy;
            $state.go('app.groupDetail', {groupName: data.groupName});

        }
        //$scope.initialize();
       }
    angular.module('flaskApp')
        .controller('CreateGroupCtrl', CreateGroupCtrl);

    CreateGroupCtrl.$inject = ['$scope', '$ionicPopover','GroupService','$cookies','$state','$ionicModal','$ionicHistory','$localStorage'];

    /* @ngInject */
    function CreateGroupCtrl($scope, $ionicPopover,GroupService,$cookies,$state,$ionicModal,$ionicHistory,$localStorage) {
        var userDetail = $cookies.getObject('CurrentUser');
        var userId = userDetail.data.userId;
        $scope.myFriends = [];
        $scope.userContactList = [];
        $scope.startIndex = 0;
        $scope.endIndex = 9;
        $scope.noFriendAdded = false;
        $scope.searchBox = {show:false};
        $scope.searchContact = {"searchtext" :""};
        $scope.messsage = {'messsageToSend':''};
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.goBack = function(){
            $ionicHistory.goBack();
        }
        $scope.createGroup = function (groupName, description) {
            GroupService.createGroup(groupName, description,userDetail.data.firstName+' '+userDetail.data.lastName).then(function (response) {
                $scope.groupId = response.groupId
                GroupService.saveGroup($scope.groupId, userId,userDetail.data.firstName+' '+userDetail.data.lastName,userDetail.data.emailAddress).then(function (response) {
                    $scope.showInviteFriendPopup();


                });

            });
        }


        $scope.showInviteFriendPopup = function(){
         // $scope.searchUserContact('',$scope.startIndex, $scope.endIndex);
            GroupService.getMyFriendList().then(function(resopnse){
                $scope.userContactList=resopnse;
                $scope.memberNotAdded(null);

            })
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
        $scope.memberNotAdded=function(userId){
            $scope.memberToAddInGroup=[];
            var counter=-1;
            $scope.MatchedIndex=-1;
            angular.forEach($scope.userContactList,function(value,key){
                counter++
                if(value.userId!=userId){
                    memberHaveProfilePic(value);
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
            $state.go('app.my_friends_tab.friendsGroup');
        }
        $scope.cancel=function(){
            $state.go('app.my_friends_tab.friendsGroup');
        }
    }

})();