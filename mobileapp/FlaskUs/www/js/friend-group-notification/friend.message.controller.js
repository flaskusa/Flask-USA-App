(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsMessageCtrl', FriendsMessageCtrl);

    FriendsMessageCtrl.$inject = ['$scope', '$http', '$ionicModal', 'FriendsNotificationService', 'UserService', 'SERVER', '$localStorage', '$flaskUtil', '$state', '$ionicHistory', '$timeout', '$ionicLoading', '$ionicPopup', '$cookies', '$anchorScroll', '$location', '$ionicScrollDelegate'];

    /* @ngInject */
    function FriendsMessageCtrl($scope, $http, $ionicModal, FriendsNotificationService, UserService, SERVER, $localStorage, $flaskUtil, $state, $ionicHistory, $timeout, $ionicLoading, $ionicPopup, $cookies, $anchorScroll, $location, $ionicScrollDelegate) {
        $scope.userThreadMessage = [];
        $scope.showTextArea = { show: false };
        $scope.textMessage = { messageToSend: "" };
        var userDetail = $cookies.getObject('CurrentUser');
        $scope.loggedInUser = userDetail.data.userId;
        $scope.friendDetail = [];
        $scope.friednsCookiesArray = [];
        $scope.friendDetail = $cookies.getObject('friendData');
        $scope.picUrl = $cookies.getObject('profileUrl');
        showPopupFromFriends();
        $scope.allFriends = [];
        $scope.allSortedFriends = [];
        $scope.readMsg = false;
        $scope.ShowReplyButton = true;
        $scope.addingInGroup = false;
        $scope.allGroupChatFriends = [];
        $scope.friendChatMessages = " Loading.... ";
        $scope.groupChatMessages = " Loading.... ";
        $scope.insideChatMessage = " Loading.... ";
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope,
            animation: 'fade-in'
        }).then(function (modal) {
            $scope.modal = modal;
        });
        if ($scope.userId && $scope.userId != 0) {
            $scope.addingInGroup = true;
        }
        if ($localStorage["myFriendDetails"] == undefined) {
            $localStorage["myFriendDetails"] = [];
        }
        $scope.profilePicUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        $scope.CurrentUserprofilePic = '';
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
                };
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
                var formattedDate = formatDate($scope.messageDate);
                var result = getTimeDifference(value.dateTime, formattedDate);
                value.diffDate = result;
            });
        }

        function formatDate(dateVal) {
            var newDate = new Date(dateVal);

            var sMonth = padValue(newDate.getMonth() + 1);
            var sDay = padValue(newDate.getDate());
            var sYear = newDate.getFullYear().toString().substr(-2)
            var sHour = newDate.getHours();
            var sMinute = padValue(newDate.getMinutes());
            var sAMPM = "AM";

            var iHourCheck = parseInt(sHour);

            if (iHourCheck > 12) {
                sAMPM = "PM";
                sHour = iHourCheck - 12;
            }
            else if (iHourCheck === 0) {
                sHour = "12";
            }

            sHour = padValue(sHour);

            return sMonth + "/" + sDay + "/" + sYear + " " + sHour + ":" + sMinute + " " + sAMPM;
        }

        function padValue(value) {
            return (value < 10) ? "0" + value : value;
        }

        $scope.goBack = function () {
            $ionicHistory.goBack();
        }
        function getTimeDifference(dateTime, formattedDate) {
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
                return formattedDate.substr(9);
            } else if (days < 31) {
                return formattedDate;
            } else if (months < 12) {
                return formattedDate;
            } else {
                formattedDate;
            }
        }


        $scope.deleteMessage = function (messageId) {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Delete message ?'
            });
            confirmPopup.then(function (res) {
                if (res) {
                    FriendsNotificationService.deleteMessageById(messageId).then(function (response) {
                        for (var i = 0; i < $scope.myMessages.length; i++) {
                            if ($scope.myMessages[i].messageId == messageId){
                                $scope.myMessages.splice(i, 1);
                            }
                        }
                    })
                }
                else {
                }
            });
        }

        //get all user groups
        function getAllGroups() {
            $scope.allGroupChatFriends = [];
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
                getOnlyGroup();
            });
            
        }

        function getOnlyGroup() {
            angular.forEach($scope.groups, function (value, key) {
                getAllGroupChatFriends(value);
            });
        }
       
        function getAllGroupChatFriends(data) {
            FriendsNotificationService.getAllMyFlaskGroupMessages(data.groupId).then(function (response) {
                if (response.length != 0) {
                    $scope.allGroupChatFriends.push(data);
                    $scope.allGroupChatFriends.sort(custom_sort);
                } else {
                    $scope.groupChatMessages = "There are no messages.";
                }
            });
        }

        //get all friends
        function getAllFriends() {
            $scope.searchText = " ";
            FriendsNotificationService.getMyFriends($scope.searchText).then(function (response) {
                angular.forEach(response, function (value, key) {
                    if (value.portraitId > 0) {
                        $scope.getUserProfile(value);
                    }
                    else {
                        push_friends(value);
                        if (userExistInLocalStorage(value) == false) {
                            $localStorage["myFriendDetails"].push(value)
                        }
                    }
                })
            });
            
        }
        
        function custom_sort(a, b) {
            if (a.lastMessageDateTime < b.lastMessageDateTime)
                return 1;
            if (a.lastMessageDateTime > b.lastMessageDateTime)
                return -1;
            return 0;
        }

        function push_friends(value) {           
            getAllChatFriends(value);
        }

        function getAllChatFriends(value) {
            FriendsNotificationService.getMyAllMessages(parseInt(value.userId)).then(function (response) {
                if (response.length!=0) {
                    $scope.allFriends.push(value);
                    $scope.allFriends.sort(custom_sort);
                } else {
                    $scope.friendChatMessages = "There are no messages";
                }
            });
        }

        //get profile picture of friend 
        $scope.getUserProfile = function (UserDetail) {
            UserService.getUserProfile(UserDetail.userId).then(function (res) {
                if (res.data.fileEntryId != undefined) {
                    UserDetail.friendProfilePicUrl = $scope.profilePicUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                    push_friends(UserDetail);
                    if (userExistInLocalStorage(UserDetail) == false) {
                        $localStorage["myFriendDetails"].push(UserDetail);
                    }
                } else {
                    push_friends(UserDetail);
                    if (userExistInLocalStorage(UserDetail) == false) {
                    $localStorage["myFriendDetails"].push(UserDetail);
                }
                }
            }, function (err) {
            })
        }
        //add data in localstorage
        function userExistInLocalStorage(userDetail) {
            var exist = false;
            angular.forEach($localStorage["myFriendDetails"], function (value, key) {
                if (value.userId == userDetail.userId) {
                    exist = true
                }
            })
            return exist;
        }
        $scope.isUser = false;

        //show chat window from my_friends tab
        function showPopupFromFriends() {
            if ($scope.friendDetail != undefined){
                $scope.friednsCookiesArray.push({ "userId": $scope.friendDetail.userId, "fullName": $scope.friendDetail.firstName + $scope.friendDetail.lastName, "friendProfilePicUrl": $scope.picUrl });
                $timeout(function () {
                    $scope.showChatWindowPopup($scope.friednsCookiesArray[0], 'user');
                }, 300);  
            }
        }
        //to delete the conversation
        $scope.deleteConversation = function (receipientuserId,conversationType) {
            $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
            var deleteConversationMessages = '';
            var newArray = [];
            if (conversationType == "user") {
                FriendsNotificationService.getMyAllMessages(receipientuserId).then(function (response) {
                    angular.forEach(response, function (index, element) {
                        newArray.push(index.messageId);
                        deleteConversationMessages = newArray.join();
                    });
                    FriendsNotificationService.deleteIndividualConverstaion(deleteConversationMessages).then(function (response) {
                        console.log("Deleted");
                        $scope.allFriends.length = 0;
                        getAllFriends();
                    });
                    $ionicLoading.hide();
                });

            } else {
                FriendsNotificationService.getAllMyFlaskGroupMessages(receipientuserId.groupId).then(function (response) {
                    angular.forEach(response, function (index, element) {
                        newArray.push(index.messageId);
                        deleteConversationMessages = newArray.join();
                    });
                    FriendsNotificationService.deleteGroupConverstaion(deleteConversationMessages).then(function (response) {
                        console.log("Deleted");
                        $scope.groups.length = 0;
                        getAllGroups();
                    });
                    $ionicLoading.hide();
                });
            }
        }
        //show chat window of friend
        $scope.showChatWindowPopup = function (data, type) {
            $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
            $scope.myMessages = [];
            if (type == 'user') {
                $scope.isUser = true;
                $scope.receiverId = data.userId;
                $scope.friendName = data.fullName;
                $scope.profilePic = data.friendProfilePicUrl;
                //get messages by receiverId on click of friend
                $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
                FriendsNotificationService.getMyAllMessages(data.userId).then(function (response) {
                    $scope.myMessages = response;
                    if (response.length == 0) {
                        $scope.insideChatMessage = "There are no Messages";
                    }
                    for (var i = 0; i < $scope.myMessages.length; i++) {
                        if ($scope.myMessages[i].recipients == $scope.loggedInUser) {
                            FriendsNotificationService.setReadMessage($scope.myMessages[i].messageId).then(function (response) {
                                $scope.readMsg = true;
                            });
                        }
                    }
                    $scope.getMessagesTime();
                    $ionicScrollDelegate.scrollBottom();
                    $ionicLoading.hide();
                });
            }
            else {
                $scope.isUser = false;
                $scope.friendName = data.groupName;
                $scope.groupId = data.groupId;
                $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
                FriendsNotificationService.getAllMyFlaskGroupMessages(data.groupId).then(function (response) {
                    $scope.myMessages = response;
                    if ($scope.myMessages.length != 0) {
                        for (var i = 0; i < $scope.myMessages.length; i++) {
                            FriendsNotificationService.setGroupMessageRead($scope.myMessages[i].messageId).then(function (response) {
                                $scope.readMsg = true;
                            });
                        }
                        $scope.getMessagesTime();
                        $ionicScrollDelegate.scrollBottom();
                        $ionicLoading.hide();
                    } else {
                            $scope.insideChatMessage = "There are no Messages";
                    }
                });
            }
            $scope.modal.show();
            $timeout(function () {
                $ionicScrollDelegate.scrollBottom();
                $ionicLoading.hide();
            }, 200);
        }
        $scope.closeChatWindowPopup = function () {
            if ($scope.friendDetail != undefined) {
                $scope.modal.hide();
                $cookies.remove('friendData');
                $cookies.remove('profileUrl');
                $ionicHistory.goBack();
            }
            $scope.modal.hide();
        };
        //send message to friend
        $scope.sendReply = function (message) {
            if(message){
                if ($scope.isUser == true){
                    FriendsNotificationService.sendMessage($scope.receiverId, message).then(function (response) {
                        delete $scope.textMessage.messageToSend;
                        $scope.myMessages.push(response);
                        $ionicScrollDelegate.scrollBottom();
                    });
                }
                else {
                    FriendsNotificationService.sendFlaskGroupMessage($scope.groupId, message).then(function (response) {
                        delete $scope.textMessage.messageToSend;
                        $scope.myMessages.push(response);
                        $ionicScrollDelegate.scrollBottom();
                    });
                }
            }            
        }

        //when messages page is opened using popup notification.
        var activeUsingPopup = $cookies.getObject('popupData');
        var myObj = {};
        if (activeUsingPopup != undefined) {
            if (activeUsingPopup.coldstart == true) {
                $timeout(function () {
                    callPopup();
                }, 6000);
            } else {
                callPopup();
            }
        }

        function callPopup() {
                if (activeUsingPopup.activeUsingPopup == true) {
                    if (activeUsingPopup.user == "user") {
                        getUserProficPic(activeUsingPopup.infoData.userId);
                        myObj = {
                            "fullName": activeUsingPopup.infoData.firstName + " " + activeUsingPopup.infoData.lastName,
                            "userId": activeUsingPopup.infoData.userId,
                            "friendProfilePicUrl": $scope.CurrentUserprofilePic
                        }
                    } else {
                        myObj = {
                            "groupName": activeUsingPopup.infoData.groupName,
                            "groupId": activeUsingPopup.infoData.groupId
                        }
                    }
                    $timeout(function () {
                        $scope.showChatWindowPopup(myObj, activeUsingPopup.user);
                    }, 300);
                    $cookies.putObject('popupData', { 'activeUsingPopup': false });
                }
        }

        //to get profile pic of the user
        function getUserProficPic(UserId) {
            $scope.storageData = $localStorage.myFriendDetails;
            for (var i = 0; i < $scope.storageData.length; i++) {
                if ($scope.storageData[i].userId == UserId && $scope.storageData[i].friendProfilePicUrl != undefined) {
                    $scope.CurrentUserprofilePic = $scope.storageData[i].friendProfilePicUrl;
                    break;
                } else {
                    $scope.CurrentUserprofilePic = "img/default-profilepic-copy.png";
                }
            }            
        }
    }
})();