(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatorsCtrl', mytailgatorsCtrl);

    mytailgatorsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService','$cookies','$ionicModal','$flaskUtil','UserService','$localStorage'];

    /* @ngInject */
    function mytailgatorsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies,$ionicModal,$flaskUtil,UserService,$localStorage) {
        $scope.myTailgaters = [];
        $scope.myFriends = [];
        var userDetail=$cookies.getObject('CurrentUser');
        var userId=userDetail.data.userId;
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }
        var tailGateId = $cookies.get('currtailGateId');
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        $scope.imgUrl=SERVER.hostName + "c/document_library/get_file?uuid=";
        

        function getTailgaters() {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (response) {
                $scope.myTailgaters=[]

                angular.forEach(response.data,function(value,key){
                    haveProfilePic(value)
                })


                            });

                getAllFriends();
        }
        function haveProfilePic(memberDetail){
            var PicExist=false
            angular.forEach($localStorage["myFriendDetail"],function(value,key){
                if(value.friendProfilePicUrl!=undefined){
                    PicExist=true
                    if(value.userId==memberDetail.userId){
                        memberDetail.friendProfilePicUrl=value.friendProfilePicUrl

                    }
                }



            });
            if(memberDetail.userId==userId || !isMemberMyFrnd(memberDetail)) {
                $scope.getUserProfile(memberDetail)

            }else{
                $scope.myTailgaters.push(memberDetail)
            }
        }
        function isMemberMyFrnd(memberDetail){
            var friend=false;


            angular.forEach($localStorage["myFriendDetail"], function (value2, key) {
                if (memberDetail.userId == value2.userId) {
                    friend=true;
                    return friend;
                }
            })

            return friend;

        }

        function getAllFriends() {
            TailgateService.getUserFrends().then(function (response) {
                if($localStorage["myFriendDetail"].length==response.length){
                    $scope.myFriends=$localStorage["myFriendDetail"];
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

        }
        })}
        $scope.getUserProfile = function(UserDetail) {
            UserService.getUserProfile(UserDetail.userId).then(function(res) {
                if(UserDetail.portraitId!=undefined) {
                    if (res.data.fileEntryId != undefined) {
                        UserDetail.friendProfilePicUrl = $scope.imgUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                        $scope.myFriends.push(UserDetail);

                        if (userExistInLocal(UserDetail) == false) {
                            $localStorage["myFriendDetail"].push(UserDetail);
                        }
                    }
                }else{if(res.data.fileEntryId != undefined) {
                    UserDetail.friendProfilePicUrl = $scope.imgUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                    $scope.myTailgaters.push(UserDetail);

                }else{
                    $scope.myTailgaters.push(UserDetail);
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

        $scope.addTailgateMembers = function(currUserData,index) {
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
                $scope.myFriends.splice(index, 1);
            })           
        };

        getTailgaters();

    }
})();

