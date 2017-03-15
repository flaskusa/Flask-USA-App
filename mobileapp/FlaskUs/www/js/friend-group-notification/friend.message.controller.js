(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsMessageCtrl', FriendsMessageCtrl);

    FriendsMessageCtrl.$inject = ['$scope', '$http', '$ionicModal', 'FriendsNotificationService', '$flaskUtil', '$state', '$ionicHistory', '$timeout', '$ionicLoading', '$ionicPopup', '$cookies'];

    /* @ngInject */
    function FriendsMessageCtrl($scope, $http, $ionicModal, FriendsNotificationService, $flaskUtil, $state, $ionicHistory, $timeout, $ionicLoading, $ionicPopup, $cookies) {
        $scope.myMessages = [];
        $scope.userThreadMessage = [];
        $scope.showTextArea = { show: false };
        $scope.textMessage = { messageToSend: "" };
        $scope.totalNotification = 0;
        var userDetail = $cookies.getObject('CurrentUser');
        $scope.loggedInUser = userDetail.data.userId;
        $scope.allFriends = [];
        $scope.ShowReplyButton = true;
        $scope.addingInGroup = false;
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope,
            animation: 'fade-in'
        }).then(function (modal) {
            $scope.modal = modal;
        });
        if ($scope.userId && $scope.userId != 0) {
            $scope.addingInGroup = true;
        }
        getAllGroups();
        getAllFriends();

        $scope.getTimeWithInterval = function () {
            $scope.messageTimeOut = $timeout(function () {
                $scope.getMessagesTime();
                $scope.getTimeWithInterval();
            }, 10000);

        };
        $scope.clickedForReply = false;

        $scope.replyMessage = function (msgDetail, index, textMessage, string) {
            if (msgDetail.read == false) {
                msgDetail.read = true;
                FriendsNotificationService.setReadMessage(msgDetail.messageId).then(function (response) {

                })
            }
            angular.forEach($scope.allMessages, function (value, key) {

                value.reply = false;

            });

            $scope.allMessages[index].reply = true;


            $scope.ShowReplyButton = true;
            if (string != "") {
                $scope.clickedForReply = true;

                $scope.showTextArea.show = true;
                setTimeout(startToggleFunction, 20);
            } else {
                /* if($scope.clickedForReply==false) {
                     $scope.showTextArea.show = false;
                 }
                 $timeout(function(){
                     $scope.clickedForReply=false;
                 },200)*/
            }


            function startToggleFunction() {
                $scope.messageBoxClasses = document.getElementById("textArea").classList;

                if ($scope.messageBoxClasses.contains("hideAll")) {
                    $scope.messageBoxClasses.remove("hideAll");
                    $scope.textMessage.messageToSend = "";
                }
                ;
                setTimeout(removeText, 10);
                function removeText() {
                    if ($scope.messageBoxClasses.contains("hidemsgTexArea")) {
                        $scope.messageBoxClasses.remove("hidemsgTexArea");

                    }
                    else {
                        if (textMessage == undefined || textMessage.trim() === '' && string != "") {
                            $scope.messageBoxClasses.add("hidemsgTexArea");
                            setTimeout(hideArea, 400);
                            return;
                        }
                        if (string != "") {
                            FriendsNotificationService.sendMessage(msgDetail.senderUserId, textMessage).then(function (res) {
                                if (res != undefined && res.sendEmail == true) {
                                    $scope.messageSentStatus = true;

                                    $scope.textMessage = { messageToSend: "" };

                                    $timeout(function () { $scope.ShowReplyButton = false; }, 1000);
                                    $ionicLoading.show({ template: 'Message sent', noBackdrop: false, duration: 5000 });

                                    $timeout(function () {
                                        $scope.messageBoxClasses.add("hidemsgTexArea");
                                        setTimeout(hideArea, 400);
                                    }, 1200);

                                } else {
                                    $flaskUtil.alert("Failed to send message");
                                }

                            });
                        }

                    }
                }
            }

            function hideArea() {
                $scope.messageBoxClasses.add("hideAll");
                $timeout(function () { $scope.showTextArea.show = false; }, 10);
            }
        }
        function hideMessageDiv() {
            $scope.messageSentStatus = false;
        }
        $scope.getMessagesTime = function () {
            angular.forEach($scope.myMessages, function (value, key) {
                $scope.messageDate = new Date(value.dateTime);
                var result = getTimeDifference();
                value.diffDate = result;
            });
        }

        $scope.goBack = function () {
            $ionicHistory.goBack();
        }
        function getTimeDifference() {
            var todayDate = new Date();
            var differenceTravel = todayDate.getTime() - $scope.messageDate.getTime();
            var seconds = Math.floor((differenceTravel) / (1000));
            var days = parseInt((seconds / (3600 * 24)));
            var hours = parseInt(seconds / 3600);
            var minutes = parseInt(seconds / 60);
            var months = parseInt(days / 30);
            var year = parseInt(months / 12);
            if (seconds < 60) {
                return seconds + " seconds ago"
            }
            else if (minutes < 60) {
                return minutes + ' minutes ago';
            } else if (hours < 24) {
                return hours + " hours ago";
            }
            else if (days < 31) {
                return days + " days ago"
            } else if (months < 12) {
                return months + " months ago"

            } else {
                year + " years ago"
            }
        }


        $scope.deleteMessage = function (messageId, index) {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Delete message ?'
            });
            confirmPopup.then(function (res) {
                if (res) {
                    FriendsNotificationService.deleteMessageById(messageId).then(function (response) {
                        $scope.allMessages.splice(index, 1);
                    })
                }
                else {
                }
            });
        }

        //get all user groups
        function getAllGroups() {
            FriendsNotificationService.getAllGroups($scope.loggedInUser).then(function (response) {
                if (response.message != "Authenticated access required") {
                    if ($scope.addingInGroup == true) {
                        $scope.showDoneButton = false;
                        $scope.groupsToAdd = [];
                        $scope.groupsToAdd = response;
                        $scope.counter = 0;
                        angular.forEach($scope.groupsToAdd, function (value, key) {
                            isUserAvailableInGroup(value.groupId).then(function (res) {
                                $scope.counter++;
                                if ($scope.isGroupMemberIsAvailable == true) {
                                    $scope.groupsToAdd[key] = "";
                                }
                                if (res == false) {
                                    $scope.isLoginAdmin();
                                    if ($scope.isLoginUserAdmin == false) {
                                        $scope.groupsToAdd[key] = ""
                                    }
                                }
                                if ($scope.counter == response.length) {
                                    $scope.groupsToAdd.clean("");
                                    $scope.groupsToAdd.clean(undefined);
                                    $scope.groups = $scope.groupsToAdd;
                                    $scope.showDoneButton = true;
                                }
                            });
                        })

                    }
                    else {
                        $scope.groups = response;
                    }
                }

            });
        }

        //get all friends
        function getAllFriends() {
            $scope.searchText = "";
            FriendsNotificationService.getMyFriends($scope.searchText).then(function (response) {
                $scope.allFriends = response;
            });
        }
        $scope.closeChatWindowPopup = function () {
            $scope.modal.hide();
        };
        $scope.isUser = false;
        //show chat window of friend
        $scope.showChatWindowPopup = function (data, type) {
            if (type == 'user') {
                $scope.isUser = true;
                $scope.receiverId = data.userId;
                $scope.friendName = data.fullName;
                //get messages by receiverId on click of friend
                FriendsNotificationService.getMyAllMessages(data.userId).then(function (response) {
                    $scope.myMessages = response;
                    for (var i = 0; i < $scope.myMessages.length; i++) {
                        if ($scope.myMessages[i].read == false) {
                            FriendsNotificationService.setReadMessage($scope.myMessages[i].messageId).then(function (response) {
                            });
                        }
                    }
                    $scope.getMessagesTime();
                });
            }
            else {
                $scope.isUser = false;
                $scope.friendName = data.groupName;
                $scope.groupId = data.groupId;
                FriendsNotificationService.getAllMyFlaskGroupMessages(data.groupId).then(function (response) {
                    $scope.myMessages = response;
                    for (var i = 0; i < $scope.myMessages.length; i++) {
                        if ($scope.myMessages[i].read == false) {
                            FriendsNotificationService.setReadMessage($scope.myMessages[i].messageId).then(function (response) {
                            });
                        }
                    }
                    $scope.getMessagesTime();
                });
            }
            $scope.modal.show();
        }
        //send message to friend
        $scope.sendReply = function (message) {
            if ($scope.isUser == true){
                FriendsNotificationService.sendMessage($scope.receiverId, message).then(function (response) {
                    delete $scope.textMessage.messageToSend;
                    $scope.myMessages.push(response);
                    $ionicLoading.show({ template: 'Message sent successfully!', noBackdrop: false, duration: 3000 });
                });
            }
            else {
                FriendsNotificationService.sendFlaskGroupMessage($scope.groupId, message).then(function (response) {
                    delete $scope.textMessage.messageToSend;
                    $scope.myMessages.push(response);
                    $ionicLoading.show({ template: 'Message sent successfully!', noBackdrop: false, duration: 3000 });
                });
            }
        }
    }
})();