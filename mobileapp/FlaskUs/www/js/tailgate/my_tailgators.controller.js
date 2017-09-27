(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatorsCtrl', mytailgatorsCtrl);

    mytailgatorsCtrl.$inject = ['$scope', '$rootScope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies', '$ionicModal', '$flaskUtil', 'UserService', '$localStorage', '$ionicPopup', '$ionicLoading', '$timeout'];

    /* @ngInject */
    function mytailgatorsCtrl($scope, $rootScope, $state, SERVER, $stateParams, TailgateService, $cookies, $ionicModal, $flaskUtil, UserService, $localStorage, $ionicPopup, $ionicLoading, $timeout) {
        $scope.myTailgaters = [];
        $scope.myFriends = [];
        $scope.detail = [];
        $scope.friendsToInvite = [];
        $scope.tailgaters = [];
        $scope.isTailgateAdmin = false;
        $scope.tailgateOwner = false;
        $rootScope.role = '0';
        var userDetail = $cookies.getObject('CurrentUser');
        $scope.loggedInUserId = userDetail.data.userId;
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.goBack = function () {
            $timeout(function () {
                $state.go("app.my_tailgate");
            }, 300);
        }
        var tailGateId = $cookies.get('currtailGateId');
        var tailgateOwnerId = $cookies.get('currtailGateUserId');
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";

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
                            $flaskUtil.alert("Tailgate User Removed successfully");
                        })
                    } else {
                        $flaskUtil.alert("Tailgate admin can't be remove.");
                    }
                } else {
                }
            });

        }
        $scope.isUserTailgateAdmin = function (tailgateId) {
            TailgateService.isUserTailgateAdmin(tailgateId).then(function (respData) {
                $scope.isTailgateAdmin = respData.data;
            });
        };

        $scope.isUserTailgateAdmin(tailGateId);
        
        function getTailgaters() {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (response) {
                $scope.myTailgaters = []

                angular.forEach(response.data, function (value, key) {
                    haveProfilePic(value)
                })
            });
            getAllFriends();
            getTailgateUser();
        }

        function getTailgateUser() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $scope.tUserId = respData.data.userId; 
            });
        }

        function haveProfilePic(memberDetail) {
            var PicExist = false
            angular.forEach($localStorage["myFriendDetail"], function (value, key) {
                if (value.friendProfilePicUrl != undefined) {
                    PicExist = true
                    if (value.userId == memberDetail.userId) {
                        memberDetail.friendProfilePicUrl = value.friendProfilePicUrl
                    }
                }
                
            });
            if (memberDetail.userId == $scope.loggedInUserId || !isMemberMyFrnd(memberDetail)) {
                $scope.getUserProfile(memberDetail)
            } else {
                $scope.myTailgaters.push(memberDetail);
            }
        }
        function isMemberMyFrnd(memberDetail) {
            var friend = false;
            angular.forEach($localStorage["myFriendDetail"], function (value2, key) {
                if (memberDetail.userId == value2.userId) {
                    friend = true;
                    return friend;
                }
            })
            return friend;
        }

        function getAllFriends() {
            TailgateService.getUserFrends().then(function (response) {
                if ($localStorage["myFriendDetail"].length == response.length) {
                    $scope.myFriends = $localStorage["myFriendDetail"];
                }
                else {
                    angular.forEach(response, function (value, key) {
                        if (value.portraitId > 0) {
                            $scope.getUserProfile(value);
                        } else {
                            $scope.myFriends.push(value);
                            if (userExistInLocal(value) == false) {
                                $localStorage["myFriendDetail"].push(value)
                            }
                        }
                    })

                }
            })
        }
        $scope.getUserProfile = function (UserDetail) {
            UserService.getUserProfile(UserDetail.userId).then(function (res) {
                if (UserDetail.portraitId != undefined) {
                    if (res.data.fileEntryId != undefined) {
                        UserDetail.friendProfilePicUrl = $scope.imgUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                        $scope.myFriends.push(UserDetail);

                        if (userExistInLocal(UserDetail) == false) {
                            $localStorage["myFriendDetail"].push(UserDetail);
                        }
                    } else {
                        if (userExistInLocal(UserDetail) == false) {
                            $localStorage["myFriendDetail"].push(UserDetail);
                        }
                    }
                } else {
                    if (res.data.fileEntryId != undefined) {
                        UserDetail.friendProfilePicUrl = $scope.imgUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                        $scope.myTailgaters.push(UserDetail);


                    } else {
                        $scope.myTailgaters.push(UserDetail);
                    }

                }
            }, function (err) {
            })
        };
        function userExistInLocal(userDetail) {
            var exist = false;
            angular.forEach($localStorage["myFriendDetail"], function (value, key) {
                if (value.userId == userDetail.userId) {
                    exist = true
                }
            })
            return exist;
        }
        $scope.showModel = function () {
            angular.forEach($scope.myFriends, function (value, key) {
                if (!(IsUserTailgateMember(value))) {
                    $scope.friendsToInvite.push(value)
                }
            });

            $scope.modal.show();

        }
        function IsUserTailgateMember(value) {
            var userExist = false;
            angular.forEach($scope.myTailgaters, function (value2, key2) {
                if (value2.userId == value.userId) {
                    userExist = true;
                    return userExist
                }
            });
            return userExist;

        }
        $scope.hideModel = function () {
            getTailgaters();
            $scope.friendsToInvite = [];
            $scope.modal.hide();
        }

        $scope.addTailgateMembers = function (currUserData, index) {
            var addUserparams = {};
            addUserparams.groupId = 0;
            addUserparams.userId = currUserData.userId;
            addUserparams.userName = currUserData.firstName + " " + currUserData.lastName;
            addUserparams.emailAddress = currUserData.emailAddress;
            addUserparams.isAdmin = 0;
            addUserparams.tailgateId = tailGateId;
            addUserparams.isPaid = 0;
            addUserparams.paymentMode = "None";
            TailgateService.addcurrentUser(addUserparams).then(function (respData) {
                $scope.friendsToInvite.splice(index, 1);

            })
        };

        $scope.goToTailgaterTab = function () {
            //add cookie data for editing particular page on tab.
            $cookies.putObject("tabtoEdit", [2, 'attendeeTab']);
            checkTailgateId();
        }

        function checkTailgateId() {
            if (!tailGateId) {
            }
            else {
                //getting the data for editing the tailgate       
                editTailgate(tailGateId);
            }
        }

        function editTailgate(tailGateId) {
            var addTailgateParams = {}
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $cookies.putObject("editUserTailgate", respData.data);
                $state.go("app.add_my_tailgate");
            });
        }
        /*for changing role of tailgater in view tailgater page*/
        $scope.changeTailgaterRole = function (currUserId, index) {
            //console.log($scope.tUserId);
            if (currUserId != $scope.tUserId) {
                if ($scope.loggedInUserId == $scope.tUserId) {
                    TailgateService.addTailgateAdmin(currUserId, tailGateId).then(function (respData) {
                        $rootScope.role = respData.data;
                        $ionicLoading.show({ template: 'Role changed successfully!', noBackdrop: false, duration: 3000 });
                    });
                }
                else {
                    $ionicLoading.show({ template: 'You do not have the permission to change the role!', noBackdrop: false, duration: 3000 });
                }
            }
            else {
                $ionicLoading.show({ template: 'Tailgate admin cannot be removed!', noBackdrop: false, duration: 3000 });
            }
        }
        getTailgaters();

    }
})();

