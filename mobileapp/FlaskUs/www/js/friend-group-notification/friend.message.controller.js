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
        $scope.readIndividualMsg = false;
        $scope.readGroupMsg = false;
        $scope.ShowReplyButton = true;
        $scope.addingInGroup = false;
        $scope.allGroupChatFriends = [];
        $scope.allChatMessages = " Loading.... ";
        $scope.groupChatMessages = " Loading.... ";
        $scope.insideChatMessage = " Loading.... ";
        $scope.newChatData = [];
        var activeUsingPopup = $cookies.getObject('popupData');
        var myObj = {};
        var myContactObj = {};
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope,
            animation: 'fade-in'
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $ionicModal.fromTemplateUrl('templates/composeMessagesModal.html', {
            scope: $scope,
            animation: 'fade-in'
        }).then(function (modal) {
            $scope.composeMessagesModal = modal;
        });
        if ($scope.userId && $scope.userId != 0) {
            $scope.addingInGroup = true;
        }
        if ($localStorage["myFriendDetails"] == undefined) {
            $localStorage["myFriendDetails"] = [];
        }
        $scope.profilePicUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        $scope.CurrentUserprofilePic = '';
        //getAllFriends();
        getAllFriendsandGroupsWithMessages();
        $scope.newChatDataUnsorted = [];
        function getAllFriendsandGroupsWithMessages() {
            $scope.newChatDataUnsorted = [];
            $scope.newChatData = [];
            FriendsNotificationService.getallFriendsandGroupWithMessages().then(function (response) {
                $scope.allChatMessages = " Loading.... ";
                console.log("all friends & group with chats messages here");
                console.log(response);
                $scope.newChatData = response;
                angular.forEach(response, function (value, key) {
                    if (value.portraitId != 0) {
                        $scope.getUserProfile(value);                        
                    } else {
                        value.profilePic = "img/default-profilepic-copy.png";
                        $scope.newChatDataUnsorted.push(value);
                        //$scope.newChatData.push(value);
                    }
                    $scope.newChatDataUnsorted.sort(custom_sort);
                    //$scope.newChatData.sort(custom_sort);
                });

                //$scope.newChatDataUnsorted = response;
            });
        };

        function getOnlychatsWithMsg() {
            angular.forEach($scope.newChatDataUnsorted, function (value, key) {
                //$scope.newChatDataUnsorted[key].profilePic = "img/default-profilepic-copy.png";
                if (value.isUser == 1) {
                    getAllChatFriends(value);
                } else {
                    getAllGroupChatFriends(value);
                }
            });
        }

        function getAllGroupChatFriends(data) {
            FriendsNotificationService.getAllMyFlaskGroupMessages(data.id).then(function (response) {
                if (response.length != 0) {
                    $scope.newChatData.push(data);
                }
            });
            setTimeout(function () {
                callMeForSorting();
            }, 1000);
        }
        function getAllChatFriends(value) {
            FriendsNotificationService.getMyAllMessages(parseInt(value.id)).then(function (response) {
                if (response.length != 0) {
                    $scope.newChatData.push(value);
                }
            });
            setTimeout(function () {
                callMeForSorting();
            }, 1000);
        }
        function callMeForSorting() {
            console.log($scope.newChatData);
            $scope.newChatData.sort(custom_sort);
        }

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
                        setTimeout(function () {
                            if (response.length != 0) {
                                $scope.groupChatMessages = "There are no messages";
                            };
                        }, 3000);
                    }
                }                
            });
        }
        //get all friends
        function getAllFriends() {
            $scope.allFriends = [];
            $scope.searchText = "";
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
                });
            
            });            
            getAllGroups();
        }
        
        function custom_sort(a, b) {
            if (a.lastMessageDateTime < b.lastMessageDateTime)
                return 1;
            if (a.lastMessageDateTime > b.lastMessageDateTime)
                return -1;
            return 0;
        }

        function push_friends(value) {           
            $scope.allFriends.push(value);
        }

        //get profile picture of friend 
        $scope.getUserProfile = function (UserDetail) {
            var currUserId ='';
            if (UserDetail.createdBy == "" && UserDetail.description == "") {
                currUserId = UserDetail.id;
            } else {
                currUserId = UserDetail.userId;
            }
            UserService.getUserProfile( currUserId).then(function (res) {
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
                if (UserDetail.createdBy == "" && UserDetail.description == "") {
                    UserDetail.profilePic = $scope.profilePicUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                    $scope.newChatDataUnsorted.push(UserDetail);
                    //$scope.newChatData.push(UserDetail);
                    setTimeout(function () {
                        if ($scope.newChatData.length == 0) {
                            $scope.allChatMessages = "There are no messages";
                        };
                    }, 3000);
                    $scope.newChatDataUnsorted.sort(custom_sort);
                    //$scope.newChatData.sort(custom_sort);
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
        $scope.deleteConversation = function (receipientuserId, isUser) {
            $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
            var deleteConversationMessages = '';
            var newArray = [];
            if (isUser == 1) {
                FriendsNotificationService.getMyAllMessages(receipientuserId).then(function (response) {
                    angular.forEach(response, function (index, element) {
                        newArray.push(index.messageId);
                        deleteConversationMessages = newArray.join();
                    });
                    FriendsNotificationService.deleteIndividualConverstaion(deleteConversationMessages).then(function (response) {
                        console.log("Deleted");
                        $ionicLoading.hide();
                        var MessageAlert = $ionicPopup.alert({
                            title: "Message Alert",
                            template: "Messages In Conversation is Successfully Deleted"
                        }).then(function (res) {
                            $scope.newChatData.length = 0;
                            getAllFriendsandGroupsWithMessages();
                            setTimeout(function () {
                                callMeForSorting();
                            }, 1000);
                        });
                    });
                });

            } else {
                FriendsNotificationService.getAllMyFlaskGroupMessages(receipientuserId).then(function (response) {
                    angular.forEach(response, function (index, element) {
                        newArray.push(index.messageId);
                        deleteConversationMessages = newArray.join();
                    });
                    FriendsNotificationService.deleteGroupConverstaion(deleteConversationMessages).then(function (response) {
                        console.log("Deleted");
                        $ionicLoading.hide();
                        var MessageAlert = $ionicPopup.alert({
                            title: "Message Alert",
                            template: "Messages In Conversation is Successfully Deleted"
                        }).then(function (res) {
                            $scope.newChatData.length = 0;
                            getAllFriendsandGroupsWithMessages();
                            setTimeout(function () {
                                callMeForSorting();
                            }, 1000);
                        });
                    });                    
                });
            }
        }

        //for getting proper msg type
        $scope.getMsgType = function (data, isUser) {
            if (isUser == 0) {
                $scope.showChatWindowPopup(data, 'group');
            } else {
                $scope.showChatWindowPopup(data, 'user');
            }            
        }

        //show chat window of friend
        $scope.showChatWindowPopup = function (data, type) {
            $scope.insideChatMessage = " Loading.... ";
            $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
            $scope.myMessages = [];
            $scope.myNewIndividualMessageIdstoRead = [];
            $scope.myNewGroupMessageIdstoRead = [];
            $scope.myIndividualMessageIdstoRead = [];
            $scope.myGroupMessageIdstoRead = [];
            if (type == 'user') {
                $scope.isUser = true;
                $scope.receiverId = data.id;
                $scope.friendName = data.name;
                $scope.profilePic = data.friendProfilePicUrl;
                getUserProficPic(data.id);
                //get messages by receiverId on click of friend
                $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
                FriendsNotificationService.getMyAllMessages(data.id).then(function (response) {
                    $scope.myMessages = response;
                    $timeout(function () {
                        if (response.length == 0) {
                            $scope.insideChatMessage = "There are no Messages";
                        }
                    }, 3000);
                    for (var i = 0; i < $scope.myMessages.length; i++) {
                        if ($scope.myMessages[i].recipients == $scope.loggedInUser && $scope.myMessages[i].read!=true) {
                            $scope.myNewGroupMessageIdstoRead.push($scope.myMessages[i].messageId);
                            
                        }
                    }
                    $scope.myIndividualMessageIdstoRead = $scope.myNewGroupMessageIdstoRead.join();
                    if ($scope.myIndividualMessageIdstoRead != "") {
                        FriendsNotificationService.setReadMessage($scope.myIndividualMessageIdstoRead).then(function (response) {
                            $scope.readIndividualMsg = true;
                        });
                    }
                    $scope.getMessagesTime();
                    $ionicScrollDelegate.scrollBottom(true);
                    $ionicLoading.hide();
                });
            }
            else {
                $scope.isUser = false;
                $scope.friendName = data.name;
                $scope.groupId = data.id;
                $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
                FriendsNotificationService.getAllMyFlaskGroupMessages(data.id).then(function (response) {
                    $scope.myMessages = response;
                    if ($scope.myMessages.length != 0) {
                        for (var i = 0; i < $scope.myMessages.length; i++) {
                            if ($scope.myMessages[i].read != true) {
                                $scope.myNewGroupMessageIdstoRead.push($scope.myMessages[i].messageId);
                            }
                        }
                        $scope.myGroupMessageIdstoRead = $scope.myNewGroupMessageIdstoRead.join();
                        if ($scope.myGroupMessageIdstoRead != "") {
                            FriendsNotificationService.setGroupMessageRead($scope.myGroupMessageIdstoRead).then(function (response) {
                                $scope.readGroupMsg = true;
                            });
                        }
                        $scope.getMessagesTime();
                        $ionicScrollDelegate.scrollBottom(true);
                        $ionicLoading.hide();
                    } else {
                        $timeout(function () {
                            if (response.length == 0) {
                                $scope.insideChatMessage = "There are no Messages";
                            }
                        }, 3000);
                    }
                });
            }
            $scope.modal.show();
            $timeout(function () {
                $ionicScrollDelegate.scrollBottom(true);
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
            $ionicScrollDelegate.scrollTop(true);
            $scope.modal.hide();
        };
        $scope.showContactList = function () {
            getAllFriends();
            $scope.composeMessagesModal.show();
        }
        $scope.closeshowContactListWindowPopup = function () {
            $scope.searchContact='';
            getAllFriendsandGroupsWithMessages();
            callMeForSorting();
            $scope.composeMessagesModal.hide();
        };
        $scope.callConactsPopup = function (data, userType) {
            $scope.closeshowContactListWindowPopup();
                if (userType == "user") {
                    getUserProficPic(data.userId);
                    myContactObj = {
                        "name": data.fullName,
                        "id": data.userId,
                        "friendProfilePicUrl": $scope.CurrentUserprofilePic
                    }
                } else {
                    myContactObj = {
                        "name": data.groupName,
                        "id": data.groupId
                    }
                }
                $timeout(function () {
                    $scope.showChatWindowPopup(myContactObj, userType);
                }, 300);
        }
        //allGroupChatFriends for ser4aching
        //send message to friend
        $scope.sendReply = function (message) {
            //delete $scope.textMessage.messageToSend;
            $scope.textMessage.messageToSend = '';
            if(message){
                if ($scope.isUser == true){
                    FriendsNotificationService.sendMessage($scope.receiverId, message).then(function (response) {                        
                        $scope.myMessages.push(response);
                        $ionicScrollDelegate.scrollBottom(true);
                    });
                }
                else {
                    FriendsNotificationService.sendFlaskGroupMessage($scope.groupId, message).then(function (response) {
                        $scope.myMessages.push(response);
                        $ionicScrollDelegate.scrollBottom(true);
                    });
                }
            }            
        }

        //when messages page is opened using popup notification.

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
                            "name": activeUsingPopup.infoData.firstName + " " + activeUsingPopup.infoData.lastName,
                            "id": activeUsingPopup.infoData.userId,
                            "friendProfilePicUrl": $scope.CurrentUserprofilePic
                        }
                    } else {
                        myObj = {
                            "name": activeUsingPopup.infoData.groupName,
                            "id": activeUsingPopup.infoData.groupId
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
                    $scope.friendProfilePicUrl = $scope.storageData[i].friendProfilePicUrl;
                    break;
                } else {
                    $scope.CurrentUserprofilePic = "img/default-profilepic-copy.png";
                }
            }            
        }

        //chat layout for keyboard keyup on mobile
        $scope.inputUp = function () {
            if (isIOS) $scope.data.keyboardHeight = 216;
            $timeout(function () {
                $ionicScrollDelegate.scrollBottom(true);
            }, 300);
        };

        $scope.inputDown = function () {
            if (isIOS) $scope.data.keyboardHeight = 0;
            $ionicScrollDelegate.resize();
        };

        $scope.closeKeyboard = function () {
            // cordova.plugins.Keyboard.close();
        };
    }
})();