
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('FriendsService', FriendsService);

    FriendsService.$inject = ['$http','SERVER','$ionicLoading'];

    function FriendsService($http, SERVER,$ionicLoading) {
        var services =  {
            getMyFriends :getMyFriends,
            getFriendByUserId :getFriendByUserId 
        }
        
        var url = SERVER.url;
        var searchMyFriend = "/flask-social-portlet.entry/search-my-friends";
        var searchFriendById = "/flask-social-portlet.entry/get-user-by-id"
        var searchUserContact = '/flask-social-portlet.entry/search-users-and-contacts';
        var companyId = SERVER.companyId;
         function getMyFriends() {
           $ionicLoading.show();
            return $http.get(url+searchMyFriend,{params:{
                companyId: companyId,
                keywords: '',
               
            }})
            .then(function success(response) {
                $ionicLoading.hide();
                return response.data;
            }, function failure(response) {
                $ionicLoading.hide();
                //add errror handling 
            });
        }

        function getFriendByUserId(userId) {
            $ionicLoading.show();
            return $http.get(url+searchFriendById,{params:{
                userId: userId
            }})
            .then(function success(response) {
                $ionicLoading.hide();
                return response.data;
            }, function failure(response) {
                $ionicLoading.hide();
                //add errror handling 
            });
        }


return services;

    }
})();