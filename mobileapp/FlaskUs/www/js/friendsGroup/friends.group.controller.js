(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsGroupCtrl', FriendsGroupCtrl);

    FriendsGroupCtrl.$inject = ['$scope','GroupService','$cookies','$state','$flaskUtil','$ionicPopup'];

    /* @ngInject */
    function FriendsGroupCtrl($scope,GroupService,$cookies,$state,$flaskUtil,$ionicPopup) {
        $scope.initialize = function() {
            getAllGroups();
        };

        $scope.allMember=[];
        $scope.memberToAddInGroup=[];
        $scope.groups = [];
        $scope.groups=GroupService.group;
        $scope.searchBox={showBox:false};
        var userDetail=$cookies.getObject('CurrentUser');
        var userId=userDetail.data.userId;
        $scope.goBack = function () {
            $state.go("app.user_navigation_menu");
        }
        function getAllGroups() {
            GroupService.getAllGroups(userId).then(function(response){
                if(response.message!="Authenticated access required") {
                    $scope.groups = response;
                }
            });
        }
        $scope.getGroupDetail=function(group){
            GroupService.groupId=group.groupId;
            GroupService.groupDetail="";
            GroupService.groupAdminDetail=group.createdBy;
        }
        $scope.deleteGroup = function(groupId,index) {

                var confirmPopup = $ionicPopup.confirm({
                    title: 'Delete Group?',
                    template: 'Select OK to Confirm!'
                });
                confirmPopup.then(function(res) {
                    if(res) {
                        GroupService.deleteGroup(groupId).then(function(response){
                            if(response.statusText=="OK"){
                                $scope.groups.splice(index,1);
                            }
                            else{
                                alert("failed to delete");
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

    CreateGroupCtrl.$inject = ['$scope', '$ionicPopover','GroupService','$cookies','$state','$ionicModal','$ionicHistory'];

    /* @ngInject */
    function CreateGroupCtrl($scope, $ionicPopover,GroupService,$cookies,$state,$ionicModal,$ionicHistory) {
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
                GroupService.saveGroup($scope.groupId, userId).then(function (response) {
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
                    $scope.memberToAddInGroup.push(value);
                }else{
                    $scope.MatchedIndex=counter;
                }
            });
            if($scope.MatchedIndex!=-1){
                $scope.userContactList.splice($scope.MatchedIndex,1);
            }

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

    }

})();