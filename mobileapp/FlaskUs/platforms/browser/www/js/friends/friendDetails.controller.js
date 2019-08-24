(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendDetailCtrl', FriendDetailCtrl);

    FriendDetailCtrl.$inject = ['$scope', '$stateParams', 'FriendsService', 'FriendsNotificationService', '$cookies', '$flaskUtil', 'SERVER', '$state', '$ionicModal', '$ionicHistory', '$timeout', '$ionicLoading'];

    /* @ngInject */
    function FriendDetailCtrl($scope, $stateParams, FriendsService, FriendsNotificationService, $cookies, $flaskUtil, SERVER, $state, $ionicModal, $ionicHistory, $timeout, $ionicLoading) {
        $scope.friendId = FriendsService.data.userId;
        $scope.showenablebuttons = false;
        $scope.friend = {};
        $scope.picUrl = SERVER.url+"c/document_library/get_file?uuid=";
        $scope.profilepicUrl=FriendsService.data.friendProfilePicUrl;
        $scope.showTextArea={show:false};
        $scope.message={messageToSend:""};
        $scope.initialize = function() {
            $scope.getFriendByUserId($scope.friendId);
            $cookies.put('fromPage', 'MyFriends');
            $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
            $timeout(function () {  $ionicLoading.hide(); $scope.showenablebuttons = true; }, 1000);
        };
        $scope.goBack = function(){
            //$timeout(function () {
                $ionicHistory.goBack();
            //}, 1000);
        }
        $scope.initializeMediatorId=function(userId){

        FriendsService.mediatorUserId=userId;
            $state.go('app.my_friends_tab.friendsGroup');
        }
        $scope.goToChatWindow = function (data) {         
            $timeout(function () {
                $cookies.putObject('friendData', $scope.friend);
                $cookies.putObject('profileUrl', $scope.profilepicUrl);            
                $state.go('app.messages');
            }, 1000);            
        }
        
        $scope.toggleMessageBox=function(message) {
            $scope.showTextArea.show = true;
            setTimeout(startToggleFunction, 20);

            function startToggleFunction() {

                $scope.messageBoxClasses = document.getElementById("textArea").classList;

                if ($scope.messageBoxClasses.contains("hideAll")) {
                    $scope.messageBoxClasses.remove("hideAll");
                };
                setTimeout(removeText, 10);
                function removeText() {
                    if ($scope.messageBoxClasses.contains("hideTexArea")) {
                        $scope.messageBoxClasses.remove("hideTexArea");
                    }
                    else {
                        if (message == undefined || message.trim() === '') {
                            $scope.messageBoxClasses.add("hideTexArea");
                            setTimeout(hideArea, 400);
                            return;
                        }
                        FriendsService.sendMessage($scope.friend.userId, message).then(function (res) {
                            if (res != undefined && res.sendEmail == true) {
                                $scope.messageSentStatus = true;
                                $scope.message={messageToSend:""};
                                $timeout(function () { $scope.messageSentStatus = false; }, 1500);
                                $timeout(function () {  $scope.messageBoxClasses.add("hideTexArea");
                                    setTimeout(hideArea, 400);},1200);
                            } else {
                                $flaskUtil.alert("Failed to send message");
                            }

                        });

                    }
                }
            }

            function hideArea() {
                $scope.messageBoxClasses.add("hideAll");
                $timeout(function () { $scope.showTextArea.show = false; }, 10);
            }
        }
        function hideMessageDiv(){
            $scope.messageSentStatus = false;
        }
        $scope.getFriendByUserId = function(userId) {
            FriendsService.getFriendByUserId(userId).then(function(response) {
                if(response != undefined && response.exception == undefined) {
                    $scope.friend = response;                    
                } else{
                    $flaskUtil.alert("Failed to load details");
                }
            });
        };
        $scope.blockFriend = function() {
            FriendsService.blockUser($scope.friend.userId).then(function(res) {
                $state.go("app.my_friends");
            });
        };
         $scope.sendMessage = function(message) {

        };
        $scope.showSendMessagePopup = function() {
            $scope.modal.show();
           
        }
        $scope.closeSendMessagePopup = function() {
            $scope.modal.hide();
        }
         $scope.unFriend = function() {
            FriendsService.unFriend($scope.friend.userId).then(function(res) {
                $state.go("app.my_friends");
            });
        };

            $scope.initialize();
        }

})();