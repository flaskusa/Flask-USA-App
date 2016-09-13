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
            deleteMessageById:deleteMessageById
        }
        var url = SERVER.url;
        var getMyNotificationCountUrl="/flask-social-portlet.entry/get-requests-count"
        var getMessageCountUrl="/flask-social-portlet.flaskmessages/get-my-flask-messages-count"
        var getMyAllMessageUrl="/flask-social-portlet.flaskmessages/get-all-my-flask-messages";
        var deleteMessageUrl="/flask-social-portlet.flaskmessages/delete-message";
        var companyId = SERVER.companyId;
        function getNotificationCount(){
            return $http.get(url+getMyNotificationCountUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getMessageCount(){
            return $http.get(url+getMessageCountUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getMyAllMessages(){
            return $http.get(url+getMyAllMessageUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteMessageById(messageId){
            return $http.get(url+deleteMessageUrl,{params:{
                messageId: messageId
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        return services;deleteMessageById
    }
})();