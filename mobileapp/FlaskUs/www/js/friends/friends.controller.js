(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsCtrl', FriendsCtrl);

    FriendsCtrl.$inject = ['$scope', '$http', '$ionicModal', 'FriendsService', '$flaskUtil', '$state', 'UserService', 'SERVER', '$localStorage', '$ionicScrollDelegate', '$ionicPopup', '$rootScope','$timeout'];

    /* @ngInject */
    function FriendsCtrl($scope, $http, $ionicModal, FriendsService, $flaskUtil, $state, UserService, SERVER, $localStorage, $ionicScrollDelegate, $ionicPopup, $rootScope, $timeout) {
      $scope.myFriends = [];
      $scope.userContactList = [];
      $scope.startIndex = 0;
      $scope.endIndex = 9;
      $scope.noFriendAdded = false;
      $scope.shoeEmptyMessage=false;
      $scope.searchBox = {show:false};
      $scope.searchContact = { "searchtext": "" };
      $scope.noFriendMsg = "Loading ....";
      $scope.messsage = {'messsageToSend':''};
        $scope.moreDataCanBeLoaded = true;
        if($localStorage["myFriendDetail"]==undefined) {
            $localStorage["myFriendDetail"] = [];
        }
        $scope.profileUrl = SERVER.hostName + "c/document_library/get_file?uuid=";

        $scope.myFriendTab=function(){
            $state.go("app.my_friends_tab.my_friends");
            FriendsService.mediatorUserId=0;
        }
        $scope.goBack = function () {
            $timeout(function () {
                $state.go("app.user_navigation_menu");
            }, 1000);            
        }
        $scope.goTOGroup=function(){
            $state.go('app.my_friendDetail',{userId:0});
        }
        $scope.initialize = function () {
          $rootScope.$broadcast('loading:show');
          $scope.getMyFriends($scope.searchContact.searchtext);
          $ionicModal.fromTemplateUrl('templates/modal.html', {
              scope: $scope
          }).then(function (modal) {
              $scope.modal = modal;
          });
         
      }; 

      $scope.showInviteFriendPopup = function(){
          $scope.moreDataCanBeLoaded = true;
          $scope.searchUserContact('',$scope.startIndex, $scope.endIndex);
          $scope.modal.show();
      };
      $scope.closeInviteFriendPopup = function () {
          $scope.modal.hide();
          $scope.moreDataCanBeLoaded = true;
          $scope.resetPopup();
      };
      $scope.resetPopup = function() {
          $scope.endIndex = 9;
          $scope.searchContact.searchtext =  "";
      };
      $scope.unFriend = function (userId) {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Unfriend ?'
            });
            confirmPopup.then(function(res) {
                if(res) {
                    FriendsService.unFriend(userId).then(function (response) {
                        for (var i = 0; i < $scope.myFriends.length; i++) {
                            if ($scope.myFriends[i].userId == userId) {
                                $scope.myFriends.splice(i, 1);
                            }
                        }
                            
                    });
                } else {
                }
            });
      };
        /*
        $scope.deleteTailgateUser = function (currUserId) {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Delete Tailgater ?'
            });
            confirmPopup.then(function (res) {
                if (res) {
                    if (currUserId != $scope.loggedInUserId) {
                        TailgateService.deleteTailgateUser(tailGateId, currUserId).then(function (response) {
                            for (var i = 0; i < $scope.myTailgaters.length; i++) {
                                if ($scope.myTailgaters[i].userId == currUserId) {
                                    $scope.myTailgaters.splice(i,1);
                                }
                            }
                        })
                    } else {
                        $flaskUtil.alert("Tailgate admin can't be remove.")
                    }
                } else {
                }
            });

        }*/
        $scope.blockFriend = function(userId) {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Block friend?'
            });
            confirmPopup.then(function(res) {
                if(res) {
                    FriendsService.blockUser(userId).then(function(response) {
                        if(response){
                            for (var i = 0; i < $scope.myFriends; i++) {
                                if ($scope.myFriends[i].userId == response.userId) {
                                    $scope.myFriends.splice(i, 1);
                                }
                            }

                        }else{
                            $flaskUtil.alert("failed to block");
                        }
                    });
                } else {
                }
            });

        };
      $scope.getMyFriends = function(searchText) {
          $scope.moreDataCanBeLoaded = true;
          FriendsService.getMyFriends(searchText).then(function (response) {
              $scope.searchedFriend = response.data;
              $scope.shoeEmptyMessage=true;
              if(response != undefined && Array.isArray(response))   {
                  if($localStorage["myFriendDetail"].length==response.length){
                      $scope.myFriends = $localStorage["myFriendDetail"];
                  }
                  else{
                  angular.forEach(response,function(value,key){
                      if(value.portraitId>0) {
                          $scope.getUserProfile(value);
                      }else{
                          $scope.myFriends.push(value);
                          if(userExistInLocal(value)==false){
                              $localStorage["myFriendDetail"].push(value)
                          }
                      }
                  })

                $scope.searchBox.show  = false;
                      //  $scope.noFriendAdded = $scope.myFriends.length == 0;
                $rootScope.$broadcast('loading:hide');
              }}else{
                  $flaskUtil.alert("Failed to load friends List");
                  $scope.searchBox.show = false;
                  $scope.noFriendMsg = "There are no friends.";
                  $rootScope.$broadcast('loading:hide');
              }
              $rootScope.$broadcast('loading:hide');
          });
         
      };
        $scope.getUserProfile = function(UserDetail) {
            UserService.getUserProfile(UserDetail.userId).then(function(res) {
                if(res.data.fileEntryId != undefined) {
                    UserDetail.friendProfilePicUrl = $scope.profileUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                    $scope.myFriends.push(UserDetail);

                    if(userExistInLocal(UserDetail)==false) {
                        $localStorage["myFriendDetail"].push(UserDetail);
                    }
                }else{
                    $scope.myFriends.push(UserDetail);

                    if(userExistInLocal(UserDetail)==false) {
                        $localStorage["myFriendDetail"].push(UserDetail);
                    }
                }
            },function(err) {
            })
        };
        function userExistInLocal(userDetail){
            var exist=false;
            angular.forEach($localStorage["myFriendDetail"],function(value,key){
                if(value.userId==userDetail.userId){
                    exist=true
                }
            })
            return exist;
        }

      $scope.getAllfilteredFrieds = function(searchText) {
          $scope.getMyFriends (searchText);
      };

      $scope.filterUserContact = function(searchText) {
          $scope.endIndex = 9;
          $scope.searchUserContact(searchText,$scope.startIndex,$scope.endIndex);
      };

      $scope.getMoreUserContact = function(searchText)  {
          $scope.endIndex +=10;
          $scope.searchUserContact(searchText, $scope.startIndex, $scope.endIndex);
      }
      $scope.searchUserContact = function(searchText, startIndex, endIndex) {
           FriendsService.searchUserContact( $scope.searchContact.searchtext, $scope.startIndex, $scope.endIndex).then(function(response){
                if(response != undefined && Array.isArray(response))   {
                        $scope.userContactList = response;
                        if($scope.userContactList.length<10){
                            $ionicScrollDelegate.scrollTop();
                        }
                        if($scope.userContactList.length < $scope.endIndex-1) {

                            $scope.moreDataCanBeLoaded = false;
                        }else{
                            $scope.moreDataCanBeLoaded = true;
                        }
                        $scope.$broadcast('scroll.infiniteScrollComplete');
              }else{
                  $flaskUtil.alert("Failed to load contact List");
              }   
           });
      };

        $scope.unBlockUser = function(userObject) {
            FriendsService.unBlockUser(userObject.userId).then(function(response){
                if(response != undefined)   {
                    userObject.block = false;
              }else{
                  $flaskUtil.alert("Failed to unblock user");
              }   
           });
        };

        $scope.showSendMessagePopup = function() {
             $scope.modal.show();
        };

      
        $scope.sendFriendRequest = function(userObject) {
            FriendsService.sendFriendRequest(userObject.userId).then(function(response){
                if(response != undefined)   {
                    userObject.connectionRequested = true;
              }else{
                  $flaskUtil.alert("Failed to unblock user");
              }   
           });
        };



        $scope.groupMemberDetail=function(data){
            $state.go('app.my_friendDetail',{friendId:data.userId});
            FriendsService.data=data;
        }

        //search friend function
        $scope.getSearchedFriends = function (searchText) {
            FriendsService.getMyFriends(searchText).then(function (response) {
                $scope.myFriends = response;
            });
        }

    }

})();