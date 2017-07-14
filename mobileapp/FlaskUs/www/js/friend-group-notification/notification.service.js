(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('FriendsNotificationService', FriendsNotificationService);

    FriendsNotificationService.$inject = ['$http', 'SERVER', '$q'];

    function FriendsNotificationService($http, SERVER, $q) {
        var services = {
            getNotificationCount: getNotificationCount,
            getTotalUnreadChatCount: getTotalUnreadChatCount,
            getMyAllMessages: getMyAllMessages,
            deleteMessageById: deleteMessageById,
            getRequestToConfirm: getRequestToConfirm,
            getUserById: getUserById,
            addSocialRelation: addSocialRelation,
            deleteRequest: deleteRequest,
            setReadMessage: setReadMessage,
            setGroupMessageRead:setGroupMessageRead,
            sendMessage: sendMessage,
            getAllGroups: getAllGroups,
            getMyFriends: getMyFriends,
            getAllMyFlaskGroupMessages: getAllMyFlaskGroupMessages,
            sendFlaskGroupMessage: sendFlaskGroupMessage,
            deleteIndividualConverstaion: deleteIndividualConverstaion,
            deleteGroupConverstaion: deleteGroupConverstaion,
            getallFriendsandGroupWithMessages: getallFriendsandGroupWithMessages
        }
        var getMyNotificationCountUrl = "/flask-social-portlet.entry/get-requests-count";
        var getTotalUnreadChatCountUrl = "/flask-social-portlet.flaskmessages/get-total-unread-chat-count";
        var getMyAllMessageUrl = "/flask-social-portlet.flaskmessages/get-all-my-flask-messages";
        var deleteMessageUrl = "/flask-social-portlet.flaskmessages/delete-message";
        var getRequestUrl = "/flask-social-portlet.entry/get-requests-to-confirm";
        var getUserByIdUrl = "/flask-social-portlet.entry/get-user-by-id";
        var addSocialRelationUrl = "/flask-social-portlet.entry/add-social-relation";
        var deleteSocialRelationUrl = "/flask-social-portlet.entry/delete-request";
        var sendFlaskMessage = "/flask-social-portlet.flaskmessages/send-flask-message";
        var setMessageReadUrl = "/flask-social-portlet.flaskrecipients/set-read";
        var setGroupMessageReadUrl = "/flask-social-portlet.flaskgrouprecipients/set-group-message-read";
        var getUnreadMessagesURL = "/flask-social-portlet.flaskmessages/get-my-unread-flask-messages";
        var searchMyFriend = "/flask-social-portlet.entry/search-my-friends";
        var getAllGroupsURL = "/flask-manage-user-group-portlet.flaskgroup/get-all-my-groups";
        var getAllMyFlaskGroupMessagesUrl = "/flask-social-portlet.flaskgroupmessages/get-all-my-flask-group-messages";
        var sendFlaskGroupMessageUrl = "/flask-social-portlet.flaskgroupmessages/send-flask-group-message";
        var deleteIndividualConversationUrl = "/flask-social-portlet.flaskmessages/delete-my-chat-messages";
        var deleteGroupConversationUrl = "/flask-social-portlet.flaskgroupmessages/delete-my-group-chat-messages";
        var getallFriendsandGroupWithMessagesURL = "/flask-social-portlet.entry/get-all-my-messages";
        var companyId = SERVER.companyId;

        function getMyFriends(searchText) {
            return $http.get(SERVER.url + searchMyFriend, {
                params: {
                    companyId: companyId,
                    keywords: searchText
                }
            })
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getNotificationCount() {
            return $http.get(SERVER.url + getMyNotificationCountUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        //get total unread chat count
        function getTotalUnreadChatCount() {
            return $http.get(SERVER.url + getTotalUnreadChatCountUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getMyAllMessages(receiverId) {
            return $http.get(SERVER.url + getMyAllMessageUrl, {
                params: {
                    receiverId: receiverId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //get group messages
        function getAllMyFlaskGroupMessages(groupId) {
            return $http.get(SERVER.url + getAllMyFlaskGroupMessagesUrl, {
                params: {
                    groupId: groupId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteMessageById(messageId) {
            return $http.get(SERVER.url + deleteMessageUrl, {
                params: {
                    messageId: messageId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function deleteIndividualConverstaion(msgIds) {
            return $http.get(SERVER.url + deleteIndividualConversationUrl, {
                params: {
                    messageIds: msgIds
                }
            })
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling
            });
        }

        function deleteGroupConverstaion(msgIds) {
            return $http.get(SERVER.url + deleteGroupConversationUrl, {
                params: {
                    groupMessageIds: msgIds
                }
            })
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling
            });
        }

        function getRequestToConfirm() {
            return $http.get(SERVER.url + getRequestUrl, {
                params: {
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getUserById(userId) {
            return $http.get(SERVER.url + getUserByIdUrl, {
                params: {
                    userId: userId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function addSocialRelation(receiverUserId) {
            return $http.get(SERVER.url + addSocialRelationUrl, {
                params:
                { receiverUserId: receiverUserId }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteRequest(receiverUserId) {
            return $http.get(SERVER.url + deleteSocialRelationUrl, {
                params:
                { receiverUserId: receiverUserId }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function setReadMessage(messageId) {
            return $http.get(SERVER.url + setMessageReadUrl, {
                params:
            { messageId: messageId }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //set group messages as read
        function setGroupMessageRead(groupMessageId) {
            return $http.get(SERVER.url + setGroupMessageReadUrl, {
                params:
            { groupMessageId: groupMessageId }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function sendMessage(userId, messgae) {
            return $http.get(SERVER.url + sendFlaskMessage, {
                params: {
                    recipients: userId,
                    message: messgae,
                    sendEmail: true
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //send message to group
        function sendFlaskGroupMessage(groupId, messgae) {
            return $http.get(SERVER.url + sendFlaskGroupMessageUrl, {
                params: {
                    groupId: groupId,
                    message: messgae,
                    sendEmail: true
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getAllUnreadMessages() {
            return $http.get(SERVER.url + getUnreadMessagesURL)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        //get all user groups
        function getAllGroups(userId) {
            return $http.get(SERVER.url + getAllGroupsURL, {
                params: {
                    "userId": userId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        //search my friends
        function getMyFriends(searchText) {
            return $http.get(SERVER.url + searchMyFriend, {
                params: {
                    companyId: companyId,
                    keywords: searchText
                }
            })
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getallFriendsandGroupWithMessages() {
            return $http.get(SERVER.url + getallFriendsandGroupWithMessagesURL)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        return services;
    }
})();