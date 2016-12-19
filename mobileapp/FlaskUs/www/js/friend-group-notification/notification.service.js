(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('FriendsNotificationService', FriendsNotificationService);

    FriendsNotificationService.$inject = ['$http','SERVER','$q'];

    function FriendsNotificationService($http, SERVER,$q) {
        var services = {
            getNotificationCount:getNotificationCount,
            getMessageCount:getMessageCount,
            getMyAllMessages:getMyAllMessages,
            deleteMessageById:deleteMessageById,
            getRequestToConfirm:getRequestToConfirm,
            getUserById:getUserById,
            addSocialRelation:addSocialRelation,
            deleteRequest:deleteRequest,
            setReadMessage:setReadMessage,
            sendMessage:sendMessage
        }
        var getMyNotificationCountUrl="/flask-social-portlet.entry/get-requests-count"
        var getMessageCountUrl="/flask-social-portlet.flaskmessages/get-my-flask-messages-count"
        var getMyAllMessageUrl="/flask-social-portlet.flaskmessages/get-all-my-flask-messages";
        var deleteMessageUrl="/flask-social-portlet.flaskmessages/delete-message";
        var getRequestUrl="/flask-social-portlet.entry/get-requests-to-confirm";
        var getUserByIdUrl="/flask-social-portlet.entry/get-user-by-id";
        var addSocialRelationUrl="/flask-social-portlet.entry/add-social-relation";
        var deleteSocialRelationUrl="/flask-social-portlet.entry/delete-request";
        var sendFlaskMessage = "/flask-social-portlet.flaskmessages/send-flask-message";
        var setMessageReadUrl="/flask-social-portlet.flaskrecipients/set-read";
        var companyId = SERVER.companyId;
        function getNotificationCount(){
            return $http.get(SERVER.url+getMyNotificationCountUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getMessageCount(){
            return $http.get(SERVER.url+getMessageCountUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getMyAllMessages(){
            return $http.get(SERVER.url+getMyAllMessageUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteMessageById(messageId){
            return $http.get(SERVER.url+deleteMessageUrl,{params:{
                messageId: messageId
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getRequestToConfirm(){
            return $http.get(SERVER.url+getRequestUrl,{params:{
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getUserById(userId){
            return $http.get(SERVER.url+getUserByIdUrl,{params:{
                userId: userId }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function addSocialRelation(receiverUserId){
            return $http.get(SERVER.url+addSocialRelationUrl,{params:
            {receiverUserId:receiverUserId}})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteRequest(receiverUserId){
            return $http.get(SERVER.url+deleteSocialRelationUrl,{params:
            {receiverUserId:receiverUserId}})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function setReadMessage(messageId){
            return $http.get(SERVER.url+setMessageReadUrl,{params:
        {messageId:messageId}})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        };
        function sendMessage (userId,messgae) {
            return $http.get(SERVER.url+sendFlaskMessage,{params:{
                recipients: userId,
                message:messgae,
                sendEmail:true
            }})
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